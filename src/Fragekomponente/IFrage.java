package Fragekomponente;

import java.util.Set;

import SoLeCommon.AntwortmoeglichkeitTyp;

public interface IFrage {
	
	/**
	 * 
	 * @return Fragetext
	 */
	public String getFrageText();
	
	/**
	 * 
	 * @return Set der Antwortmöglichkiten
	 */
	public Set<AntwortmoeglichkeitTyp> getAntworten();
	
	/**
	 * 
	 * @return Informationstext
	 */
	public String getInformationsText();
	
	/**
	 * Überprüft, ob zwei Objekte gleich sind
	 * @param o
	 * @return wahr oder falsch, je nachdem ob sie gleich sind.
	 */
	public boolean equals(Object o);
	
}
