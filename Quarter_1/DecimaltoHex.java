import java.util.Scanner;

public class DecimaltoHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ret = 'N';
		char[] letters = new char[6];
		letters[0]='A';
		letters[1]='B';
		letters[2]='C';
		letters[3]='D';
		letters[4]='E';
		letters[5]='F';
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a decimal value(0 to 15): ");
		int decimal = input.nextInt();
		int remainder = decimal % 16;
		
		if(remainder > 9) {
			ret = letters[remainder - 10];
		}
		
		if(decimal > 15) {
			System.out.println("Invalid Input");
		}
		else if(decimal < 10) {
			System.out.println("The hex value is: ");
			System.out.println(remainder);
		}
		else if(decimal >= 10 && decimal <= 15) {
			System.out.println("The hex value is: ");
			System.out.println(ret);
		}
	
	}

}
