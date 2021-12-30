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
		
		mainFrm = new JFrame("���� ó����");
		mainFrm.setSize(900, 600);
		mainFrm.setLocationRelativeTo(null);
		mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrm.setResizable(false);
		
		
		contentPane = mainFrm.getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));
		
		pnl1 = new JPanel();
		pnl1.setLayout(new GridLayout(4, 1)); //4�� 1��
		
		imprt1Btn = new JButton("�̹���1 �ҷ�����");
		
		img1Lbl = new JLabel("�̹��� 1");
		img1Lbl.setHorizontalAlignment(JLabel.CENTER);
		pnl1.add(img1Lbl);
		imprt2Btn = new JButton("�̹���2 �ҷ�����");
		img2Lbl = new JLabel("�̹��� 2");
		img2Lbl.setHorizontalAlignment(JLabel.CENTER);
		
		pnl1.add(img1Lbl);
		pnl1.add(imprt1Btn);
		pnl1.add(img2Lbl);	
		pnl1.add(imprt2Btn);
	
		pnl2 = new JPanel();
		pnl2.setLayout(new GridLayout(2, 1));
		saveBtn = new JButton("��� �̹��� �����ϱ�");
		rsltLbl = new JLabel("��� �̹���");
		rsltLbl.setHorizontalAlignment(JLabel.CENTER);
		
		pnl2.add(rsltLbl);
		pnl2.add(saveBtn);
		
		pnl3 = new JPanel();
		pnl3.setLayout(new GridLayout(8, 1));
		toolBarLbl = new JLabel("Tool");
		toolBarLbl.setHorizontalAlignment(JLabel.CENTER);
		gryBtn = new JButton("��� ���� ����");
		edgeBtn = new JButton("���� ����");
		cntrstBtn = new JButton("���");
		smthBtn = new JButton("������");
		addBtn = new JButton("�̹��� ��ġ��");
		brghtBtn = new JButton("��� ����");
		etcBtn = new JButton("��Ÿ ���");
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
