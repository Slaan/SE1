package component;

import component_interface.IBenutzerKomponenteServices;
import component_interface.IFrageKomponenteServices;
import component_interface.IGruppenkomponenteServices;
import component_interface.IPersistenceServices;

public class main {
	
	IPersistenceServices ips = null; // TODO implement me
	IFrageKomponenteServices ifks = new FrageKomponente(ips);
	IBenutzerKomponenteServices ibks = new BenutzerKomponente(ips,ifks);
	IGruppenkomponenteServices igks = new GruppenKomponente(ips,ifks,ibks);
}