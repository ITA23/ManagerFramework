package ita23.managerframework.item;

import ita23.managerframework.skill.AbstractSkill;

/**
 * This interface represents an Boost
 * @author Rafael Marques
 * @author Lukas Knuth
 * @version 1.0
 */
public interface Boost {

    /**
     * Returns the skill to boost
     * @return the boosted skill
     */
    public AbstractSkill getBoostedSkill();

    /**
     * Returns the amount of points to boost.
     * @return the amount of points to boost.
     */
    public int getBoostPoints();

    /**
     * Returns the price of this item
     * @return the boosts price,
     */
    public int getPrice();

    /**
     * Returns the name of this item
     * @return the boosts name.
     */
    public String getName();

    /**
     * Returns the description of this Boost
     * @return the boosts description.
     */
    public String getDescription();
}
