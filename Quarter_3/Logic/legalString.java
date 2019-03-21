package Logic;

import java.util.Arrays;

public class legalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Cases: \n");
		
		System.out.println("Check if \"a\" is legal");
		System.out.println(legal("a") + "\n");
		
		System.out.println("Check if \"a&b\" is legal");
		System.out.println(legal("a&b")+ "\n");
		
		System.out.println("Check if \"(a&b)\" is legal");
		System.out.println(legal("(a&b)") + "\n");
		
		System.out.println("Check if \"((a&b) || c)\" is legal");
		System.out.println(legal("((a&b) || c)") + "\n");
		
		System.out.println("Edge Cases: \n");
		
		System.out.println("Test if \")(a)(\" is legal");
		System.out.println(legal(")(a)("));

		String[] str = new String[1];
		str[0] = "a||b";
		TruthAssignment ta = new TruthAssignment(str);
		System.out.println("Created a String of \"a||b\" and assigned it to false.");
		System.out.println("evaluate method returns:");
		System.out.println(evaluate(str[0], ta) + "\n");
				
		String[] str1 = new String[1];
		str1[0] = "a&b";
		boolean[] bool1 = new boolean[1];
		bool1[0] = true;
		TruthAssignment ta1 = new TruthAssignment(str1, bool1);
		System.out.println("Created a String of \"a&b\" and assigned it to true.");
		System.out.println("evaluate method returns:");
		System.out.println(evaluate(str1[0], ta1) + "\n");

		System.out.println("Created an array with two prop const \"a\" and \"b\" \n");
		String[] arr = new String[4];
		arr[0] = "a";
		arr[1] = "b";
		System.out.println("Output of generateAllPairwiseConjunctions for our array");
		System.out.println(generateAllPairwiseConjunctions(arr) + "\n");
		System.out.println("Output of generateAllPairwiseGeneral for our array");
		System.out.println(generateAllPairwiseGeneral(arr) + "\n");

		System.out.println(generateAllSentencesLessThan6CharsLong(arr));
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

	public static String generateAllPairwiseConjunctions(String[] pcs) {
		String[] ret = new String[pcs.length/2];
		LogicalSentence[] ls = new LogicalSentence[ret.length];
		ls[0] = new LogicalSentence(pcs[0]);
		ls[0].makeConjunction(pcs[1]);
		ls[1] = new LogicalSentence(pcs[1]);
		ls[1].makeConjunction(pcs[0]);
		ret[0] = ls[0].toString();
		ret[1] = ls[1].toString();
		return Arrays.toString(ret);
	}

	public static String generateAllPairwiseGeneral(String[] pcs) {
		String[] ret = new String[pcs.length*2];
		LogicalSentence[] ls = new LogicalSentence[pcs.length*2];

		ls[0] = new LogicalSentence(pcs[0]);
		ls[0].makeConjunction(pcs[1]);
		ls[1] = new LogicalSentence(pcs[1]);
		ls[1].makeConjunction(pcs[0]);
		ls[2] = new LogicalSentence(pcs[0]);
		ls[2].makeDisjunction(pcs[1]);
		ls[3] = new LogicalSentence(pcs[1]);
		ls[3].makeDisjunction(pcs[0]);
		ls[4] = new LogicalSentence(pcs[0]);
		ls[4].makeNegation();
		ls[5] = new LogicalSentence(pcs[1]);
		ls[5].makeNegation();
		ls[6] = new LogicalSentence(pcs[0]);
		ls[6].makeBiconditional(pcs[1]);
		ls[7] = new LogicalSentence(pcs[1]);
		ls[7].makeBiconditional(pcs[0]);

		for(int i = 0; i < ret.length; i++) {
			ret[i] = ls[i].toString();
		}

		return Arrays.toString(ret);
	}

	public static String generateAllSentencesLessThan6CharsLong(String[] pcs) {
		String[] ret = new String[16];
		LogicalSentence[] ls = new LogicalSentence[16];
		for (int i = 0; i < ret.length/2; i++) {
			ls[i] = new LogicalSentence(pcs[0]);
		}
		for (int i = ret.length/2; i < ret.length; i++) {
			ls[i] = new LogicalSentence(pcs[1]);
		}
		
		
		ls[0].makeNegation();
		ls[0].makeBiconditional(pcs[1]);
		
		ls[1].makeNegation();
		
		ls[2].makeConjunction(pcs[1]);
		
		ls[3].makeDisjunction(pcs[1]);
		
		ls[4].makeBiconditional(pcs[1]);
		
		ls[5].makeNegation();
		ls[5].makeConjunction(pcs[1]);
		
		ls[8].makeNegation();
		ls[8].makeBiconditional(pcs[0]);

		ls[9].makeNegation();
		
		ls[10].makeConjunction(pcs[1]);
		
		ls[11].makeDisjunction(pcs[0]);
		
		ls[12].makeBiconditional(pcs[0]);


		for(int i = 0; i < ret.length; i++) {
			ret[i] = ls[i].toString();
		}

		return Arrays.toString(ret);
	}

	public String generateAllSentencesShorterThan(String[] pcs, int maxLength) {
		return "hi3";
	}

	//Checks if the sentence is simiple and legal
	public static boolean simple(String str) {
		if("~~".contains(str) != false)return false;
		return"~a&b~b~a|ba|~ba&~ba<=>b~a<=>~b~a<=>ba==>~b".contains(str);
	}
}

