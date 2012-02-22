package ita23.managerframework.skill;

/**
 * This class represents an activity which can be used to
 *  increase certain skills of an employee.
 * @author Lukas Knuth
 * @version 1.0
 */
public interface AbstractActivity {

    /**
     * Get the name of this activity.
     * @return the name of this activity.
     */
    public String getName();

    /**
     * Returns the amount of money needed to successfully use
     *  this {@code AbstractActivity} on an {@code Employee}.
     * @return the amount of money needed for this activity.
     */
    public int getPrice();

    /**
     * Get the count of steps this activity increases a given
     *  {@code AbstractSkill} at maximum.
     * The real count of points, by which the skill is increased, is
     *  drawn randomly.</p>
     * This method will be redundantly called for every {@code AbstractSkill}
     *  the trained {@code Employee} has.
     * @param skill the skill which should be increased.
     * @return the count of steps this {@code AbstractSkill} is
     *  increased.
     */
    public int increaseSkillMax(AbstractSkill skill);

}
