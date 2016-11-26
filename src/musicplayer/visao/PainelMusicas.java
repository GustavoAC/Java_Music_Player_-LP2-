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
	private MouseListener listener;
	
	public PainelMusicas(int x, int y, int width, int height, MouseListener listener) {
		super(new BorderLayout());
		this.setBounds(x, y, width, height);
		
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		this.listener = listener;
		
		this.add(pane);
		this.setVisible(true);

		list.addMouseListener(listener);	
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
		list.addMouseListener(listener);
		this.add(pane);
	}
	
	public void addMusic(String name) {
		model.addElement(name);
	}

}
