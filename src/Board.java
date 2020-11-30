package src;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel {
	private static ArrayList<Point> points;
	private static int numGamePlayers;
	private static Player[] p;
	private Color tile = new Color(0, 0, 0);
	private Color red = new Color(255, 0, 0);
	private Color blue = new Color(0, 0, 255);
	private Color green = new Color(0, 255, 0);
	private Color yellow = new Color(255, 255, 0);
	private Color safeBorder = new Color(0, 255, 0);
	private Color safeFill = new Color(0, 150, 150);
	private Color base = new Color(0, 179, 21);
	private int SIZE =45;

	/*
	 * Board Constructor Constructs a custom board for numPlayers to play
	 */
	public Board(int numPlayers) {
		numGamePlayers = numPlayers;

		p = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			p[i] = new Player(i);
		}
	}

	/*
	 * Function to pre-load the points for all pieces to aid in debugging
	 * traversal issues
	 */
	public static void debugLoadPoints() {
		for (int i = 0; i < numGamePlayers; i++) {
			for (int j = 0; j < numGamePlayers; j++) {
				p[i].t[j].setPositionIndex(61);
			}
		}
	}

	/*
	 * Check For Winner! Return -1 for no winner, else return player index.
	 * Should only ever return -1,0,1,2,3. Nothing else.
	 */
	public static int checkWin() {
		for (int i = 0; i < numGamePlayers; i++) {
			if (p[i].hasWon()) {
				return p[i].getPID();
			}

		}
		return -1;
	}

	/*
	 * MovePlayer moves and sets the players Token locations on the board tv =
	 * turnValue Moves Player based on tv index.
	 */
	public static void movePlayer(int tv, int r) {
		int tok = p[tv].chooseToken();// Select Token
		int i = p[tv].t[tok].getPositionIndex();// Get the Current Index

		p[tv].t[tok].setPositionIndex(i + r);// Set the current Index + the roll
												// value
		// Get the current index (i+r) for the point data
		int z = p[tv].t[tok].getPositionIndex() + p[tv].getOffset();

		// Check if we've made a complete traversal. This condition should only
		// happen once
		if (p[tv].t[tok].checkTraversal() > -1) {
			p[tv].t[tok].setSafeZone(true);
		}
		// If we have made a complete traversal, go down the special lane
		if (p[tv].t[tok].getSafeZone()) {
			if (z > p[tv].specialPointData.size()) {
				z = p[tv].specialPointData.size() - 1;
			}
		}// Otherwise, continue moving
		else {
			if (z > points.size()) {
				// If the calculated index is larger than the board, the set it
				// to itself w/ modulo
				// Handles Offset issues
				z = z % points.size() + 1;
			}
			p[tv].t[tok].setX(points.get(z).x + 10);
			p[tv].t[tok].setY(points.get(z).y + 10);
			// System.out.println("pt:" + points.get(z).x + " "+
			// points.get(z).y);
		}

	}

	/*
	 * Returns List of Points, for the Game Logic Array.
	 */
	public ArrayList<Point> getPoints() {
		ArrayList<Point> pts = new ArrayList<Point>();
		pts = points;
		return pts;
	}

	/*
	 * Returns Point List Length
	 */
	public int getPointLength() {
		return points.size();
	}

	/*
	 * Prints out point list for debugging purposes
	 */
	public void printPoints() {
		for (int i = 0; i < points.size(); i++) {
			System.out.println(points.get(i));
		}
	}

	/*
	 * Returns Block Size for Board
	 */
	public int getBlockSize() {
		return SIZE;
	}

	/*
	 * Handles Painting the Players info and Tokens
	 */

	public void paintPlayerOverlay(Graphics g) {
		for (int i = 0; i < p.length; i++) {
			p[i].update(g);
		}
	}

	/*
	 * Paints the Board, Players, and tokens
	 */
	public void paint(Graphics g) {
		super.paint(g);
		points = new ArrayList<Point>();
		int size = SIZE;
		int x = 60;// starting
		int y = 345;
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

		// bottom, right
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y += size;
		}
		x -= size;
		y -= size;

		// bottom, Center
		g.setColor(green);// SafeZone
		g.fillRect(x, y, w, h);
		// System.out.println("bottm pt:" + x + " "+ y);
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
		points.add(new Point(x, y));
		x -= size;

		// bottom, left
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);

			points.add(new Point(x, y));
			y -= size;
		}
		y += size;
		x -= size;

		// Left, bottom
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x -= size;
		}

		// left, Center
		y -= size;
		x += size;
		g.setColor(yellow);// SafeZone
		g.fillRect(x, y, w, h);
		// System.out.println("left pt:" + x + " "+ y);
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
		points.add(new Point(x, y));
		x += size;

		// safeBorder Horizontal
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			x += size;
		}
		g.setColor(base);// SafeZone
		g.fillRect(x, y, w, h);
		g.setColor(safeBorder);// SafeZone
		g.drawRect(x, y, w, h);
		x += size;
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			x += size;
		}
		x -= size * 8;
		y -= size * 7;

		// safeBorder Vertical
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			y += size;
		}
		y += size;// skip one
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			y += size;
		}

		paintPlayerOverlay(g);
	}

}
