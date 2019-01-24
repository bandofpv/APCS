package Ch9;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bool1 = true;
		boolean bool2 = false; 
		char ch1 = 'a';
		char ch2 = 'b';
		int in1 = 1;
		int in2 = 2;
		double doub1 = 1.1;
		double doub2 = 2.2;
		String str1 = "str1";
		String str2 = "str2";
		
		//System.out.println(bool1 + bool2); 
		//The operator + is undefined for the argument type(s) boolean, boolean
		
		//System.out.println(bool1 + ch1); 
		//The operator + is undefined for the argument type(s) boolean, char
		
		//System.out.println(bool1 + in1); 
		//The operator + is undefined for the argument type(s) boolean, int
		
		//System.out.println(bool1 + doub1); 
		//The operator + is undefined for the argument type(s) boolean, double
		
		System.out.println(bool1 + str1);
		//truestr1

		System.out.println(ch1 + ch2);
		//195
		
		System.out.println(ch1 + in1);
		//98
		
		System.out.println(ch1 + doub1);
		//98.1
		
		System.out.println(ch1 + str1);
		//astr1
		
		System.out.println(in1 + in2);
		//3
		
		System.out.println(in1 + doub1);
		//2.1
		
		System.out.println(in1 + str1);
		//1str1
		
		System.out.println(doub1 + doub2);
		//3.3000000000000003
		
		System.out.println(doub1 + str1);
		//1.1str1
		
		System.out.println(str1 + str2);
		//str1str2
		
		char x = 'x';
		
		x++;
		
		//x = x + 1;
		//Doesn't work
		
		System.out.println(x);
		//y
		
		System.out.println("" + bool1);
		//true
		
		System.out.println("" + ch1);
		//a
		
		System.out.println("" + in1);
		//1
		
		System.out.println("" + doub1);
		//1.1
		
		System.out.println("" + str1);
		//str1

	}

}
