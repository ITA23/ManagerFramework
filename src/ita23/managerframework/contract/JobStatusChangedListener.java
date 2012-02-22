package ita23.managerframework.contract;

/**
 * This listener can be registered to the {@code JobManager} to receive
 *  updates when a new {@code Job} is taken or an old one was finished.
 * @author Lukas Knuth
 * @version 1.0
 */
public interface JobStatusChangedListener {

    /**
     * Called if the status of a {@code Job} changed.</p>
     * The current status of the job can be retrieved by using the
     *  passed {@code status}-argument.
     * @param status the current status of the {@code Job}.
     */
    public void jobStatusChanged(JobManager.JobStatus status);
}
