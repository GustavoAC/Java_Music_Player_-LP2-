package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.Musica;
import musicplayer.modelo.Playlist;

public class PainelMusicas {

	JFrame frame;

	public PainelMusicas(ControlePrincipal controle, Playlist pl, int width, int height) {
		frame = new JFrame("asd");
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		if (pl != null) {	
			ArrayList<Musica> musicas = pl.getMusicas();
			for (Musica musica : musicas) {
				model.add(model.getSize(), musica.getPath());
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
						controle.tocarMusicaSelecionada(0);
					}
				}
			}
		};
		list.addMouseListener(mouseListener);
	}

	public static void main(String[] args) {
		Musica m1 = new Musica("Musica 1", 120);
		Musica m2 = new Musica("Musica 2", 120);
		Playlist pl = new Playlist();
		pl.addMusic(m1);
		pl.addMusic(m2);
		PainelMusicas pm = new PainelMusicas(new ControlePrincipal(), pl, 200, 300);
	}
}
