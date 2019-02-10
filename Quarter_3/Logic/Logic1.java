package Logic;

public class Logic1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Exercise 4, Problem 1:");
		System.out.println("All x are z.\n" + "All y are z.\n" + "Therefore, some x are y.\n");
		System.out.println("x = [1,2], y = [2,1], z = [1,2]\n");

		int[] a = {1,2};

		int[] b = {2,1};

		int[] c = {1,2};

		System.out.println("All x are z.");
		if(allXareY(a,c)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");
		
		System.out.println("All y are z.");
		if(allXareY(b,c)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");

		System.out.println("Therefore, some x are y.");
		if(someXareY(a,b)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");

		System.out.println("Exercise 4, Problem 2:");
		System.out.println("Some x are y.\n" + "All y are z.\n" + "Therefore, some x are z.\n");
		System.out.println("x = [1,3], y = [1,2,4], z = [1,2,3,4]\n");

		int[] x = {1,3};

		int[] y = {1,2,4};

		int[] z = {1,2,3,4};
		
		System.out.println("Some x are y.");
		if(someXareY(x,y)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");
		
		System.out.println("All y are z.");
		if(allXareY(y,z)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");

		System.out.println("Therefore, some x are z.");
		if(someXareY(x,z)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");

		System.out.println("Exercise 4, Problem 2:");
		System.out.println("All x are y.\n" + "Some y are z.\n" + "Therefore, some x are z.\n");
		System.out.println("x = [1,2], y = [1,2,3,4], z = [3,5,4]\n");

		int[] i = {1,2};

		int[] d = {1,2,3,4};

		int[] k = {3,5,4};
		
		System.out.println("All x are y.");
		if(allXareY(i,d)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");
		
		System.out.println("Some y are z.");
		if(someXareY(d,i)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");
		
		System.out.println("Therefore, some x are z.");
		if(someXareY(i,k)) System.out.println("Passed test\n");

		else System.out.println("Failed test\n");


	}

	public static boolean allXareY(int[] x, int[] y){
		if(x[0] == y[0])return true;
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


