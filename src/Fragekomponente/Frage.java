package Fragekomponente;

import java.util.Set;

import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
import SoLeCommon.AntwortmoeglichkeitTyp;
import SoLeCommon.UniqueID;

/**
 * 
 * @author Alex Mantel, Daniel Hofmeister; Praktikumsgruppe 2
 *
 */
public class Frage implements IFrage {

	private Integer			  				_question_id;
	private	String			  				_question_text;
	private	Set<AntwortmoeglichkeitTyp> 	_answer_options;
	private String			 		  		_information_text;
	
	public Frage(String frage_text, Set<AntwortmoeglichkeitTyp> answer_option) throws 
							 UngueltigeAnwortAnzahlException, 
							 KeineKorrekteAntwortVorhandenException, 
							 LeereFragenException {
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
		for(AntwortmoeglichkeitTyp answer : _answer_options) {
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
	public String getFrageText() {
		return _question_text;
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<AntwortmoeglichkeitTyp> getAntworten() {
		return _answer_options;
	}
	
	/**
	 * 
	 * @return information 
	 */
	public String getInformationsText() {
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
			//boolean a = _answer_options.equals(other.getAntworten())
					 return _information_text.equals(other.getInformationsText());
//					 && _question_id.equals(other.getQuestionID())
//					 && _question_text.equals(other.getFrageText());
//			return a;
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
	
	@Override
	public String toString() {
		return "Frage(" + _question_id 		+
			   ", "		+ _question_text 	+
			   ", "		+ _answer_options + ")";		
	}

}