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
import musicplayer.modelo.Musica;
import musicplayer.modelo.Playlist;

public class PainelMusicas extends JPanel {

	public PainelMusicas(ControlePrincipal controle, Playlist pl, int width, int height, int x, int y) {
		super(new BorderLayout());
		this.setBounds(x, y, width, height);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		if (pl != null) {	
			ArrayList<Musica> musicas = pl.getMusicas();
			for (Musica musica : musicas) {
				model.addElement(musica.getPath());
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
						controle.tocarMusicaSelecionada(0);
					}
				}
			}
		};
		list.addMouseListener(mouseListener);
		
	}

}
