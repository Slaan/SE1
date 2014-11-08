package entity;

import java.security.KeyStore.PasswordProtection;

public class User {

	private Integer 	_id;
	private String		_nickname;
	private	String 		_password; // password plain?
	private Email 		_email;
	
	/**
	 * Create user (A1)
	 * @param nickname is the name of user
	 * @param email of the user.
	 */
	public User(String nickname, String password, Email email) {
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
	public Email getEmail() {
		return _email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(!(obj instanceof User)) {
			return false;
		} else {
			User other = (User) obj;
			return 	_id.equals(other.getUserID())
			&&	   	_nickname.equals(other.getNickname())
			&&		_email.equals(other.getEmail());
		}
	}
	
}