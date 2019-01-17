import java.math.BigInteger;

public class Big {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BigInteger number = BigInteger.valueOf(2147483647);

		for (int i = 0; i <= 30; i++){
			System.out.println(i + ": " + factorial(i));
		}

	}

	public static BigInteger factorial(int number){
		BigInteger result = BigInteger.valueOf(1);
		for (int i = number;i > 0;i--){
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result; 
	}


}
