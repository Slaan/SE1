package Gruppenkomponente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Benutzerkomponente.IBenutzerKomponenteServices;
import Benutzerkomponente.INutzer;
import Exceptions.InvalideFrageException;
import Exceptions.KeineAnfrageVorhandenException;
import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.KeineRechteException;
import Exceptions.LeereFragenException;
import Exceptions.UngueltigeAnwortAnzahlException;
import Fragekomponente.Frage;
import Fragekomponente.IFrage;
import Fragekomponente.IFrageKomponenteServices;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class GruppenKomponente implements IGruppenkomponenteServices{
	
	private IPersistenceServices 				_ips;
	private IFrageKomponenteServices			_ifks;
	private IBenutzerKomponenteServices			_ibks;

	private Set<Gruppe>							_gruppen;
	private Set<IFrage>							_fragen;

	public GruppenKomponente(IPersistenceServices ips, 
							 IFrageKomponenteServices ifks, 
							 IBenutzerKomponenteServices ibks) {
		_ips  		= ips;
		_ifks 		= ifks;
		_ibks 		= ibks;
		_gruppen	= new HashSet<>();
		_fragen		= new HashSet<>();
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void erstelleGruppe(INutzer ersteller, String name, String passwort) {
		// TODO Auto-generated method stub
		
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
	public IGruppe waehleGruppeAus(INutzer nutzer, Integer GruppenID) throws SQLException {
		ResultSet gruppe = _ips.getGruppe(GruppenID);
		IGruppe result = null;
		String gruppenName = gruppe.getString(1);
		String passwort = gruppe.getString(2);
		HashSet<INutzer> moderatoren = (HashSet<INutzer>) gruppe.getObject(3);
		HashSet<INutzer> nutzerSet = (HashSet<INutzer>) gruppe.getObject(4);
		HashSet<INutzer> ausstehendeNutzer = (HashSet<INutzer>) gruppe.getObject(5);
		HashSet<IFrage> fragen = (HashSet<IFrage>) gruppe.getObject(6);
		result = new Gruppe(GruppenID, gruppenName, passwort, moderatoren, nutzerSet, ausstehendeNutzer, fragen);
		return result;
	}

	/**
	 * @see IGruppenkomponenteServices
	 */
	@Override
	public void fuegeFrageHinzu(IGruppe gruppe, String frageText,
									Set<AntwortmoeglichkeitTyp> antworten)
								throws // throw fancy stuff @see IGruppeKompo
		IFrage frage;
		try {
			frage = _ifks.erstelleTextFrage(frageText, antworten);
			_ips.speicherFrage(gruppe, frage);
		} catch (InvalideFrageException e) {
			e.printStackTrace();
		}
	}
}