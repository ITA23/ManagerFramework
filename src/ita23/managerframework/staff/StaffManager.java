package ita23.managerframework.staff;

import ita23.managerframework.item.Boost;
import ita23.managerframework.player.PlayerStat;
import ita23.managerframework.skill.AbstractActivity;
import ita23.managerframework.skill.AbstractSkill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class manages all staff-members which are registered to it.
 * @author Lukas Knuth
 * @version 1.0
 */
public enum StaffManager {

    /** The singleton instance to work with */
    INSTANCE;

    /** All {@code Employee}s which are currently hired */
    private Map<String, Employee> staff;

    /** Maximum amount of employees for the Map initialization */
    private static final int MAX_STAFF_COUNT = 8;

    /**
     * Does the basic setup for this Manager-class.</p>
     *  This class is not instantiable!
     */
    private StaffManager(){
        staff = new HashMap<String, Employee>(MAX_STAFF_COUNT);
    }

    /**
     * Get a single employee by his name.</p>
     * To retrieve a single Employee, first use the {@code getStaff()}-
     *  method to receive a list with the correct mapping and then use
     *  the {@code getName()}-method for the argument of this method.
     * @param employee_name the name of the {@code Employee} to be received.
     * @return the {@code Employee} from the staff.
     */
    public Employee getEmployee(String employee_name){
        return staff.get(employee_name);
    }

    /**
     * Get all employed employees as a {@code List}.
     * @return all currently employed workers.
     */
    public List<Employee> getStaff(){
        return new ArrayList<Employee>(staff.values());
    }

    /**
     * Train a given {@code Employee} with the given {@code AbstractActivity}.
     * @param employee the employee to be trained.
     * @param activity the activity used to train the employee.
     */
    public void trainEmployee(Employee employee, AbstractActivity activity){
        for (AbstractSkill skill : employee.getSkills()){
            int max = activity.increaseSkillMax(skill);
            skill.increaseLevelRandom(max);
        }
        PlayerStat.INSTANCE.investMoney(activity.getPrice());
    }

    /**
     * Boosts all Employees with the given {@code Boost}.
     * @param boost the boost to use.
     */
    public void boostStaff(Boost boost){
        for (Employee employee : this.getStaff())
            employee.boost(boost);
        PlayerStat.INSTANCE.investMoney(boost.getPrice());
    }

    /**
     * Boost a single given {@code Employee} with the given {@code Boost}.
     * @param boost the boost to use.
     * @param employee the employee to boost up.
     */
    public void boostEmployee(Boost boost, Employee employee){
        getEmployee(employee.getName()).boost(boost);
        PlayerStat.INSTANCE.investMoney(boost.getPrice());
    }

    /**
     * Pay all employees from your current staff.
     */
    public void payStaff(){
        for (Employee employee : this.getStaff())
            PlayerStat.INSTANCE.transferSalary(employee.getSalary());
    }

    /**
     * Remove an {@code Employee} from your staff.
     * @param employee the employee to remove from the staff.
     * @throws NullPointerException if {@code employee} is {@code null}.
     */
    public void fire(Employee employee){
        // TODO Add check so you can not fire all Employees.
        if (employee == null) throw new NullPointerException("The Employee can't be null!");
        // Seams okay:
        staff.remove(employee.getName());
    }

    /**
     * Add a new {@code Employee} to your staff.
     * @param employee the new employee to add.
     * @throws NullPointerException if {@code employee} is {@code null}.
     */
    public void hire(Employee employee){
        // TODO Add check here if there is space left for a new Employee (use Room).
        // Check for vitality:
        if (employee == null) throw new NullPointerException("New Employee can't be null!");
        // Seams okay, add:
        staff.put(employee.getName(), employee);
    }
}
