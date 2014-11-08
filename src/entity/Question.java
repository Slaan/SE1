package entity;

import java.util.Set;

import exceptions.EmptyQuestionException;
import exceptions.InvalidAmountOfAnswersException;
import exceptions.NoCorrectAnswerExistsException;

public class Question {

	private Integer			  _question_id;
	private	Integer			  _group_id;
	private	String			  _question_text;
	private	Set<AnswerOption> _answer_options;
	private String			  _information_text;
	
	public Question() throws InvalidAmountOfAnswersException, 
							 NoCorrectAnswerExistsException, 
							 EmptyQuestionException {
		_question_id = UniqueID.getUniqueId();
		
		isValid();
	}
	
	/**
	 * Specification of Question (Glossar)
	 * Checks that the question text is not empty, the 
	 * given answers are at least one correct and that
	 * there are four answers.
	 * @throws InvalidAmountOfAnswersException 
	 * @throws NoCorrectAnswerExistsException 
	 * @throws EmptyQuestionException 
	 */
	private void isValid() throws 	InvalidAmountOfAnswersException, 
									NoCorrectAnswerExistsException, 
									EmptyQuestionException {
		if(_answer_options.size() != 4) throw new InvalidAmountOfAnswersException();
		// check that there is at least one
		// correct answer
		boolean accu = false;
		for(AnswerOption answer : _answer_options) {
				accu = accu || answer.isCorrect();
		}
		if(!accu) throw new NoCorrectAnswerExistsException();
		// check questiontext
		if(_answer_options.isEmpty()) throw new EmptyQuestionException();
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getQuestionID() {
		return _question_id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getQuestionText() {
		return _question_text;
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<AnswerOption> getAnswerOptions() {
		return _answer_options;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInformationText() {
		return _information_text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if(!(obj instanceof Question)) {
			return false;
		} else {
			Question other = (Question) obj;
			boolean a = _answer_options.equals(other.getAnswerOptions())
					 && _information_text.equals(other.getInformationText())
					 && _question_id.equals(other.getQuestionID())
					 && _question_text.equals(other.getQuestionText());
			return a;
		}
	}
	
	@Override
	public int hashCode() {
		return (31 * _question_id) 
		      +(31 * _question_text.hashCode() )
			  +(31 * _answer_options.hashCode())
		      +(31 * _information_text.hashCode())
		      +(31 * _question_text.hashCode());
	}

}