import java.util.Scanner;

public class QuadraticFormulaLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a: ");
		double a = input.nextDouble();
		
		System.out.print("Enter b: ");
		double b = input.nextDouble();
		
		System.out.print("Enter c: ");
		double c = input.nextDouble();
		
		double dis = (b * b) - (4 * a * c);
		
		double root1 = ((-b + Math.pow(dis, 0.5)) /  (2 * a));
		double root2 = ((-b - Math.pow(dis, 0.5)) /  (2 * a));
		
		if(dis > 0) {
			System.out.print("The roots are: ");
			System.out.println(root1);
			System.out.print(" and ");
			System.out.println(root2);
		}
		else if(dis == 0) {
			System.out.print("The root is ");
			System.out.println(root1);
		}
		else {
			System.out.print("The equation has no real roots");
		}
	}

}
