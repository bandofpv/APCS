package Assignments;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class MainDraw extends JComponent {

    public int x = 50;
    public int y = 50;
    public int xv = 0;
    public int yv = 0;
    public int time = 0;
    public int xa = 0;
    public int ya = 0;

    public int xgoal = 100;
    public int ygoal = 100;
	private int maxa = 4;
	private int oldXerror = 0;
	private int oldYerror = 0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.BLACK);


        updateAcc();

        //updateGoal();


        pause();

        repaint();

        xv += xa;
        yv += ya;

        x += xv;
        y += yv;

        time++;
    }

    public void updateGoal(Point point) {
		xgoal = point.x;
		ygoal = point.y;

	}

	private void updateAcc() {
    	int xerror = xgoal - x;
    	int yerror = ygoal - y;

    	int dxerror = xerror - oldXerror;
    	int dyerror = yerror - oldYerror;

		xa = xerror + dxerror;
		ya = yerror + dyerror;


		if(xa < -maxa) xa = -maxa;
		if(xa > maxa) xa = maxa;
		if(ya < -maxa) ya = -maxa;
		if(ya > maxa) ya = maxa;

		oldXerror = xerror;
		oldYerror = yerror;
	}

	private void pause() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

	}

	public void moveRight() {
        xv++;

    }

    public void moveLeft() {
        xv--;

    }

    public void moveDown() {
        yv++;

    }

    public void moveUp() {
        yv--;

    }
}
