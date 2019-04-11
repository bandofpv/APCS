package Assignments;

public class NestedLoopMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

	public double np;
	public double[] npa = new double[2];
	
	//A constructor that takes a NumberPile and an array of double
	public NestedLoopMath(double n, double[] np) {
		this.np = n;
		this.npa = np;
	}
	
	//A method called makeB that takes no arguments, and returns a NumberPile
	public double makeB() {
		return this.np;
	}
	
	//A method called rowOp that takes two integers and returns a NumberPile.
	public double[] rowOp(int a, int b) {
		npa[0] = a;
		npa[1] = b;
		return this.npa;
	}
	
	//A method called grate that takes a double and an integer and returns a NumberPile.
	public double[] dubOp(double a, int b) {
		npa[0] = a;
		npa[1] = b;
		return this.npa;
	}
	
	public double[] zeroOut(double[] a, double[] b) {
		double[] ret = new double[a.length];
		double i = a[0]/b[0];
		ret = rowOp(a,i);
		ret = rowAdd(ret,b);
		return ret;
	}
}
