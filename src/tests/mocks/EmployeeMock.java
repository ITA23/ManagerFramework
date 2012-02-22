package tests.mocks;

import ita23.managerframework.skill.AbstractSkill;
import ita23.managerframework.staff.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lukas Knuth
 * @version 1.0
 * Mock-class to test the {@code Employee}-class.
 */
public class EmployeeMock extends Employee {

    private String name;
    private HashMap<String, AbstractSkill> skills;

    public EmployeeMock(String name){
        this.name = name;
        this.skills = new HashMap<String, AbstractSkill>(4);
        AbstractSkill skill = new SkillMock(SkillMock.SKILL_WRITING);
        AbstractSkill skill2 = new SkillMock(SkillMock.SKILL_SCENARIO);
        skills.put(skill.getName(), skill);
        skills.put(skill2.getName(), skill2);
    }

    @Override
    public AbstractSkill getSkill(String skill_name) {
        return skills.get(skill_name);
    }

    @Override
    public List<AbstractSkill> getSkills() {
        return new ArrayList<AbstractSkill>(skills.values());
    }

    @Override
    public int getSalary() {
        return 200;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Gender getGender() {
        return Gender.MALE;
    }
}
