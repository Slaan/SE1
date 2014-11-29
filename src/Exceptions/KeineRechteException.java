package Exceptions;

/**
 * 
 * @author alex
 *
 */
public class KeineRechteException extends Exception {
	
	  public KeineRechteException() { super(); }
	  public KeineRechteException(String message) { super(message); }
	  public KeineRechteException(String message, Throwable cause) { super(message, cause); }
	  public KeineRechteException(Throwable cause) { super(cause); }
	  
}
