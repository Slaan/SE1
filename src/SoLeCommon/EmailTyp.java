package SoLeCommon;

import Exceptions.UngueltigeEmailException;

public class EmailTyp {

	private String _address;
	
	/**
	 * Constructor
	 * @param address of valid address
	 * @throws UngueltigeEmailException when email has not valid format.
	 */
	public EmailTyp(String address) throws UngueltigeEmailException {
		if(address == null) throw new IllegalArgumentException();
		if(!isValid(address)) {
			String err_msg =  "Given email does not fit "
							+ "the commun norm.";
			throw new UngueltigeEmailException(err_msg);
		}
		_address = address;
	}
	
	/**
	 * Copy constructor
	 * @param address
	 * @throws UngueltigeEmailException
	 */
	public EmailTyp(EmailTyp address) throws UngueltigeEmailException {
		if(address == null) throw new IllegalArgumentException();
		if(!isValid(address.getAddress())) {
			String err_msg =  "Given email does not fit "
							+ "the commun norm.";
			throw new UngueltigeEmailException(err_msg);
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
		} else if(!(obj instanceof EmailTyp)) {
			return false;
		} else {
			return _address.equals(((EmailTyp) obj).getAddress());
		}
	}
	
	@Override
	public String toString() {
		return "Email(" + _address + ")";
	}
	
}
