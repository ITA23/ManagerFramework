package ita23.managerframework.skill;

import java.util.Random;

/**
 * This interface can be implemented to represent a skill that an
 *  {@code Employee} can have.
 * @author Lukas Knuth
 * @author Rafael Marques
 * @version 1.0
 */
public abstract class AbstractSkill {

    // TODO Subscribe to "job-changed-listener" to reset the boost.

    /** The current level, this skill is on */
    private int level;

    /** The points this skill is currently boosted */
    private int boost = 0;

    /** The maximum level this skill can grow */
    public static final int MAXIMUM_LEVEL = 100;

    /**
     * Don't use this class directly!
     */
    protected AbstractSkill(){}

    /**
     * Get the name of that skill.
     * @return the name of this skill.
     */
    public abstract String getName();

    /**
     * Get the current level this skill is on.</p>
     *  If this skill is currently boosted, it returns the
     * current skill plus the boost.
     * @return the level this skill is currently on.
     */
    public int getCurrentLevel(){
        return level + boost;
    }

    /**
     * Boost this {@code AbstractSkill} up by the given points.
     * @param points the points by which this skill should be
     *  boosted up.
     */
    public void boost(int points){
        this.boost += points;
    }

    /**
     * Increase the level of this skill by the given steps.
     * @param steps the steps to increase this skill.
     */
    public void increaseLevel(int steps){
        if (steps + level >= MAXIMUM_LEVEL) return;
        this.level += steps;
    }

    /**
     * Increase this skill by a random number between 0 and
     *  the passed {@code maximum}-argument.
     * @param maximum the maximum number of steps this skill
     *  should be increased.
     */
    public void increaseLevelRandom(int maximum){
        int draw = new Random().nextInt(maximum);
        if (level + draw >= MAXIMUM_LEVEL) return;
        level += draw;
    }
    
}
