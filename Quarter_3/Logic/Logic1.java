package Logic;

public class Logic1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comparing if all (1,2,3) are in (2,1,3)");

		int[] a = {1,2,3};

		int[] b = {2,1,3};

		if(allXareY(a,b)) System.out.println("Passed test");

		else System.out.println("Failed test");

		System.out.println("");

		System.out.println("Comparing if all (4,5,6) are in (3,1,2)");

		int[] x = {4,5,6};

		int[] y = {3,1,2};

		if(allXareY(x,y)) System.out.println("Passed test");

		else System.out.println("Failed test");

		System.out.println("");

		System.out.println("Comparing if all (1,2,3) are in (3,2,1)");

		int[] w = {1,2,3};

		int[] l = {3,2,1};

		if(allXareY(w,l)) System.out.println("Passed test");

		else System.out.println("Failed test");

		System.out.println("");

		System.out.println("Comparing if all (4,5,3) are in (3,4,2)");

		int[] f = {4,5,3};

		int[] s = {3,4,2};

		if(allXareY(f,s)) System.out.println("Passed test");

		else System.out.println("Failed test");

		System.out.println("");

		System.out.println("Comparing if some (1,2) are in (2,1)");

		int[] e = {1,2,4};

		int[] r = {2,3,1};

		if(someXareY(e,r)) System.out.println("Passed test");

		else System.out.println("Failed test");


	}

	public static boolean allXareY(int[] x, int[] y){
		int j = 0; 
		for (int i = 0; i < y.length; i++){ 
			for (j = 0; j < x.length; j++) 
				if(y[i] == x[j]) break; 
			if (j == x.length) return false; 
		} 
		return true; 

	}

	public static boolean someXareY(int[] x, int[] y){
		int j = 0; 
		for (int i = 0; i < y.length; i++){ 
			for (j = 0; j < x.length; j++) 
				if(y[i] == x[j]) break; 
			if (j > x.length) return false; 
		} 
		return true; 

	}
}

