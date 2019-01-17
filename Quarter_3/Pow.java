import java.math.BigInteger;

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(pow(212312,10));

	}


	public static BigInteger pow(int x, int n) {
		BigInteger bigX = BigInteger.valueOf(x);
		BigInteger bixN = BigInteger.valueOf(n);
		if (n == 0) return BigInteger.valueOf(1);

		// find x to the n/2 recursively
		BigInteger t = pow(x, n / 2);

		// if n is even, the result is t squared
		// if n is odd, the result is t squared times x
		if (n % 2 == 0) {
			return t.multiply(t);
		} else {
			return t.multiply(t).multiply(bigX);
		}
	}

}
