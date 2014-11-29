package Fragekomponente;

import java.util.Set;

import javax.sound.sampled.AudioInputStream;

import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class AudioFrage extends Frage {

	private AudioInputStream _audio;
	
	public AudioFrage(Integer groupid, Set<AntwortmoeglichkeitTyp> answer_option, String frage_text, AudioInputStream audio) throws 	
																			UngueltigeAnwortAnzahlException,
																			KeineKorrekteAntwortVorhandenException, 
								LeereFragenException {
		super(groupid, answer_option, frage_text);
		_audio = audio; 
	}

	/**
	 * @return audio
	 */
	public AudioInputStream getAudio() {
		return _audio;
	}

}