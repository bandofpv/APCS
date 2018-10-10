import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "scissor");
		map.put("1", "rock");
		map.put("2", "paper");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("scissor (0), rock (1), paper (2): ");
		int user = input.nextInt();
		
		Random r = new Random();
		int comp = r.nextInt((2 - 1) + 1) + 1;
		
		if(comp == user) {
			System.out.print("The computer is ");
			System.out.print(map.get(Integer.toString(comp)));
			System.out.print(". You are ");
			System.out.print(map.get(Integer.toString(user)));
			System.out.print(" too. It's a draw.");
		}
		else if(user == 0) {
			if(comp == 2) {
				System.out.print("The computer is ");
				System.out.print(map.get(Integer.toString(comp)));
				System.out.print(". You are ");
				System.out.print(map.get(Integer.toString(user)));
				System.out.print(". You win.");
			}
			else {
				System.out.print("The computer is ");
				System.out.print(map.get(Integer.toString(comp)));
				System.out.print(". You are ");
				System.out.print(map.get(Integer.toString(user)));
				System.out.print(". I win.");
			}
		}
		else if(user == 1) {
			if(comp == 0) {
				System.out.print("The computer is ");
				System.out.print(map.get(Integer.toString(comp)));
				System.out.print(". You are ");
				System.out.print(map.get(Integer.toString(user)));
				System.out.print(". You win.");
			}
			else {
				System.out.print("The computer is ");
				System.out.print(map.get(Integer.toString(comp)));
				System.out.print(". You are ");
				System.out.print(map.get(Integer.toString(user)));
				System.out.print(". I win.");
			}
		}
		else if(user == 2) {
			if(comp == 1) {
				System.out.print("The computer is ");
				System.out.print(map.get(Integer.toString(comp)));
				System.out.print(". You are ");
				System.out.print(map.get(Integer.toString(user)));
				System.out.print(". You win.");
			}
			else {
				System.out.print("The computer is ");
				System.out.print(map.get(Integer.toString(comp)));
				System.out.print(". You are ");
				System.out.print(map.get(Integer.toString(user)));
				System.out.print(". I win.");
			}
		}
	}

}
