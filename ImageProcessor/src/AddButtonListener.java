import java.awt.event.*;

import javax.swing.*;

public class AddButtonListener implements ActionListener {
	
	JTextField text1;
	ImagePanel panel;
	
	public AddButtonListener(JTextField text1, ImagePanel panel) {
		
		super();
		this.text1 = text1;
		this.panel = panel;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		panel.setPath(text1.getText());
		panel.repaint();
		
	}
	
}
