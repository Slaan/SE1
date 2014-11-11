package component;

import component_interface.IBenutzerKomponente;
import component_interface.IFrageKomponente;
import component_interface.IGruppenKomponente;
import component_interface.IPersistenceServices;

import entity.Frage;
import entity.Nutzer;
import exceptions.KeineAnfrageVorhandenException;
import exceptions.KeineRechteException;

public class GruppenKomponente implements IGruppenKomponente{
	
	private IPersistenceServices 				_ips;
	

	public GruppenKomponente(IPersistenceServices ips) {
		_ips = ips;
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
