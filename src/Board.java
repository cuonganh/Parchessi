import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Board extends JPanel {
  
  //Board Constructor Constructs a custom board for numPlayers to play
  public Board() {
    
  }
  
  
  //Function to pre-load the points for all pieces to aid in debugging traversal issues
  public static void debugLoadPoints() {
    
  }

  
  	/*
	 * Check For Winner! Return -1 for no winner, else return player index.
	 * Should only ever return -1,0,1,2,3. Nothing else.
	 */
	public static int checkWin() {
	
		return -1;
  }
  
  
  	/*
	 * MovePlayer moves and sets the players Token locations on the board tv =
	 * turnValue Moves Player based on tv index.
	 */
	public static void movePlayer(int tv, int r) {
    
  }
  
  
	 //Returns List of Points, for the Game Logic Array.
	public ArrayList<Point> getPoints() {
		
  }
  
  
	 //Returns Point List Length
	public int getPointLength() {
    
  }
  
  
	 //Prints out point list for debugging purposes
	public void printPoints() {
    
  }
  
  
	//Returns Block Size for Board
	public int getBlockSize() {
    
  }
  
  
  	//Handles Painting the Players info and Tokens
	public void paintPlayerOverlay(Graphics g) {
		for (int i = 0; i < p.length; i++) {
			p[i].update(g);
		}
	}
  
  
	 //Paints the Board, Players, and tokens
	public void paint(Graphics g) {
		super.paint(g);
		points = new ArrayList<Point>();
		int size = SIZE;
		int x = 15;// starting
		int y = 315;
		int w = size;
		int h = size;

		// Left, top
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x += size;
		}

		// Top, Left
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y -= size;
		}
		
		x += size;
		y += size;
		// Top, Center
		g.setColor(red);// SafeZone
		g.fillRect(x, y, w, h);
		// System.out.println("top pt:" + x + " "+ y);
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
		points.add(new Point(x, y));
		x += size;

		// Top, right
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y += size;
		}
		y -= size;
		x += size;

		// Right, top
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x += size;
		}

		// Right, Center
		y += size;
		x -= size;
		g.setColor(blue);// SafeZone
		g.fillRect(x, y, w, h);
		g.setColor(tile);// SafeZone
		// System.out.println("right pt:" + x + " "+ y);
		g.drawRect(x, y, w, h);
		points.add(new Point(x, y));
		y += size;

		// Right, bottom
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x -= size;
		}
  	}

}
