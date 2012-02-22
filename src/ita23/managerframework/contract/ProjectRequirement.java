package ita23.managerframework.contract;

/**
 * This is an extension of the basic {@code Requirement}-class, which is
 *  used in a {@code ProjectJob}.</p>
 * These requirements never finish and simply count up the points, as in
 *  a project, there is no maximum point-requirement.
 * @see ita23.managerframework.contract.Requirement
 * @author Lukas Knuth
 * @version 1.0
 */
public abstract class ProjectRequirement extends Requirement {

    /**
     * Simply adds the given points to the current points of this {@code Requirement}.
     * @param points the points to add to the current state of this {@code Requirement}.
     * @see Requirement#addPoints(int)  
     */
    @Override
    void addPoints(int points){
        this.current_count += points;
    }

    /**
     * As there is no "end" for {@code Requirement}s on a {@code ProjectJob}, this method
     *  only returns {@code false}.
     * @return {@code false}, no madder what.
     * @see ita23.managerframework.contract.Requirement#isFinished() 
     */
    @Override
    public boolean isFinished(){
        return false;
    }

    /**
     * Always returns {@code 0}, as there are no minimum required points on a
     *  {@code ProjectJob}.
     * @return {@code 0} in any case.
     * @see ita23.managerframework.contract.Requirement#getRequiredPoints() 
     */
    @Override
    public int getRequiredPoints() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @see ita23.managerframework.contract.Requirement#getMatchingSkill()  
     */
    public abstract String getMatchingSkill();

    /**
     * {@inheritDoc}
     * @see ita23.managerframework.contract.Requirement#getName()
     */
    public abstract String getName();

}
