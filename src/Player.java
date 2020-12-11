import javax.swing.JPanel;

@SuppressWarnings("serial")
class Player extends JPanel {
	private final int NUM_TOKENS = 4;
	private int pid;// Player id
	private Point p;// Player info,Starting point for pieces for each player
	private Color color;
	private int offset;
	public Token[] t;
	public final ArrayList<Point> specialPointData;// Point Data for Special
	
	public Player(int id) {
		specialPointData = new ArrayList<Point>();
		
		// Initialize Player Details
		pid = id + 1;
		
		switch (id) {
		case 0:// player1

			break;
		case 1:// player2
			
			break;
		case 2:// player3
			
			break;
		case 3:// player4
			
			break;
		default: 
			
		}
	}
	
	
	public ArrayList<String> getAvailableTokens() {
		
	}
	
	
	public int getPID() {
		
	}
	
	
	public int getOffset() {
		
	}
	
	
	//Choose Player's Token to move with Error Bounds Checking
	public int chooseToken() {
		
	}
	
	
	//Select Token To Move, returns an integer representing a valid usable token. -1 otherwise
	public int autoSelectFreeToken() {
		
	}
	
	
	public void setPoint(int x, int y) {
		
	}
	
	
	//Updates the Player info and tokens on board
	public void update(Graphics g) {
		
	}
	
	
	//Checks if Player has won. Returns a boolean representation of the condition
	public boolean hasWon() {
		
	}
	
	
	//gets Player Color
	public Color getColor() {
		
	}
	
	
	//Nested Token Object Class, each player has 4 tokens
	class Token {
		
	}
	
}
