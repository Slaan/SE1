package Benutzerkomponente;

import SoLeCommon.EmailTyp;
import SoLeCommon.UniqueID;

public class Nutzer implements INutzer {

	private Integer 	_id;
	private String		_nickname;
	private	String 		_password; // password plain?
	private EmailTyp 	_email;
	
	/**
	 * Create user (A1)
	 * @param nickname is the name of user
	 * @param email of the user.
	 */
	public Nutzer(String nickname, String password, EmailTyp email) {
		if(nickname == null) throw new IllegalArgumentException("Nickname is null.");
		if(password == null) throw new IllegalArgumentException("Password is null");
		if(email == null) throw new IllegalArgumentException("Email is null.");
		_id = UniqueID.getUniqueId();
		_nickname = nickname;
	}
	
	/**
	 * 
	 * @return id of user
	 */
	public Integer getUserID() {
		return _id;
	}
	
	/**
	 * 
	 * @return nickname of user
	 */
	public String getNickname() {
		return _nickname;
	}
	
	/**
	 * 
	 * @return email address of user
	 */
	public EmailTyp getEmail() {
		return _email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(!(obj instanceof Nutzer)) {
			return false;
		} else {
			Nutzer other = (Nutzer) obj;
			return 	_id.equals(other.getUserID())
			&&	   	_nickname.equals(other.getNickname())
			&&		_email.equals(other.getEmail());
		}
	}
	
	@Override
	public int hashCode() {
		return 	  (_id * 31) 
				+ (_nickname.hashCode() * 31)
				+ (_password.hashCode() * 31)
				+ (_email.hashCode() * 31);
	}
	
}