package component;

import component_interface.IBenutzerKomponente;
import component_interface.IFrageKomponente;
import component_interface.IGruppenKomponente;
import component_interface.IPersistenceServices;

public class FrageKomponente implements IFrageKomponente  {
	
	private IGruppenKomponente					_igk;
	private IPersistenceServices 				_ips;

	public FrageKomponente(IPersistenceServices ips, IGruppenKomponente igk) {
		_igk = igk;
		_ips = ips;
	}
}
