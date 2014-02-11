package pm.points.utility;

public class ParseUtility
{
	public static boolean isEmpty(String s) {
		return s == null || s == "";
	}
	
	public static long safeParseLong(String s, long fallback) {
		try {
			return Long.parseLong(s);
		}
		catch ( Throwable t ) {
			return fallback;
		}
	}
	
	public static int safeParseInt(String s, int fallback) {
		try {
			return Integer.parseInt(s);
		}
		catch ( Throwable t ) {
			return fallback;
		}
	}
	
	public static double safeParseDouble(String s, double fallback) {
		try {
			return Double.parseDouble(s);
		}
		catch( Throwable t ) {
			return fallback;
		}
	}
}