package ita23.managerframework.contract;

import ita23.managerframework.time.Duration;

import java.util.List;

/**
 * This interface represents a single Job which can be put in the
 *  {@code PlayerStat} to make the staff work on it.
 * @author Lukas Knuth
 * @version 1.0
 */
public interface Job {

    /**
     * Represents the time this job lasts before the deadline is
     *  reached.
     * @return the duration till the deadline.
     */
    public Duration getDuration();

    /**
     * The amount of money payed to the player when the job is
     *  successfully finished before the deadline is reached.
     * @return the units of money associated with this Job.
     */
    public int getPayment();

    /**
     * Get all {@code Requirement}s associated with this job.</p>
     * The count of points for each {@code Requirement} is stored
     *  in the single {@code Requirement}-objects.
     * @return all requirements necessary to complete this job.
     */
    public List<Requirement> getRequirements();

    /**
     * Get the name of this Job.</p>
     * This might be a short description like "Make an X".
     * @return the describing name for this Job.
     */
    public String getName();
}
