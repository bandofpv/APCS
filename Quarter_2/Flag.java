// Flag starter kit

/*
 * YOUR NAME HERE
 * YOUR PARTNER'S NAME HERE
 * OTHER PARTNER'S NAME (if group of three)
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.* ;
import javax.swing.* ;
import java.awt.geom.* ; //  Classes GeneralPath etc.

import javax.swing.JApplet;

public class Flag extends JApplet {
	private final int STRIPES = 13;

	// SCALE FACTORS (A through L)
	//
	// Note: Constants in Java should always be ALL_CAPS, even
	// if we are using single letters to represent them
    //
    // NOTE 2: Do not delete or change the names of any of the
    // variables given here

	// Set the constants to exactly what is specified in the documentation
	private final double A = 1.0;  // Hoist (width) of flag
	private final double B = 1.9;  // Fly (length) of flag
	private final double C = 0.5385;  // Hoist of Union
	private final double D = 0.76;  // Fly of Union
	private final double E = 0.054;  // See flag specification
	private final double F = 0.054;  // See flag specification
	private final double G = 0.063;  // See flag specification
	private final double H = 0.063;  // See flag specification
	private final double K = 0.0616;  // Diameter of star
	private final double L = 0.0769;  // Width of stripe

    // You will need to set values for these in paint()
	private double flag_width;   // width of flag in pixels
	private double flag_height;  // height of flag in pixels
	private double stripe_height;
	private double field_width;
	private double field_height; 
	private double star_radius;
	
	
    // init() will automatically be called when an applet is run
	public void init() {
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setSize(760, 400);
		repaint();
	}

    // paint() will be called every time a resizing of an applet occurs
	public void paint(Graphics g) {
	   Graphics2D graphics2D = (Graphics2D) g;
       graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (getHeight() * B > getWidth()) {
			flag_width = getWidth();
			flag_height = flag_width / B;
		}
		else {
			flag_height = getHeight();
			flag_width = flag_height * B;
			
		}
		
		stripe_height = L * flag_height;
		field_width = D * flag_height;
		field_height = C * flag_height; 
		
		

		drawBackground(g);
		drawStripes(g);
		drawField(g);
		drawStars(g);
		
		
	}

	private void drawBackground(Graphics g) {
		
		g.setColor(Color.decode("0xFFFFFF"));
		g.fillRect(0,0, (int)(flag_width), (int)(flag_height));
		
		g.setColor(Color.decode("0xEEEEEE"));
		g.fillRect(0,0, (int)(getWidth()), (int)(getHeight()));

	}
	
	public void drawStripes(Graphics g) {
		for(int i = 0; i < STRIPES; i++) {
			for(int s = 0; s <= STRIPES; s += 2) {
				g.setColor(Color.decode("0xE0162B"));
				g.fillRect(0, (int)(stripe_height * s), (int)(flag_width),(int)(stripe_height));
			}
			for(int s = 1; s < STRIPES; s += 2) {
				g.setColor(Color.WHITE);
				g.fillRect(0, (int)(stripe_height * s), (int)(flag_width),(int)(stripe_height));
			}
		}
	}

	public void drawField(Graphics g) {
		g.setColor(Color.decode("0x0052A5"));
		g.fillRect(0, 0, (int)(field_width), (int)(field_height));
	}

	public void drawStars(Graphics g) {
		
	}
	public void drawStar(Graphics g, int x, int y) {
		g.setColor(Color.WHITE);
		
		double[] starX = {0, 0.197, 0.81, 0.314, 0.51, 0, -0.51, -0.314, -0.81, -0.197};
		double[] starY = {-0.85, -0.26, -0.26, 0.093, 0.68, 0.3168, 0.68, 0.093, -0.26, -0.26};
		
		int[] scaleStarX = new int[starX.length];
		for (int i = 0; i < starX.length; i++) {
			scaleStarX[i] = (int)(x + starX[i] * (0.5 /0.85) * K * flag_height);
		}
		
		int[] scaleStarY = new int[starX\Y.length];
		for (int i = 0; i < starY.length; i++) {
			scaleStarY[i] = (int)(y + starY[i] * (0.5 /0.85) * K * flag_height);
		}
		
		g.fillPolygon(scaledStarX, scaledStarY, scaledStarY.length);
	}
} 
