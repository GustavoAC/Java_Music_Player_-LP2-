package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;

public class PainelPlaylists extends JPanel  {

	public PainelPlaylists(ControlePrincipal controle, ArrayList<Playlist> playlists, int x, int y, int width, int height) {
		super(new BorderLayout());
		this.setBounds(x,y,width, height);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		
		if (playlists != null) {
			for (Playlist pl : playlists) {
				model.add(model.getSize(), pl.getNome());
			}
		}

		JScrollPane pane = new JScrollPane(list);
		this.add(pane);
		this.setVisible(true);

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

}
