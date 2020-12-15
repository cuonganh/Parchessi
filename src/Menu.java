package src;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Menu extends JPanel {

	/* Add's a button to the Panel */
	public Menu() {
		setBackground(new Color(72, 209, 204));

		/*
		 * Add Basic Menu Buttons, Other Buttons Need access to internal logic
		 * of the game, so they are added in the parcheesi constructor
		 */

		addButton(this, "Help/Instructions", null, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String info = "Goal: \n\tGet all of your tokens arround the board,"
						+ " and then to the center of the board.\n\nRules:\n\tIf a token is on a white tile,"
						+ " and another Player's token is moved there, the origonal token must"
						+ " go back to start. \nEach player will roll 2 dice, with a maximum value of 12 to determine"
						+ " how many spaces to move\n\n"
						+ "For Each Player's Turn: \n\t1.First Roll the dice.\n\t2.Then Select Which piece to move.\n "
						+ "WARNING! If you select a peice before the roll, this piece will be moved to that location.";
				JOptionPane.showMessageDialog(null, info, "Help/Instuctions",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		addButton(this, "Exit Game", null, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (areYouSure()) {
					System.exit(0);
				}
			}
		});

		addButton(this, "New Game", null, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (areYouSure()) {
					Parchessi.reset();
				}
			}
		});

	}

	/*
	 * Generates a simple button
	 */
	public void addButton(Container c, String title, ImageIcon img,	ActionListener a) {
		JButton b = new JButton(title);
		c.add(b);
		b.addActionListener(a);
	}

	/*
	 * Yes/No Dialog Generator for basic yes/no menu questions
	 */
	public boolean areYouSure() {
		String[] options = { "Yes!", "No!" };
		String x = (String) JOptionPane.showInputDialog(null, "Are You Sure?",
				"Parcheesi", JOptionPane.QUESTION_MESSAGE, null, options,
				options[0]);
		if (x == "Yes!") {
			return true;
		} else {
			return false;
		}

	}
}
