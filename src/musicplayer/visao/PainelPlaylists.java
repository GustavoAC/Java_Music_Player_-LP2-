package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.Musica;
import musicplayer.modelo.Playlist;

public class PainelPlaylists {

	JFrame frame;

	public PainelPlaylists(ControlePrincipal controle, ArrayList<Playlist> playlists, int width, int height) {
		frame = new JFrame("dfsj");
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		
		if (playlists != null) {
			for (Playlist pl : playlists) {
				model.add(model.getSize(), pl.getNome());
			}
		}

		JScrollPane pane = new JScrollPane(list);

		frame.add(pane);
		frame.setVisible(true);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String o = theList.getSelectedValue().toString();
						JOptionPane.showConfirmDialog(null, "Tocando música: " +  o);
						controle.tocarPlaylistSelecionada(0);
					}
				}
			}
		};
		list.addMouseListener(mouseListener);
	}

	public static void main(String[] args) {
		ArrayList<Playlist> array = new ArrayList<Playlist>();
		Playlist pl1 = new Playlist();
		Playlist pl2 = new Playlist();
		array.add(pl1);
		array.add(pl2);
		PainelPlaylists pp = new PainelPlaylists(new ControlePrincipal(), array, 200, 300);

	}
}
