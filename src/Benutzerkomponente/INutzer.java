package Benutzerkomponente;

import SoLeCommon.EmailTyp;

public interface INutzer {

	/**
	 * 
	 * @return id of user
	 */
	public Integer getUserID();
	
	/**
	 * 
	 * @return nickname of user
	 */
	public String getNickname();
	
	/**
	 * 
	 * @return email address of user
	 */
	public EmailTyp getEmail();
	
	/**
	 * Überprüft, ob zwei Objekte gleich sind
	 * @param o
	 * @return wahr oder falsch, je nachdem ob sie gleich sind.
	 */
	public boolean equals(Object o);
}
