package Assignments;

public class Flight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time a = new Time(20);
		Time b = new Time(50);
		
		Flight x = new Flight(a,b);
		
		System.out.println(x.getDepartureTime().getTime());
		System.out.println(x.getArrivalTime().getTime());
	}
	
	public Time departureTime;
	public Time arrivalTime;
	
	public Flight(Time newdepartureTime, Time newarrivalTime) {
		this.departureTime = newdepartureTime;
		this.arrivalTime = newarrivalTime;
	}
	
	public Time getDepartureTime() {
		return this.departureTime;
	}
	
	public Time getArrivalTime() {
		return this.arrivalTime;
	}
}
