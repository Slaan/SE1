package Gruppenkomponente;

import java.sql.SQLException;
import java.util.Set;

import Benutzerkomponente.INutzer;
import Exceptions.GruppeNichtVorhandenException;
import Exceptions.InvalideFrageException;
import Exceptions.KeineAnfrageVorhandenException;
import Exceptions.KeineRechteException;
import Fragekomponente.IFrage;
import SoLeCommon.AntwortmoeglichkeitTyp;

public interface IGruppenkomponenteServices {
	
	/**
	 * Erstellt eine neue Gruppe (A12) 
	 * @param ersteller der Gruppe
	 * @param name der Gruppe
	 * @param passwort fuer Gruppenbeitritt
	 */
	public void erstelleGruppe(INutzer ersteller, String name, String passwort);
	
	/**
	 * Ein Nutzer w��hlt eine Gruppe aus 
	 * @param nutzer
	 * @param GruppenID
	 * @return Die ausgew��hlte Gruppe
	 */
	public IGruppe waehleGruppeAus(INutzer nutzer, Integer GruppenID);
	
	/**
	 * Nutzer tritt mittels Passwort einer Gruppe bei (A13)
	 * @param neues potentielles mitglied
	 * @param passwort welches dem gruppen passwort abgeglichen wird.
	 * @return true wenn das passwort richtig war und neues als Mitglied eingetragen wurde.
	 */
	public boolean treteGruppeMitPasswortBei(INutzer neues, String passwort);

	/**
	 * Bestaetigt eine bereits erstellte Mitgliedsanfrage eines Nutzers  
	 * @param moderator welcher eine mitgliedsanfrage bestaetigen (A14)
	 * @param anfragesteller welcher bestaetigt wird
	 * @throws KeineRechteException 
	 * @throws KeineAnfrageVorhandenException 
	 */
	public void beschaetigeAnfrage(INutzer moderator, INutzer anfragesteller) 
														throws 	KeineRechteException, 
																KeineAnfrageVorhandenException;
	
	/**
	 * Lehnt eine Mitgliedsanfrage eines Nutzers ab (A14)  
	 * @param moderator der gruppe
	 * @param anfragesteller welcher bestaetigt wird
	 * @throws KeineRechteException 
	 * @throws KeineAnfrageVorhandenException 
	 */
	public void weiseAnfrageAb(INutzer moderator, INutzer anfragesteller) 
														throws 	KeineRechteException, 
																KeineAnfrageVorhandenException;
	
	/**
	 * Fuegt einen Moderator der Gruppe hinzu (A15)
	 * @param moderator welcher den neuen moderator hinzufuegt
	 * @param nutzer welcher ein neuer moderator ist
	 * @throws KeineRechteException 
	 */
	public void fuegeModeratorHinzu(INutzer moderator, INutzer nutzer) 
														throws KeineRechteException;
	
	/**
	 * Fuegt eine Frage in der Gruppe hinzu
	 * @param nutzer welcher die frage hinzufuegt
	 * @param gruppenname in welche die Frage eingetragen werden soll
	 * @param frage welche der gruppe hinzugefuegt werden soll
	 * @throws KeineRechteException falls der nutzer nicht zur gruppe gehoert
	 */
	public void fuegeFrageHinzu(INutzer nutzer, String gruppe, String Fragetext, 
												Set<AntwortmoeglichkeitTyp> antworten) 
														throws 	KeineRechteException,
																InvalideFrageException,
																GruppeNichtVorhandenException;
}
