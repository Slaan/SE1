package Gruppenkomponente;

import java.util.HashSet;
import java.util.Set;

import Benutzerkomponente.INutzer;
import Exceptions.KeineAnfrageVorhandenException;
import Exceptions.KeineRechteException;
import Fragekomponente.Frage;
import Fragekomponente.IFrage;
import SoLeCommon.UniqueID;

class Gruppe implements IGruppe {

	private	Integer			_groupid;
	private	String			_name;
	private	String			_passwort;
	private	Set<INutzer> 	_moderatoren;
	private	Set<INutzer> 	_nutzer;
	private	Set<INutzer>	_ausstehende_nutzer;
	private Set<IFrage> 	_fragen; 
	
	/**
	 * Erzeugt eine neue Gruppe (A12)
	 * @param name der neuen gruppe
	 * @param erzeuger der gruppe
	 * @throws GruppenNamenIstNullException
	 * @throws GruppenErzeugerIstNullException
	 */
	public Gruppe(INutzer erzeuger, String name, String passwort) throws 	
														GruppenNamenIstNullException, 
														GruppenErzeugerIstNullException {
		if(name == null) 	 throw new GruppenNamenIstNullException();
		if(erzeuger == null) throw new GruppenErzeugerIstNullException();
		_ausstehende_nutzer = new HashSet<>();
		_groupid 		= UniqueID.getUniqueId();
		_passwort 		= passwort;
		_name 			= erzeuger.getNickname() + name;
		_fragen 		= new HashSet<>();
		_moderatoren 	= new HashSet<>();
		_moderatoren.add(erzeuger);
		_nutzer 		= new HashSet<>();
		_nutzer.add(erzeuger);
	}
	
	public Gruppe(Integer ID, String gruppenName, String passwort, HashSet<INutzer> moderatoren,  
					HashSet<INutzer> nutzer, HashSet<INutzer> ausstehendeNutzer, HashSet<IFrage> fragen) {
		
		_ausstehende_nutzer = ausstehendeNutzer;
		_groupid = ID;
		_passwort = passwort;
		_name = gruppenName;
		_fragen = fragen;
		_moderatoren = moderatoren;
		_nutzer = nutzer;
	}

	/**
	 * Erstellt eine Mitgliedsanfrage (A13)
	 * @param neues potentielles Mitglied 
	 */
	public void erstelleMitgliedsAnfrage(INutzer neues) {
		if(neues == null) throw new IllegalArgumentException("Neuer ist null");
		_ausstehende_nutzer.add(neues);
	}
	
	/**
	 * Nutzer tritt mittels Passwort einer Gruppe bei (A13)
	 * @param neues potentielles mitglied
	 * @param passwort welches dem gruppen passwort abgeglichen wird.
	 * @return true wenn das passwort richtig war und neues als Mitglied eingetragen wurde.
	 */
	public boolean tretteGruppeMitPasswortBei(INutzer neues, String passwort) {
		if(neues == null) throw new IllegalArgumentException("Nutzer ist null");
		if(passwort == null) throw new IllegalArgumentException("Passwort ist null");
		if(!(passwort.equals(_passwort))) {
			return false;
		}
		return _nutzer.add(neues);
	}

	/**
	 * Bestaetigt eine bereits erstellte Mitgliedsanfrage eines Nutzers  
	 * @param moderator welcher eine mitgliedsanfrage bestaetigen (A14)
	 * @param anfragesteller welcher bestaetigt wird
	 * @throws KeineRechteException 
	 * @throws KeineAnfrageVorhandenException 
	 */
	public void bestaetigeAnfrage(INutzer moderator, INutzer anfragesteller) 
													throws 	KeineRechteException, 
															KeineAnfrageVorhandenException {
		if(moderator == null) throw new NullPointerException("moderator ist null");
		if(anfragesteller == null) throw new NullPointerException("anfragesteller ist null");
		if(!_moderatoren.contains(moderator)) {
			throw new KeineRechteException("Der angegebe Moderator ist keiner");
		}
		if(!_ausstehende_nutzer.remove(anfragesteller)) {
			throw new KeineAnfrageVorhandenException();
		}
		_nutzer.add(anfragesteller);
	}
	
	/**
	 * Lehnt eine Mitgliedsanfrage eines Nutzers ab (A14)  
	 * @param moderator der gruppe
	 * @param anfragesteller welcher bestaetigt wird
	 * @throws KeineRechteException 
	 * @throws KeineAnfrageVorhandenException 
	 */
	public void weiseAnfrageAb(INutzer moderator, INutzer anfragesteller) 
													throws 	KeineRechteException, 
															KeineAnfrageVorhandenException {
		if(moderator == null) throw new NullPointerException("moderator ist null");
		if(anfragesteller == null) throw new NullPointerException("anfragesteller ist null");
		if(!_moderatoren.contains(moderator)) {
			throw new KeineRechteException("Der angegebe Moderator ist keiner");
		}
		if(!_ausstehende_nutzer.remove(anfragesteller)) {
			throw new KeineAnfrageVorhandenException();
		}
	}
	
	/**
	 * Fuegt einen Moderator der Gruppe hinzu (A15)
	 * @param moderator welcher den neuen moderator hinzufuegt
	 * @param nutzer welcher ein neuer moderator ist
	 * @throws KeineRechteException 
	 */
	public void fuegeModeratorHinzu(INutzer moderator, INutzer nutzer) 
													throws KeineRechteException {
		if(moderator == null) 	throw new NullPointerException("Moderator ist null");
		if(nutzer == null) 		throw new NullPointerException("Nutzer ist null");
		if(!_moderatoren.contains(moderator)) {
			throw new KeineRechteException("Der angegebe Moderator ist keiner");
		}
		_moderatoren.add(nutzer);
	}
	
	/**
	 * Fuegt eine Frage in der Gruppe hinzu
	 * @param nutzer welcher mitglied der gruppe ist
	 * @param frage 
	 * @throws KeineRechteException falls der nutzer nicht zur gruppe gehoert
	 */
	public void fuegeFrageHinzu(INutzer nutzer, IFrage frage) throws KeineRechteException {
		if(nutzer == null) throw new NullPointerException("nutzer ist null");
		if(frage == null) throw new NullPointerException("frage ist null");
		if(!_nutzer.contains(nutzer)) {
			throw new KeineRechteException("Der angebene Nutzer gehoert nicht zur Gruppe");
		}
		_fragen.add(frage);
	}
	
	/**
	 * 
	 * @return name der gruppe
	 */
	public String getName() {
		return _name;
	}
	
	public Integer getGroupID() {
		return _groupid;
	}
	
	public Set<INutzer> getNutzer() {
		return _nutzer;
	}
	
	public Set<IFrage> getFragen() {
		return _fragen;
	}
}
