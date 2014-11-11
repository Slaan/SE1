package component;

import component_interface.IBenutzerKomponente;
import component_interface.IFrageKomponente;
import component_interface.IGruppenKomponente;
import component_interface.IPersistenceServices;

public class main {
	
	IPersistenceServices ips = null; // TODO implement me
	IGruppenKomponente igk = new GruppenKomponente(ips);
	IFrageKomponente ifk = new FrageKomponente(ips,igk);
	IBenutzerKomponente ibk = new BenutzerKomponente(ips,ifk,igk);
}