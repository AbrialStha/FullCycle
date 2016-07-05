package utility;
/**
 * This class contains all the other helper functions used for some minor tweaks
 * @author pav15p
 *
 */
public class Helper {
	
	public static String getTestId(String TestName) {
		String[] temp = TestName.split("_");
		//System.out.println( temp[temp.length-1] );
		return temp[temp.length-1];
	}
}
