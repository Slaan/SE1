package fragekomponente;

import java.util.Set;

import javax.sound.sampled.AudioInputStream;

import exceptions.KeineKorrekteAntwortVorhandenException;
import exceptions.LeereFragenException;
import exceptions.UngueltigeAnwortAnzahlException;

public class AudioFrage extends Frage {

	private AudioInputStream _audio;
	
	public AudioFrage(Integer groupid, Set<AntwortMoeglichkeit> answer_option, String frage_text, AudioInputStream audio) throws 	
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