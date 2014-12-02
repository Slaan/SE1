package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Benutzerkomponente.IBenutzerKomponenteServices;
import Benutzerkomponente.INutzer;
import Exceptions.GruppeNichtVorhandenException;
import Exceptions.InvalideFrageException;
import Exceptions.KeineKorrekteAntwortVorhandenException;
import Exceptions.KeineRechteException;
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

/**
 * Dummy Frageklasse
 * @author alex
 */
class Frage implements IFrage {

	private String 						_question_text;
	private String						_information_text;
	private Set<AntwortmoeglichkeitTyp>	_answer_options;
	
	public Frage(String frage_text, Set<AntwortmoeglichkeitTyp> answer_option) throws 
												 UngueltigeAnwortAnzahlException, 
												 KeineKorrekteAntwortVorhandenException {
		if(answer_option == null) throw new NullPointerException();
		if(frage_text == null) throw new NullPointerException();
		_question_text = frage_text;
		_answer_options = answer_option;
		isValid();
	}
	
	private void isValid() throws 	UngueltigeAnwortAnzahlException, 
									KeineKorrekteAntwortVorhandenException {
		if(_answer_options.size() != 4) throw new UngueltigeAnwortAnzahlException();
		// check that there is at least one
		// correct answer
		boolean accu = false;
		for(AntwortmoeglichkeitTyp answer : _answer_options) {
				accu = accu || answer.istRichtig();
		}
		if(!accu) throw new KeineKorrekteAntwortVorhandenException();
		// check questiontext
	}
	 
	/**
	 * 
	 * @return
	 */
	public String getFrageText() {
		return _question_text;
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<AntwortmoeglichkeitTyp> getAntworten() {
		return _answer_options;
	}
	
	/**
	 * 
	 * @return information 
	 */
	public String getInformationsText() {
		return _information_text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if(!(obj instanceof Frage)) {
			return false;
		} else {
			Frage other = (Frage) obj;
			return 		_answer_options.equals(other.getAntworten())
					 && _question_text.equals(other.getFrageText());
		}
	}
	
	@Override
	public int hashCode() { 
		return (31 * _question_text.hashCode() )
			  +(31 * _answer_options.hashCode());
	}

	@Override
	public Integer getFragenummer() {
		return 0;
	}
}

public class GruppenKomponenteTest {

	private	IPersistenceServices		_ips;
	private IFrageKomponenteServices	_ifs;
	private	IBenutzerKomponenteServices _ibs;
	private IGruppenkomponenteServices 	_igk;
	
	private INutzer nutzer;
	
	@Before
	public void setUp() {
		nutzer = new INutzer() {
			
			@Override
			public Integer getUserID() {
				return 0;
			}
			
			@Override
			public String getNickname() {
				return "testuser";
			}
			
			@Override
			public EmailTyp getEmail() {
				return null;
			}
			
			@Override
			public String getPassword() {
				return "password";
			}
		};
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
				return new Frage(fragetext, antworten);
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
		_igk.erstelleGruppe(nutzer, "test", "123");
	}
	
	@Test
	public void testFuegeFrageHinzu() throws 	UngueltigeAnwortAnzahlException, 
												KeineKorrekteAntwortVorhandenException, 
												LeereFragenException {
		Set<AntwortmoeglichkeitTyp> antworten = new HashSet<>();
		for(Integer i : Arrays.asList(1,2,3)) {
			antworten.add(new AntwortmoeglichkeitTyp(i.toString(), false));
		}
		antworten.add(new AntwortmoeglichkeitTyp("4", true));
		try {
			_igk.fuegeFrageHinzu(nutzer, "testusertest", "2+2?", antworten);
		} catch (KeineRechteException | InvalideFrageException
				| GruppeNichtVorhandenException e) {
			e.printStackTrace();
			fail("Exception raised by adding question");
		}
	}
	
	@Test(expected = InvalideFrageException.class)
	public void testFuegeFrageHinzuMitUngueltigerAntwortZahl() throws 	KeineRechteException, 
																		InvalideFrageException, 
																		GruppeNichtVorhandenException {
		Set<AntwortmoeglichkeitTyp> antworten = new HashSet<>();
		for(Integer i : Arrays.asList(1,2,3,4,6)) {
			antworten.add(new AntwortmoeglichkeitTyp(i.toString(), false));
		}
		antworten.add(new AntwortmoeglichkeitTyp("4", true));
		_igk.fuegeFrageHinzu(nutzer, "testusertest", "2+2?", antworten);
		
	}
	
	@Test(expected = GruppeNichtVorhandenException.class) 
	public void testFuegeFrageHinzuMitNichtVorhandenerGruppe() throws 	KeineRechteException, 
																		InvalideFrageException, 
																		GruppeNichtVorhandenException {
		Set<AntwortmoeglichkeitTyp> antworten = new HashSet<>();
		for(Integer i : Arrays.asList(1,2,3,4)) {
			antworten.add(new AntwortmoeglichkeitTyp(i.toString(), false));
		}
		antworten.add(new AntwortmoeglichkeitTyp("4", true));
		_igk.fuegeFrageHinzu(nutzer, "pferdegruppe", "2+2?", antworten);
	}
	
	@Test(expected = KeineRechteException.class)
	public void testFuegeFrageHinzuOhneMitgliedZuSein() throws 	KeineRechteException, 
																InvalideFrageException, 
																GruppeNichtVorhandenException {
		nutzer = new INutzer() {
			
			@Override
			public Integer getUserID() {
				return 5;
			}
			
			@Override
			public String getNickname() {
				return "testuser2";
			}
			
			@Override
			public EmailTyp getEmail() {
				return null;
			}
			
			@Override
			public String getPassword() {
				return "password123";
			}
		};
		Set<AntwortmoeglichkeitTyp> antworten = new HashSet<>();
		for(Integer i : Arrays.asList(1,2,3,4)) {
			antworten.add(new AntwortmoeglichkeitTyp(i.toString(), false));
		}
		antworten.add(new AntwortmoeglichkeitTyp("4", true));
		_igk.fuegeFrageHinzu(nutzer, "testusertest", "2+2?", antworten);
	}

}
