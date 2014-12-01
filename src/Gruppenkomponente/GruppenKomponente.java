package Gruppenkomponente;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Benutzerkomponente.IBenutzerKomponenteServices;
import Benutzerkomponente.INutzer;
import Exceptions.GruppeNichtVorhandenException;
import Exceptions.InvalideFrageException;
import Exceptions.KeineAnfrageVorhandenException;
import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.KeineRechteException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
import Fragekomponente.IFrage;
import Fragekomponente.IFrageKomponenteServices;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class GruppenKomponente implements IGruppenkomponenteServices {
	
	private IPersistenceServices 				_ips;
	private IFrageKomponenteServices			_ifks;
	private IBenutzerKomponenteServices			_ibks;

	private Set<Gruppe>							_gruppen;

	public GruppenKomponente(IPersistenceServices ips, 
							 IFrageKomponenteServices ifks, 
							 IBenutzerKomponenteServices ibks) {
		_ips  		= ips;
		_ifks 		= ifks;
		_ibks 		= ibks;
		_gruppen	= new HashSet<>();
		// TODO: sync with ips
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void erstelleGruppe(INutzer ersteller, String name, String passwort) {
		Gruppe gruppe = new Gruppe(ersteller, name, passwort);
		_gruppen.add(gruppe);
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public boolean treteGruppeMitPasswortBei(INutzer neues, String passwort) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void beschaetigeAnfrage(INutzer moderator, INutzer anfragesteller)
			throws KeineRechteException, KeineAnfrageVorhandenException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void weiseAnfrageAb(INutzer moderator, INutzer anfragesteller)
			throws KeineRechteException, KeineAnfrageVorhandenException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void fuegeModeratorHinzu(INutzer moderator, INutzer nutzer)
			throws KeineRechteException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public IGruppe waehleGruppeAus(INutzer nutzer, Integer GruppenID) {
		return null;
	}

	/** 
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void fuegeFrageHinzu(INutzer nutzer, String gruppenname, String fragetext, 
												Set<AntwortmoeglichkeitTyp> antworten)
											throws 	KeineRechteException, 
													GruppeNichtVorhandenException, 
													InvalideFrageException {
		// gruppe vorhanden?
		Gruppe gruppe = findeGruppe(gruppenname);
		if(!gruppe.getNutzer().contains(nutzer)) {
			// user is not in group
			throw new KeineRechteException();
		}
		try {
			IFrage frage = _ifks.erstelleTextFrage(fragetext, antworten);
			gruppe.fuegeFrageHinzu(nutzer, frage);
			_ips.speicherFrage(gruppe, frage);
		} catch (UngueltigeAnwortAnzahlException
				| KeineKorrekteAntwortVorhandenException | LeereFragenException e) {
			throw new InvalideFrageException();
		}
		
	}
	
	@Override
	public Set<IFrage> fragenInGruppe(String gruppenname) throws GruppeNichtVorhandenException {
		Gruppe gefundende_gruppe = findeGruppe(gruppenname);
		return gefundende_gruppe.getFragen();
	}
	
	/**
	 * Sucht nach der Gruppe durch den Gruppennamen
	 * @param gruppenname
	 * @return Gruppe nach welcher gesucht wurde.
	 * @throws GruppeNichtVorhandenException
	 */
	private Gruppe findeGruppe(String gruppenname) throws GruppeNichtVorhandenException {
		Gruppe gruppe = null;
		for(Iterator<Gruppe> i = _gruppen.iterator(); i.hasNext(); ) {
			Gruppe g = i.next();
			if(g.getName().equals(gruppenname)) {
				gruppe = g;
			}
		}
		if(gruppe == null) throw new GruppeNichtVorhandenException();
		return gruppe;
	}
}