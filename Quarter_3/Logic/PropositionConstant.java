package Logic;

public class PropositionConstant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropositionConstant pr = new PropositionConstant("b");
		System.out.println(pr);

	}

	private String str;
	
	//A constructor creating a prop const of "a"
	public PropositionConstant() {
		this.str = "a";
	}
	
	//A constructor creating a prop const of your input
	public PropositionConstant(String pr) {
		this.str = pr;
	}

	//a toString return the prop const
	public String toString() {
		return str;
	}

}
