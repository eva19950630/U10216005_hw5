
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class Calculation extends JFrame {
	
	private JTextField jtf;
	private JButton jbt[];
	private JPanel numPanel, optPanel, framePanel;
	
	private String now_num = "";
	private boolean reset_num = false;
	private int optSymbol = 0;
	private double sol = 0;
	private double tmp2 = 0;
	
	/**Constructor*/
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
		for (int i = 0; i <= 9; i++) {
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
		
		for (int i = 12; i <= 19; i++) {
			optPanel.add(jbt[i]);
			jbt[i].setForeground(Color.RED);
			jbt[i].setFont(new Font("Verdana", Font.PLAIN, 12));
			jbt[i].addActionListener(acl);
			jbt[i].setMargin(new Insets(0, 10, 0, 10));
		}
		
		// Composing these twenty buttons
		framePanel.add(numPanel, BorderLayout.CENTER);
		framePanel.add(optPanel, BorderLayout.EAST);
		
	}
	
	/**Handle these twenty buttons*/
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbt[0] || e.getSource() == jbt[1] || e.getSource() == jbt[2] || e.getSource() == jbt[3] || e.getSource() == jbt[4] || e.getSource() == jbt[5] || e.getSource() == jbt[6] || e.getSource() == jbt[7] || e.getSource() == jbt[8] || e.getSource() == jbt[9]) {
				now_num = jtf.getText();
				if (Double.parseDouble(now_num) == 0 || reset_num) {
					reset_num = false;
					jtf.setText(e.getActionCommand());	
				} else {
					now_num = jtf.getText();
					jtf.setText(now_num + e.getActionCommand());
				}
			} else if (e.getSource() == jbt[12]) {
				double now = Double.parseDouble(jtf.getText());
				if (optSymbol == 0) {
					sol = now;
					optSymbol = 4;
					reset_num = true;
				} else {
					tmp2 = now;
					sol = operation(optSymbol, sol, tmp2);
					optSymbol = 4;
					reset_num = true;
				}
				jtf.setText(sol + "");
			} else if (e.getSource() == jbt[14]) {
				double now = Double.parseDouble(jtf.getText());
				if (optSymbol == 0) {
					sol = now;
					optSymbol = 3;
					reset_num = true;
				} else {
					tmp2 = now;
					sol = operation(optSymbol, sol, tmp2);
					optSymbol = 3;
					reset_num = true;
				}
				jtf.setText(sol + "");
			} else if (e.getSource() == jbt[16]) {
				double now = Double.parseDouble(jtf.getText());
				if (optSymbol == 0) {
					sol = now;
					optSymbol = 2;
					reset_num = true;
				} else {
					tmp2 = now;
					sol = operation(optSymbol, sol, tmp2);
					optSymbol = 2;
					reset_num = true;
				}
				jtf.setText(sol + "");
			} else if (e.getSource() == jbt[18]) {
				double now = Double.parseDouble(jtf.getText());
				if (optSymbol == 0) {
					sol = now;
					optSymbol = 1;
					reset_num = true;
				} else {
					tmp2 = now;
					sol = operation(optSymbol, sol, tmp2);
					optSymbol = 1;
					reset_num = true;
				}
				jtf.setText(sol + "");
			} else if (e.getSource() == jbt[19]) {
				double now = Double.parseDouble(jtf.getText());
				tmp2 = now;
				sol = operation(optSymbol, sol, tmp2);
				reset_num = true;
				optSymbol = 0;
				jtf.setText(sol + "");
			} else if (e.getSource() == jbt[13]) {
				tmp2 = 0;
				reset_num = true;
				optSymbol = 0;
				sol = 0;
				jtf.setText("0");
			} else if (e.getSource() == jbt[11]) {
				String now = jtf.getText();
				if (now.charAt(0) != '-') {
					jtf.setText('-' + now);
				} else {
					jtf.setText(now.substring(1, now.length()));
				}
			} else if (e.getSource() == jbt[15]) {
				double now = Double.parseDouble(jtf.getText());
				if (optSymbol == 0) {
					sol = now / 100;
					optSymbol = 0;
					reset_num = true;
				} else {
					tmp2 = now;
					sol = operation(optSymbol, sol, tmp2) / 100;
					optSymbol = 0;
					reset_num = true;
				}
				jtf.setText(sol + "");
			} else if (e.getSource() == jbt[17]) {
				double now = Double.parseDouble(jtf.getText());
				if (optSymbol == 0) {
					sol = 1 / now;
					optSymbol = 0;
					reset_num = true;
				} else {
					tmp2 = now;
					sol = 1 / operation(optSymbol, sol, tmp2);
					optSymbol = 0;
					reset_num = true;
				}
				jtf.setText(sol + "");	
			} else if  (e.getSource() == jbt[10]) {
				now_num = jtf.getText();
				if (now_num.indexOf('.') == -1) {
					jtf.setText(now_num + ".");
				}
			}
			
		}
	
		// Create a method "operation" to calculate + - * /
		public double operation(int optS, double sol, double tmp2) {
			if (optS == 1) {
				sol = sol + tmp2;
			} else if (optS == 2) {
				sol = sol - tmp2;
			} else if (optS == 3) {
				sol = sol * tmp2;
			} else if (optS == 4) {
				if (tmp2 != 0.0) {
					sol = sol / tmp2;
				}
			}
			return sol;
		}
		
	}
	
}


public class CalculatorGUI {

	public static void main(String[] args) {
		Calculation cal = new Calculation();
		cal.setDefaultCloseOperation(cal.EXIT_ON_CLOSE);
	}

}
