package Fragekomponente;

import java.util.Set;

import SoLeCommon.AntwortmoeglichkeitTyp;

public interface IFrage {
	
	/**
	 * 
	 * @return id
	 */
	public Integer getFragenummer();
	
	/**
	 * 
	 * @return Fragetext
	 */
	public String getFrageText();
	
	/**
	 * 
	 * @return Set der Antwortmoeglichkiten
	 */
	public Set<AntwortmoeglichkeitTyp> getAntworten();
	
	/**
	 * 
	 * @return Informationstext
	 */
	public String getInformationsText();
	
	/**
	 * ueberprueft, ob zwei Objekte gleich sind
	 * @param o
	 * @return wahr oder falsch, je nachdem ob sie gleich sind.
	 */
	public boolean equals(Object o);
	
	/**
	 * Typical toString method
	 * @return a string containing all values
	 */
	public String toString();
}
