package exceptions;

/**
 * 
 * @author alex
 *
 */
public class EmptyQuestionException extends Exception {
	
	  public EmptyQuestionException() { super(); }
	  public EmptyQuestionException(String message) { super(message); }
	  public EmptyQuestionException(String message, Throwable cause) { super(message, cause); }
	  public EmptyQuestionException(Throwable cause) { super(cause); }
	  
}
