package entity;

import exceptions.InvalidEmailException;

public class Email {

	private String _address;
	
	/**
	 * Constructor
	 * @param address of valid address
	 * @throws InvalidEmailException when email has not valid format.
	 */
	public Email(String address) throws InvalidEmailException {
		if(address == null) throw new IllegalArgumentException();
		if(!isValid(address)) {
			String err_msg =  "Given email does not fit "
							+ "the commun norm.";
			throw new InvalidEmailException(err_msg);
		}
		_address = address;
	}
	
	/**
	 * Copy constructor
	 * @param address
	 * @throws InvalidEmailException
	 */
	public Email(Email address) throws InvalidEmailException {
		if(address == null) throw new IllegalArgumentException();
		if(!isValid(address.getAddress())) {
			String err_msg =  "Given email does not fit "
							+ "the commun norm.";
			throw new InvalidEmailException(err_msg);
		}
		_address = address.getAddress();
	}
	
	/**
	 * 
	 * @param addr to check
	 * @return true when email has valid format and false when 
	 * 		   it does not.
	 */
	public boolean isValid(String addr) {
	    return addr.matches(".+@.+\\.[a-z]+");
	}
	
	/**
	 * 
	 * @return valid email address
	 */
	public String getAddress() {
		return _address;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if(!(obj instanceof Email)) {
			return false;
		} else {
			return _address.equals(((Email) obj).getAddress());
		}
	}
	
}