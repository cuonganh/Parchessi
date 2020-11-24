import java.awt.AWTException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
class Parchessi extends JFrame {

	public Parchessi() {
		chooseNumPlayers();
	}
	public static void chooseNumPlayers() {
		String[] options = { "1", "2", "3", "4" };
		String x = (String) JOptionPane.showInputDialog(null,
				"How Many Players? (1-4)", "Parcheesi",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//		while (numPlayers > 4 || numPlayers < 1) {
//			
//
//			if (x == null) {
//				System.exit(0);
//			} else {
//				numPlayers = Integer.parseInt(x);
//			}
		//}

	}
	public static void main(String[] args) throws AWTException {
	new Parchessi();
	}

}
