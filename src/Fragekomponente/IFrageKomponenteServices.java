package Fragekomponente;

import java.util.Set;

import Exceptions.InvalideFrageException;
import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
import SoLeCommon.AntwortmoeglichkeitTyp;


public interface IFrageKomponenteServices {

	/**
	 * Erstellt eine neue TextFrage
	 * @param fragetext
	 * @param antworten - es muessen vier vorhanden sein, von der mindestens eine korrekt ist. 
	 * @throws InvalideFrageException wird geworfen, wenn nicht vier Antwortmoeglichkeiten gegeben sind, von 
	 * diesen nicht mindestens eine korrekt ist oder der frageText null ist.
	 */
	public IFrage erstelleTextFrage(String fragetext, Set<AntwortmoeglichkeitTyp> antworten) 
															throws UngueltigeAnwortAnzahlException, 
															KeineKorrekteAntwortVorhandenException, 
															LeereFragenException;
;
}
