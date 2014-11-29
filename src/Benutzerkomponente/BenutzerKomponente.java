package Benutzerkomponente;

import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.NameBereitsVergebenException;
import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
import Exceptions.UngueltigeEmailException;
import Fragekomponente.IFrageKomponenteServices;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.EmailTyp;

public class BenutzerKomponente implements IBenutzerKomponenteServices {
	private IPersistenceServices 					_ips;
	private IFrageKomponenteServices				_ifk;
	
	public BenutzerKomponente(IPersistenceServices ips, IFrageKomponenteServices ifk) {
		_ips = ips;
		_ifk = ifk;
	}


	@Override
	public void neuerUser(String nutzername, String passwort, EmailTyp email) 
										throws	NameBereitsVergebenException, 
												NameZuKurzException,
												PasswortZuKurzException {
		
		INutzer neuerNutzer = new Nutzer(nutzername,passwort,email);
		_ips.nutzerSpeichern(neuerNutzer);
	}


	@Override
	public INutzer logIn(String nutzername, String passwort) throws UngueltigeEmailException, SQLException {
		
		ResultSet nutzerDaten = _ips.nutzerLogIn(nutzername,passwort);
		EmailTyp email = new EmailTyp(nutzerDaten.getString(3));
		INutzer result = new Nutzer(nutzername, passwort, email);
		return result;
	}

}
