package Gruppenkomponente;

import java.util.Set;

import Benutzerkomponente.IBenutzerKomponenteServices;
import Benutzerkomponente.INutzer;
import Exceptions.KeineAnfrageVorhandenException;
import Exceptions.KeineRechteException;
import Fragekomponente.Frage;
import Fragekomponente.IFrageKomponenteServices;
import SoLeCommon.IPersistenceServices;

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
	public void fuegeFrageHinzu(INutzer nutzer, Frage frage)
			throws KeineRechteException {
		// TODO Auto-generated method stub
		
	}
}