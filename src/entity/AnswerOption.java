package entity;

public class AnswerOption {
	
	private String 	_answer_text;
	private	Boolean	_is_correct;
	
	/**
	 * 
	 * @param answer_text
	 * @param is_correct
	 */
	public AnswerOption(String answer_text, Boolean is_correct) {
		if(answer_text == null) throw new IllegalArgumentException("Antworttext darf nicht leer sein.");
		if(is_correct == null) throw new IllegalArgumentException("Der Wahrheitswert muss gesetzt werden.");
		_answer_text = answer_text;
		_is_correct = is_correct;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if(!(obj instanceof AnswerOption)) {
			return false;
		} else {
			AnswerOption other = (AnswerOption) obj;
			boolean a = _answer_text.equals(other.getAnswerText());
			return a && _is_correct.equals(other.isCorrect());
		}
	} 
	
	/**
	 * 
	 * @return
	 */
	public String getAnswerText() {
		return _answer_text;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean isCorrect() {
		return _is_correct;
	}
}