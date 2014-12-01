package Tests;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Benutzerkomponente.INutzer;
import Exceptions.InvalideFrageException;
import Fragekomponente.FrageKomponente;
import Fragekomponente.IFrage;
import Fragekomponente.IFrageKomponenteServices;
import Gruppenkomponente.IGruppe;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class FrageKomponenteTest {

	private IFrageKomponenteServices _ifs;
	private IPersistenceServices	 _ips;
	
	@Before
	public void setUp() {
		_ips = new IPersistenceServices() {
			@Override
			public void speicherFrage(IGruppe gruppe, IFrage frage) {
				System.out.println("Gruppe: " + gruppe + " Frage: " + frage);
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
		_ifs = new FrageKomponente(_ips);
	}
	
	@Test
	public void testErstelleFrage() {
		Set<AntwortmoeglichkeitTyp> antworten = new HashSet<>();
		antworten.add(new AntwortmoeglichkeitTyp("pferd", true));
		
	}
	
	

}
