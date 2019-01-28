package Ch11;

public class Rational{
	public static void main(String args[]){
		Rational rat1 = new Rational();
		
		System.out.println("Using printRational method to print default rational");
		rat1.printRational();
		
		System.out.println("");
		
		System.out.println("Using toString method to print default rational");
		System.out.println(rat1);
		
		System.out.println("");

		Rational rat2 = new Rational(1, 2);

		System.out.println("Using toString method to print 1/2 rational");
		System.out.println(rat2);
		
		System.out.println("");
		
		System.out.println("Negating 1/2 to -1/2");
		rat2.negate();
		System.out.println(rat2);

		System.out.println("");
		
		System.out.println("Inverting -1/2 to -2/1");
		rat2.invert();
		System.out.println(rat2);

		System.out.println("");
		
		System.out.println("Turning -2/1 into a double --> -2.0");
		System.out.println(rat2.toDouble());

		Rational rat3 = new Rational(5, 15);

		System.out.println("");
		
		System.out.println("Reducing 5/15 to 1/3");
		System.out.println(rat3.reduce());

		Rational rat4 = new Rational(1, 4);

		Rational rat5 = new Rational(1, 4);

		System.out.println("");
		
		System.out.println("Adding 1/4 and 1/4 to get 1/2");
		System.out.println(rat4.add(rat5));
		
		System.out.println("");
		
		Rational rat6 = new Rational(-1, 2);
		rat6.invert();
		System.out.println("Inverting -1/2 correctly");
		System.out.println(rat6);
		Rational rat7 = new Rational(-1, 2);
		System.out.println("Inverting -1/2 incorrectly");
		rat6.wrongInvert();
		System.out.println(rat6);
		
		if (rat7.equals(rat6) == false) {
			System.out.println("Test Failed!!!");
		}
	}

	private int	numerator;

	private int	denominator;

	public Rational(){

		this(0,1);
	}

	public Rational(Rational a){

		this(a.numerator,a.denominator);

		printRational();
	}

	public Rational(int numerator, int denominator){

		this.set(numerator,denominator);

	}

	public void	printRational(){

		System.out.println(this.numerator + "/" + this.denominator);

	}

	public void	negate(){

		this.numerator = -this.numerator;

	}	

	public void	invert(){

		this.numerator += this.denominator;
		this.denominator = this.numerator - this.denominator;
		this.numerator = this.numerator - this.denominator;

		this.extra();
	}

		public void	wrongInvert(){
			
			this.numerator = this.denominator;
			this.denominator = this.numerator;
			
			this.extra();
	
		}


	public Double toDouble(){

		return (double)this.numerator / (double)this.denominator;
	}

	public Rational reduce(){

		int gcd = gcd(this.numerator, this.denominator);
		return new Rational(this.numerator / gcd,	this.denominator / gcd);
	}

	private int gcd(int p, int q) {

		if (q == 0) return p;

		else return gcd(q, p % q);

	}

	public Rational add(Rational newRat){

		int newNum = this.numerator * newRat.denominator + newRat.numerator * this.denominator;
		int newDen = this.denominator * newRat.denominator;

		Rational ret = new Rational(newNum, newDen).reduce();
		ret.extra();

		this.set(ret.numerator, ret.denominator);
		return ret;
	}

	public void	set(int numerator, int denominator){

		this.numerator	= numerator;
		this.denominator = denominator;
		this.extra();
	}

	private void extra(){

		if	(this.denominator < 0){

			this.negate();

			this.denominator = -this.denominator;

		}

	}

	public String toString(){

		return this.numerator + "/" + this.denominator;

	}

}
