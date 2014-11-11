package exceptions;

/**
 * 
 * @author alex
 *
 */
public class UngueltigeEmailException extends Exception {
	
	  public UngueltigeEmailException() { super(); }
	  public UngueltigeEmailException(String message) { super(message); }
	  public UngueltigeEmailException(String message, Throwable cause) { super(message, cause); }
	  public UngueltigeEmailException(Throwable cause) { super(cause); }
	  
}
