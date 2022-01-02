import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.*;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class ImageProcessor {
	
	private static JFrame mainFrm;
	private static Container contentPane;
	private static JPanel pnl1, pnl2, pnl3, pnl4, imgPnl;
	private static JButton imprt1Btn, imprt2Btn, saveBtn, gryBtn, edgeBtn, 
					cntrstBtn, blrBtn, addBtn, brghtBtn, darkBtn, thrshldBtn; 
	private static JLabel toolBarLbl, img1Lbl, img2Lbl, rsltLbl;
	private static JFileChooser choice = new JFileChooser("C:\\Users\\류지연\\"
					+ "Pictures");
	private static BufferedImage dfltBffdImg, gryBffdImg, brghtBffdImg, 
					drkBffdImg, blrBffdImg, cntrstBffdImg, thrshldBffdImg, brghtBffdImg2;
	private static Image dfltImg, gryImg, brghtImg, drkImg, blrImg, cntrstImg, 
					thrshldImg;
	private static ImageIcon imgIcon;
	
	private static int value;
	
	private static ActionListener actionListener = new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == imprt1Btn) {
			
				FileNameExtensionFilter fltr = new FileNameExtensionFilter("JPG Images", "jpg");
				choice.setFileFilter(fltr);
				int result = choice.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					
					String fpath = choice.getSelectedFile().getPath();
					
					File file = new File(fpath);
					
					try {
						
						dfltBffdImg = ImageIO.read(file);
//						
						Image dfltImg = dfltBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
						ImageIcon imgIcon = new ImageIcon(dfltImg);
					
						img1Lbl.setIcon(imgIcon);
						img1Lbl.setText("");
					
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				
				}
				
			}
			
			else if (e.getSource() == imprt2Btn) {
			
				FileNameExtensionFilter fltr = new FileNameExtensionFilter("JPG Images", "jpg");
				choice.setFileFilter(fltr);
				int result = choice.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					
					String fpath = choice.getSelectedFile().getPath();
					
					File file = new File(fpath);
					
					try {
						
						dfltBffdImg = ImageIO.read(file);
						dfltImg = dfltBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
						ImageIcon imageIcon = new ImageIcon(dfltImg);
					
						img2Lbl.setIcon(imageIcon);
						img2Lbl.setText("");
					
					} catch (IOException e1) {

						e1.printStackTrace();
						
					}
				
				}
				
			}
			
			else if (e.getSource() == gryBtn) {
				
				gryBffdImg = deepCopy(dfltBffdImg);
				
				int width = gryBffdImg.getWidth();
				int height = gryBffdImg.getHeight();
				
				for (int j = 0; j < height ; j++) {
					
					for (int i = 0; i < width; i++) {
						
						int p = gryBffdImg.getRGB(i, j);
						
						int a = (p>>24)&0xff;
						int r = (p>>16)&0xff;
						int g = (p>>8)&0xff;
						int b = p&0xff;
						
						int avg = (r+g+b)/3;
						
						p = (a<<24) | (avg<<16) | (avg<<8) | avg;
						
						
						gryBffdImg.setRGB(i, j, p);
						
					}
					
				}
				
				gryImg = gryBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				imgIcon = new ImageIcon(gryImg);
				
				rsltLbl.setIcon(imgIcon);
			
			}
			
			else if (e.getSource() == brghtBtn) {
				
				
				
				JFrame sldrFrm = new JFrame();
				Container c = sldrFrm.getContentPane();
				
				sldrFrm.setLocationRelativeTo(null);
				sldrFrm.setTitle("Brightness");
				sldrFrm.setSize(300, 100);
				sldrFrm.setVisible(true);
				
				
				JSlider slider = new JSlider(-20, 20, 0);
				slider.setMinorTickSpacing(1);
				slider.setMajorTickSpacing(5);
				slider.setPaintTicks(true);
				slider.setPaintLabels(true);
				
				c.add(slider);
				
				slider.addChangeListener(new ChangeListener() {
					
					public void stateChanged(ChangeEvent e) {

						value = slider.getValue();
						
						brghtBffdImg = deepCopy(dfltBffdImg);
						int width = brghtBffdImg.getWidth();
						int height = brghtBffdImg.getHeight();
						
						for (int j = 0; j < height ; j++) {
					
							for (int i = 0; i < width; i++) {
						
								int p = brghtBffdImg.getRGB(i, j);
								
								int a = (p>>24)&0xff;
								int r = (p>>16)&0xff;
								int g = (p>>8)&0xff;
								int b = p&0xff;
								
								r += value;
								g += value;
								b += value;
					
								if (r > 255) {
									 r = 255;
								}
								
								if (r < 0) {
									r = 0;
								}
								
								if (g > 255) {
									g = 255;
								}
								
								if (g < 0) {
									g = 0;
								}
								
								if (b > 255) {
									b = 255;
								}
								
								if (b < 0) {
									b = 0;
								}
								
								p = (a<<24) | (r<<16) | (g<<8) | b;
								
								brghtBffdImg.setRGB(i, j, p);
								
							}
					
						}
				
						brghtImg = brghtBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
						imgIcon = new ImageIcon(brghtImg);
						
						rsltLbl.setIcon(imgIcon);
					}
				});
				
			}
			
			/*else if (e.getSource() == brghtBtn) {
				
				brghtBffdImg = deepCopy(dfltBffdImg);
				
				int width = brghtBffdImg.getWidth();
				int height = brghtBffdImg.getHeight();
				
				for (int j = 0; j < height ; j++) {
					
					for (int i = 0; i < width; i++) {
						
						int p = brghtBffdImg.getRGB(i, j);
						
						int a = (p>>24)&0xff;
						int r = (p>>16)&0xff;
						int g = (p>>8)&0xff;
						int b = p&0xff;
						
						r += 40;
						g += 40;
						b += 40;
			
						if (r > 255) {
							 r = 255;
						}
						
						if (g > 255) {
							g = 255;
						}
						
						if (b > 255) {
							b = 255;
						}
						
						p = (a<<24) | (r<<16) | (g<<8) | b;
						
						brghtBffdImg.setRGB(i, j, p);
						
					}
					
				}
				
				brghtImg = brghtBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				imgIcon = new ImageIcon(brghtImg);
				
				rsltLbl.setIcon(imgIcon);
				
			}*/
			
			/*else if (e.getSource() == darkBtn) {
				
				drkBffdImg = deepCopy(dfltBffdImg);
				
				int width = drkBffdImg.getWidth();
				int height = drkBffdImg.getHeight();
				
				for (int j = 0; j < height ; j++) {
					
					for (int i = 0; i < width; i++) {
						
						int p = drkBffdImg.getRGB(i, j);
						
						int a = (p>>24)&0xff;
						int r = (p>>16)&0xff;
						int g = (p>>8)&0xff;
						int b = p&0xff;
						
						r -= 40;
						g -= 40;
						b -= 40;
			
						if (r < 0) {
							 r = 0;
						}
						
						if (g < 0) {
							g = 0;
						}
						
						if (b < 0) {
							b = 0;
						}
						
						p = (a<<24) | (r<<16) | (g<<8) | b;
						
						drkBffdImg.setRGB(i, j, p);
						
					}
					
				}
				
				drkImg = drkBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				imgIcon = new ImageIcon(drkImg);
				
				rsltLbl.setIcon(imgIcon);
				
			}*/
			
			else if (e.getSource() == blrBtn) {
				
				blrBffdImg = deepCopy(dfltBffdImg);
			
				
				Kernel k = new Kernel(5, 5, new float[] {
						1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 
						1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 
						1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5),
						1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5),
						1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5), 1f/(5*5)
						});
				
				ConvolveOp convolveOp = new ConvolveOp(k);
				blrBffdImg = convolveOp.filter(blrBffdImg, null);
				blrImg = blrBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				rsltLbl.setIcon(new ImageIcon(blrImg));
				
				/*for (int j = 2; j < height ; j++) {
					
					for (int i = 2; i < width; i++) {
						
						
						
						int pxl = blrBffdImg.getRGB(i, j);
						
						int[] p = new int[9];
						
						
						
						p[0] = blrBffdImg.getRGB(i-1, j-1); //(1, 1)
						p[1] = blrBffdImg.getRGB(i, j-1); //((1, 2)
						p[2] = blrBffdImg.getRGB(i+1, j-1); //(1, 3)
						p[3] = blrBffdImg.getRGB(i-1, j); //(2, 1)
						p[4] = blrBffdImg.getRGB(i, j); //(2, 2) * target pixel
						p[5] = blrBffdImg.getRGB(i+1, j);
						p[6] = blrBffdImg.getRGB(i-1, j+1);
						p[7] = blrBffdImg.getRGB(i, j+1);
						p[8] = blrBffdImg.getRGB(i+1, j+1);
						System.out.println("(" + j + ", " + i + ")");
						int a = (pxl>>24)&0xff;
					
						int[] r = new int[9];
						int sumOfRed = 0;
						for (int k = 0; k < 9; k++) {
							r[k] = (p[k]>>16)&0xff;
							sumOfRed += r[k];
							//System.out.println("test" + (k+1));
						}
						
						int avgOfRed = sumOfRed / 9;
						
						
						int[] g = new int[9];
						int sumOfGreen = 0;
						for (int k = 0; k < 9; k++) {
							g[k] = (p[k]>>8)&0xff;
							sumOfGreen += g[k];
						}
						int avgOfGreen = sumOfGreen / 9;
						
						
						int[] b = new int[9];
						int sumOfBlue = 0;
						for (int k = 0; k < 9; k++) {
							b[k] = p[k]&0xff;
							sumOfBlue += b[k];
						}
						int avgOfBlue = sumOfBlue / 9;
					
						
						pxl = (a<<24) | (avgOfRed<<16) | (avgOfGreen<<8) | avgOfBlue;
						
						blrBffdImg.setRGB(i, j, pxl);
						
						
					}
					
				}
				
				blrImg = blrBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				imgIcon = new ImageIcon(blrImg);
				
				rsltLbl.setIcon(imgIcon);*/
				
				
			}
			
			else if (e.getSource() == saveBtn) {
				
				Image rsltImg = imgIcon.getImage();
				
				BufferedImage rsltBffdImg = (BufferedImage) rsltImg;
				
				//Icon rsltIcon = rsltLbl.getIcon();
				//BufferedImage bi = new BufferedImage(rsltIcon.getIconWidth(), rsltIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
				
				try {
					
					File outputFile = new File("C:\\Users\\류지연\\Pictures\\resultImg.jpg");
					ImageIO.write(rsltBffdImg, "jpg", outputFile);
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
			
			else if (e.getSource() == cntrstBtn) {
				
				cntrstBffdImg = deepCopy(dfltBffdImg);
				
				int width = cntrstBffdImg.getWidth();
				int height = cntrstBffdImg.getHeight();
				
				for (int j = 2; j < height ; j++) {
					
					for (int i = 2; i < width; i++) {
					
						int p = cntrstBffdImg.getRGB(i, j);
						
						int a = (p>>24)&0xff;
						int r = (p>>16)&0xff;
						int g = (p>>8)&0xff;
						int b = p&0xff;
						int gray = (r+g+b)/3;
						
						r = gray;
						g = gray;
						b = gray;
						
						r *= 1.5;
						g *= 1.5;
						b *= 1.5;
						
						
						if (r > 255) {
							r = 255;
						}
						
						if (g > 255) {
							
							g = 255;
							
						}
						
						if (b > 255) {
							b = 255;
						}
			
						p = (a<<24) | (r<<16) | (g<<8) | b;
						
						cntrstBffdImg.setRGB(i, j, p);
						
					}
					
				}
				
				cntrstImg = cntrstBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				imgIcon = new ImageIcon(cntrstImg);
				
				rsltLbl.setIcon(imgIcon);
				
				
			}
			
			else if (e.getSource() == thrshldBtn) {
				
				thrshldBffdImg = deepCopy(dfltBffdImg);
				
				int width = thrshldBffdImg.getWidth();
				int height = thrshldBffdImg.getHeight();
				
				for (int j = 2; j < height ; j++) {
					
					for (int i = 2; i < width; i++) {
					
						int p = thrshldBffdImg.getRGB(i, j);
						
						int a = (p>>24)&0xff;
						int r = (p>>16)&0xff;
						int g = (p>>8)&0xff;
						int b = p&0xff;
						int gray = (r+g+b)/3;
						
						if (gray > 80) {
							gray = 255;
						}
						else {
							gray = 0;
						}
						
						r = gray;
						g = gray;
						b = gray;
			
						p = (a<<24) | (r<<16) | (g<<8) | b;
						
						thrshldBffdImg.setRGB(i, j, p);
						
					}
					
				}
				
				thrshldImg = thrshldBffdImg.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				imgIcon = new ImageIcon(thrshldImg);
				
				rsltLbl.setIcon(imgIcon);
				
				
			}
			
			
		}
		
	};
	
	public static BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public static void main(String[] args) {
		
		mainFrm = new JFrame("영상 처리기");
		mainFrm.setSize(900, 600);
		mainFrm.setLocationRelativeTo(null);
		mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrm.setResizable(false);
		
		contentPane = mainFrm.getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));
		
		pnl1 = new JPanel();
		pnl1.setLayout(new BorderLayout()); //4행 1열
		
		imprt1Btn = new JButton("이미지1 불러오기");
		imprt1Btn.addActionListener(actionListener);
		
		choice.setFileFilter(new FileNameExtensionFilter("png", "png"));
		choice.setMultiSelectionEnabled(false);
		
		img1Lbl = new JLabel("이미지 1");
		img1Lbl.setHorizontalAlignment(JLabel.CENTER);
		
		/*imprt2Btn = new JButton("이미지2 불러오기");
		imprt2Btn.addActionListener(actionListener);
		
		img2Lbl = new JLabel("이미지 2");
		img2Lbl.setHorizontalAlignment(JLabel.CENTER);*/
		
		pnl1.add(img1Lbl, BorderLayout.CENTER);
		pnl1.add(imprt1Btn, BorderLayout.SOUTH);
		
		/*pnl2 = new JPanel();
		pnl2.setLayout(new BorderLayout());
		pnl2.add(img2Lbl, BorderLayout.CENTER);
		pnl2.add(imprt2Btn, BorderLayout.SOUTH);*/
		
		imgPnl = new JPanel();
		//imgPnl.setLayout(new GridLayout(2, 1));
		imgPnl.setLayout(new GridLayout(1, 1));
		imgPnl.add(pnl1);
		//imgPnl.add(pnl2);
	
		pnl3 = new JPanel();
		pnl3.setLayout(new BorderLayout());
		saveBtn = new JButton("결과 이미지 저장하기");
		saveBtn.addActionListener(actionListener);
		
		rsltLbl = new JLabel();
	
		pnl3.add(rsltLbl, BorderLayout.CENTER);
		pnl3.add(saveBtn, BorderLayout.SOUTH);
		
		pnl4 = new JPanel();
		pnl4.setLayout(new GridLayout(6, 1));
		toolBarLbl = new JLabel("Tool");
		toolBarLbl.setHorizontalAlignment(JLabel.CENTER);
		gryBtn = new JButton("Grayscale");
		gryBtn.addActionListener(actionListener);
		
		/*edgeBtn = new JButton("에지 추출");
		edgeBtn.addActionListener(actionListener);*/
		
		cntrstBtn = new JButton("Contrast on Grayscale Image");
		cntrstBtn.addActionListener(actionListener);
		
		blrBtn = new JButton("Smoothing");
		blrBtn.addActionListener(actionListener);
		
		/*addBtn = new JButton("이미지 합치기");
		addBtn.addActionListener(actionListener);*/
		
		brghtBtn = new JButton("Brightness");
		brghtBtn.addActionListener(actionListener);
	
		/*darkBtn = new JButton("밝기 낮추기");
		darkBtn.addActionListener(actionListener);*/
		
		thrshldBtn = new JButton("Threshold");
		thrshldBtn.addActionListener(actionListener);
		
		pnl4.add(toolBarLbl);
		pnl4.add(gryBtn);
		//pnl4.add(edgeBtn);
		pnl4.add(cntrstBtn);
		pnl4.add(blrBtn);
		//pnl4.add(addBtn);
		pnl4.add(brghtBtn);
		//pnl4.add(darkBtn);
		pnl4.add(thrshldBtn);
		
		mainFrm.setVisible(true);
		
		contentPane.add(imgPnl);
		contentPane.add(pnl3);
		contentPane.add(pnl4);
		
		
	}

}
