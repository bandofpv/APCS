import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.util.Vector;

class Point 
{ 
    int x, y; 
    Point(int x, int y){ 
        this.x=x; 
        this.y=y; 
    } 
	
// ADD TO POINT CLASS!!!!
} 
  
class Hull { 
      
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
    	
        // There must be at least 3 points 
        if (n < 3) return; 
       
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

            //System.out.println(temp.x + " " + temp.y); 
            System.out.println(temp.x);
        
        System.out.println();
        
        // Print Result 
        for (Point temp : hull) 

            //System.out.println(temp.x + " " + temp.y); 
            System.out.println(temp.y);
            
    } 
    
    public static void main(String[] args)  
    { 
  
        Point points[] = new Point[7]; 
        points[0]=new Point(0, 3); 
        points[1]=new Point(2, 3); 
        points[2]=new Point(1, 1); 
        points[3]=new Point(2, 1); 
        points[4]=new Point(3, 0); 
        points[5]=new Point(0, 0); 
        points[6]=new Point(3, 3); 
          
        int n = points.length; 
        convexHull(points, n); 
        
    
        
    }
  
}

public class Convex_Hull extends JApplet{
	
	public void init() {
		
		setSize(800, 800);
		repaint();
	}
	public void paint(Graphics g) {
		drawBackground(g);
		drawPoints(g);
	}
	
	private void drawBackground(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0, (int)(getWidth()), (int)(getHeight()));
		
	}
	public void drawPoints(Graphics g) {
		
		int off = 50;
		int off2 = 300;
		
		g.setColor(Color.BLACK);
		g.fillOval(400 + 0 * off,400 - 3 * off,10,10);
		g.fillOval(400 + 0 * off,400 - 0 * off,10,10);
		g.fillOval(400 + 3 * off,400 - 0 * off,10,10);
		g.fillOval(400 + 3 * off,400 - 3 * off,10,10);
		
		
		
	}
   

} 
