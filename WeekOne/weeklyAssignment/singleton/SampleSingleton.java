/**
 * 
 */
package singleton;

/**
 * @author Smoothstack - Pramod
 * @author Edited by Parker W.
 *
 */
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleSingleton { // can't have a static class unless it is inside of another class
	private static Connection conn = null;
	private static SampleSingleton instance = null;

	private SampleSingleton() {
		// private constructor to only allow there to be one instance
	}

	public static SampleSingleton getInstance() {
		// add double locked checking
		if (instance == null)
			synchronized (SampleSingleton.class) {
				// can't synch on instance as you can't lock on null, synch on class instead as
				// any stalling should only happen
				// when instance is still null
				if (instance == null) {
					instance = new SampleSingleton();
				}
			}
		return instance;
	}

	public static void databaseQuery(BigDecimal input) {
		try {	// Try/Catch to handle errors
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			BigDecimal x = new BigDecimal(0);	//BigDecimal and primitive int don't play nice, turn x into a BigDecimal
			while (rs.next()) {
				x = (input.multiply(new BigDecimal(rs.getInt(1))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}