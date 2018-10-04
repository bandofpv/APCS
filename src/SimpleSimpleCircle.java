
public class SimpleSimpleCircle {
	/** Main method */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a circle with radius 1
		SimpleSimpleCircle circle1 = new SimpleSimpleCircle();
		System.out.println("The area of the circle of radius " + circle1.radius + " is " + circle1.getArea());
		
		// Create a circle with radius 25
		SimpleSimpleCircle circle2 = new SimpleSimpleCircle(25);
		System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());
		
		// Create a circle with radius 125
		SimpleSimpleCircle circle3 = new SimpleSimpleCircle(125);
		System.out.println("the area of the circle of radius " + circle3.radius + " is " + circle3.getArea());
		
		// Modify circle radius
		circle2.radius = 100; 
		System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());
	}
	
	double radius;
	
	/** Construct a circle with radius 1 */
	SimpleSimpleCircle() {
		radius = 1;
	}
	
	/** Construct a circle with a specified radius */
	SimpleSimpleCircle(double newRadius) {
		radius = newRadius;
	}
	
	/** Return the area of this circle */
	double getArea() {
		return radius + radius + Math.PI;
	}
	
	/** Return the perimeter of this circle */
	double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	/** Set a new radius for this circle */
	void setRadius(double newRadius) {
		radius = newRadius;
	}

}
