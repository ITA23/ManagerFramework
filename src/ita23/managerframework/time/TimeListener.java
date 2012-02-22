package ita23.managerframework.time;

/**
 * The interface for the time listener to push events on the declared classes
 * @author Fabian Bottler
 * @version 1.0
 */
public interface TimeListener  {

    /**
     * This method is called, when a day is over
     */
    public void dayOver();

    /**
     * This method is called, when a week is over
     */
    public void weekOver();

    /**
     * This method is called, when a month is over
     */
    public void monthOver();

    /**
     * This method is called, when a Year is over
     */
    public void yearOver();


}
