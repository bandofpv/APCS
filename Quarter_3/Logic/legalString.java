package Logic;

public class legalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Cases: \n");

		System.out.println("Check if \"a\" is legal");
		System.out.println(legal("a") + "\n");

		System.out.println("Check if \"a&&b\" is legal");
		System.out.println(legal("a&&b")+ "\n");

		System.out.println("Check if \"(a&&b)\" is legal");
		System.out.println(legal("(a&&b)") + "\n");

		System.out.println("Check if \"((a&&b) || c)\" is legal");
		System.out.println(legal("((a&&b) || c)") + "\n");
		
		System.out.println("Edge Cases: \n");
		
		System.out.println("Test if \")(a)(\" is legal");
		System.out.println(legal(")(a)("));
	}
	private String str;


	public legalString(String str) {
		this.str = str;
	}

	public static boolean simple(String str) {
		if("~~".contains(str) != false)return false;
		return"~a&&b~b~a||ba||~ba&&~ba<==>b~a<==>~b~a<==>ba<==>~b".contains(str);
	}

	public static boolean legal(String a) {
		if(simple(a)) return true;

		else if(a.contains("(") && a.contains(")")) {
			if(a.lastIndexOf('(') < a.indexOf(')')) {
				return simple(a.substring(a.lastIndexOf('(') + 1, a.indexOf(')')));
			}
			return false;
		}

		return false;
	}

	public String toString() {
		if(simple(this.str)) {
			return this.str;
		}
		else {
			return "Sorry, thats not legal.......";
		}
	}
}

