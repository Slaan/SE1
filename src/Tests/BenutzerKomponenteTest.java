package Tests;

import java.sql.ResultSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Benutzerkomponente.BenutzerKomponente;
import Benutzerkomponente.IBenutzerKomponenteServices;
import Benutzerkomponente.INutzer;
import Exceptions.InvalideFrageException;
import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.LeereFragenException;
import Exceptions.NameBereitsVergebenException;
import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
import Exceptions.UngueltigeAnwortAnzahlException;
import Exceptions.UngueltigeEmailException;
import Fragekomponente.IFrage;
import Fragekomponente.IFrageKomponenteServices;
import Gruppenkomponente.IGruppe;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.AntwortmoeglichkeitTyp;
import SoLeCommon.EmailTyp;

public class BenutzerKomponenteTest {

	IPersistenceServices 			_ips;
	IFrageKomponenteServices		_ifk;
	IBenutzerKomponenteServices		_ibs;
	
	@Before
	public void setUp() {
		// dummy persistence
		_ips = new IPersistenceServices() {
			
			@Override
			public void speicherFrage(IGruppe gruppe, IFrage frage) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public void nutzerSpeichern(INutzer neuerNutzer) {
				System.out.println("Nutzer wurde gespeichert: " + neuerNutzer.toString());
			}
			
			@Override
			public ResultSet nutzerLogIn(String nutzername, String passwort) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public ResultSet getGruppe(Integer gruppeID) {
				throw new UnsupportedOperationException();
			}
		};
		_ifk = new IFrageKomponenteServices() {
			
			@Override
			public IFrage erstelleTextFrage(String fragetext,
					Set<AntwortmoeglichkeitTyp> antworten)
					throws UngueltigeAnwortAnzahlException,
					KeineKorrekteAntwortVorhandenException, LeereFragenException {
				throw new UnsupportedOperationException();
			}
		};
		_ibs = new BenutzerKomponente(_ips, _ifk);
	}
	
	@Test
	public void testNutzerRegistrierung() throws NameBereitsVergebenException, NameZuKurzException, PasswortZuKurzException, UngueltigeEmailException {
		EmailTyp email = new EmailTyp("coolertyp@gmail.com");
		_ibs.neuerUser("cooler_student", "jm1#0J8*I", email);
		// wie konkret testen?
	}
	
	@Test(expected = NameBereitsVergebenException.class)
	public void testNutzerRegistrierungVergebenenNamen() throws UngueltigeEmailException, 
																NameBereitsVergebenException, 
																NameZuKurzException, 
																PasswortZuKurzException {
		EmailTyp email = new EmailTyp("coolertyp@gmail.com");
		_ibs.neuerUser("cooler_student", "jm1#0J8*I", email);
		_ibs.neuerUser("cooler_student", "jm1#0J8*I", email);
	}
	
	@Test(expected = NameZuKurzException.class)
	public void testNutzerRegistrierungNameZuKurz() throws 	UngueltigeEmailException, 
															NameBereitsVergebenException, 
															NameZuKurzException, 
															PasswortZuKurzException {
		EmailTyp email = new EmailTyp("coolertyp@gmail.com");
		_ibs.neuerUser("co", "jm1#0J8*I", email);
	}
	
	@Test(expected = PasswortZuKurzException.class)
	public void testNutzerRegistrierungPasswortZuKurz() throws 	UngueltigeEmailException, 
																NameBereitsVergebenException, 
																NameZuKurzException, 
																PasswortZuKurzException {
		EmailTyp email = new EmailTyp("coolertyp@gmail.com");
		_ibs.neuerUser("cooalabaer", "jo", email);
	}

}
