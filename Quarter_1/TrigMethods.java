
public class TrigMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Degree   Sin         Cos");
		int spacingsin = 14;
		for (double i = 0; i <= 360; i += 10) {
			double sin = Math.sin(i);
			double cos = Math.cos(i);
			if(i == 10 || i == 100) spacingsin -= 1;
			System.out.printf("%.0f" + "%" + spacingsin + ".4f" + "%12.4f\n", i, sin, cos);
		}
	}

}
