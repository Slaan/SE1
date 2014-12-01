package Fragekomponente;

import java.util.Set;

import Exceptions.InvalideFrageException;
import Gruppenkomponente.IGruppenkomponenteServices;
import PersistenceKomponente.IPersistenceServices;
import SoLeCommon.AntwortmoeglichkeitTyp;

public class FrageKomponente implements IFrageKomponenteServices  {
	
	private IGruppenkomponenteServices					_igk;
	private IPersistenceServices 						_ips;

	public FrageKomponente(IPersistenceServices ips) {
		_ips = ips;
	}

	@Override
	public IFrage erstelleTextFrage(String fragetext,
			Set<AntwortmoeglichkeitTyp> antworten)
			throws InvalideFrageException {
				return null;
	}


}
