import java.awt.*;

import javax.swing.*;

public class ImagePanel extends JPanel{
	
	Image image;
	Toolkit toolkit = getToolkit();
	
	public void setPath(String src) {
		
		image = toolkit.getImage(src);
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, 480, 640);
		
		if (image != null) {
			
			g.drawImage(image, 0, 0, this);
		}
		
		
	}

}
