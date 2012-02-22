package ita23.managerframework.contract;

/**
 * A {@code Requirement} is part of a {@code Job} and matches with a
 *  {@code AbstractSkill}.
 * @author Lukas Knuth
 * @version 1.0
 */
public abstract class Requirement {
    
    /** The current count of points already done for this {@code Requirement}. */
    protected int current_count;

    /**
     * Adds the passed number of points and checks if this "part" of the {@code Job}
     *  is finished.</p>
     * To check if this {@code Requirement} is finished, use the {@code isFinished()}-
     *  method.
     * @param points the points to add to the current state of this {@code Requirement}.
     */
    void addPoints(int points){
        // Check if the necessary points are already reached:
        if (this.current_count == getRequiredPoints()) return;
        // Check if they are now reached:
        if (this.current_count + points >= getRequiredPoints()){
            // Set the current points to the maximum:
            this.current_count = getRequiredPoints();
            return;
        }
        // Otherwise, add the points:
        this.current_count += points;
    }

    /**
     * Get the current points for this {@code Requirement}.
     * @return the current points.
     */
    public int getPoints(){
        return this.current_count;
    }

    /**
     * Check if there are enough points for this {@code Requirement}.
     * @return {@code true} if this {@code Requirement} is done, {@code false}
     *  otherwise.
     */
    public boolean isFinished(){
        if (this.current_count == getRequiredPoints())
            return true;
        else return false;
    }

    /**
     * Get the name of the {@code AbstractSkill} that matches
     *  this {@code Requirement}.
     * @return the matching skill.
     */
    public abstract String getMatchingSkill();

    /**
     * Get the count of points required to finish this "part" of the Job.
     * @return the points needed to finish this "part" of the Job.
     */
    public abstract int getRequiredPoints();

    /**
     * Get a name for this Requirement.
     * @return the name.
     */
    public abstract String getName();
}
