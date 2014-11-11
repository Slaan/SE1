package component;

import benutzerkomponente.Nutzer;
import component_interface.IBenutzerKomponenteServices;
import component_interface.IFrageKomponenteServices;
import component_interface.IGruppenkomponenteServices;
import component_interface.IPersistenceServices;
import exceptions.KeineAnfrageVorhandenException;
import exceptions.KeineRechteException;
import fragekomponente.Frage;

public class GruppenKomponente implements IGruppenkomponenteServices{
	
	private IPersistenceServices 				_ips;
	private IFrageKomponenteServices			_ifks;
	private IBenutzerKomponenteServices			_ibks;

	public GruppenKomponente(IPersistenceServices ips, IFrageKomponenteServices ifks, IBenutzerKomponenteServices ibks) {
		_ips = ips;
		_ifks = ifks;
		_ibks = ibks;
	}
	
	@Override
	public boolean treteGruppeMitPasswortBei(Nutzer neues, String passwort) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beschaetigeAnfrage(Nutzer moderator, Nutzer anfragesteller)
			throws KeineRechteException, KeineAnfrageVorhandenException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void weiseAnfrageAb(Nutzer moderator, Nutzer anfragesteller)
			throws KeineRechteException, KeineAnfrageVorhandenException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fuegeModeratorHinzu(Nutzer moderator, Nutzer nutzer)
			throws KeineRechteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fuegeFrageHinzu(Nutzer nutzer, Frage frage)
			throws KeineRechteException {
		// TODO Auto-generated method stub
		
	}

}
