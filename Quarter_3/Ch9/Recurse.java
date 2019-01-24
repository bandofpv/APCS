package Ch9;
import java.util.Arrays;

public class Recurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Andrew";
		
		System.out.println(first(str));
		//Test for first() method
		
		System.out.println(rest(str));
		//Test for rest() method
		
		System.out.println(middle(str));
		//Test for middle() method
		
		System.out.println(length(str));
		//Test for length() method
		
		printString(str);
		//Test for printString() method
		
		printBackward(str);
		//Test for print Backward method
		
		System.out.println(reverseString("coffee"));
		//print the reverse of coffee
		
		System.out.println(isPalindrome("palindromeemordnilap"));
		//Check if palindromeemordnilap is a palindrome
		
		System.out.println(isAbecedarian("dimpsy"));
		//check if dimpsy is Abecaedarian
		
		System.out.println(isDoubloon("appall"));
		//check if appall is Doubloon
		
		System.out.println(isAnagrams("allen downey", "well annoyed"));
		//check if "stop" and "pots" are anagrams
		
		System.out.println(canSpell("jib", "quijibo"));
		//check if "jib" can be spelled with Scrabble letters "quijibo"

	}

	/**
	 * Returns the first character of the given String.
	 */
	public static char first(String s) {
		return s.charAt(0);
	}
	

	/**
	* Returns all but the first letter of the given String.
	*/
	public static String rest(String s) {
		return s.substring(1);
	}
	

	/**
	 * Returns all but the first and last letter of the String.
	 */
	public static String middle(String s) {
		return s.substring(1, s.length() - 1);
	}
	

	/**
	 * Returns the length of the given String.
	 */
	public static int length(String s) {
		return s.length();
	}
	
	/**
	 * 
	 * @param a The String you want to print
	 * @return The string with each letter in a line
	 */
	public static void printString(String a) {
		if (length(a) > 0) {
			System.out.println(first(a));
			printString(rest(a));
		}
	}
	
	/**
	 * 
	 * @param a The String you want to print backwards
	 * @return The string backwards with each letter in a line
	 */
	public static void printBackward(String a) {
		if (length(a) > 0) {
			printBackward(rest(a));
			System.out.println(first(a));
		}
	}
	
	/**
	 * 
	 * @param a The String you want to reverse
	 * @return The string in reverse
	 */
	static String i = "";
	public static String reverseString(String a) {
		if (length(a) > 0) {
			return reverseString(rest(a)) + first(a);
		}
		return "";
	}
	
	/**
	 * 
	 * @param a The String you want to check if it is a palindrome
	 * @return true or false if it is or isn't a palindrome
	 */
	public static boolean isPalindrome(String a) {
		if(length(a) == 1) {
			return true;
		}
		
		else if(length(a) == 2) {
			return first(a) == first(rest(a));
		}
		
		else {
			return first(a) == first(reverseString(rest(a))) && isPalindrome(middle(a));
		}
	}
	
	/**
	 * 
	 * @param a The String you want to check if it is a abecedarian
	 * @return true or false if it is or isn't a abecedarian
	 */
	public static boolean isAbecedarian(String a) {
		a = a.toLowerCase();
		for (int i = 0; i < a.length()-1; i++) {
			if (a.charAt(i) < a.charAt(i+1)) return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param a The String you want to convert to histogram
	 * @return Array with number of each letter
	 */
	public static int[] convertHist(String a) {
		int[] array = new int[26];
		a = a.toLowerCase();
		for (char letter: a.toCharArray()) {
	          if (letter >= 'a' && letter <= 'z') {
	             array[letter- 'a'] += 1;
	          }  
		}
		
		return array;
	          
	}
	
	/**
	 * 
	 * @param a The String you want to check if it is a Doubloon
	 * @return true or false if the string is or isn't a Doubloon
	 */
	public static boolean isDoubloon(String a) {
		int [] Array = new int[26];
		Array = convertHist(a);
		for (int i = 0; i < 26; i++) {
			if (Array[i] == 1 || Array[i] > 2) return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param a The first String you want to check with the second String if they are anagrams
	 * @param b The second String you want to check with the first String if they are anagrams
	 * @return true or false if it is or isn't a anagram
	 */
	public static boolean isAnagrams(String a, String b) {
		int [] Arraya = new int[26];
		Arraya = convertHist(a);
		a = Arrays.toString(Arraya);
		
		int [] Arrayb = new int[26];
		Arrayb = convertHist(b);
		b = Arrays.toString(Arrayb);

		if(a.equals(b)) return true;
		
		return false;
	}
	
	/**
	 * 
	 * @param a The String that you want to spell 
	 * @param b The String that that included the given Scrabble letters
	 * @return true or false if you can or can't spell the String
	 */
	public static boolean canSpell(String a, String b) {
		int [] Arraya = new int[26];
		Arraya = convertHist(a);
		
		int [] Arrayb = new int[26];
		Arrayb = convertHist(b);
		
		for (int i = 0; i < 26; i++) {
			if(Arraya[i] == 1 && Arrayb[i] < Arraya[i]) return false;
		}
		
		return true;
	}

}
