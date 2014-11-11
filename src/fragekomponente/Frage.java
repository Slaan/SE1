package fragekomponente;

import java.util.Set;

import simple_typen.UniqueID;
import exceptions.LeereFragenException;
import exceptions.UngueltigeAnwortAnzahlException;
import exceptions.KeineKorrekteAntwortVorhandenException;

/**
 * 
 * @author Alex Mantel, Daniel Hofmeister; Praktikumsgruppe 2
 *
 */
public class Frage {

	private Integer			  			_question_id;
	private	Integer			  			_group_id;
	private	String			  			_question_text;
	private	Set<AntwortMoeglichkeit> 	_answer_options;
	private String			 		  	_information_text;
	
	public Frage(Integer groupid, Set<AntwortMoeglichkeit> answer_option, String frage_text) throws 
							 UngueltigeAnwortAnzahlException, 
							 KeineKorrekteAntwortVorhandenException, 
							 LeereFragenException {
		if(groupid == null) throw new NullPointerException();
		if(answer_option == null) throw new NullPointerException();
		if(frage_text == null) throw new NullPointerException();
		_question_id = UniqueID.getUniqueId();
		
		isValid();
	}
	
	/**
	 * Ueberprueft ob vier Fragen vorhanden sind, (Glossar)
	 * mindestens eine von diesen korrekt ist
	 * @throws LeereFragenException 
	 * @throws UngueltigeAnwortAnzahlException 
	 * @throws KeineKorrekteAntwortVorhandenException 
	 */
	private void isValid() throws 	UngueltigeAnwortAnzahlException, 
									KeineKorrekteAntwortVorhandenException, 
									LeereFragenException {
		if(_answer_options.isEmpty()) throw new LeereFragenException();
		if(_answer_options.size() != 4) throw new UngueltigeAnwortAnzahlException();
		// check that there is at least one
		// correct answer
		boolean accu = false;
		for(AntwortMoeglichkeit answer : _answer_options) {
				accu = accu || answer.istRichtig();
		}
		if(!accu) throw new KeineKorrekteAntwortVorhandenException();
		// check questiontext
	}
	
	/**
	 * Setze neue Hintergrundinformation fuer die Frage
	 * @param info 
	 */
	public void setzeInformationsText(String info) {
		if(info == null) throw new IllegalArgumentException("Information ist null");
		_information_text = info;
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
	public Set<AntwortMoeglichkeit> getAnswerOptions() {
		return _answer_options;
	}
	
	/**
	 * 
	 * @return information 
	 */
	public String getInformationText() {
		return _information_text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if(!(obj instanceof Frage)) {
			return false;
		} else {
			Frage other = (Frage) obj;
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