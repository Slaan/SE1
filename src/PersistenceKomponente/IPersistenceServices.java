package PersistenceKomponente;

import java.sql.ResultSet;

import Benutzerkomponente.INutzer;
import Fragekomponente.IFrage;
import Gruppenkomponente.IGruppe;

/**
 * Presistenzschicht
 *
 */
public interface IPersistenceServices {
	
	
	/**
	 * Legt einen neuen Datenbankeintrag f��r einen neuen Nutzer an.
	 * @param neuerNutzer Zu speichernder Nutzer
	 * @return 
	 */
	void nutzerSpeichern(INutzer neuerNutzer);
	
	/**
	 * Speichert eine Frage f��r eine Gruppe
	 * @param gruppe Gruppe f��r die die Frage erstellt wurde
	 * @param frage Frage die gespeichert werden soll
	 */
	void speicherFrage(IGruppe gruppe, IFrage frage);
	
	/**
	 * Logged den Nutzer ein
	 * @param nutzername
	 * @param passwort
	 * @return Nutzerdaten
	 */
	ResultSet nutzerLogIn(String nutzername, String passwort);
	
	/**
	 * 
	 * @param gruppeID
	 * @return Gruppendaten
	 */
	ResultSet getGruppe(Integer gruppeID);
}
