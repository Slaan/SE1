package Fragekomponente;

import java.awt.Image;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;

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
		super(groupid, answer_option, frage_text);
		_bild = bild;
	}
	
	/**
	 * 
	 */
	 public Image getBild() {
		 return _bild;
	 }

}