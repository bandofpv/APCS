
public class TotalArea {
	/** Main method */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare circleArray
		CircleWithPrivateDataFields[] circleArray;
		
		// CreatecircleArray
		circleArray = createCricleArray();
		
		// Print circleArray and total areas of the circles
		printCircleArray(circleArray);
	}
	
	/** Create an array of Circle objects */
	public static CircleWithPrivateDataFields[] createCircleArray() {
		CircleWithPrivateDataFields[] circleArray = new CircleWithPrivateDataFields[5];
		
		for (int i = 0; i < circleArray.length; i++) {
			circleArray[i] = new CircleWithPrivateDataFields(Math.random() * 100);
		}
		
		// Return Circle array
		return circleArray;
	}

}
