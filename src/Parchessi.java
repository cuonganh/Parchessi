import java.awt.AWTException;
import javax.swing.JFrame;

@SuppressWarnings("serial")
class Parchessi extends JFrame {

	public Parchessi() {
		// Set and Initialize Number of Players
		turnValue = 0;
		displayValue = turnValue + 1;
		chooseNumPlayers();

		// Initialize Roll Button
		rollButton = new JButton("Roll Dice");
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Parchessi.roll();
				while (rollAgain == true) {
					rollAgain = false;// Set to false imediatley
					System.out
							.println("Parchessi:rollButton.addActionListener(): Roll again set to false");
					System.out
							.println("Parchessi:rollButton.addActionListener(): Rolling Again, automatically");
					System.out
							.println("Parchessi:rollButton.addActionListener(): before Roll: "
									+ roll);
					roll += rollAgain();
					System.out
							.println("Parchessi:rollButton.addActionListener():  after Roll: "
									+ roll);
				}
				Board.movePlayer(turnValue, roll);
				repaint();
				rollButton.setEnabled(false);
				nextTurn.setEnabled(true);
			}
		});
		



		// Initialize Board and Menu
		b = new Board(numPlayers);
		m = new Menu();
		m.add(rollButton);
		m.add(nextTurn);

		// Game Panel Stuff
		mContainer = new JPanel();
		rollView = new JLabel("Turn: Player " + displayValue + ";    Dice Roll: ");

		rollView.setBorder(new EmptyBorder(5, 5, 5, 5));
		b.setBorder(new EmptyBorder(5, 5, 5, 5));
		mContainer.add(m, "East");
		mContainer.add(rollView, "West");
		add(b, "Center");
		add(mContainer, "South");
		getContentPane().setBackground(new Color(250, 250, 250));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setBounds(20, 20, 900, 850);
		setVisible(true);
	}

	public static void main(String[] args) throws AWTException {
		gameFrame = new Parchessi();
	}

}
