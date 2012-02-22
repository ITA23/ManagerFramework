package tests.mocks;

import ita23.managerframework.skill.AbstractActivity;
import ita23.managerframework.skill.AbstractSkill;

/**
 * @author Lukas Knuth
 * @version 1.0
 * This is a sample-implementation of the {@code AbstractActivity}-class
 *  used for the Unit-Tests.
 */
public class ActivityMock implements AbstractActivity {
    @Override
    public String getName() {
        return "Chillen";
    }

    @Override
    public int getPrice() {
        return 300;
    }

    @Override
    public int increaseSkillMax(AbstractSkill skill) {
        if (SkillMock.SKILL_SCENARIO.equals(skill.getName())){
            // Increase Scenario...
            return 5;
        } else if (SkillMock.SKILL_WRITING.equals(skill.getName())){
            // Increase wringing:
            return 20;
        } else {
            return 0;
        }
    }
}
