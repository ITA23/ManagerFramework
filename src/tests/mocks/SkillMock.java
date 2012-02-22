package tests.mocks;

import ita23.managerframework.skill.AbstractSkill;

/**
 * @author Lukas Knuth
 * @version 1.0
 */
public class SkillMock extends AbstractSkill {
    
    private String skill_name;
    
    public static final String SKILL_WRITING = "Writing";
    public static final String SKILL_SCENARIO = "Scenario";
    
    public SkillMock(String name){
        this.skill_name = name;
    }

    @Override
    public String getName() {
        return skill_name;
    }
}
