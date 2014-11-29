package Fragekomponente;

import Gruppenkomponente.IGruppenkomponenteServices;
import SoLeCommon.IPersistenceServices;

public class FrageKomponente implements IFrageKomponenteServices  {
	
	private IGruppenkomponenteServices					_igk;
	private IPersistenceServices 						_ips;

	public FrageKomponente(IPersistenceServices ips) {
		_ips = ips;
	}
}
