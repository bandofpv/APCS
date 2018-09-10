import java.util.Scanner;

public class Cylinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter radius of cylinder: ");
		double radius = input.nextDouble();
		
		System.out.println("Enter length of cylinder: ");
		double length = input.nextDouble();
		
		double area = radius * radius * Math.PI;
		double volume = area * length; 
		
		System.out.println("The area is: ");
		System.out.println(area);
		
		System.out.println("The volume is: ");
		System.out.println(volume);
	}

}
