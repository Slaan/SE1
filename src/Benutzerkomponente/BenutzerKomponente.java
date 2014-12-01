package Benutzerkomponente;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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
	private Set<INutzer>							_nutzer;
	
	public BenutzerKomponente(IPersistenceServices ips, IFrageKomponenteServices ifk) {
		_ips 	= ips;
		_ifk 	= ifk;
		_nutzer = new HashSet<>();
	}


	@Override
	public void neuerUser(String nutzername, String passwort, EmailTyp email) 
										throws	NameBereitsVergebenException, 
												NameZuKurzException,
												PasswortZuKurzException {
		for(INutzer nutzer : _nutzer) {
			if(nutzer.getNickname().equals(nutzername))
				throw new NameBereitsVergebenException();
		}
		INutzer neuerNutzer = new Nutzer(nutzername,passwort,email);
		_nutzer.add(neuerNutzer);
		_ips.nutzerSpeichern(neuerNutzer);
	}


	@Override
	public INutzer logIn(String nutzername, String passwort) throws UngueltigeEmailException, SQLException {
		return null;
//		ResultSet nutzerDaten = _ips.nutzerLogIn(nutzername,passwort);
//		EmailTyp email = new EmailTyp(nutzerDaten.getString(3));
//		INutzer result = new Nutzer(nutzername, passwort, email);
//		return result;
	}

}
