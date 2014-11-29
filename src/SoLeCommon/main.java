package SoLeCommon;

import Benutzerkomponente.BenutzerKomponente;
import Benutzerkomponente.IBenutzerKomponenteServices;
import Fragekomponente.FrageKomponente;
import Fragekomponente.IFrageKomponenteServices;
import Gruppenkomponente.GruppenKomponente;
import Gruppenkomponente.IGruppenkomponenteServices;
import PersistenceKomponente.IPersistenceServices;

public class main {	
	IPersistenceServices ips = null; 
	IFrageKomponenteServices ifks = new FrageKomponente(ips);
	IBenutzerKomponenteServices ibks = new BenutzerKomponente(ips,ifks);
	IGruppenkomponenteServices igks = new GruppenKomponente(ips,ifks,ibks);
}