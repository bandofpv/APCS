import java.util.Scanner;

public class PhoneKeypads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = input.nextLine();
		String ret = "";
		
		
		for (int i = 0; i < str.length(); i++) {
			ret += getNumber(str.charAt(i));
		}
		
		System.out.println(ret);
	}
	
	public static char getNumber(char uppercaseLetter) {
		if (uppercaseLetter == 'A') return '2';
		if (uppercaseLetter == 'B') return '2';
		if (uppercaseLetter == 'C') return '2';
		if (uppercaseLetter == 'D') return '3';
		if (uppercaseLetter == 'E') return '3';
		if (uppercaseLetter == 'F') return '3';
		if (uppercaseLetter == 'G') return '4';
		if (uppercaseLetter == 'H') return '4';
		if (uppercaseLetter == 'I') return '4';
		if (uppercaseLetter == 'J') return '5';
		if (uppercaseLetter == 'K') return '5';
		if (uppercaseLetter == 'L') return '5';
		if (uppercaseLetter == 'M') return '6';
		if (uppercaseLetter == 'N') return '6';
		if (uppercaseLetter == 'O') return '6';
		if (uppercaseLetter == 'P') return '7';
		if (uppercaseLetter == 'Q') return '7';
		if (uppercaseLetter == 'R') return '7';
		if (uppercaseLetter == 'S') return '7';
		if (uppercaseLetter == 'T') return '8';
		if (uppercaseLetter == 'U') return '8';
		if (uppercaseLetter == 'V') return '8';
		if (uppercaseLetter == 'W') return '9';
		if (uppercaseLetter == 'X') return '9';
		if (uppercaseLetter == 'Y') return '9';
		if (uppercaseLetter == 'Z') return '9';
		
		else return uppercaseLetter;
		
	}

}
