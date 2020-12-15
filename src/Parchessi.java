package src;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
					System.out.println("Parchessi:rollButton.addActionListener(): Roll again set to false");
					System.out.println("Parchessi:rollButton.addActionListener(): Rolling Again, automatically");
					System.out.println("Parchessi:rollButton.addActionListener(): before Roll: " + roll);
					roll += rollAgain();
					System.out.println("Parchessi:rollButton.addActionListener():  after Roll: " + roll);
				}
				Board.movePlayer(turnValue, roll);
				repaint();
				int res = Board.checkWin();
				if (res > -1) {
					gameHasBeenWon(res);
				}
				rollButton.setEnabled(false);
				nextTurn.setEnabled(true);
			}
		});
		
		// Initialize Next Turn Button
		nextTurn = new JButton("Next Turn");
		nextTurn.setEnabled(false);
		nextTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rollButton.setEnabled(true);
				nextTurn.setEnabled(false);
				getNextTurn();

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
	
	
	public static void gameHasBeenWon(int id) {
		
	}
	
	
	//Next Turn Returns the index of the next Game Player
	public static void getNextTurn() {
		
	}
	
	
	//Roll Dice. If both Dice are equal, Player can go again
	public static int roll() {
		
	}
	
	
	//Roll Dice Again, can only happen once
	public static int rollAgain() {
		
	}
	
	
	//Choose Number of Players with Error Bounds Checking
	public static void chooseNumPlayers() {
		
	}
	
	
	//Resets the Game
	public static void reset() {
		
	}
	
	
	public static void PlayAI() throws AWTException {
		
	}
	
	
	public static Board getBoard() {
		
	}

	
	public static void main(String[] args) throws AWTException {
		gameFrame = new Parchessi();
	}

}
