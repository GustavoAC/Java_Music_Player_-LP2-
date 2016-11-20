package musicplayer.visao;

import java.awt.BorderLayout;

import javax.swing.*;

public class PainelMusicas {

	JFrame frame;
	
	public PainelMusicas() {
		frame = new JFrame("asd");
		frame.setSize(100, 100);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		PainelMusicas pm = new PainelMusicas();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("asd");
		model.addElement("dsadas");
		model.addElement("123123");
		model.addElement("12312");
		
		JList<String> list = new JList<String>(model);
		JScrollPane pane = new JScrollPane(list);
		
		pm.frame.add(pane);
		pm.frame.setVisible(true);
	}
}
