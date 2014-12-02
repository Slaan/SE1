package PersistenceKomponente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Benutzerkomponente.INutzer;
import Fragekomponente.IFrage;
import Gruppenkomponente.IGruppe;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class PersistenceKomponente implements IPersistenceServices {
	
	private Connection _conn;
	
	public PersistenceKomponente(String nutzername, String passwort) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String driver = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521:inf09";
            this._conn = DriverManager.getConnection(driver, nutzername, passwort);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    private boolean insert(String query) {
		System.out.println(query);
        try {
            Statement stmt = _conn.createStatement();
            stmt.executeUpdate(query);

            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }   
    
    private boolean delete(String query){
        try {
            Statement stmt = _conn.createStatement();
            stmt.executeUpdate(query);
     
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	@Override
	public void nutzerSpeichern(INutzer neuerNutzer) {
		String query = 	"INSERT INTO nutzer "
					 + 	"VALUES (" 	+ neuerNutzer.getUserID() 
					 +	", '"		+ neuerNutzer.getNickname() 
					 +	"', '"		+ neuerNutzer.getEmail().getAddress()	
					 +	"', '"		+ neuerNutzer.getPassword()
					 +	"')";
		insert(query);
	}

	@Override
	public void speicherFrage(IGruppe gruppe, IFrage frage) {
		String query = "INSERT INTO frage (frageid, gruppeid, fragetext)" 
					 + " VALUES (" 	+ frage.getFragenummer()
					 + ", " 		+ gruppe.getGroupID()
					 + ", '" 		+ frage.getFrageText()
					 + "')";
		insert(query);
		for(AntwortmoeglichkeitTyp a : frage.getAntworten()) {
			query = "INSERT INTO antwort "
				  + "VALUES (" 	+ a.getAntwortmoeglichkeitID()
				  + ", "	   	+ frage.getFragenummer()
				  + ", '"		+ a.getAnswerText()
				  + "', '"		+ (a.istRichtig() ? "Y" : "N")
				  + "')";
			insert(query);
		}
	}
	
	@Override
	public ResultSet nutzerLogIn(String nutzername, String passwort) {
		// nop
		return null;
	}

	@Override
	public ResultSet getGruppe(Integer gruppeID) {
		return null;
	}

	

}
