
public class checkParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(parenthesesCounter("(afd)()(f )(fad)"));

	}
	
	/**
	 * 
	 * @param s The string you want to check if it has same numbe of '(' and ')'
	 * @return number of uncompleted '('
	 */
	public static int parenthesesCounter(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (c == '(') {
		        count++;
		    } else if (c == ')') {
		        count--;
		    }
		}
		return count;
	}

}
