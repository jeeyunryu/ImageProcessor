import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// ImageProcessor 클래스로부터 buffered 이미지를 받아옴
public class GrayScale {
	
	public GrayScale() {
		
	}
	
	public void cnvrtClrToGryScle() {
		
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedImage img = null;
		File f = null;
		
		try {
			
			f = new File("C:\\Users\\류지연\\Pictures\\6943984.1.jpg");
			img = ImageIO.read(f);
			
		} catch (IOException e) {
			
			System.out.println(e);
			
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		for (int j = 0; j < height; j++) {
			
			for (int i = 0; i < width; i++) {
				
				int p = img.getRGB(i, j);
				
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = p&0xff;
				
				int avg = (r+g+b)/3;
				
				p = (a<<24)|(avg<<16)|(avg<<8)|avg;
				
				img.setRGB(i, j, p);
				
			}
		}
			
		try {
			
			f = new File("C:\\Users\\류지연\\Pictures\\KKOOMDORI.jpg");
			ImageIO.write(img, "jpg", f);
			
		} catch (IOException e) {
			
			System.out.println(e);
			
		}
		
	}
				

}
