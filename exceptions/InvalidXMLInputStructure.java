package exceptions;
/**
 * Exception class offers to a major contradiction while parsing
 */
public class InvalidXMLInputStructure extends RuntimeException{
    /**
     * Exceptions' default constructor
     * @param message - this message will pop out in System.out stream if an exception
     */
    public InvalidXMLInputStructure(String message){
        super(message);
    }
}