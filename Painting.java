/*
 * HackBI Advanced Java and GUI workshop
 * 
 * JFrame and Panel Painting
 * Author: Matthew Grillo (@crickon)
 * Date: October 26, 2018
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painting {
	private static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("HackBI");
		frame.setSize(1080, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PaintPanel c = new PaintPanel();
		frame.add(c);

		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class PaintPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
		g2.drawString("Welcome to HackBI", 0, 100);
		
		g2.drawRect(500, 400, 50, 25);
		g2.drawOval(250, 250, 100, 50);
		g2.drawArc(500, 500, 100, 100, 0, 270);

		g2.setStroke(new BasicStroke(5));
		g2.drawLine(0, 110, 1080, 110);
	}
}