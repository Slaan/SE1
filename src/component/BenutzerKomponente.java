package component;

import component_interface.IBenutzerKomponenteServices;
import component_interface.IFrageKomponenteServices;
import component_interface.IGruppenkomponenteServices;
import component_interface.IPersistenceServices;

public class BenutzerKomponente implements IBenutzerKomponenteServices {
	private IPersistenceServices 					_ips ;
	private IFrageKomponenteServices				_ifk;
	
	public BenutzerKomponente(IPersistenceServices ips, IFrageKomponenteServices ifk) {
		_ips = ips;
		_ifk = ifk;
	}
}
