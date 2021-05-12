package exceptions;
/**
 * Exception class offers to overstepping a restrictions, which are whiten in the Task
 */
public class InvalidInputValueException extends Exception{

    /**
     * Exceptions' default constructor
     * @param message - this message will pop out in System.out stream if an exception
     */
    public InvalidInputValueException (String message){
        super(message);
    }
}
