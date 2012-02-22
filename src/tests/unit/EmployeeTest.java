package tests.unit;

import ita23.managerframework.skill.AbstractSkill;
import ita23.managerframework.staff.Employee;
import org.junit.Before;
import org.junit.Test;
import tests.mocks.EmployeeMock;

import static org.junit.Assert.assertTrue;

/**
 * @author Lukas Knuth
 * @version 1.0
 * Tests for the {@code Employee}-class.
 */
public class EmployeeTest {

    /** The {@code Employee}-object to work with */
    private Employee guy;

    /**
     * Set up the test-internment.
     */
    @Before
    public void setUp(){
        this.guy = new EmployeeMock("Bottler");
    }

    /**
     * Check if increasing the level of the employee works and also check
     *  if the Skill are being updated probably.
     */
    @Test
    public void testIncreaseLevel() throws Exception {
        System.out.println("Before Lvl-Up:");
        for (AbstractSkill skill : guy.getSkills()){
            System.out.println(skill.getName()+" > "+skill.getCurrentLevel());
        }
        // Increase:
        guy.increaseLevel();
        // List:
        System.out.println("After Lvl-Up:");
        for (AbstractSkill skill : guy.getSkills()){
            System.out.println(skill.getName()+" > "+skill.getCurrentLevel());
        }
        assertTrue(guy.getLevel() == 2);
    }

    /**
     * Simply read out all Skills and their current level.
     */
    @Test
    public void testReadSkills() throws Exception{
        for (AbstractSkill skill : guy.getSkills()){
            System.out.println(skill.getName()+" > "+skill.getCurrentLevel());
        }
        assertTrue(true);
    }

    /**
     * Test if fetching a single Skill from the {@code Employee} works.
     *  Also try to increase it's level and check if this works.
     */
    @Test
    public void testSingleSkill() throws Exception{
        AbstractSkill skill = guy.getSkill("Scenario");
        skill.increaseLevel(3);
        int skill_lvl = guy.getSkill("Scenario").getCurrentLevel();
        System.out.println("New Skill-Level: "+skill_lvl);
        assertTrue(skill_lvl == 3);
    }

}
