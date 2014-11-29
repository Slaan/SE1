package Fragekomponente;

import java.awt.Image;
import java.util.Set;

import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class BildFrage extends Frage {
	
	private Image _bild;

	public BildFrage(Integer groupid, Set<AntwortmoeglichkeitTyp> answer_option, String frage_text, Image bild) throws 	
								UngueltigeAnwortAnzahlException,
								KeineKorrekteAntwortVorhandenException, 
								LeereFragenException {
		super(frage_text, answer_option);
		_bild = bild;
	}
		
	/**
	 * 
	 */
	 public Image getBild() {
		 return _bild;
	 }

}