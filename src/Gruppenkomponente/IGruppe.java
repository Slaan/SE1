package Gruppenkomponente;

import java.util.Set;

import Benutzerkomponente.INutzer;
import Exceptions.KeineRechteException;
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
	 * Fuegt eine Frage in der Gruppe hinzu
	 * @param nutzer welcher mitglied der gruppe ist
	 * @param frage 
	 * @throws KeineRechteException falls der nutzer nicht zur gruppe gehoert
	 */
	public void fuegeFrageHinzu(INutzer nutzer, IFrage frage) throws KeineRechteException;
	
	/**
	 * Uewberprueft, ob zwei Objekte gleich sind
	 * @param o
	 * @return wahr oder falsch, je nachdem ob sie gleich sind.
	 */
	public boolean equals(Object o);

}
