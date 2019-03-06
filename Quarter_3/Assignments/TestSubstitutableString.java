package Assignments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface SubstitutableString{
	
	static String extractFirstParen(String a) {
		return null;
	}
	static String substituteAll(String a, String b, String c) {
		return null;
	}
}

public abstract class TestSubstitutableString implements SubstitutableString{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Cases for extractFirstParen method \n");
		
		System.out.println("Test Cases:");
		System.out.println("\"a(c)b\" : " + extractFirstParen("a(c)b"));
		System.out.println("\"(\" : " + extractFirstParen("("));
		System.out.println("\")(\" : " + extractFirstParen(")("));
		System.out.println("\"(adas)(fa))\" : " + extractFirstParen("(adas)(fa))") + "\n");
		
		System.out.println("Edge cases:");
		System.out.println("\"(adas))(!)((@)(#)\" : " + extractFirstParen("(adas))(!)((@)(#)"));
		System.out.println("\"(a()(*)\" : " + extractFirstParen("(a()(*)") + "\n");
		
		System.out.println("Cases for substituteAll method \n");
		
		System.out.println("Test Cases:");
		System.out.println("\"abc\", \"b\", \"c\" : " + substituteAll("abc", "b", "c"));
		System.out.println("\"Andrew is cool\", \"cool\", \"happy\" : " +substituteAll("Andrew is cool", "cool", "happy"));
		System.out.println("\"aca\", \"b\", \"c\" : " +substituteAll("aca", "b", "c"));

	}
	
	// given a string returns the earliest substring delimited by parenthesis that contains no parenthesis.
	public static String extractFirstParen(String a) {
		if(a.contains("(") && a.contains(")")) {
			if(a.lastIndexOf('(') < a.indexOf(')')) {
				return a.substring(a.lastIndexOf('(') + 1, a.indexOf(')'));
			}
		}
		return "Error";

	}
	
	// return a string equal to a, *except* that every occurance of b in a is substituted for by c.
	public static String substituteAll(String a, String b, String c) {
		if(a.contains(b)) {
			String ret = a;
			ret = ret.replaceAll(b, c);
			return ret;
		}
		return a;
	}

	/**
	Find out what a reference implementation and what an edge case is. Then...

	This interface will support two methods:

	extractFirstParen(String a); // given a string returns the earliest substring delimited by parenthesis that contains no parenthesis.
 	// document and test your choices for edge cases. (What is an edge case?)

	substituteAll(String a, String b, String c); // return a string equal to a, *except* that every occurance of b in a is substituted for by c.
	// again. document and test edge cases
	**/

}
