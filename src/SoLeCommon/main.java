package SoLeCommon;

import Benutzerkomponente.BenutzerKomponente;
import Benutzerkomponente.IBenutzerKomponenteServices;
import Exceptions.NameBereitsVergebenException;
import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
import Exceptions.UngueltigeEmailException;
import Fragekomponente.FrageKomponente;
import Fragekomponente.IFrageKomponenteServices;
import Gruppenkomponente.GruppenKomponente;
import Gruppenkomponente.IGruppenkomponenteServices;
import PersistenceKomponente.IPersistenceServices;
import PersistenceKomponente.PersistenceKomponente;

public class main {
	
	public static void main(String[] args) throws NameBereitsVergebenException, NameZuKurzException, PasswortZuKurzException, UngueltigeEmailException {
		IPersistenceServices ips = new PersistenceKomponente("nutzername", "passwort"); 
		IFrageKomponenteServices ifks = new FrageKomponente(ips);
		IBenutzerKomponenteServices ibks = new BenutzerKomponente(ips,ifks);
		IGruppenkomponenteServices igks = new GruppenKomponente(ips,ifks,ibks);
		ibks.neuerUser("blabla", "1337", new EmailTyp("13371337@gmail.com"));
	}
}