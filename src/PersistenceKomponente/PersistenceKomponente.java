package PersistenceKomponente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import Benutzerkomponente.INutzer;
import Fragekomponente.IFrage;
import Gruppenkomponente.IGruppe;

public class PersistenceKomponente implements IPersistenceServices {
	
	private Connection _conn;
	
	@Override
	public void nutzerSpeichern(INutzer neuerNutzer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speicherFrage(IGruppe gruppe, IFrage frage) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ResultSet nutzerLogIn(String nutzername, String passwort) {
        try {
             DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             String driver = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521:inf09";
             this._conn = DriverManager.getConnection(driver, nutzername, passwort);
         } catch (Exception e) {
             e.printStackTrace();
         }

		return null;
	}

	@Override
	public ResultSet getGruppe(Integer gruppeID) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
