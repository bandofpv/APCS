package Assignments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface SubstitutableString{
	
	void substituteAll(String a, String b, String c);
}

public abstract class TestSubstitutableString implements SubstitutableString{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(extractFirstParen("a(()c)b"));
		
		 String x= "Hello (Java)";
		 Matcher m = Pattern.compile("\\((.*?)\\)").matcher(x);
		while(m.find()) {
		    System.out.println(m.group(1));
		}
	}
	
	public static String extractFirstParen(String a) {
		return a.substring(a.indexOf("(") + 1, a.indexOf(")"));

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
