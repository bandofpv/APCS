import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LottoNumbers {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File file = new File("/Users/palycs/git/APCS/src/LottoNumbers.txt"); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		boolean[] isCovered = new boolean[99]; // Default is false
		
		// Read each number and mark its corresponding element covered
		int number = Integer.valueOf(br.readLine());
		while (number != 0) {
			isCovered[number - 1] = true;
			number = Integer.valueOf(br.readLine());
		}
		
		// Check whether all covered
		boolean allCovered = true;  //Assume all covered initially
		for (int i = 0; i < isCovered.length; i++) {
			if (!isCovered[i]) {
				allCovered = false; // Find one number not covered
				break;
			}
		}
		
		// Display result
		if (allCovered) {
			System.out.println("The tickets cover all numbers");
		}
		else {
			System.out.println("The tickets don't cover all numbers");
		}
	}

}
