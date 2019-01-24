package Ch9;
import java.util.Arrays;

public class letterHist {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.toString(convertHist("qwertyuiopasdfghjklzxcvbnmmmmafadfadfasfafdas")));
	}
	
	/**
	 * 
	 * @param a The String you want to convert to histogram
	 * @return Array with number of each letter
	 */
	public static int[] convertHist(String a) {
		int[] array = new int[26];
		a = a.toLowerCase();
		for (char letter: a.toCharArray()) {
	          if (letter >= 'a' && letter <= 'z') {
	             array[letter- 'a'] += 1;
	          }  
		}
		
		return array;
	          
	}
		

}
