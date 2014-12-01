package Tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

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
import Gruppenkomponente.GruppenKomponente;
import Gruppenkomponente.IGruppe;
import Gruppenkomponente.IGruppenkomponenteServices;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.AntwortmoeglichkeitTyp;
import SoLeCommon.EmailTyp;

public class GruppenKomponenteTest {

	private	IPersistenceServices		_ips;
	private IFrageKomponenteServices	_ifs;
	private	IBenutzerKomponenteServices _ibs;
	private IGruppenkomponenteServices 	_igk;
	
	@Before
	public void setUp() {
		// dummy komponenten
		_ips = new IPersistenceServices() {
			
			@Override
			public void speicherFrage(IGruppe gruppe, IFrage frage) {
				System.out.println("Persistence: Speichere in " + gruppe + ", " + frage);
			}
			
			@Override
			public void nutzerSpeichern(INutzer neuerNutzer) {
				throw new UnsupportedOperationException();
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
		_ifs = new IFrageKomponenteServices() {
			
			@Override
			public IFrage erstelleTextFrage(String fragetext,
					Set<AntwortmoeglichkeitTyp> antworten)
					throws UngueltigeAnwortAnzahlException,
					KeineKorrekteAntwortVorhandenException, LeereFragenException {
				return new IFrage() {
					@Override
					public String getInformationsText() {
						return "no info.";
					}
					
					@Override
					public String getFrageText() {
						return fragetext;
					}
					
					@Override
					public Set<AntwortmoeglichkeitTyp> getAntworten() {
						return antworten;
					}
				};
			}
		};
		_ibs = new IBenutzerKomponenteServices() {
			@Override
			public void neuerUser(String nutzername, String passwort, EmailTyp email)
					throws NameBereitsVergebenException, NameZuKurzException,
					PasswortZuKurzException {
				throw new UnsupportedOperationException();
				
			}
			@Override
			public INutzer logIn(String nutzername, String passwort)
					throws UngueltigeEmailException, SQLException {
				throw new UnsupportedOperationException();
			}
		};
		_igk = new GruppenKomponente(_ips, _ifs, _ibs); 
	}
	
	@Test
	public void test() {
		
	}

}
