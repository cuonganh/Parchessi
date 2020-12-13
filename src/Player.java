import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * POINT DATA DECLARED AT BOTTOM OF FILE!!! In Token Class
 */
@SuppressWarnings("serial")
class Player extends JPanel {

	private final int NUM_TOKENS = 4;
    	private int pid;// Player id
    	private Point p;// Player info,Starting point for pieces for each player
    	private Color color;
	private Color red = new Color(255, 0, 0);
	private Color blue = new Color(0, 0, 255);
	private Color green = new Color(0, 255, 0);
	private Color yellow = new Color(255, 255, 0);
	private Color[] col = {red,blue,green,yellow};
	private int offset;
	public Token[] t;
	public final ArrayList<Point> specialPointData;// Point Data for Special

    	public Player(int id) {

        	specialPointData = new ArrayList<Point>();

        	// Initialize Player Details
        	pid = id + 1;
        	switch (id) {
            	case 0:// player1
			p = new Point(60, 30);
			offset = 25;// Perfect
			color = Color.RED;
			break;
		    case 1:// player2
			p = new Point(514, 30);
			offset = 31;
			color = Color.BLUE;
			break;
		    case 2:// player3
			p = new Point(60, 485);
			offset = -1;
			color = Color.YELLOW;               
			break;
		    case 3:// player4
			p = new Point(514, 485);
			offset = 47;
			color = Color.GREEN;
			break;
		    default: // This should never happen
			p = new Point(60, 60);
			color = Color.RED;
		}
	    
		t = new Token[NUM_TOKENS];
		for (int i = 0; i < NUM_TOKENS; i++) {
			t[i] = new Token(i, p.x, p.y, getColor());
		}
	    
    	}

	public ArrayList<String> getAvailableTokens() {

	}

	public int getPID() {
		return pid;
	}

	public int getOffset() {
		return offset;
	}

	/*
	* Choose Player's Token to move with Error Bounds Checking
	*/
	public int chooseToken() {
		int tok = -1;
		ArrayList<String> available = getAvailableTokens();
		
		return tok;
	}

	public int autoSelectFreeToken() {

	}

	public void setPoint(int x, int y) {
		p = new Point(x, y);
	}

	/*
	* Updates the Player info and tokens on board
	*/
	public void update(Graphics g) {

	}

	/*
	* Checks if Player has won. Returns a boolean representation of the condition
	*/
	public boolean hasWon() {

	}

	/*
	* gets Player Color
	*/
	public Color getColor() {
		return color;
	}

	/*
	* Nested Token Object Class, each player has 4 tokens
	*/
	class Token {

		// This constructor takes the players individual Corner Parameters so it
		// knows where each players nest is
		public Token(int i, int x, int y, Color col) {

		}

		// Draws a token, anywhere on the board we want to
		public void drawToken(Graphics g, int x, int y) {

		}

		public void draw(Graphics g) {

		}

		/*
		 * If the player has traversed the entire board, then we want to go down the
		 * players safe zone for a win! Returns -1 if false Returns any other positive
		 * value to represent how many spaces the user can traverse following the turn
		 */
		public int checkTraversal() {

		}

		/*
		 * gets the safe zone condition
		 */
		public boolean getSafeZone() {
			return lastEight;
		}

		/*
		 * sets the safe zone condition
		 */
		public void setSafeZone(boolean b) {
			lastEight = b;
		}

		/*
		 * Checks to see if the token is Safe, or not
		 */
		public boolean isSafe() {

		}


		// Getter and Setter
		public void setX(int xPos) {
			pos.x = xPos;
		}

		public int getX() {
			return pos.x;
		}

		public void setY(int yPos) {
			pos.y = yPos;
		}

		public int getY() {
			return pos.y;
		}

		public int getWidth() {
			return tokenSize;
		}

		public int getHeight() {
			return tokenSize;
		}
		
	}

}
