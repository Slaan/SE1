package Exceptions;

/**
 * 
 * @author alex
 *
 */
public class LeereFragenException extends Exception {
	
	  public LeereFragenException() { super(); }
	  public LeereFragenException(String message) { super(message); }
	  public LeereFragenException(String message, Throwable cause) { super(message, cause); }
	  public LeereFragenException(Throwable cause) { super(cause); }
	  
}
