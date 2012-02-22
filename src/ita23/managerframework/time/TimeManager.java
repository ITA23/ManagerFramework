package ita23.managerframework.time;

import java.util.*;

/**
 * The TimeManager manage the time interval and fired a event,
 *  if the timer reached a week, a month or a year.
 * @author Fabian Bottler
 * @version 1.0
 */
public enum TimeManager {
    /**The instance to work with */
    INSTANCE;

    /**The List hold all declared classes */
    private List<TimeListener> timeListener;

    /**the final time in milli second for a week, in this case we used 10 minutes for one week */
    private final long dayOver = Math.round(1 * Math.pow(10,4));

    /**The timer variable is to start the Timer class */
    private Timer time = new Timer("week", true);
    
    private int days;

    /**In weeks we hold the weeks until to a month  */
    private int weeks;

    /**In month we hold the month until to a year  */
    private int months;

    /**The playedTime hold the time we have played */
    private int playedTime;

    /**
     * In the constructor we initialize the variables and
     * start the time method withe a inner-class which execute
     * the executeTime method every 10 minutes.
     */
    private TimeManager() {
        days = 0;
        weeks = 0;
        months = 0;
        playedTime = 0;

        // TODO Synchronize the list in some way (use a queue?) so that listeners can be unregistered.
        timeListener = new ArrayList<TimeListener>();

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                try{
                    executeTime();
                } catch (ConcurrentModificationException e){
                    /** God, this is so dirty.. I feel so bad about this...
                     * I'm going to kill myself for this...*/
                }
            }
        }, dayOver, dayOver);
    }

    /**
     * In the executeTime method we fire every time the dayOver method of the TimeListener.
     * we increase the weeks and when  we reach 4 weeks, than we fire the monthOver method of the TimeListener,
     *increase the month and set the weeks to 0.
     *When the month reach 12, than we fired the yearOver method of the TimeListener and set the month to 0.
     * We also increase the playedTime every time.
     */
    private void executeTime() {

        days++;
        playedTime++;

        for (TimeListener list : timeListener){

            list.dayOver();
        }


        if (days == 5) {
            days = 0;
            weeks++;

            for (TimeListener list : timeListener){

                list.weekOver();
            }
        }

        if (weeks == 4) {
            weeks = 0;
            months++;

            for (TimeListener list : timeListener){

                list.monthOver();
            }
        }

        if (months == 12) {
            months = 0;

            for (TimeListener list : timeListener){

                list.yearOver();
            }
        }
    }

    /**
     * In this method we add a Listener to the ArrayList.
     * @param timeList is the instance from the class which implements the TimeListener.
     */
    public void addTimeListener(TimeListener timeList) {
        timeListener.add(timeList);
    }

    /**
     * In this method we remove a Listener from the ArrayList.
     * @param timeList is the instance from the class which implements the TimeListener.
     */
    public void removeTimeListener(TimeListener timeList) {
        timeListener.remove(timeList);
    }

    /**
     * Get the time the Player had played.
     * @return the played time.
     */
    public int getPlayedTime(){
        return playedTime;
    }

}
