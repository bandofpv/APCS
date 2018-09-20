import java.util.Scanner;

public class Investment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("The amount invested: ");
		double investment = input.nextDouble();
		
		System.out.print("Annual interest rate: ");
		double rate = input.nextDouble();
		
		rate *= 0.01;
		
		System.out.println("Years   Future Value");
		for(int i = 1; i <= 30; i++) {
			int spacing = 19;
			if (i >= 10) spacing = 18;
			System.out.printf(i + "%"+ spacing +".2f\n", futureInvestmentValue(investment, rate/12, i));
	       }
		}
	
	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
		return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
	}

}
