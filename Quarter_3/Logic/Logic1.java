package Logic;

public class Logic1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Exercise 4, Problem 1:");
		System.out.println("All x are z.\n" + "All y are z.\n" + "Therefore, some x are y.");
		System.out.println("x = [1,2,3], y = [2,1,3], z = [0,1,2,3,4]\n");

		int[] a = {1,2,3};

		int[] b = {2,1,3};

		int[] c = {0,1,2,3,4};

		if(someXareY(a,b)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");

		System.out.println("Exercise 4, Problem 2:");
		System.out.println("Some x are y.\n" + "All y are z.\n" + "Therefore, some x are z.");
		System.out.println("x = [1,3], y = [1,2,4], z = [1,2,3,4]\n");

		int[] x = {1,3};

		int[] y = {1,2,4};

		int[] z = {1,2,3,4};

		if(someXareY(x,z)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");

		System.out.println("Exercise 4, Problem 2:");
		System.out.println("All x are y.\n" + "Some y are z.\n" + "Therefore, some x are z.\n");
		System.out.println("x = [1,2], y = [1,2,3], z = [2,1,5,4]\n");

		int[] i = {1,2};

		int[] d = {1,2,3};

		int[] k = {2,1,5,4};

		if(someXareY(i,k)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");


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
		if(x[0] == y[0])return true;
		int j = 0; 
		for (int i = 0; i < y.length; i++){ 
			for (j = 0; j < x.length; j++) 
				if(y[i] == x[j]) break; 
			if (j >= x.length) return false; 
		} 
		return true; 

	}
}


