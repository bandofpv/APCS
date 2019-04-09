package Assignments;

public class NestedLoopMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberPiles a = new NumberPiles();
		a.NumberPiles(1);
		
		NumberPiles[] b = new NumberPiles[2];
		b[0].NumberPiles(2);
		b[1].NumberPiles(3);
		
		NestedLoopMath nlm = new NestedLoopMath(a,b);
		
		System.out.println(nlm.makeB());
		System.out.println(nlm.rowOp(1,2));
		System.out.println(nlm.dubOp(3,4));
		
	}

	public NumberPiles np;
	public NumberPiles[] npa = new NumberPiles[2];
	
	//A constructor that takes a NumberPile and an array of NumberPiles
	public NestedLoopMath(NumberPiles n, NumberPiles[] np) {
		this.np = n;
		this.npa = np;
	}
	
	//A method called makeB that takes no arguments, and returns a NumberPile
	public NumberPiles makeB() {
		return this.np;
	}
	
	//A method called rowOp that takes two integers and returns a NumberPile.
	public NumberPiles[] rowOp(int a, int b) {
		npa[0].NumberPiles(a);
		npa[1].NumberPiles(b);
		return this.npa;
	}
	
	//A method called grate that takes a double and an integer and returns a NumberPile.
	public NumberPiles[] dubOp(double a, int b) {
		npa[0].NumberPiles(a);
		npa[1].NumberPiles(b);
		return this.npa;
	}
}
