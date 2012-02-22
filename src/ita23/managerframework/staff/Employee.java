package ita23.managerframework.staff;

import ita23.managerframework.item.Boost;
import ita23.managerframework.skill.AbstractSkill;

import java.util.List;

/**
 * Abstract class which represents a single {@code Employee}.
 * @author Lukas Knuth
 * @author Rafael Marques
 * @version 1.0
 */
public abstract class Employee {

    /** The current level of this {@code Employee} */
    private int level = 1;

    /** The maximum points a skill can increase during a level up */
    private static final int MAX_LVL_UP_SKILL_INCREASE = 12;

    /**
     * This will get the Boost which should be Boosted
     * and boost it with the given points
     */
    void boost(Boost boost){
        // Get local skill:
        AbstractSkill skill_to_boost = this.getSkill(boost.getBoostedSkill().getName());
        skill_to_boost.boost(boost.getBoostPoints());
    }

    /**
     * Increases the level of this {@code Employee} by one.</p>
     * This will also increase the Skill-points of all skills
     *  of the {@code Employee}-implementation by a random number
     *  between 0 and {@code MAX_LVL_UP_SKILL_INCREASE}.
     */
    public void increaseLevel(){
        level++;
        // Increase all Skills
        for (AbstractSkill skill : this.getSkills())
            skill.increaseLevelRandom(MAX_LVL_UP_SKILL_INCREASE);
    }

    /**
     * Get this employees current level.
     * @return the current level of this {@code Employee}.
     */
    public int getLevel(){
        return level;
    }

    /**
     * Get a single {@code AbstractSkill} for this {@code Employee}.</p>
     * This method should only return skills which can be found in the
     *  {@code List} which is returned by the {@code getSkills()}-method.
     * @param skill_name the name of the desired {@code AbstractSkill}.
     * @return a single {@code AbstractSkill} of this employee-instance.
     */
    public abstract AbstractSkill getSkill(String skill_name);

    /**
     * This method returns a list of {@code AbstractSkill}s, that this
     *  {@code Employee} can have.</p>
     * This is thought to be used only in the basic extension of the 
     *  {@code Employee} and should not change for different instances!
     * @return a {@code List} of {@code AbstractSkill}s for this implementation
     *  of the {@code Employee}-class.
     */
    public abstract List<AbstractSkill> getSkills();

    /**
     * Get the salary for this employee. </p>
     *  This salary is not bind to any physical currency and is returned in
     *  money-units.
     * @return the salary for this employee in money-units.
     */
    public abstract int getSalary();

    /**
     * Gets you the full name of this employee.</p>
     *  There is no difference made between the first- and the last name.
     * @return the full name of this employee.
     */
    public abstract String getName();

    /**
     * Gives you the gender of this employee as a {@code Gender}-constant.
     * @return the gender of this employee.
     */
    public abstract Gender getGender();

    /**
     * The possible gender's for one employee.
     */
    public enum Gender{
        MALE, FEMALE
    }
    
}