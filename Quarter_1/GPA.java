import java.util.HashMap;
import java.util.Scanner;

public class GPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		map.put("A+", 5.0);
		map.put("A", 4.0);
		map.put("B+", 4.0);
		map.put("B", 3.0);
		map.put("C+", 3.0);
		map.put("C", 2.0);
		map.put("D+", 2.0);
		map.put("D", 1.0);
		map.put("F+", 1.0);
		map.put("F", 0.0);
		
		double addGrade = 0.0;
		
		System.out.print("Enter grade for Math: ");
		addGrade += map.get(input.nextLine());
		System.out.print("Enter grade for History: ");
		addGrade += map.get(input.nextLine());
		System.out.print("Enter grade for English: ");
		addGrade += map.get(input.nextLine());
		System.out.print("Enter grade for Science: ");
		addGrade += map.get(input.nextLine());
		System.out.print("Enter grade for PE: ");
		addGrade += map.get(input.nextLine());
		System.out.print("Enter grade for APCS: ");
		addGrade += map.get(input.nextLine());
		System.out.print("Enter grade for Spanish: ");
		addGrade += map.get(input.nextLine());
		
		double GPA = addGrade / 7;
		
		System.out.println("");
		System.out.printf("Your GPA is: " + "%.1f", GPA);
	}

}
