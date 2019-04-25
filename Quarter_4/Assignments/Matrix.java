package Assignments;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double[][] Mat = new double[0][0];
	
	public Matrix(double[] a, int rows,int cols) {
		this.Mat = new double[rows][cols];
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			if (count % rows == 0) count++;
			Mat[i][count] = a[i];
		}
	}
}
