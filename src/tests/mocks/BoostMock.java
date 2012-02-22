package tests.mocks;

import ita23.managerframework.item.Boost;
import ita23.managerframework.skill.AbstractSkill;

/**
 * @author Rafael Marques
 * @version 1.0
 * This is the BoostMock for the boost interface
 */
public class BoostMock implements Boost {
    private String boost_name;
    private String boost_description;
    
    public BoostMock(String name, String description){
        this.boost_name = name;
        this.boost_description = description;
    }
    @Override
    public AbstractSkill getBoostedSkill() {
        return new SkillMock(SkillMock.SKILL_SCENARIO);
    }

    @Override
    public int getBoostPoints() {
        return 12;
    }

    @Override
    public int getPrice() {
        return 50;
    }

    @Override
    public String getName() {
        return boost_name;
    }

    @Override
    public String getDescription() {
        return boost_description;
    }
}
