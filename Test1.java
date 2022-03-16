import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
class Test1 implements ActionListener {
	JTextField tf1, tf2, tf3;
	JButton b1, b2, b3, b4;
	Font f1;
	Test1() {
		JFrame f = new JFrame("Calculate");
		f1 = new Font("Arial", Font.BOLD, 30);
		tf1 = new JTextField();
		tf1.setBounds(50, 50, 150, 40);
		tf1.setFont(f1);
		tf2 = new JTextField();
		tf2.setBounds(50, 100, 150, 40);
		tf2.setFont(f1);
		tf3 = new JTextField();
		tf3.setBounds(50, 150, 150, 40);
		tf3.setFont(f1);
		tf3.setEditable(false);
		b1 = new JButton("+");
		b1.setBounds(60, 200, 60, 50);
		b1.setFont(f1);
		b2 = new JButton("-");
		b2.setBounds(130, 200, 60, 50);
		b2.setFont(f1);
		b3 = new JButton("\u00D7");
		b3.setBounds(60, 250, 60, 50);
		b3.setFont(f1);
		b4 = new JButton("\u00F7");
		b4.setBounds(130, 250, 60, 50);
		b4.setFont(f1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.add(tf1); f.add(tf2); f.add(tf3); f.add(b1); f.add(b2); f.add(b3); f.add(b4);
		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String s1 = tf1.getText();
		String s2 = tf2.getText();
		try {
			double a = Double.parseDouble(s1);
			double b = Double.parseDouble(s2);
			double c = 0.0;
			if (e.getSource()==b1) {
				c = a + b;
				String result = String.valueOf((int)c);
				tf3.setText(result);
			}
			else if (e.getSource()==b2) {
				c = a - b;
				String result = String.valueOf((int)c);
				tf3.setText(result);
			}
			else if (e.getSource()==b3) {
				c = a * b;
				String result = String.valueOf((int)c);
				tf3.setText(result);
			}
			else if (e.getSource()==b4)
				if (b==0)
					throw new Exception("Divide by 0");
				else if(a%b==0) {
					c = a / b;
					String result = String.valueOf((int)c);
					tf3.setText(result);
				}
				else {
					c = (double)a/(double)b;
					String result = String.valueOf(c);
					tf3.setText(result);
				}
		} catch(Exception exp) {
			tf3.setText("ERROR");
		}
	}
	public static void main(String[]args) {
		new Test1();
	}
}