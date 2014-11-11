package component;

import component_interface.IFrageKomponenteServices;
import component_interface.IGruppenkomponenteServices;
import component_interface.IPersistenceServices;

public class FrageKomponente implements IFrageKomponenteServices  {
	
	private IGruppenkomponenteServices					_igk;
	private IPersistenceServices 						_ips;

	public FrageKomponente(IPersistenceServices ips) {
		_ips = ips;
	}
}
