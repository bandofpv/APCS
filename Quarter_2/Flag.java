// Flag starter kit

/*
 * YOUR NAME HERE
 * YOUR PARTNER'S NAME HERE
 * OTHER PARTNER'S NAME (if group of three)
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	private double stripe_height = L * 400; // height of an individual stripe in pixels
	private double field_width = D * 400;
	private double field_height = C * 400; 
	
	

    // init() will automatically be called when an applet is run
	public void init() {
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setSize(760, 400);
		repaint();
	}

    // paint() will be called every time a resizing of an applet occurs
	public void paint(Graphics g) {
		if (getHeight() * B > getWidth()) {
			flag_width = getWidth();
			flag_height = flag_width / B;
		}
		else {
			flag_height = getHeight();
			flag_width = flag_height * B;
			
		}
		
		drawBackground(g);
		//drawStripes(g);
		//drawField(g);
		
	}

	private void drawBackground(Graphics g) {
		
		g.setColor(Color.decode("0xFFFFFF"));
		g.fillRect(0,0, (int)(flag_width), (int)(flag_height));
	}
	
	public void drawStripes(Graphics g) {
		for(int i = 0; i < STRIPES; i++) {
			for(int s = 0; s <= STRIPES; s += 2) {
				g.setColor(Color.decode("0xE0162B"));
				g.fillRect(0, (int)(stripe_height * s), 760,(int)(stripe_height));
			}
		}
	}

	public void drawField(Graphics g) {
		g.setColor(Color.decode("0x0052A5"));
		g.fillRect(0, 0, (int)(field_width), (int)(field_height));
	}

	public void drawStars(Graphics g) {
	}
}
 