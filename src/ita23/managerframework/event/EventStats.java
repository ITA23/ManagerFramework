package ita23.managerframework.event;

/**
 * The EventStats class hold all event info from a project.</p>
 * It is hold in a ArrayList in the PlayerStat class.
 * @author Fabian Bottler
 * @version 1.0
 */
public class EventStats {
    /** Event Name hold the name of the event*/
    private String eventName;

    /** Project Name is the name from the project witch joined the event */
    private String projectName;

    /** It show the place that the project have reached  */
    private int place;

    /** It give us the money we have won from the event */
    private int priceMoney;

    /** It give us the number of fans we have won at the event */
    private int fans;

    /**
     * This ist the public constructor.
     * @param eventName set the name of the event.
     * @param projectName set the name from the project witch joined the event
     * @param place set teh place that the user had reached
     * @param priceMoney set the money that the user has won
     * @param fans set the winn of the fans in the event.
     */
    public EventStats(String eventName,String projectName, int place, int priceMoney, int fans){
        this.eventName = eventName;
        this.projectName = projectName;
        this.place = place;
        this.priceMoney = priceMoney;
        this.fans = fans;
    }

    /**
     * Get the name from the Event we have involved
     * @return the name of the event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Get the Place of the project
     * @return the place as number
     */
    public int getPlace() {
        return place;
    }

    /**
     * Get the money the have won
     * @return the money
     */
    public int getPriceMoney() {
        return priceMoney;
    }

    /**
     * Get the fans witch the user won in the event
     * @return the fans as number
     */
    public int getFans() {
        return fans;
    }

    /**
     *  Get the name of the project witch was joined the event
     * @return the name of the project as a String
     */
    public String getProjectName() {
        return projectName;
    }
}
