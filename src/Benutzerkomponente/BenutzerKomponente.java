package Benutzerkomponente;

import Exceptions.NameBereitsVergebenException;
import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
import Fragekomponente.IFrageKomponenteServices;
import SoLeCommon.EmailTyp;
import SoLeCommon.IPersistenceServices;

public class BenutzerKomponente implements IBenutzerKomponenteServices {
	private IPersistenceServices 					_ips ;
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
		// TODO: implement me
	}
}
