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
	 * @return password of user
	 */
	public String getPassword();
	
	/**
	 * 
	 * @return email address of user
	 */
	public EmailTyp getEmail();
	
	/**
	 * Ueberprueft, ob zwei Objekte gleich sind
	 * @param o
	 * @return wahr oder falsch, je nachdem ob sie gleich sind.
	 */
	public boolean equals(Object o);
}
