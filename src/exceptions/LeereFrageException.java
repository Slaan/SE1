package exceptions;

/**
 * 
 * @author alex
 *
 */
public class LeereFrageException extends Exception {
	
	  public LeereFrageException() { super(); }
	  public LeereFrageException(String message) { super(message); }
	  public LeereFrageException(String message, Throwable cause) { super(message, cause); }
	  public LeereFrageException(Throwable cause) { super(cause); }
	  
}
