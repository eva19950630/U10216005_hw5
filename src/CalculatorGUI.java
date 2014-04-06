
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


class Calculation extends JFrame {
	
	private JTextField jtf;
	private JButton jbt[];
	private JPanel numPanel, optPanel, framePanel;
	private
	
	public Calculation() {
		
		// Overall Appearance
		framePanel = (JPanel)this.getContentPane();
		this.setTitle("Simple Calculator");
		this.setBounds(0, 0, 400, 300);
		this.setBackground(Color.PINK);
		this.setVisible(true);
		BorderLayout bl = new BorderLayout();
		this.setLayout(new BorderLayout(10, 5));
		
		// Display
		jtf = new JTextField("0");
		jtf.setEditable(false);
		jtf.setBackground(Color.WHITE);
		jtf.setMargin(new Insets(5, 5, 5, 5));
		jtf.setFont(new Font("Verdana", Font.PLAIN, 15));
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		framePanel.add(jtf, BorderLayout.NORTH);
		
		// Button
		jbt = new JButton[20];
		
		// Left Button(Number . +/-)
		GridLayout glL = new GridLayout(3, 2);
		glL.setHgap(10);
		glL.setVgap(10);
		numPanel = new JPanel(glL);
		ButtonListener acl = new ButtonListener();
		
		// 0~9  Button
		for (int i = 0, i <= 9, i++) {
			jbt[i] = new JButton(i + "");
			jbt[i].setFont(new Font("Verdana", Font.PLAIN, 12));
			jbt[i].setMargin(new Insets(0, 0, 0, 0));
			jbt[i].addActionListener(acl);
		}	
		
		numPanel.add(jbt[7]);
		numPanel.add(jbt[8]);
		numPanel.add(jbt[9]);
		numPanel.add(jbt[4]);
		numPanel.add(jbt[5]);
		numPanel.add(jbt[6]);
		numPanel.add(jbt[1]);
		numPanel.add(jbt[2]);
		numPanel.add(jbt[3]);
		numPanel.add(jbt[0]);
		
		// .  Button
		jbt[10] = new JButton(".");
		jbt[10].setFont(new Font("Verdana", Font.PLAIN, 12));
		jbt[10].addActionListener(acl);
		
		numPanel.add(jbt[10]);
		
		// +/-  Button
		jbt[11] = new JButton("+/-");
		jbt[11].setFont(new Font("Verdana", Font.PLAIN, 12));
		jbt[11].addActionListener(acl);
		
		numPanel.add(jbt[11]);
		
		// Right Button(+ - * / = C % 1/x)
		GridLayout glR = new GridLayout(2, 1, 5, 5);
		optPanel = new JPanel(glR);
		
		// + - * / = C % 1/x  Button
		jbt[12] = new JButton("/");
		jbt[13] = new JButton("C");
		jbt[14] = new JButton("*");
		jbt[15] = new JButton("%");
		jbt[16] = new JButton("-");
		jbt[17] = new JButton("1/x");
		jbt[18] = new JButton("+");
		jbt[19] = new JButton("=");
		
		for (int i = 12, i <= 19, i++) {
			optPanel.add(jbt[i]);
			jbt[i].setForeground(Color.RED);
			jbt[i].setFont(new Font("Verdana", Font.PLAIN, 12));
			jbt[i].addActionListener(acl);
			jbt[i].setMargin(new Insets(0, 10, 0, 10));
		}
		
		// Typesetting
		framePanel.add(numPanel, BorderLayout.CENTER);
		framePanel.add(optPanel, BorderLayout.EAST);
		
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if 
			
		}
		
	}
	
	
}


public class CalculatorGUI {

	public static void main(String[] args) {

	}

}
