import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

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
	
	private final int X_GRID_OFFSET = 25; // 25 pixels from left
	private final int Y_GRID_OFFSET = 40; // 40 pixels from top
	private final int CELL_WIDTH = 5;
	private final int CELL_HEIGHT = 5;
	
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
    public static void convexHull(Point points[], int n) 
    { 
    	
    	int[] x = new int[7];
    	int[] y = new int[7];
       
        // Initialize Result 
        Vector<Point> hull = new Vector<Point>(); 
       
        // Find the leftmost point 
        int l = 0; 
        for (int i = 1; i < n; i++) 
            if (points[i].x < points[l].x) 
                l = i; 
       
        // Start from leftmost point, keep moving  
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

        
        // Print Result 
        for (Point temp : hull) 

        	xs += Integer.toString(temp.x);
        
        // Print Result 
        for (Point temp : hull) 
        	ys += Integer.toString(temp.y);
        
    }
    
    public static void main(String[] args) {
		Point points[] = new Point[9]; 
	    points[0]=new Point(5, 5); 
	    points[1]=new Point(10, -10); 
	    points[2]=new Point(-5, -5); 
	    points[3]=new Point(10, 10); 
	    points[4]=new Point(7, -7); 
	    points[5]=new Point(-10, 10); 
	    points[6]=new Point(-3, 3); 
	    points[7]=new Point(-10, -10);
	    points[8]=new Point(10, -10);
	    

	    
	    int n = points.length; 
	        
	    convexHull(points, n);
	    
	    System.out.println(xs+ys);
	    
	    
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Simple Window");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(800, 700);
	 
	    Convex_Hull panel = new Convex_Hull();
	 
	    frame.add(panel);
	 
	    frame.setVisible(true);
	  }
    
    public double
  
    public void paintComponent(Graphics g) {
	 
	     //  box side lines
	     g.setColor(Color.black);
	     g.drawLine((xs.charAt(0) - X_GRID_OFFSET - 1) / (CELL_WIDTH + 1),ys.charAt(0) + 120, xs.charAt(1) + 120, ys.charAt(1) + 20);
	     g.drawLine(xs.charAt(1) + 120,ys.charAt(1) + 20, xs.charAt(2) + 20, ys.charAt(2) + 20);
	     g.drawLine(xs.charAt(2) + 20,ys.charAt(2) + 20, xs.charAt(3) + 20, ys.charAt(3) + 120);
	     g.drawLine(xs.charAt(3) + 20,ys.charAt(3) + 120, xs.charAt(0) + 120, ys.charAt(0) + 120);
	     
	     int x = (arg4.getX() - X_GRID_OFFSET - 1) / (CELL_WIDTH + 1);
			int y = (arg4.getY() - Y_GRID_OFFSET - 4) / (CELL_HEIGHT + 1);
	
	     //  text identifiers
	     g.drawString("10,-10",120,120);
	     g.drawString("10,10", 120, 20);
	     g.drawString("-10,10", 20, 20);
	     g.drawString("-10,10", 20,120);
	  }
	

} 
