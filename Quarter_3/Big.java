
public class Big {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int integer = 2147483647;
	      System.out.println(Math.pow(integer + 1, 10));
	      for (int i = 0; i < 30; i++){
	         System.out.println(i + ": " + factorial(i));
	      }
		
	}
	
	public static int factorial(int number){
	      int result = 1;
	      for (int i = number;i > 0;i--){
	         result = result * i;
	      }
	      return result; 
	   }


}
