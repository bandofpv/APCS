import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComponent;

// Note that the JComponent is set up to listen for mouse clicks
// and mouse movement.  To achieve this, the MouseListener and
// MousMotionListener interfaces are implemented and there is additional
// code in init() to attach those interfaces to the JComponent.


public class Display extends JComponent implements MouseListener, MouseMotionListener {
	// Variables for cells and offsets
	public static final int ROWS = 80;
	public static final int COLS = 100;
	public static Cell[][] cell = new Cell[ROWS][COLS];
	private final int X_GRID_OFFSET = 25; // 25 pixels from left
	private final int Y_GRID_OFFSET = 40; // 40 pixels from top
	private final int CELL_WIDTH = 5;
	private final int CELL_HEIGHT = 5;

	// Note that a final field can be initialized in constructor
	// Variable for display and buttons
	private final int DISPLAY_WIDTH;   
	private final int DISPLAY_HEIGHT;
	private StartButton startStop;
	private StepButton Step;
	private WrapButton Wrap;
	private ClearButton Clear;
	private QuitButton Quit;
	private PresetButton Preset;
	private boolean paintloop = false;
	private boolean stepOne = false;
	private boolean wrap = true;

	//Sets the Display to proper height and width
	public Display(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}

	//This will always run
	public void init() {
		//sets size of the display
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		initCells();
		
		//added mouse listener to get mouse inputs
		addMouseListener(this);
		addMouseMotionListener(this);

		// Example of setting up a button.
		// See the StartButton class nested below.
		startStop = new StartButton();
		startStop.setBounds(100, 550, 100, 36);
		add(startStop);
		startStop.setVisible(true);
		repaint();
		
		//Create Step Button
		Step = new StepButton();
		Step.setBounds(200, 550, 100, 36);
		add(Step);
		Step.setVisible(true);
		repaint();
		
		//Create Wrap Button
		Wrap = new WrapButton();
		Wrap.setBounds(300, 550, 100, 36);
		add(Wrap);
		Wrap.setVisible(true);
		repaint();
		
		//Create Preset Button
		Preset = new PresetButton();
		Preset.setBounds(400, 550, 100, 36);
		add(Preset);
		Preset.setVisible(true);
		repaint();
		
		//Create Clear Button
		Clear = new ClearButton();
		Clear.setBounds(500, 550, 100, 36);
		add(Clear);
		Clear.setVisible(true);
		repaint();
		
		//Create Quit Button
		Quit = new QuitButton();
		Quit.setBounds(600, 550, 100, 36);
		add(Quit);
		Quit.setVisible(true);
		repaint();
	}


	public void paintComponent(Graphics g) {
		final int TIME_BETWEEN_REPLOTS = 100; // change to your liking
		
		//Draw the grid, cells, and buttons
		g.setColor(Color.BLACK);
		drawGrid(g);
		drawCells(g);
		drawButtons();

		//This will run nextGeneration();
		if (paintloop) {
			try {
				Thread.sleep(TIME_BETWEEN_REPLOTS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nextGeneration();
			repaint();
			
			//If stepOne is true ==> it toggle paint loop once to step
			//AND set the variable back to false preventing it from keep toogling paint loop
			if(stepOne) {
				togglePaintLoop();
				stepOne = false;
			}
		}
	}
	
	//This will clear all the cells from grid
	public void clearAll() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cell[row][col].setAlive(false);
			}
		}
	}
	
	//Initialize Cells
	public void initCells() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cell[row][col] = new Cell(row, col);
			}
		}
		
		//Create default cells
		cell[36][24].setAlive(true); 
		cell[36][25].setAlive(true); 
		cell[36][26].setAlive(true); 
		cell[34][25].setAlive(true);
		cell[35][26].setAlive(true);
	}

	//Toggle the Paint Loop
	public void togglePaintLoop() {
		paintloop = !paintloop;
	}
	
	//This will draw the grid with proper size
	void drawGrid(Graphics g) {
		for (int row = 0; row <= ROWS; row++) {
			g.drawLine(X_GRID_OFFSET,
					Y_GRID_OFFSET + (row * (CELL_HEIGHT + 1)), X_GRID_OFFSET
					+ COLS * (CELL_WIDTH + 1), Y_GRID_OFFSET
					+ (row * (CELL_HEIGHT + 1)));
		}
		for (int col = 0; col <= COLS; col++) {
			g.drawLine(X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET,
					X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET
					+ ROWS * (CELL_HEIGHT + 1));
		}
	}

	//This will draw the cells 
	void drawCells(Graphics g) {
		// Have each cell draw itself
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				// The cell cannot know for certain the offsets nor the height
				// and width; it has been set up to know its own position, so
				// that need not be passed as an argument to the draw method
				cell[row][col].draw(X_GRID_OFFSET, Y_GRID_OFFSET, CELL_WIDTH,
						CELL_HEIGHT, g);
			}
		}
	}

	//This will draw all the Buttons
	private void drawButtons() {
		startStop.repaint();
		Step.repaint();
		Clear.repaint();
		Quit.repaint();
		Preset.repaint();
		Wrap.repaint();
	}

	//This is where all the magic happens!!! Makes Conway's game of Life work...
	private void nextGeneration() {
		 for (int row = 0; row < ROWS; row++) {
	            for (int col = 0; col < COLS; col++) {
	                Cell a = cell[row][col];
	                //If wrap is true it will use calcNeighboors
	                //If wrap is false it will use calcNeighboorsNoWrap
	                //The wrap variable changes in the Wrap Button
	                if (wrap) {
	                	a.calcNeighbors(cell);
	                } else {
	                	a.calcNeighborsNoWrap(cell);
	                }
	                int aliveNeighbors = a.getNeighbors();
	                if (a.getAlive()) {
	                    a.setAliveNextTurn(aliveNeighbors > 1 && aliveNeighbors < 4);
	                } else {
	                    a.setAliveNextTurn(aliveNeighbors == 3);
	                }
	            }
	        }
	        for (int row = 0; row < ROWS; row++) {
	            for (int col = 0; col < COLS; col++) {
	                Cell a = cell[row][col];
	                a.setAlive(a.getAliveNextTurn());
	            }
	        }

	}

	//When mouse is clicked ==> it will draw a cell where clicked with offsets
	public void mouseClicked(MouseEvent arg4) {
		int x = (arg4.getX() - X_GRID_OFFSET - 1) / (CELL_WIDTH + 1);
		int y = (arg4.getY() - Y_GRID_OFFSET - 4) / (CELL_HEIGHT + 1);
		//Exception to prevent spam of errors if mouse is off the grid
		try {
			Cell drawNewCell = cell[y][x];
			drawNewCell.setAlive(!drawNewCell.getAlive());
			repaint();
		}
		catch (Exception e){
			
		}
	}
	
	//When mouse is pressed down and dragged ==> it will draw cells where the mouse is being dragged with proper offsets
	public void mouseDragged(MouseEvent arg5) {
		int x = (arg5.getX() - X_GRID_OFFSET - 1) / (CELL_WIDTH + 1);
		int y = (arg5.getY() - Y_GRID_OFFSET - 4) / (CELL_HEIGHT + 1);
		//Exception to prevent spam of errors if mouse is off the grid
		try {
			Cell drawNewCell = cell[y][x];
			drawNewCell.setAlive(!drawNewCell.getAlive(), Color.RED);
			repaint();
		}
		catch (Exception e){
			
		}
	}

	//Start Button code
	private class StartButton extends JButton implements ActionListener {
		StartButton() {
			super("Start");
			addActionListener(this);
		}
		
		//When the button is pressed ==> toggle the paint loop to start code & change name to "Stop". 
		//If pressed again ==> toggle the paint loop again to stop code & change the name to "Start".
		public void actionPerformed(ActionEvent arg0) {
			
			// nextGeneration(); // test the start button
			if (this.getText().equals("Start")) {
				
				togglePaintLoop();
				setText("Stop");
				
			} else {
				
				togglePaintLoop();
				setText("Start");
			
			}
			repaint();
			
		}
	}
	
	//Step Button code
	private class StepButton extends JButton implements ActionListener {
		StepButton() {
			super("Step");
			addActionListener(this);
		}
		
		//If clicked ==> toggle the paint loop and set stepOne to true which will move the cells by one
		public void actionPerformed(ActionEvent arg1) {
			togglePaintLoop();
			stepOne = true;
			repaint();
		}
	}
	
	//Wrap Button code
	private class WrapButton extends JButton implements ActionListener {
		WrapButton() {
			super("No Wrap");
			addActionListener(this);
		}

		//If pressed ==> set wrap to false which will run the calcNeighborsNoWrap making the cells not wrap
		//Also, it will change the name of button to "Wrap"
		public void actionPerformed(ActionEvent arg7) {
			if (this.getText().equals("No Wrap")) {
				wrap = false;
				
				
				setText("Wrap");
			}
			//If pressed ==> set wrap to true which will run the calcNeighbors making the cells wrap again
			//Also, it will change the name of button to "No Wrap"
			else {
				wrap = true;
				
				
				setText("No Wrap");
			}
		}
	}
	
	//Preset Button code
	private class PresetButton extends JButton implements ActionListener {
		PresetButton() {
			super("Still");
			addActionListener(this);
		}
		
		//If pressed...
		public void actionPerformed(ActionEvent arg6) {
			
			//If pressed when button says "Still" ==> clear all cells and create new cells that won't be able to move
			//AND change name to "Stuff"
			if (this.getText().equals("Still")) {
				
				clearAll();
				
				cell[36][24].setAlive(true); 
				cell[36][25].setAlive(true); 
				cell[37][24].setAlive(true); 
				cell[37][25].setAlive(true);
				
				cell[41][24].setAlive(true); 
				cell[41][25].setAlive(true); 
				cell[42][24].setAlive(true); 
				cell[42][25].setAlive(true);
				
				cell[40][30].setAlive(true); 
				cell[41][29].setAlive(true); 
				cell[41][31].setAlive(true); 
				cell[42][29].setAlive(true);
				cell[42][31].setAlive(true); 
				cell[43][30].setAlive(true); 
				
				cell[35][30].setAlive(true); 
				cell[36][29].setAlive(true); 
				cell[36][31].setAlive(true); 
				cell[37][29].setAlive(true);
				cell[37][31].setAlive(true); 
				cell[38][30].setAlive(true); 
				
				setText("Stuff");
				togglePaintLoop();
				repaint();
			}
			
			//If pressed when button says "Stuff" ==> clear all cells and create cells that will move
			//AND change name of button to "Random"
			else if (this.getText().equals("Stuff")) {
				
				clearAll();
				
				cell[35][30].setAlive(true); 
				cell[35][31].setAlive(true); 
				cell[33][31].setAlive(true); 
				cell[34][33].setAlive(true); 
				cell[35][34].setAlive(true); 
				cell[35][35].setAlive(true); 
				cell[35][36].setAlive(true); 
				
				setText("Random");
				togglePaintLoop();
				repaint();
			}
			
			//If pressed when button says "Random" ==> clear all cells and create 3,000 new random cells 
			//AND change name of Button to "Insane"
			else if (this.getText().equals("Random")) {
				
				clearAll();
				
				Random rand = new Random(); 
				
				for (int i = 0; i <= 3000; i++) {
					cell[rand.nextInt(80)][rand.nextInt(100)].setAlive(true);
				}
				
				setText("Insane");
				togglePaintLoop();
				repaint();
			}
			
			//If pressed when button says "Insane" ==> clear all cells and create a straight line of cells going across the  
			//grid to to some thing COOL!!! AND change name of button to "Default"
			else if (this.getText().equals("Insane")) {
				
				clearAll();
				
				try {
					for (int x = 0; x <= 100; x++) {
						cell[36][x].setAlive(true);
					}
					repaint();
				}
				catch (Exception e){
					
				}
				
				setText("Default");
				togglePaintLoop();
				repaint();
			}
			
			//If pressed when button says "Default" ==> clear all cells and create the default cells 
			//AND change name of button to "Still"
			else if (this.getText().equals("Default")) {
				
				clearAll();
								
				cell[36][24].setAlive(true); 
				cell[36][25].setAlive(true); 
				cell[36][26].setAlive(true); 
				cell[34][25].setAlive(true);
				cell[35][26].setAlive(true);
				
				setText("Still");
				togglePaintLoop();
				repaint();
			}
			repaint();
			
		}
	}
	
	//Clear Button code
	private class ClearButton extends JButton implements ActionListener {
		ClearButton() {
			super("Clear");
			addActionListener(this);
		}
		
		//If pressed ==> clear all cells from grid
		public void actionPerformed(ActionEvent arg2) {
			
			// nextGeneration(); // test the start button
			if (this.getText().equals("Clear")) {
				
				clearAll();
				
				togglePaintLoop();
				setText("Clear");
				
			}
			repaint();
			
		}
	}
	
	//Quit Button code
	private class QuitButton extends JButton implements ActionListener {
		QuitButton() {
			super("Quit");
			addActionListener(this);
		}

		//If pressed ==> Quit the application
		public void actionPerformed(ActionEvent arg3) {
			
			// nextGeneration(); // test the start button
			if (this.getText().equals("Quit")) {
				
				System.exit(0);
				
				togglePaintLoop();
				setText("Quit");
				
			}
			repaint();
			
		}
	}

	//Added Required but unused mouse methods here!!!

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
