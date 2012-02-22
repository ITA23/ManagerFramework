package ita23.managerframework.time;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a period of time which the {@code TimeManager}
 *  keeps track of.</p>
 * This class is immutable and therefore guaranteed to be thread-safe.
 * @author Lukas Knuth
 * @version 1.0
 */
public class Duration implements TimeListener {

    /** The count of weeks, this period goes. */
    private final int weeks;
    /** The count of months, this period goes. */
    private final int months;
    /** The count of years, this period goes. */
    private final int years;
    
    /** Counts the weeks, already over */
    private int weeks_over;
    /** Counts the moths, already over */
    private int months_over;
    /** Counts the years, already over */
    private int years_over;
    
    /** Collects all registered {@code DurationOverListener}s */
    private List<DurationOverListener> listeners;

    /**
     * Creates a new period of time.
     * @param weeks the amount of weeks in this period.
     * @param moths the amount of moths in this period.
     * @param years the amount of years in this period.
     */
    public Duration(int weeks, int moths, int years){
        this.weeks = weeks;
        this.months = moths;
        this.years = years;
        this.weeks_over = 0;
        this.months_over = 0;
        this.years_over = 0;
        this.listeners = new ArrayList<DurationOverListener>(4);
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(20);
        if (weeks != 0) builder.append(weeks+" Weeks");
        if (months != 0) builder.append(months+" Months");
        if (years != 0) builder.append(years+" Years");
        return builder.toString();
    }

    /**
     * Register a new {@code DurationOverListener} to this {@code Duration}.
     * @param listener the new listener which should be called, when this
     *  {@code Duration} is over.
     */
    public void addDurationOverListener(DurationOverListener listener){
        listeners.add(listener);
    }

    /**
     * Remove a previously added {@code DurationOverListener} from this
     *  {@code Duration}
     * @param listener the {@code DurationOverListener} to remove.
     */
    public void removeDurationOverListener(DurationOverListener listener){
        listeners.remove(listener);
    }

    /**
     * Registers this {@code Duration} to the {@code TimeManager} and
     *  starts keeping track of the time.
     */
    public void startDuration(){
        TimeManager.INSTANCE.addTimeListener(this);
    }

    /**
     * Cancels this {@code Duration}, for example if the Job finished
     *  before it was over.
     */
    public void cancelDuration(){
        TimeManager.INSTANCE.removeTimeListener(this);
    }

    /**
     * Checks if this duration is over. If so, calls all registered
     *  {@code DurationOverListener} to notify them.
     */
    private void checkAndNotify(){
        // Check:
        if (weeks_over != weeks &&
            months_over != months &&
            years_over != years) return;
        // Else, call:
        for (DurationOverListener listener : listeners)
            listener.durationOver();
        // Remove self from TimeManager
        this.cancelDuration();
    }

    @Override
    public void weekOver() {
        this.weeks_over++;
        checkAndNotify();
    }

    @Override
    public void monthOver() {
        this.months_over++;
        checkAndNotify();
    }

    @Override
    public void yearOver() {
        this.years_over++;
        checkAndNotify();
    }

    /** Unused */
    @Override public void dayOver() {}
}
