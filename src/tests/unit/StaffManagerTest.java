package tests.unit;

import ita23.managerframework.player.PlayerStat;
import ita23.managerframework.skill.AbstractSkill;
import ita23.managerframework.staff.Employee;
import ita23.managerframework.staff.StaffManager;
import org.junit.Before;
import org.junit.Test;
import tests.mocks.ActivityMock;
import tests.mocks.EmployeeMock;

import static junit.framework.Assert.assertTrue;

/**
 * @author Lukas Knuth
 * @version 1.0
 * Unit-Test for the {@code StaffManager}-class.
 */
public class StaffManagerTest {
    
    private StaffManager manager;
    private PlayerStat player;

    /**
     * Set up the test-environment.
     */
    @Before
    public void setUp(){
        manager = StaffManager.INSTANCE;
        player = PlayerStat.INSTANCE;
    }

    /**
     * Test if a single Employee can be retrieved from the {@code StaffManager}
     */
    @Test
    public void testGetEmployee() throws Exception {
        Employee employee = new EmployeeMock("Testguy");
        manager.hire(employee);
        Employee got = manager.getEmployee(employee.getName());
        manager.fire(employee);
        assertTrue(employee.equals(got));
    }

    /**
     * Test if the whole Staff can successfully be retrieved.
     */
    @Test
    public void testGetStaff() throws Exception {
        System.out.println("--- Getting Staff ---");
        manager.hire(new EmployeeMock("Typ1"));
        manager.hire(new EmployeeMock("Typ2"));
        manager.hire(new EmployeeMock("Typ3"));
        System.out.println("Count: " + manager.getStaff().size());
        for (Employee emp : manager.getStaff()){
            System.out.println(emp.getName()+" > "+emp.getGender());
        }
        assertTrue(true);
    }

    /**
     * Test if hiring and firing of staff works.
     */
    @Test
    public void testHireFire() throws Exception {
        Employee employee = new EmployeeMock("Bottler");
        int current = manager.getStaff().size();
        manager.hire(employee);
        boolean hire_works = manager.getStaff().size() == current+1;
        manager.fire(employee);
        boolean fire_works = manager.getStaff().size() == current;
        assertTrue(hire_works && fire_works);
    }

    /**
     * Test if using an {@code AbstractActivity} to increase the users skills
     *  works.
     */
    @Test
    public void testActivity() throws Exception{
        // Hire someone:
        manager.hire(new EmployeeMock("Guybrush"));
        Employee guy = manager.getEmployee("Guybrush");
        // Show his stat:
        System.out.println("Before Activity");
        for (AbstractSkill skill : guy.getSkills()){
            System.out.println(skill.getName()+" > "+skill.getCurrentLevel());
        }
        // Train!
        manager.trainEmployee(guy, new ActivityMock());
        // Print out:
        System.out.println("After Activity");
        for (AbstractSkill skill : guy.getSkills()){
            System.out.println(skill.getName()+" > "+skill.getCurrentLevel());
        }
        assertTrue(true);
    }

    /**
     * Test if paying the staff works.
     */
    @Test
    public void testPayStaff() throws Exception{
        System.out.println("Before Paying Staff: "+player.getMoney());
        Employee guy = new EmployeeMock("Bottler");
        manager.hire(guy);
        manager.payStaff();
        System.out.println("After Paying Staff: "+player.getMoney());
        assertTrue((10000 - guy.getSalary()) == player.getMoney());
    }
}
