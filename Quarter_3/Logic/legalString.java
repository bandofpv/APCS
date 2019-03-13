package Logic;

public class legalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Test Cases: \n");
//
//		System.out.println("Check if \"a\" is legal");
//		System.out.println(legal("a") + "\n");
//
//		System.out.println("Check if \"a&&b\" is legal");
//		System.out.println(legal("a&&b")+ "\n");
//
//		System.out.println("Check if \"(a&&b)\" is legal");
//		System.out.println(legal("(a&&b)") + "\n");
//
//		System.out.println("Check if \"((a&&b) || c)\" is legal");
//		System.out.println(legal("((a&&b) || c)") + "\n");
//		
//		System.out.println("Edge Cases: \n");
//		
//		System.out.println("Test if \")(a)(\" is legal");
//		System.out.println(legal(")(a)("));
		
		String[] str = new String[1];
		str[0] = "a||b";
		TruthAssignment ta = new TruthAssignment(str);
		System.out.println("Created a String of \"a||b\" and assigned it to false.");
		System.out.println("evaluate method returns:");
		System.out.println(evaluate(str[0], ta) + "\n");
		
		String[] str1 = new String[1];
		str1[0] = "a&&b";
		boolean[] bool1 = new boolean[1];
		bool1[0] = true;
		TruthAssignment ta1 = new TruthAssignment(str1, bool1);
		System.out.println("Created a String of \"a&&b\" and assigned it to true.");
		System.out.println("evaluate method returns:");
		System.out.println(evaluate(str1[0], ta1) + "\n");
	}
	private String str;

	//Constructor assigning legalString object to str
	public legalString(String str) {
		this.str = str;
	}
	
	//Checks if the sentence is simiple and legal
	public static boolean simple(String str) {
		if("~~".contains(str) != false)return false;
		return"~a&&b~b~a||ba||~ba&&~ba<==>b~a<==>~b~a<==>ba<==>~b".contains(str);
	}
	
	//check if sentence in parens is simple or complex and legal
	public static boolean legal(String a) {
		if(simple(a)) return true;

		else if(a.contains("(") && a.contains(")")) {
			if(a.lastIndexOf('(') < a.indexOf(')')) {
				return simple(a.substring(a.lastIndexOf('('
						) + 1, a.indexOf(')')));
			}
			return false;
		}

		return false;
	}
	
	//method that takes a string representing a logical sentence and a TruthAssignment which returns a boolean that is the result of evaluating the logical sentence with the given truth assignment
	public static boolean evaluate(String str, TruthAssignment ta) {
		if (legal(str)) return ta.getTruthProp(str);
		return false;
	}
	
	public static void generate() {
		
	}
	
	//toString method returning String of logical sentence or if it's not legal than "Sorry, thats not legal......."
	public String toString() {
		if(simple(this.str)) {
			return this.str;
		}
		else {
			return "Sorry, thats not legal.......";
		}
	}
}

