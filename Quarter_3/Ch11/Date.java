package Ch11;

public class Date{

	public static void main(String args[]){

		Date birthday = new Date(7, 13, 2003);

		System.out.println(birthday.year+" "+birthday.month+" "+birthday.day);

	}

	public int year;

	public int month;

	public int day;

	public Date(int year, int month, int day){

		this.year = year;

		this.month = month;

		this.day = day;

	}
	public Date(){

		this(0, 0, 0);

	}

}