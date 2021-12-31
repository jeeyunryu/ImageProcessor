import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawImage {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\류지연\\Pictures\\tiger.jpg");
		BufferedImage img = ImageIO.read(file);
		JLabel lb = new JLabel(new ImageIcon(img));
		JFrame f = new JFrame("이미지 그리기");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(lb);
		f.pack();
		f.setLocation(200, 200);
		f.setVisible(true);
		
	}
}