package exceptions;

public class InvalidAmountOfAnswersException extends Exception {

	  public InvalidAmountOfAnswersException() { super(); }
	  public InvalidAmountOfAnswersException(String message) { super(message); }
	  public InvalidAmountOfAnswersException(String message, Throwable cause) { super(message, cause); }
	  public InvalidAmountOfAnswersException(Throwable cause) { super(cause); }
	  
}