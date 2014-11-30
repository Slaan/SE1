package PersistenceKomponente;

import java.sql.ResultSet;

import Benutzerkomponente.INutzer;
import Fragekomponente.IFrage;
import Gruppenkomponente.IGruppe;

public class PersistenceKomponente implements IPersistenceServices {

	@Override
	public void nutzerSpeichern(INutzer neuerNutzer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet nutzerLogIn(String nutzername, String passwort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getGruppe(Integer gruppeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void speicherFrage(IGruppe gruppe, IFrage frage) {
		// TODO Auto-generated method stub
		
	}

}
