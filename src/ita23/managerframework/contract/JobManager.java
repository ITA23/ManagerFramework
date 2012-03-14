package ita23.managerframework.contract;


import ita23.managerframework.skill.AbstractSkill;
import ita23.managerframework.staff.Employee;
import ita23.managerframework.staff.StaffManager;
import ita23.managerframework.time.DurationOverListener;
import ita23.managerframework.time.TimeListener;
import ita23.managerframework.time.TimeManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager-class that keeps track of the status of the current Job and
 *  manages it's status.
 * @author Lukas Knuth
 * @version 1.0
 */
public enum JobManager implements DurationOverListener, TimeListener {

    /** The instance to work with */
    INSTANCE;

    /** The Job you're currently working on */
    private Job currentJob;
    
    /** Collects all registered {@code JobStatusChangedListener}s. */
    private List<JobStatusChangedListener> listeners;

    /**
     * Possible states of a {@code Job}.
     */
    public enum JobStatus{
        FINISHED, DEADLINE
    }

    /**
     * Private constructor - not instantiable.
     */
    private JobManager(){
        currentJob = null;
        listeners = new ArrayList<JobStatusChangedListener>(4);
    }

    /**
     * Check, if the player is currently working on a {@code Job}.
     * @return {@code true} if so, {@code false} otherwise.
     */
    public boolean isWorking(){
        return (this.currentJob != null);
    }

    /**
     * Assign a new Job to the staff.
     * @param job the job the staff should work on.
     * @throws CantTakeJobException if the job could not be taken.
     *  Further information can be found in the exception-message.
     */
    public void doJob(Job job) throws CantTakeJobException{
        if (this.currentJob != null)
            throw new CantTakeJobException("You're already working on a Job");
        // Otherwise take:
        this.currentJob = job;
        currentJob.getDuration().addDurationOverListener(this);
        TimeManager.INSTANCE.addTimeListener(this);
    }

    /**
     * Called when the time associated with the current job is over - 
     *  e.g. it's deadline is reached.
     */
    @Override
    public void durationOver() {
        for (JobStatusChangedListener listener : listeners)
            listener.jobStatusChanged(JobStatus.DEADLINE);
        // Remove duration listener:
        jobCleanUp();
    }

    /**
     * A day is over, calculate the awarded {@code Requirement}s and
     *  check if work is done.
     */
    @Override
    public void dayOver() {
        boolean allFinished = true;
        for (Requirement req : currentJob.getRequirements()){
            // Check if already done:
            if (!req.isFinished()){
                req.addPoints(calculateNewPoints(req));
                allFinished = false;
            } else System.out.println(req.getName()+" finished!");
        }
        // Check if done:
        if (allFinished){
            for (JobStatusChangedListener listener : listeners)
                listener.jobStatusChanged(JobStatus.FINISHED);
            // Remove duration listener:
            jobCleanUp();
        }
    }

    /**
     * This method does the necessary clean-up after a job was finished.</p>
     * This includes removing observer and resetting the {@code currentJob}.
     */
    private void jobCleanUp(){
        currentJob.getDuration().removeDurationOverListener(this);
        TimeManager.INSTANCE.removeTimeListener(this);
        currentJob = null;
    }

    /**
     * Calculate the points which should be added to this
     * @param requirement the {@code Requirement} to work on.
     * @return the points to add to the {@code Requirement}.
     */
    private int calculateNewPoints(Requirement requirement){
        int points = 0;
        for (Employee employee : StaffManager.INSTANCE.getStaff()){
            AbstractSkill skill = employee.getSkill(
                    requirement.getMatchingSkill());
            // Calculate and add:
            points += (skill.getCurrentLevel() * 100) / AbstractSkill.MAXIMUM_LEVEL;
            System.out.println(employee.getName()+" added "+points+" Points for "+skill.getName());
        }
        System.out.println("----");
        return points;
    }

    /** Unused */ @Override public void weekOver() {}
    /** Unused */ @Override public void monthOver() {}
    /** Unused */ @Override public void yearOver() {}

    /**
     * Adds a new {@code JobStatusChangedListener} to the {@code JobManager},
     *  which is then called when the status of the current job changed. 
     * @param listener the new listener.
     */
    public void addJobStatusChangedListener(JobStatusChangedListener listener){
        listeners.add(listener);
    }

    /**
     * Remove a previously added {@code JobStatusChangedListener} from the
     *  listeners managed by the {@code JobManager}.
     * @param listener the listener to be removed.
     */
    public void removeJobStatusListener(JobStatusChangedListener listener){
        listeners.remove(listener);
    }
}
