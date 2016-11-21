package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		JList<String> list = new JList<String>(model);
		model.add(model.getSize() , "asd");
		model.add(model.getSize() , "dsadas");
		model.add(model.getSize() , "123123");
		model.add(model.getSize() , "12312");

		JScrollPane pane = new JScrollPane(list);

		pm.frame.add(pane);
		pm.frame.setVisible(true);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String o = theList.getSelectedValue().toString();
						JOptionPane.showConfirmDialog(null, "Tocando música: " +  o);
					}
				}
			}
		};
		list.addMouseListener(mouseListener);
	}
}
