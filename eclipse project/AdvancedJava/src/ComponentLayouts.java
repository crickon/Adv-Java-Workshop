
/*
 * HackBI Advanced Java and GUI workshop
 * 
 * GUI Components and Layouts
 * Author: Matthew Grillo (@crickon)
 * Date: October 26, 2018
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentLayouts {
	private static JFrame frame;
	private static JPanel panel;

	private static ArrayList<Component> components;
	private static JTextArea consoleText;

	public static void main(String[] args) {
		frame = new JFrame("HackBI");
		frame.setSize(1080, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		components = new ArrayList<Component>();

		// JTextArea
		JTextArea textArea = new JTextArea("Console:");
		textArea.setFocusable(false);
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(400, 400));
		consoleText = textArea;
		components.add(textArea);

		// JButton and it's ActionListener
		JButton button = new JButton("Click here");
		button.setFocusable(false);
		button.setActionCommand("Pressed");
		button.addActionListener(new ButtonEvent());
		components.add(button);

		// JLabel and MouseListeners
		JLabel label = new JLabel("This is a Label");
		label.setFocusable(false);
		label.setFont(new Font("MS Comic Sans", Font.BOLD, 20));
		label.addMouseListener(new ClickEvent());
		components.add(label);

		// JTextField and it's ActionListener
		JTextField textField = new JTextField("Enter text here:");
		textField.setEditable(true);
		textField.addActionListener(new TextFieldEvent(textField));
		textField.setPreferredSize(new Dimension(100, 20));
		components.add(textField);

		// JPanel and KeyListener
		panel = new JPanel();
		panel.setFocusable(true);
		panel.addKeyListener(new KeyboardEvent());
		
		/*
		 * Set Layouts
		 */
		setAsFlowLayout();
		//setAsGridLayout();

		frame.add(panel);
		frame.setVisible(true);
	}

	private static void setAsFlowLayout() {
		panel.setLayout(new FlowLayout());
		for (Component c : components)
			panel.add(c);
	}

	private static void setAsGridLayout() {
		panel.setLayout(new GridLayout(2, 2));
		for (Component c : components)
			panel.add(c);
	}

	public static void addText(String text) {
		consoleText.setText(consoleText.getText() + "\n" + text);
		panel.grabFocus();
	}

}

class ButtonEvent implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Pressed")) {
			ComponentLayouts.addText("The Button was Pressed!");
		}
	}
}

class ClickEvent implements MouseListener {
	public void mouseClicked(MouseEvent event) {
		ComponentLayouts.addText("The JLabel was clicked");
	}

	// Other Mouse Event capabilities:
	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
	}

	public void mouseReleased(MouseEvent event) {
	}
}

class TextFieldEvent implements ActionListener {
	private JTextField textField;

	public TextFieldEvent(JTextField textField) {
		this.textField = textField;
	}

	public void actionPerformed(ActionEvent event) {
		ComponentLayouts.addText(textField.getText());
		textField.setText("");
	}
}
class KeyboardEvent implements KeyListener {
	public void keyPressed(KeyEvent event) {
		if (event.getKeyChar() == 'h') {
			ComponentLayouts.addText("You have found the hidden key!");
		}
	}
	public void keyReleased(KeyEvent event) {
	}
	public void keyTyped(KeyEvent event) {
	}
}
