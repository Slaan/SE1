package Benutzerkomponente;

import Exceptions.NameBereitsVergebenException;
import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
import SoLeCommon.EmailTyp;

/**
 * Die Verwaltungskomponente fuer und ueber Nutzer 
 * @author Alex, Daniel
 *
 */
public interface IBenutzerKomponenteServices {
	

	/**
	 * Legt einen neuen Nutzer an. (A1)
	 * @param nutzername des anzulegenden Nutzer. Dieser muss eindeutig sein.
	 * @param passwort des anzulegenden Nutzer
	 * @param email des anzulegenden Nutzer
	 * @throws NameBereitsVergebenException
	 * @throws NameZuKurzException
	 * @throws PasswortZuKurzException
	 */
	public void neuerUser(String nutzername, String passwort, EmailTyp email) 
										throws 	NameBereitsVergebenException,
												NameZuKurzException,
												PasswortZuKurzException;
	
}
