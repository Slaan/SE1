package simple_typen;

public final class UniqueID {
	
	private static int __highest_id = 0; 
	
	private UniqueID() {
		// nop
	}
	
	/**
	 * 
	 * @return unique id
	 */
	public static int getUniqueId() {
		return __highest_id++;
	}
}