package Logic;

public class LogicalSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public LogicalSentence(String str) {
		if(simple(str)) {
			System.out.println(str);
		}
		else {
			System.out.println("Sorry, thats not legal.......");
		}
	}
	
	public static String makeNegation(String str) {
		return "~" + str;
	}
	
	public static String makeNDisjunction(String str) {
		return "||" + str;
	}
	
	public static String makeNConjunction(String str) {
		return "&&" + str;
	}
	
	public static String make(String str) {
		return "~" + str;
	}

	public static boolean simple(String str) {
		if(str.length() == 1) {
			"abc".contains(str);
		}
		else {
			return true;
		}
		return false;
	}
}
