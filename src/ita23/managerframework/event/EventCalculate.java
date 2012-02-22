package ita23.managerframework.event;

import ita23.managerframework.contract.ProjectJob;
import ita23.managerframework.contract.Requirement;
import ita23.managerframework.player.PlayerStat;

import java.util.*;

/**
 * The Class EventCalculate calculate the place from the project list.</p>
 * The results of the calculate are stored in the playerStat for the statistic.
 * @author Fabian Bottler
 * @version 1.0
 */
public class EventCalculate implements Comparator{

    /** It is the name of the Event */
    private String eventName;

    /** It take the maximal Price money that the user can win */
    private int maxPriceMoney;

    /** It take the maximal fans that can the user reach*/
    private int maxFans;

    /** The ArrayList from the Projects thai joined the event */
    private List<ProjectJob> projectList;

    /** The money that the user has won in the event */
    private int money;

    /** The number of fans that the user has reached */
    private int fans;

    /** The instants of the
     * @see EventStats
     */
    private EventStats eventStats;

    /** Count  the points from a project to calculate  the place*/
    private int countPoints;

    /** Hold  the points from every  project */
    private Map<String, Integer> projectPoints;

    /**
     * This ist the public constructor from the EventCalculate
     * @param eventName the name of the event
     * @param maxPriceMoney the maximal price money that can  the user win in the event
     * @param maxFans the maximal fans that can get the user in the event.
     * @param projectList the complete list of projects that has joined the event
     */
    public EventCalculate(String eventName, int maxPriceMoney, int maxFans, List<ProjectJob> projectList) {

        this.eventName = eventName;
        this.maxPriceMoney = maxPriceMoney;
        this.maxFans = maxFans;
        this.projectList = projectList;

        projectPoints = new HashMap<String, Integer>();
    }


    /**
     * The calculate method is for the calculate the place
     * of a project in the event.
     * First we sort the own projects in order of here points
     * and than we calculate the place of the projects.
     */
    private void calculate(){
        //TODO Implemens the calculate method
        for(ProjectJob projectJob : projectList){

            for(Requirement requirement : projectJob.getRequirements()){
                countPoints+=requirement.getPoints();
            }
            projectPoints.put(projectJob.getName(),countPoints);
            countPoints=0;
        }

        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(this);
        sortedMap.putAll(projectPoints);



    }

    /**
     * this is a method from the implement class Comparato and it is used to sort a ArrayList.
     * @param o1 that is the first object to compare with o2
     * @param o2 that is the second object to compare with o1
     * @return it return a number, 1 to change the tow objects and 0 to do nothing.
     */
    @Override
    public int compare(Object o1, Object o2) {
        return projectPoints.get(o2).compareTo(projectPoints.get(o1));
    }

    /**
     * Set the results of the calculate to the PlayerStat.
     */
    private void setEventStatToPlayer(){
        PlayerStat.INSTANCE.eventOver(money, fans, eventStats);
    }

}
