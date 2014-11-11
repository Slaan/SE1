package component_interface;

import benutzerkomponente.Nutzer;
import exceptions.KeineAnfrageVorhandenException;
import exceptions.KeineRechteException;
import fragekomponente.Frage;

public interface IGruppenKomponente {
	
	/**
	 * Nutzer tritt mittels Passwort einer Gruppe bei (A13)
	 * @param neues potentielles mitglied
	 * @param passwort welches dem gruppen passwort abgeglichen wird.
	 * @return true wenn das passwort richtig war und neues als Mitglied eingetragen wurde.
	 */
	public boolean treteGruppeMitPasswortBei(Nutzer neues, String passwort);

	/**
	 * Bestaetigt eine bereits erstellte Mitgliedsanfrage eines Nutzers  
	 * @param moderator welcher eine mitgliedsanfrage bestaetigen (A14)
	 * @param anfragesteller welcher bestaetigt wird
	 * @throws KeineRechteException 
	 * @throws KeineAnfrageVorhandenException 
	 */
	public void beschaetigeAnfrage(Nutzer moderator, Nutzer anfragesteller) throws 	KeineRechteException, 
																					KeineAnfrageVorhandenException;
	
	/**
	 * Lehnt eine Mitgliedsanfrage eines Nutzers ab (A14)  
	 * @param moderator der gruppe
	 * @param anfragesteller welcher bestaetigt wird
	 * @throws KeineRechteException 
	 * @throws KeineAnfrageVorhandenException 
	 */
	public void weiseAnfrageAb(Nutzer moderator, Nutzer anfragesteller) throws 	KeineRechteException, 
																				KeineAnfrageVorhandenException;
	
	/**
	 * Fuegt einen Moderator der Gruppe hinzu (A15)
	 * @param moderator welcher den neuen moderator hinzufuegt
	 * @param nutzer welcher ein neuer moderator ist
	 * @throws KeineRechteException 
	 */
	public void fuegeModeratorHinzu(Nutzer moderator, Nutzer nutzer) throws KeineRechteException;
	
	/**
	 * Fuegt eine Frage in der Gruppe hinzu
	 * @param nutzer welcher mitglied der gruppe ist
	 * @param frage 
	 * @throws KeineRechteException falls der nutzer nicht zur gruppe gehoert
	 */
	public void fuegeFrageHinzu(Nutzer nutzer, Frage frage) throws KeineRechteException;	

}
