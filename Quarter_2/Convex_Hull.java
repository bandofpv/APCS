import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

//needed for reading coords file
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

class Point 
{ 
    int x, y; 
    Point(int x, int y){ 
        this.x=x; 
        this.y=y; 
    } 
	
// ADD TO POINT CLASS!!!!
} 
  
public class Convex_Hull extends JPanel { 
	
	public static int [] finalxx = new int[10];
	public static int [] finalyy = new int[10];
	
	public static int [] inputxx = new int[10];
	public static int [] inputyy = new int[10];
	
	public static int newnumcoords = 0;
	public static int numcoords = 0;
	
	public static String xs = "";
	public static String ys = "";
      
    // To find orientation of ordered triplet (p, q, r). 
    // The function returns following values 
    // 0 --> p, q and r are colinear 
    // 1 --> Clockwise 
    // 2 --> Counterclockwise 
    public static int orientation(Point p, Point q, Point r) 
    { 
    	
        int val = (q.y - p.y) * (r.x - q.x) - 
                  (q.x - p.x) * (r.y - q.y); 
       
        if (val == 0) return 0;  // collinear 
        return (val > 0)? 1: 2; // clock or counterclock wise 
    } 
      
    // Prints convex hull of a set of n points. 
    public static void convexHull(Point points[], int n) throws FileNotFoundException
    { 
    	
    	int[] x = new int[7];
    	int[] y = new int[7];
       
        // Initialize Result 
        Vector<Point> hull = new Vector<Point>(); 
       
        // Find the rightmost point 
        int l = 0; 
        for (int i = 1; i < n; i++) 
            if (points[i].x > points[l].x) 
                l = i; 
       
        // Start from rightmost point, keep moving  
        // counterclockwise until reach the start point 
        // again. This loop runs O(h) times where h is 
        // number of points in result or output. 
        int p = l, q; 
        do
        { 
            // Add current point to result 
            hull.add(points[p]); 
       
            // Search for a point 'q' such that  
            // orientation(p, x, q) is counterclockwise  
            // for all points 'x'. The idea is to keep  
            // track of last visited most counterclock- 
            // wise point in q. If any point 'i' is more  
            // counterclock-wise than q, then update q. 
            q = (p + 1) % n; 
              
            for (int i = 0; i < n; i++) 
            { 
               // If i is more counterclockwise than  
               // current q, then update q 
               if (orientation(points[p], points[i], points[q]) 
                                                   == 2) 
                   q = i; 
            } 
       
            // Now q is the most counterclockwise with 
            // respect to p. Set p as q for next iteration,  
            // so that q is added to result 'hull' 
            p = q; 
       
        } while (p != l);  // While we don't come to first  
                           // point 

        // Creating a File object that represents the disk file. 
        //NOTE: here is where you have to indicate the full file path to your ret.txt file
        PrintStream o = new PrintStream(new File("/Users/palycs/eclipse-workspace/APCS/Quarter_2/ret.txt")); 
        
        // Store current System.out before assigning a new value 
        PrintStream console = System.out; 
  
        // Assign o to output stream 
        System.setOut(o); 
       
        // Print Result 
        for (Point temp : hull) 
            System.out.println(temp.x + ", " + temp.y); 
        System.setOut(console); 

        
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
    
    public static void main(String[] args) throws FileNotFoundException {
    	
    	//  the following code will attempt to read in x,y coordinate values into
	    //  separate x and y arrays

	    try (
	    	//NOTE: here is where you have to indicate the full file path to your input.txt file
	        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/input.txt")));
	        ) {
	        while(sc.hasNextLine()) {
	            //  this file read pass gets total number of coordinates
	            String[] l2 = sc.nextLine().split(",");
	            if (l2.length > 1) {
	               //  without this check, blank lines will throw an exception
	               newnumcoords++;
	            }
	        }
	    }
	    catch(Exception e) {
	        System.out.println("Problem reading coordinates from input.txt file");
	        //  e.printStackTrace();
	    }
	    
	    System.out.println("input.txt file contains " + newnumcoords + " coordinate sets");
	    
        int [] xx = new int[newnumcoords];  //  allocate array, we know
        int [] yy = new int[newnumcoords];  //  how many coords are in file
	    
	    try (
	    		//NOTE: here is where you have to indicate the full file path to your input.txt file
		        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/input.txt")));
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
	    
		Point points[] = new Point[xx.length]; 
		for (int i = 0; i < xx.length; i++) {
	    	points[i] = new Point(xx[i], yy[i]);
	    }
	    

	    int n = points.length; 
	        
	    convexHull(points, n);
	    
	    System.out.println(xs+ys);
	    
	    
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Simple Window");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(200, 200);

	    //  the following code will attempt to read in x,y coordinate values into
	    //  separate x and y arrays

	    try (
	    	//NOTE: here is where you have to indicate the full file path to your ret.txt file
	        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/ret.txt")));
	        ) {
	        while(sc.hasNextLine()) {
	            //  this file read pass gets total number of coordinates
	            String[] l1 = sc.nextLine().split(",");
	            if (l1.length > 1) {
	               //  without this check, blank lines will throw an exception
	               numcoords++;
	            }
	        }
	    }
	    catch(Exception e) {
	        System.out.println("Problem reading coordinates from ret.txt file");
	        //  e.printStackTrace();
	    }
	    System.out.println("ret.txt file contains " + numcoords + " coordinate sets");
	    
        int [] retxx = new int[numcoords];  //  allocate array, we know
        int [] retyy = new int[numcoords];  //  how many coords are in file
        
	    try (
	    	//NOTE: here is where you have to indicate the full file path to your ret.txt file
	        Scanner sc = new Scanner(new BufferedReader(new FileReader("/Users/palycs/eclipse-workspace/APCS/Quarter_2/ret.txt")));
	        ) {
	        int i = 0;

	        while(sc.hasNextLine()) {
	        //  String line = sc.nextLine();

	            String[] line = sc.nextLine().split(", ");
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
	       System.out.println("Problem reading coordinates from ret.txt file");
	       //  e.printStackTrace();
	    }

	    //  this launches the window display
	    //  TO DO: replace the static lines/text coordinates with your
//	             point cloud and Convex Hull line segment solution
	    
	    Convex_Hull panel = new Convex_Hull();
	 
	    frame.add(panel);
	 
	    frame.setVisible(true);
	    
	    finalxx = retxx; 
		finalyy = retyy;
		
		inputxx = xx;
		inputyy = yy;
		
//		for (int i = 0; i < 4; i++) {
//			System.out.println(getrealx(finalxx[i]));
//			System.out.println(getrealy(finalyy[i]));
//		}
//		
//		System.out.println("");
//		for (int i = 0; i < newnumcoords -1; i++) {
//			System.out.println(getrealx(inputxx[i]));
//			System.out.println(getrealy(inputyy[i]));
//		}
	
	  }
    
  
    public void paintComponent(Graphics g) {
    	 g.setColor(Color.black);
    	 for (int i = 0; i < numcoords -1; i++) {
    		 int a = i+1;
    		 
    		 g.drawLine(getrealx(finalxx[i]), getrealy(finalyy[i]), getrealx(finalxx[a]), getrealy(finalyy[a]));
    	 }
    	 
    	 for (int i = 0; i < newnumcoords -1; i++) {
    		 int a = i+1;
    		 
    		 g.fillOval(getrealx(inputxx[i]) - 4, getrealy(inputyy[i]) - 5, 10, 10);
    	 }
    	 
    	 g.fillOval(getrealx(inputxx[newnumcoords-1]) - 4, getrealy(inputyy[newnumcoords-1]) - 4, 10, 10);
    	 
    	 g.drawString(inputxx[newnumcoords -1] + ", " + inputyy[newnumcoords -1],getrealx(inputxx[newnumcoords -1]),getrealy(inputyy[newnumcoords -1]));
    	 
    	 g.drawLine(getrealx(finalxx[numcoords-1]), getrealy(finalyy[numcoords-1]), getrealx(finalxx[0]), getrealy(finalyy[0]));
    	 
    	 for (int i = 0; i < newnumcoords -1; i++) {
    		 
    		 g.drawString(inputxx[i] + ", " + inputyy[i],getrealx(inputxx[i]),getrealy(inputyy[i]));
    	 }
 
	  }

} 
