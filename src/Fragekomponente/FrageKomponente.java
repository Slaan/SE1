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
	public void erstelleTextFrage(String fragetext,
			Set<AntwortmoeglichkeitTyp> antworten)
			throws InvalideFrageException {
		// TODO Auto-generated method stub
		
	}


}
