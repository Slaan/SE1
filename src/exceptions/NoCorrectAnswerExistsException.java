package exceptions;

public class NoCorrectAnswerExistsException extends Exception {

	  public NoCorrectAnswerExistsException() { super(); }
	  public NoCorrectAnswerExistsException(String message) { super(message); }
	  public NoCorrectAnswerExistsException(String message, Throwable cause) { super(message, cause); }
	  public NoCorrectAnswerExistsException(Throwable cause) { super(cause); }
	  
}