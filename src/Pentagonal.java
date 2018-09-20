
public class Pentagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 100; i++) {
			if(i % 10 == 1) System.out.println();
			System.out.print(getPentagonalNumber(i) + " ");
		}
	}
	public static int getPentagonalNumber(int n) {
		return (n * ((3 * n)-1))/2;
	}

}
