import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class ImageProcessor {
	
	private static JFrame mainFrm;
	private static Container contentPane;
	private static JPanel pnl1, pnl2, pnl3, pnl4, imgPnl;
	private static JButton imprt1Btn, imprt2Btn, saveBtn, gryBtn, edgeBtn, cntrstBtn, smthBtn, addBtn, brghtBtn, darkBtn, etcBtn; 
	private static JLabel toolBarLbl, img1Lbl, img2Lbl, rsltLbl, jlb;
	
	private static JFileChooser choice = new JFileChooser("C:\\Users\\������\\Pictures");
	
	private static ImageIcon rsltImg;
	
	private static BufferedImage dfltBffdImg, gryBffdImg, brghtBffdImg, drkBffdImg;
	
	private static Image dfltImg, gryImg, brghtImg, drkImg;

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
				
				gryBffdImg = dfltBffdImg;
				
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
				ImageIcon imgIcon = new ImageIcon(gryImg);
				
				rsltLbl.setIcon(imgIcon);
			
			}
			
			else if (e.getSource() == brghtBtn) {
				
				brghtBffdImg = dfltBffdImg;
				
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
				ImageIcon imgIcon = new ImageIcon(brghtImg);
				
				rsltLbl.setIcon(imgIcon);
				
			}
			
else if (e.getSource() == darkBtn) {
				
				drkBffdImg = dfltBffdImg;
				
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
				ImageIcon imgIcon = new ImageIcon(drkImg);
				
				rsltLbl.setIcon(imgIcon);
				
			}
			
			
			
		}
		
	};
	
	public static void main(String[] args) {
		
		mainFrm = new JFrame("���� ó����");
		mainFrm.setSize(900, 600);
		mainFrm.setLocationRelativeTo(null);
		mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrm.setResizable(false);
		
		contentPane = mainFrm.getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));
		
		pnl1 = new JPanel();
		pnl1.setLayout(new BorderLayout()); //4�� 1��
		
		imprt1Btn = new JButton("�̹���1 �ҷ�����");
		imprt1Btn.addActionListener(actionListener);
		
		choice.setFileFilter(new FileNameExtensionFilter("png", "png"));
		choice.setMultiSelectionEnabled(false);
		
		img1Lbl = new JLabel("�̹��� 1");
		img1Lbl.setHorizontalAlignment(JLabel.CENTER);
		
		imprt2Btn = new JButton("�̹���2 �ҷ�����");
		imprt2Btn.addActionListener(actionListener);
		
		img2Lbl = new JLabel("�̹��� 2");
		img2Lbl.setHorizontalAlignment(JLabel.CENTER);
		
		pnl1.add(img1Lbl, BorderLayout.CENTER);
		pnl1.add(imprt1Btn, BorderLayout.SOUTH);
		
		pnl2 = new JPanel();
		pnl2.setLayout(new BorderLayout());
		pnl2.add(img2Lbl, BorderLayout.CENTER);
		pnl2.add(imprt2Btn, BorderLayout.SOUTH);
		
		imgPnl = new JPanel();
		imgPnl.setLayout(new GridLayout(2, 1));
		imgPnl.add(pnl1);
		imgPnl.add(pnl2);
	
		pnl3 = new JPanel();
		pnl3.setLayout(new BorderLayout());
		saveBtn = new JButton("��� �̹��� �����ϱ�");
		saveBtn.addActionListener(actionListener);
		
		rsltLbl = new JLabel();
	
		pnl3.add(rsltLbl, BorderLayout.CENTER);
		pnl3.add(saveBtn, BorderLayout.SOUTH);
		
		pnl4 = new JPanel();
		pnl4.setLayout(new GridLayout(10, 1));
		toolBarLbl = new JLabel("Tool");
		toolBarLbl.setHorizontalAlignment(JLabel.CENTER);
		gryBtn = new JButton("��� ���� ����");
		gryBtn.addActionListener(actionListener);
		
		edgeBtn = new JButton("���� ����");
		edgeBtn.addActionListener(actionListener);
		
		cntrstBtn = new JButton("���");
		cntrstBtn.addActionListener(actionListener);
		
		smthBtn = new JButton("������");
		smthBtn.addActionListener(actionListener);
		
		addBtn = new JButton("�̹��� ��ġ��");
		addBtn.addActionListener(actionListener);
		
		brghtBtn = new JButton("��� ���̱�");
		brghtBtn.addActionListener(actionListener);
	
		darkBtn = new JButton("��� ���߱�");
		darkBtn.addActionListener(actionListener);
		
		etcBtn = new JButton("��Ÿ ���");
		
		pnl4.add(toolBarLbl);
		pnl4.add(gryBtn);
		pnl4.add(edgeBtn);
		pnl4.add(cntrstBtn);
		pnl4.add(smthBtn);
		pnl4.add(addBtn);
		pnl4.add(brghtBtn);
		pnl4.add(darkBtn);
		pnl4.add(etcBtn);
		
		mainFrm.setVisible(true);
		
		contentPane.add(imgPnl);
		contentPane.add(pnl3);
		contentPane.add(pnl4);
		
	}

}
