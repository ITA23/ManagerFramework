package ita23.managerframework.event;

import ita23.managerframework.contract.ProjectJob;
import ita23.managerframework.time.TimeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * In the EventHandler the Developer can create a new event and
 *  set the project witch should join the game.</p>
 * It take place every year at a week on the developers mind
 * @author Fabian Bottler
 * @version 1.0
 */
public class EventHandler implements TimeListener {

    /** The name of the event */
    private String eventName;

    /** The maximal money which  can the user win  */
    private int maxPriceMoney;

    /** The maximal number of fans that the user can get .*/
    private int maxFans;

    /** It says us when came the event in which week  */
    private int onWeek;

    /** Its the week iterator  */
    private int week = 0;

    /** That is the list of Projects thai  joined the event */
    private List<ProjectJob> projectList;

    /** This is an instant of the EventCalculate class.*/
    private EventCalculate eventCalculate ;

    /**
     * This ist the public constructor from the Event Handler.
     * @param eventName set The name of the Event
     * @param maxPriceMoney set the maximal money that can the user take
     * @param maxFans set the maximal fans that the user can win
     * @param onWeek set the week in which the event take place.
     */
    public EventHandler(String eventName, int maxPriceMoney, int maxFans, int onWeek) {
        this.eventName = eventName;
        this.maxPriceMoney = maxPriceMoney;
        this.maxFans = maxFans;
        this.onWeek = onWeek;

        projectList  = new ArrayList<ProjectJob>();
    }


    /**
     * The implemented weekOver method from the TimeListener.
     * In this method we increase the week and
     * when the week equals weekOver  we start the eventCalculate.
     */
    @Override
    public void weekOver() {
        week++;
        if (week == onWeek) {
            eventCalculate  = new EventCalculate(eventName, maxPriceMoney, maxFans, projectList);
        }
    }

    /**
     * The implemented yearOver method from the TimeListener.
     * If a year is over , than we set the week to 0.
     */
    @Override
    public void yearOver() {
        week = 0;
    }

    /** Unused */ @Override public void dayOver() {}
    /** Unused */ @Override public void monthOver(){}

    /**
     * This method add a Project to the arrayList.
     * @param projectJob the instants of a project that we would store in the  arrayList
     */
    public void addProject(ProjectJob projectJob){
        this.projectList.add(projectJob);
    }

    /**
     * This method remove projects from the arrayList.
     * @param projectJob the instants of a project that we would remove in the arrayList
     */
    public void removeProject(ProjectJob projectJob){
        this.projectList.remove(projectJob);
    }
}
