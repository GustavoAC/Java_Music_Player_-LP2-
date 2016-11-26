package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;

@SuppressWarnings("serial")
public class PainelMusicas extends JPanel {
	private DefaultListModel<String> model;
	private JList<String> list;
	private ArrayList<Musica> musicas;
	private JScrollPane pane;
	
	public PainelMusicas(ControlePrincipal controle, int x, int y, int width, int height) {
		super(new BorderLayout());
		this.setBounds(x, y, width, height);
		
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
						controle.play(index);
					}
				}
			}
		};
		list.addMouseListener(mouseListener);	
	}
	
	public int getSelectedIndex() {
		return list.getSelectedIndex();
	}

	public void list(ArrayList<Musica> musicas) {
		this.musicas = musicas;

		this.remove(pane);
		model = new DefaultListModel<String>();
		for (Musica mus : musicas)
			model.addElement(mus.getFilename());
		
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		this.add(pane);
	}

}
