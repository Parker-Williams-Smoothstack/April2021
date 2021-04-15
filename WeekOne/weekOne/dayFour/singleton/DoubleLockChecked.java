package dayFour.singleton;

/**
 * 
 * @author Parker W.
 *
 */
public class DoubleLockChecked {
	
	//private static instance
	private static volatile DoubleLockChecked instance;
	
	//private constructor
	private DoubleLockChecked() {
		
	}
	
	/**
	 * Static method for other classes to use to get the Singleton instance
	 * @return	the shared singleton instance
	 */
	public static DoubleLockChecked getInstance() {
		if(instance == null)
			synchronized (DoubleLockChecked.class) {
				if(instance == null)
					instance = new DoubleLockChecked();
			}
		return instance;
	}
	
	//Personally would prefer to use an enum
	/**
	 * public enum SingletonClass{
	 * 	INSTANCE;
	 * 
	 * 
	 * public void methodOne(){ ... }
	 * 
	 * }
	 */

}
