package Benutzerkomponente;

import Exceptions.NameZuKurzException;
import Exceptions.PasswortZuKurzException;
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
	 * @throws NameZuKurzException 
	 * @throws PasswortZuKurzException 
	 */
	public Nutzer(String nickname, String password, EmailTyp email) throws NameZuKurzException, PasswortZuKurzException {
		if(nickname == null) 		throw new IllegalArgumentException("Nickname is null.");
		if(password == null) 		throw new IllegalArgumentException("Password is null");
		if(email == null) 			throw new IllegalArgumentException("Email is null.");
		if(nickname.length() < 3)	throw new NameZuKurzException();
		if(password.length() < 3)	throw new PasswortZuKurzException();
		_id 		= UniqueID.getUniqueId();
		_nickname 	= nickname;
		_password 	= password;
		_email		= email;
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
	public String getPassword() {
		return _password;
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
	
	@Override
	public String toString() {
		return 		"Nutzer(" 	+ _id 
				+	", "		+ _nickname
				+	", "		+ _password.hashCode()
				+	", "		+ _email.toString()
				+	")";
	}
}