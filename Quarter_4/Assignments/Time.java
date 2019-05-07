package Assignments;

public class Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time a = new Time(60);
		Time b = new Time(100);
		
		System.out.println(minutesUntil(a, b));
	}
	
	public int a = 0;
	
	public Time(int x) {
		this.a = x;
	}
	
	public int getTime() {
		return this.a;
	}
	
	public static int minutesUntil(Time t1, Time t2) {
		return t1.getTime()-t2.getTime();
	}

}
