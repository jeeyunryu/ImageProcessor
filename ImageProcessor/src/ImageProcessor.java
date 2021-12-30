import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ImageProcessor {
	
	private static JFrame mainFrm;
	private static Container contentPane;
	private static JPanel pnl1, pnl2, pnl3;
	private static JButton imprt1Btn, imprt2Btn, saveBtn, gryBtn, edgeBtn, cntrstBtn, smthBtn, addBtn, brghtBtn, etcBtn; 
	private static JLabel toolBarLbl, img1Lbl, img2Lbl, rsltLbl;
	public static void main(String[] args) {
		
		mainFrm = new JFrame("영상 처리기");
		mainFrm.setSize(900, 600);
		mainFrm.setLocationRelativeTo(null);
		mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrm.setResizable(false);
		
		
		contentPane = mainFrm.getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));
		
		pnl1 = new JPanel();
		pnl1.setLayout(new GridLayout(4, 1)); //4행 1열
		
		imprt1Btn = new JButton("이미지1 불러오기");
		
		img1Lbl = new JLabel("이미지 1");
		img1Lbl.setHorizontalAlignment(JLabel.CENTER);
		pnl1.add(img1Lbl);
		imprt2Btn = new JButton("이미지2 불러오기");
		img2Lbl = new JLabel("이미지 2");
		img2Lbl.setHorizontalAlignment(JLabel.CENTER);
		
		pnl1.add(img1Lbl);
		pnl1.add(imprt1Btn);
		pnl1.add(img2Lbl);	
		pnl1.add(imprt2Btn);
	
		pnl2 = new JPanel();
		pnl2.setLayout(new GridLayout(2, 1));
		saveBtn = new JButton("결과 이미지 저장하기");
		rsltLbl = new JLabel("결과 이미지");
		rsltLbl.setHorizontalAlignment(JLabel.CENTER);
		
		pnl2.add(rsltLbl);
		pnl2.add(saveBtn);
		
		pnl3 = new JPanel();
		pnl3.setLayout(new GridLayout(8, 1));
		toolBarLbl = new JLabel("Tool");
		toolBarLbl.setHorizontalAlignment(JLabel.CENTER);
		gryBtn = new JButton("흑백 영상 생성");
		edgeBtn = new JButton("에지 추출");
		cntrstBtn = new JButton("대비");
		smthBtn = new JButton("스무딩");
		addBtn = new JButton("이미지 합치기");
		brghtBtn = new JButton("밝기 조절");
		etcBtn = new JButton("기타 등등");
		pnl3.add(toolBarLbl);
		pnl3.add(gryBtn);
		pnl3.add(edgeBtn);
		pnl3.add(cntrstBtn);
		pnl3.add(smthBtn);
		pnl3.add(addBtn);
		pnl3.add(brghtBtn);
		pnl3.add(etcBtn);
		
		mainFrm.setVisible(true);
		
		contentPane.add(pnl1);
		contentPane.add(pnl2);
		contentPane.add(pnl3);
		
	}
	

}
