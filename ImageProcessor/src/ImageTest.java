import java.awt.*;

import javax.swing.*;

public class ImageTest {
	
	public static void main (String[] args) {
		
		JFrame frame = new JFrame("�̹��� �ҷ�����");
		JButton button = new JButton("�̹��� �ҷ�����");
		JPanel panel = new JPanel();
		JTextField text1 = new JTextField(20);
		ImagePanel panel1 = new ImagePanel();
		
		frame.setBounds(500, 400, 480, 640);
		frame.add(panel1);
		button.addActionListener(new AddButtonListener(text1, panel1));
		panel.add(text1);
		panel.add(button);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}