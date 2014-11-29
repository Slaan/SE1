package Benutzerkomponente;

import java.sql.SQLException;

import Exceptions.NameBereitsVergebenException;
import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
import Exceptions.UngueltigeEmailException;
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
	
	/**
	 * Logged den Nutzer ins System ein
	 * @param nutzername Der Nutzer- bzw Nickname des Nutzers
	 * @param passwort	Das Passwort des Nutzers
	 * @return Das Objekt des Nutzers.
	 */
	public INutzer logIn(String nutzername, String passwort) throws UngueltigeEmailException, SQLException;
	
}
