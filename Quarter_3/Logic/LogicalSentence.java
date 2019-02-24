package Logic;

public class LogicalSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hi = "a";
		System.out.println("a&&ba~a".contains(hi));
		makeNegation(hi);
		makeDisjunction(hi, "b");
		makeConjunction(hi, "b");

	}
	
	public static void LogicalSentence(String str) {
		if(simple(str)) {
			System.out.println(str);
		}
		else {
			System.out.println("Sorry, thats not legal.......");
		}
	}
	
	public static void makeNegation(String str) {
		LogicalSentence("~" + str);
	}
	
	public static void makeDisjunction(String str, String str1) {
		LogicalSentence(str + "||" + str1);
	}
	
	public static void makeConjunction(String str, String str1) {
		LogicalSentence(str + "&&" + str1);
	}
	
	public static void make(String str) {
		LogicalSentence("~" + str);
	}

	public static boolean simple(String str) {
		return"~a&&b~b~a||ba||~ba&&~b".contains(str);
	}
}
