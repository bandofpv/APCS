package Assignments;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class MainFrame extends JFrame implements KeyListener, MouseListener {
	private MainDraw draw;

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			draw.moveRight();
		else if(e.getKeyCode()== KeyEvent.VK_LEFT)
			draw.moveLeft();
		else if(e.getKeyCode()== KeyEvent.VK_DOWN)
			draw.moveDown();
		else if(e.getKeyCode()== KeyEvent.VK_UP)
			draw.moveUp();

	}
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}

	public MainFrame(){
		this.draw=new MainDraw();
		addKeyListener(this);
		this.addMouseListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setTitle("Square Move Practice");
				frame.setResizable(false);
				frame.setSize(600, 600);
				frame.setMinimumSize(new Dimension(600, 600));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(frame.draw);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		draw.updateGoal(e.getPoint());
		System.out.println("click");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
