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
	
	public Player() {
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

}
