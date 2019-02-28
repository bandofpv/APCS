package Logic;

public class PropositionConstant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropositionConstant pr = new PropositionConstant("b");
		System.out.println(pr);

	}

	private String str;
	
	public PropositionConstant() {
		this.str = "a";
	}
	
	public PropositionConstant(String pr) {
		this.str = pr;
	}

	public String toString() {
		return str;
	}

}
