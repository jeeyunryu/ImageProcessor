import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class Class01 {
	
	public static void main(String[] args) {
		
			JFrame f = new JFrame("메인 윈도우");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocationRelativeTo(null);
			
			JLabel l = new JLabel();
			f.add(l);
			
			File file = new File("C:\\Users\\류지연\\Pictures\\tiger.jpg");
			BufferedImage m;
			
			try {
				
				m = ImageIO.read(file);
				l.setIcon(new ImageIcon(m));
				
			} catch (Exception e) {}
			
			f.setVisible(true);
			f.pack();
			
	}
}