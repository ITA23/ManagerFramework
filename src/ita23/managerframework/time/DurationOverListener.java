package ita23.managerframework.time;

/**
 * This interface can be used to subscribe to a "duration-over"-event,
 *  fired by the registered {@code Duration}.
 * @author Lukas Knuth
 * @version 1.0
 */
public interface DurationOverListener {

    /**
     * This method is called when the duration is over.
     */
    public void durationOver();
}
