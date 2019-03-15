package Logic;

import java.util.Arrays;

public class legalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println("Test Cases: \n");
		//
		//		System.out.println("Check if \"a\" is legal");
		//		System.out.println(legal("a") + "\n");
		//
		//		System.out.println("Check if \"a&b\" is legal");
		//		System.out.println(legal("a&b")+ "\n");
		//
		//		System.out.println("Check if \"(a&b)\" is legal");
		//		System.out.println(legal("(a&b)") + "\n");
		//
		//		System.out.println("Check if \"((a&b) || c)\" is legal");
		//		System.out.println(legal("((a&b) || c)") + "\n");
		//		
		//		System.out.println("Edge Cases: \n");
		//		
		//		System.out.println("Test if \")(a)(\" is legal");
		//		System.out.println(legal(")(a)("));

		//		String[] str = new String[1];
		//		str[0] = "a||b";
		//		TruthAssignment ta = new TruthAssignment(str);
		//		System.out.println("Created a String of \"a||b\" and assigned it to false.");
		//		System.out.println("evaluate method returns:");
		//		System.out.println(evaluate(str[0], ta) + "\n");
		//		
		//		String[] str1 = new String[1];
		//		str1[0] = "a&b";
		//		boolean[] bool1 = new boolean[1];
		//		bool1[0] = true;
		//		TruthAssignment ta1 = new TruthAssignment(str1, bool1);
		//		System.out.println("Created a String of \"a&b\" and assigned it to true.");
		//		System.out.println("evaluate method returns:");
		//		System.out.println(evaluate(str1[0], ta1) + "\n");
		
		String[] arr = new String[4];
		arr[0] = "a";
		arr[1] = "b";
		arr[2] = "a";
		arr[3] = "b";
		System.out.println(pgenerateAllPairwiseConjunctions(arr));
	}
	private String str;

	//Constructor assigning legalString object to str
	public legalString(String str) {
		this.str = str;
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

	public static String pgenerateAllPairwiseConjunctions(String[] pcs) {
		String[] ret = new String[pcs.length/2];
//		LogicalSentence[] ls = new LogicalSentence[ret.length];
//		for(int i = 0; i < pcs.length; i += 2) {
//			for(int z = 0; z < ret.length; z++) {
//			ls[z] = new LogicalSentence(pcs[i]);
//			ls[z].makeConjunction(pcs[i++]);
//			
//			ret[z] = ls[z].toString();
//			}
//		}
		LogicalSentence[] ls = new LogicalSentence[ret.length];
		ls[0] = new LogicalSentence(pcs[0]);
		ls[0].makeConjunction(pcs[1]);
		ls[1] = new LogicalSentence(pcs[2]);
		ls[1].makeConjunction(pcs[3]);
		ret[0] = ls[0].toString();
		ret[1] = ls[1].toString();
		//System.out.println(ls[0]);
		return Arrays.toString(ret);
	}

	public String generateAllPairwiseGeneral(String[] pcs) {
		return "hi1";
	}

	public String generateAllSentencesLessThan6CharsLong(String[] pcs) {
		return "hi2";
	}

	public String generateAllSentencesShorterThan(String[] pcs, int maxLength) {
		return "hi3";
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

	//Checks if the sentence is simiple and legal
	public static boolean simple(String str) {
		if("~~".contains(str) != false)return false;
		return"~a&b~b~a|ba|~ba&~ba<=>b~a<=>~b~a<=>ba==>~b".contains(str);
	}
}

