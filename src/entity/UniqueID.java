package entity;

public class UniqueID {
	
	private static int __highest_id = 0; 
	
	/**
	 * 
	 * @return unique id
	 */
	public static int getUniqueId() {
		return __highest_id++;
	}
}