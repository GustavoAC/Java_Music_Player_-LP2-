package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class PainelPlaylists {

	JFrame frame;

	public PainelPlaylists() {
		frame = new JFrame("dfsj");
		frame.setSize(100, 100);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}

	public static void main(String[] args) {
		PainelPlaylists pp = new PainelPlaylists();

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		model.add(model.getSize() , "Playlist 1");
		model.add(model.getSize() , "Playlist 2");

		JScrollPane pane = new JScrollPane(list);

		pp.frame.add(pane);
		pp.frame.setVisible(true);

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
