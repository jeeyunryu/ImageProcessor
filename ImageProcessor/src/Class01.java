import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class Class01 {
	
	public static void main(String[] args) {
		
			JFrame f = new JFrame("���� ������");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocationRelativeTo(null);
			
			JLabel l = new JLabel();
			f.add(l);
			
			File file = new File("C:\\Users\\������\\Pictures\\tiger.jpg");
			BufferedImage m;
			
			try {
				
				m = ImageIO.read(file);
				l.setIcon(new ImageIcon(m));
				
			} catch (Exception e) {}
			
			f.setVisible(true);
			f.pack();
			
	}
}