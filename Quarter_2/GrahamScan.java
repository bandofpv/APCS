import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

import javax.swing.*;

public class GrahamScan extends JPanel{
	
	public static int [] finalxx = new int[10];
	public static int [] finalyy = new int[10];
	
	public static Object [] pointsxx = new Object[20];
	public static Object [] pointsyy = new Object[20];
	
	public static int[] allPointsxx = new int[10];
	public static int[] allPointsyy = new int[10];
	
	public static int numcoords = 0;
	public static int newnumcoords = 0;
	
	public static String xs = "";
	public static String ys = "";
	
    static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x, y;
        
        //formula from geometry course
        static int ccw(Point a, Point b, Point c) {
            int area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);  
            if(area < 0) return -1;
            if(area > 0) return 1;  //counter clockwise
            else return 0;
        }
        
        public final Comparator<Point> POLAR_ORDER = new PolarOrder();
        
        private class PolarOrder implements Comparator<Point> {
            public int compare(Point q1, Point q2) {
                int dx1 = q1.x - x;
                int dy1 = q1.y - y;
                int dx2 = q2.x - x;
                int dy2 = q2.y - y;

                if      (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
                else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
                else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
                    if      (dx1 >= 0 && dx2 < 0) return -1;
                    else if (dx2 >= 0 && dx1 < 0) return +1;
                    else                          return  0;
                }
                else return -ccw(Point.this, q1, q2);     // both above or below

            }
        }
        
        @Override
        public String toString() {
            return x + "," + y ;
        }
        
    }
    
    public static int getrealx(int xcoord) {
    	if (xcoord < 0) {
    		return -(Math.abs(xcoord) * 4) + 100;
    	}
    	else if (xcoord > 0) {
    		return (Math.abs(xcoord) * 4) + 100;
    	}
    	return 100;
    }
    
    public static int getrealy(int ycoord) {
    	if (ycoord < 0) {
    		return (Math.abs(ycoord) * 4) + 100;
    	}
    	else if (ycoord > 0) {
    		return -(Math.abs(ycoord) * 4) + 100;
    	}
    	return 100;
    }
    
    public static List<Point> points = new ArrayList<>();
    
    //  this launches the window display
    //  TO DO: replace the static lines/text coordinates with your
//             point cloud and Convex Hull line segment solution
    public static void main(String[] args) throws FileNotFoundException {
    	
	    try (
	    	//NOTE: here is where you have to indicate the full file path to your input.txt file
	        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/points.txt")));
	        ) {
	        while(sc.hasNextLine()) {
	            //  this file read pass gets total number of coordinates
	            String[] l2 = sc.nextLine().split(",");
	            if (l2.length > 1) {
	               //  without this check, blank lines will throw an exception
	               numcoords++;
	            }
	        }
	    }
	    catch(Exception e) {
	        System.out.println("Problem reading coordinates from points.txt file");
	        //  e.printStackTrace();
	    }
	    
	    System.out.println("input.txt file contains " + numcoords + " coordinate sets");
	    
        int [] xx = new int[numcoords];  //  allocate array, we know
        int [] yy = new int[numcoords];  //  how many coords are in file
	    
	    try (
	    		//NOTE: here is where you have to indicate the full file path to your input.txt file
		        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/points.txt")));
		        ) {
		        int i = 0;

		        while(sc.hasNextLine()) {
		        //  String line = sc.nextLine();

		            String[] line = sc.nextLine().split(",");
		            if (line.length > 1) {
		               //  without this check, blank lines will throw an exception
		               xx[i] = Integer.parseInt(line[0].trim());
		               yy[i] = Integer.parseInt(line[1].trim());
		               i++;
		            }
		        }
		        
		       System.out.println("x: " + Arrays.toString(xx));
		       System.out.println("y: " + Arrays.toString(yy));

		    }
		    catch(Exception e) {
		       System.out.println("Problem reading coordinates from input.txt file");
		       //  e.printStackTrace();
		    }
	    
		for (int i = 0; i < xx.length; i++) {
			points.add(new Point(xx[i], yy[i]));
	    }
		
		for (int i = 0; i < xx.length; i++) {
			allPointsxx[i] = xx[i];
			allPointsyy[i] = yy[i];
	    }

        Collections.sort(points, (p1, p2) -> (int)(p1.y - p2.y));
        Collections.sort(points, points.get(0).POLAR_ORDER);
        
        Deque<Point> hull = new ArrayDeque<>();
        hull.push(points.get(0));
        hull.push(points.get(1));
        for(int i = 2; i < points.size(); i++) {
            Point top = hull.pop();
            Point c = points.get(i);
            while(Point.ccw(hull.peek(), top, c) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(c);
        }
        
        pointsxx = hull.toArray();
	    pointsyy = hull.toArray();
	    
	    // Creating a File object that represents the disk file. 
        //NOTE: here is where you have to indicate the full file path to your ret.txt file
        PrintStream o = new PrintStream(new File("/Users/palycs/eclipse-workspace/APCS/Quarter_2/retpoints.txt")); 
        
        // Store current System.out before assigning a new value 
        PrintStream console = System.out; 
  
        // Assign o to output stream 
        System.setOut(o); 
       
        // Print Result 
        for (int i = 0; i < pointsxx.length; i++) 
            System.out.println(pointsxx[i]); 
        System.setOut(console);  
        
    //  the following code will attempt to read in x,y coordinate values into
	    //  separate x and y arrays

	    try (
	    	//NOTE: here is where you have to indicate the full file path to your ret.txt file
	        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/retpoints.txt")));
	        ) {
	        while(sc.hasNextLine()) {
	            //  this file read pass gets total number of coordinates
	            String[] l1 = sc.nextLine().split(",");
	            if (l1.length > 1) {
	               //  without this check, blank lines will throw an exception
	               newnumcoords++;
	            }
	        }
	    }
	    catch(Exception e) {
	        System.out.println("Problem reading coordinates from retpoints.txt file");
	        //  e.printStackTrace();
	    }
	    System.out.println("retpoints.txt file contains " + newnumcoords + " coordinate sets");
	    
        int [] retxx = new int[newnumcoords];  //  allocate array, we know
        int [] retyy = new int[newnumcoords];  //  how many coords are in file
        
	    try (
	    	//NOTE: here is where you have to indicate the full file path to your ret.txt file
	        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/retpoints.txt")));
	        ) {
	        int i = 0;

	        while(sc.hasNextLine()) {
	        //  String line = sc.nextLine();

	            String[] line = sc.nextLine().split(",");
	            if (line.length > 1) {
	               //  without this check, blank lines will throw an exception
	               retxx[i] = Integer.parseInt(line[0].trim());
	               retyy[i] = Integer.parseInt(line[1].trim());
	               i++;
	            }
	        }
	     
	       System.out.println("x: " + Arrays.toString(retxx));
	       System.out.println("y: " + Arrays.toString(retyy));

	    }
	    catch(Exception e) {
	       System.out.println("Problem reading coordinates from retpoints.txt file");
	       //  e.printStackTrace();
	    }
	    
	    finalxx = retxx;
		finalyy = retyy;
	    
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Simple Window");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(200, 200);
	    
	    GrahamScan panel = new GrahamScan();
 
	    frame.add(panel);
 
	    frame.setVisible(true);

    }


    public void paintComponent(Graphics g) {
   	 g.setColor(Color.black);
   	 for (int i = 0; i < finalxx.length -1; i++) {
   		 int a = i+1;
   		 
   		 g.drawLine(getrealx(finalxx[i]), getrealy(finalyy[i]), getrealx(finalxx[a]), getrealy(finalyy[a]));
   	 }
   	 
    	 for (int i = 0; i < allPointsxx.length-1; i++) {
   		 int a = i+1;
   		 
   		 g.fillOval(getrealx(allPointsxx[i]) - 5, getrealy(allPointsyy[i]) - 5, 10, 10);
   	 }
   	 
    	 g.fillOval(getrealx(allPointsxx[allPointsxx.length-1]) - 5, getrealy(allPointsyy[allPointsyy.length-1]) - 5, 10, 10);
   	 
   	     g.drawString(allPointsxx[allPointsxx.length -1] + ", " + allPointsyy[allPointsyy.length -1],getrealx(allPointsxx[allPointsxx.length -1]),getrealy(allPointsyy[allPointsyy.length -1]));
   	 
   	     g.drawLine(getrealx(finalxx[finalxx.length -1]), getrealy(finalyy[finalyy.length -1]), getrealx(finalxx[0]), getrealy(finalyy[0]));
   	 
   	     for (int i = 0; i < allPointsxx.length -1; i++) {
   		 
   	    	 g.drawString(allPointsxx[i] + ", " + allPointsyy[i],getrealx(allPointsxx[i]),getrealy(allPointsyy[i]));
   	     }

	  }

}
