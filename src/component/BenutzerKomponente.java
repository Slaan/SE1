package component;

import component_interface.IBenutzerKomponente;
import component_interface.IFrageKomponente;
import component_interface.IGruppenKomponente;
import component_interface.IPersistenceServices;

public class BenutzerKomponente implements IBenutzerKomponente {
	private IPersistenceServices 			_ips ;
	private IGruppenKomponente				_igk;
	private IFrageKomponente				_ifk;
	
	public BenutzerKomponente(IPersistenceServices ips, IFrageKomponente ifk,  IGruppenKomponente igk) {
		_ips = ips;
		_igk = igk;
		_ifk = ifk;
	}
}
