package Gruppenkomponente;

import java.util.Set;

import Benutzerkomponente.INutzer;
import Fragekomponente.IFrage;

public interface IGruppe {
	
	/**
	 * 
	 * @return Name der Gruppe
	 */
	public String getName();
	
	/**
	 * 
	 * @return ID der Gruppe
	 */
	public Integer getGroupID();
	
	/**
	 * 
	 * @return alle Nutzer der Gruppe
	 */
	public Set<INutzer> getNutzer();
	
	/**
	 * 
	 * @return Fragen der Gruppe
	 */
	public Set<IFrage> getFragen();
	
	/**
	 * Uewberprueft, ob zwei Objekte gleich sind
	 * @param o
	 * @return wahr oder falsch, je nachdem ob sie gleich sind.
	 */
	public boolean equals(Object o);

}
