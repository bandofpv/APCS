
public class Recurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Andrew";
		
		System.out.println(first(str));
		
		System.out.println(rest(str));
		
		System.out.println(middle(str));
		
		System.out.println(length(str));
		
		printString(str);
		
		printBackward(str);
		
		System.out.println(reverseString("coffee"));
		
		System.out.println(isPalindrome("sos"));
		
		System.out.println(first(str) == first(reverseString(str)));


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
	
	public static void printString(String a) {
		if (length(a) > 0) {
			System.out.println(first(a));
			printString(rest(a));
		}
	}
	
	public static void printBackward(String a) {
		if (length(a) > 0) {
			printBackward(rest(a));
			System.out.println(first(a));
		}
	}
	
	static String i = "";
	public static String reverseString(String a) {
		if (length(a) > 0) {
			i += reverseString(rest(a));
			i += first(a);
			return i;
		}
		return "";
	}
	
	public static boolean isPalindrome(String a) {
		if(length(a) == 1) {
			return true;
		}
		
		else if(length(a) == 2) {
			return first(a) == first(rest(a));
		}
		
		else {
			return first(a) == first(reverseString(a));
		}
	}

}
