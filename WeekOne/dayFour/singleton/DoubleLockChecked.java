package singleton;

/**
 * 
 * @author Parker W.
 *
 */
public class DoubleLockChecked {
	
	//private static instance
	private static DoubleLockChecked instance = null;
	
	//private constructor
	private DoubleLockChecked() {
		
	}
	
	/**
	 * Static method for other classes to use to get the Singleton instance
	 * @return	the shared singleton instance
	 */
	public static DoubleLockChecked getInstance() {
		if(instance == null)
			synchronized (instance) {
				if(instance == null)
					instance = new DoubleLockChecked();
			}
		return instance;
	}

}
