package Gruppenkomponente;

import java.sql.SQLException;
import java.util.HashSet;

import Benutzerkomponente.INutzer;
import Exceptions.KeineAnfrageVorhandenException;
import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.KeineRechteException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
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
	 * Ein Nutzer wählt eine Gruppe aus 
	 * @param nutzer
	 * @param GruppenID
	 * @return Die ausgewählte Gruppe
	 */
	public IGruppe waehleGruppeAus(INutzer nutzer, Integer GruppenID) throws SQLException;
	
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
	 * @param nutzer welcher mitglied der gruppe ist
	 * @param frage 
	 * @throws KeineRechteException falls der nutzer nicht zur gruppe gehoert
	 */
	public void fuegeFrageHinzu(IGruppe gruppe, String frageText, HashSet<AntwortmoeglichkeitTyp> antworten) 
														throws KeineRechteException, UngueltigeAnwortAnzahlException, KeineKorrekteAntwortVorhandenException, LeereFragenException;

}
