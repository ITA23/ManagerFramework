package ita23.managerframework.contract;

/**
 * This Exception is thrown if there was a problem taking a new job.
 * @author Lukas Knuth
 * @version 1.0
 */
public class CantTakeJobException extends Exception{
    
    public CantTakeJobException(String message){
        super(message);
    }
}
