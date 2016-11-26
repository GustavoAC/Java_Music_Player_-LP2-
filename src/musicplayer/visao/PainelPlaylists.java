package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.player.Playlist;

@SuppressWarnings("serial")
public class PainelPlaylists extends JPanel  {
	private DefaultListModel<String> model;
	private JList<String> list;
	private JScrollPane pane;
	
	public PainelPlaylists(ControlePrincipal controle, int x, int y, int width, int height) {
		super(new BorderLayout());
		this.setBounds(x,y,width, height);
		
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		
		this.add(pane);
		this.setVisible(true);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList<String> theList = (JList<String>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String o = theList.getSelectedValue().toString();
						JOptionPane.showConfirmDialog(null, "Tocando música: " +  o);
						controle.tocarPlaylistSelecionada(index);
					}
				}
			}
		};
		list.addMouseListener(mouseListener);
	}

	public void loadPlaylists(ArrayList<Playlist> playlists) {
		this.remove(pane);
		model = new DefaultListModel<String>();
		for (Playlist pl : playlists)
			model.addElement(pl.getNome());
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		this.add(pane);
	}

	public void displayDefaultMessage() {
		this.remove(pane);
		model = new DefaultListModel<String>();
		model.addElement("Esse usuário não tem playlists");
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		this.add(pane);
	}
}
