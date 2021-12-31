import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.*;

public class FDialogEx extends JFrame {
	
	Container contentPane;
	JLabel imgLbl = new JLabel();
	
	FDialogEx() {
		
		setTitle("그림파일 불러와보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(imgLbl);
		MakeMenu();
		setSize(300, 300);
		setVisible(true);
		
	}
	
	void MakeMenu() {
		JMenuBar m = new JMenuBar();
		JMenu fMnu = new JMenu("파일");
		JMenuItem oltm = new JMenuItem("열기");
		
		oltm.addActionListener(new OpenActionListener());
		fMnu.add(oltm);
		m.add(fMnu);
		this.setJMenuBar(m);
		
		
	}
	
	class OpenActionListener implements ActionListener {
		
		JFileChooser choice;
		
		OpenActionListener() {
			
			choice = new JFileChooser();
		
		}
		
		public void actionPerformed(ActionEvent e) {
			
			FileNameExtensionFilter fltr = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			choice.setFileFilter(fltr);
			
			int ret = choice.showOpenDialog(null);
			
			if (ret != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았네요", "주의", JOptionPane.WARNING_MESSAGE);
				return;
			
			}
			
			String fpath = choice.getSelectedFile().getPath();
			imgLbl.setIcon(new ImageIcon(fpath));
			pack();
			
		}
	}
	
	public static void main(String[] args) {
		new FDialogEx();
	}
}