import java.util.Scanner;

public class Payroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter employee's name: ");
		String name = input.nextLine();
		
		System.out.print("Enter number of hours worked in a week: ");
		double hours = input.nextDouble();
		
		System.out.print("Enter hourly pay rate: ");
		double payRate = input.nextDouble();
		
		System.out.print("Enter federal tax withholding rate: ");
		double federalTax = input.nextDouble();
		
		System.out.print("Enter state tax wihtholding rate: ");
		double stateTax = input.nextDouble();
		
		System.out.println();
		
		System.out.print("Employee name: ");
		System.out.println(name);
		
		System.out.print("Hours Worked: ");
		System.out.println(hours);
		
		System.out.print("Pay Rate: $");
		System.out.println(payRate);
		
		double grossPay = hours * payRate;
		double with1 = grossPay * federalTax;
		double with2 = grossPay * stateTax;
		double deduction = with1 + with2;
		double net = grossPay - deduction;
		
		System.out.print("Gross Rate: $");
		System.out.println(grossPay);
		
		System.out.println("Dedecutions:");
		
		System.out.print("   Federal Withholding");
		System.out.print(" (");
		System.out.print(federalTax * 100);
		System.out.print("%): $");
		System.out.println(with1);
		
		System.out.print("   State Witholding");
		System.out.print(" (");
		System.out.print(stateTax * 100);
		System.out.print("%): $");
		System.out.println(with2);
		
		System.out.print("   Total Deduction: $");
		System.out.println(deduction);
		
		System.out.print("Net Pay: $");
		System.out.println(net);
	}

}
