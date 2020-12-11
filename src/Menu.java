import java.awt.AWTException;
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

	}

	// Generates a simple button
	public void addButton() {

	}

	// Yes/No Dialog Generator for basic yes/no menu questions
	public boolean areYouSure() {

	}


	/*
	 * Generates a simple button
	 */
	public void addButton(Container c, String title, ImageIcon img, ActionListener a) {
		JButton b = new JButton(title);
		c.add(b);
		b.addActionListener(a);
	}

	/*
	 * Yes/No Dialog Generator for basic yes/no menu questions
	 */
	public boolean areYouSure() {

	}


}
