package Assignments;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = new double[4];
		a[0] = 1;
		a[1] = 1;
		a[2] = 1;
		a[3] = 1;
		Matrix b = new Matrix(a, 2,2);
		
		System.out.println(b.get(1,1));
	}
	
	public double[][] Mat = new double[0][0];
	public int row;
	public int col;
	public int nums;
	
	public Matrix(double[] a, int rows,int cols) {
		this.row = rows;
		this.col = cols;
		this.nums = a.length;
		this.Mat = new double[rows][cols];
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			if (count % rows == 0) count++;
			Mat[i][count] = a[i];
		}
	}
	
	public double get(int row, int col) {
		return this.Mat[col][row];
	}
	
	public double[] mvmult(Matrix m) {
		int count = 0; 
		double [] ret = new double[this.row * this.col];
		for(int i = 0; i < this.nums; i++) {
			if(count % this.row == 0) count++;
			ret[i] += Mat[i][count] + m.get(i, count);
		}
		return ret;
	}
	
}
