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
	private MouseListener listener;
	
	public PainelPlaylists(int x, int y, int width, int height, MouseListener listener) {
		super(new BorderLayout());
		this.setBounds(x,y,width, height);
		
		this.listener = listener;
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		
		this.add(pane);
		this.setVisible(true);
		list.addMouseListener(listener);
	}

	public void list(ArrayList<Playlist> playlists) {
		this.remove(pane);
		model = new DefaultListModel<String>();
		for (Playlist pl : playlists)
			model.addElement(pl.getNome());
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		
		list.addMouseListener(listener);
		this.add(pane);
	}
}
