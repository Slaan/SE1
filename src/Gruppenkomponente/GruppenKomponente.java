package Gruppenkomponente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Benutzerkomponente.IBenutzerKomponenteServices;
import Benutzerkomponente.INutzer;
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

	public GruppenKomponente(IPersistenceServices ips, 
							 IFrageKomponenteServices ifks, 
							 IBenutzerKomponenteServices ibks) {
		_ips  = ips;
		_ifks = ifks;
		_ibks = ibks;
	}

	@Override
	public void erstelleGruppe(INutzer ersteller, String name, String passwort) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean treteGruppeMitPasswortBei(INutzer neues, String passwort) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beschaetigeAnfrage(INutzer moderator, INutzer anfragesteller)
			throws KeineRechteException, KeineAnfrageVorhandenException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void weiseAnfrageAb(INutzer moderator, INutzer anfragesteller)
			throws KeineRechteException, KeineAnfrageVorhandenException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fuegeModeratorHinzu(INutzer moderator, INutzer nutzer)
			throws KeineRechteException {
		// TODO Auto-generated method stub
		
	}

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

	@Override
	public void fuegeFrageHinzu(IGruppe gruppe, String frageText,
			HashSet<AntwortmoeglichkeitTyp> antworten)
			throws KeineRechteException, UngueltigeAnwortAnzahlException, 
			KeineKorrekteAntwortVorhandenException, LeereFragenException {
		
		IFrage frage = new Frage(frageText, antworten);
		_ips.speicherFrage(gruppe,frage);
	}
}