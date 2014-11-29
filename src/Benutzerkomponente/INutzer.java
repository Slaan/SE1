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
}
