package Assignments;

import java.util.Arrays;

public class randGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.toString(shuffle(4)));

	}

	public static int[] shuffle(int ln) {
		int[] ret = new int[ln];

		for(int i = 0; i < ln; i++) {
			ret[i] = i;
		}
		
		for(int i = 0; i < ret.length; i++) {
			int rand = (int)(Math.random() * ret.length); 	
			int rand1 = (int)(Math.random() * ret.length); 
			swap(ret, rand, rand1);
		}
		
		return ret;
	}

	public static void swap(int[] a, int i, int b) {
		int c = a[i];
		a[i] = a[b];
		a[b] = c;

	}

	public int[] randP(int nn) {
		int[] ret = new int[2];

		return ret;
	}

}
