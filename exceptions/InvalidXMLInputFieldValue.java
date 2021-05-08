package exceptions;
/**
 * Exception class offers to overstepping a restrictions, which are whiten in the Task
 */
public class InvalidXMLInputFieldValue extends Exception{

    /**
     * Exceptions' default constructor
     * @param message - this message will pop out in System.out stream if an exception
     */
    public InvalidXMLInputFieldValue (String message){
        super(message);
    }
}
