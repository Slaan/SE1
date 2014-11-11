package fragekomponente;

import java.awt.Image;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;

import exceptions.LeereFragenException;
import exceptions.UngueltigeAnwortAnzahlException;
import exceptions.KeineKorrekteAntwortVorhandenException;

public class BildFrage extends Frage {
	
	private Image _bild;

	public BildFrage(Integer groupid, Set<AntwortMoeglichkeit> answer_option, String frage_text, Image bild) throws 	
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