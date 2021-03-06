package Logic;

public class LogicalSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogicalSentence str = new LogicalSentence("a");
		
		System.out.println("Making a negation with a");
		str.makeNegation();
		System.out.println(str + "\n");
		
		System.out.println("Making a Disjuntion with ~a and b");
		str.makeDisjunction("b");
		System.out.println(str + "\n");
		
		System.out.println("Making a negation with ~a||b");
		str.makeNegation();
		System.out.println(str + "\n");
		
		LogicalSentence x = new LogicalSentence("a");
		
		System.out.println("Making a Conjuntion with a and b");
		x.makeConjunction("b");
		System.out.println(x + "\n");
		
		LogicalSentence y = new LogicalSentence("a");
		
		System.out.println("Making a Biconditional with a and b");
		y.makeBiconditional("b");
		System.out.println(y + "\n");

	}
	private String str;
	

	public LogicalSentence(String str) {
		this.str = str;
	}
	
	public String makeNegation() {
		this.str = "~" + str;
		return str.toString();
	}
	
	public String makeDisjunction(String str1) {
		this.str += "|" + str1;
		return str.toString();
	}
	
	public String makeConjunction( String str1) {
		this.str += "&" + str1;
		return str.toString();
	}
	
	public String makeBiconditional(String str1) {
		this.str += "<=>" + str1;
		return str.toString();
	}
	
	public String toString() {
		if(simple(this.str)) {
			return this.str;
		}
		else {
			//return "Sorry, thats not legal.......";
			return this.str;
		}
	}
	
	public static boolean simple(String str) {
		if("~~".contains(str) != false)return false;
		return"b|ab&a~a&b~b~a|ba|~ba&~ba<=>b~a<=>~b~a<=>ba<=>~b<=>a".contains(str);
	}
}
