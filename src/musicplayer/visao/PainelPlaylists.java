package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import musicplayer.modelo.patriciatree.PatriciaTree;
import musicplayer.modelo.player.Playlist;

@SuppressWarnings("serial")
public class PainelPlaylists extends JPanel  {
	private DefaultListModel<String> model;
	private JList<String> list;
	private JScrollPane pane;
	private MouseListener listener;
	private PatriciaTree tree;
	
	public PainelPlaylists(int x, int y, int width, int height, MouseListener listener) {
		super(new BorderLayout());
		this.setBounds(x,y,width, height);
		
		this.listener = listener;
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		tree = new PatriciaTree();
		
		this.add(pane);
		this.setVisible(true);
		list.addMouseListener(listener);
	}

	public void list(ArrayList<Playlist> playlists) {
		this.remove(pane);
		model = new DefaultListModel<String>();
		tree = new PatriciaTree();
		for (Playlist pl : playlists) {
			model.addElement(pl.getNome());
			tree.insert(pl.getNome());
		}
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		
		list.addMouseListener(listener);
		this.add(pane);
	}
	
	public void update(String base) {
		StringBuilder prefix = new StringBuilder();
		PatriciaTree t = tree.searchForIteration(base, prefix);
		ArrayList<String> names = null;
		if (t != null)
			names = t.iterate();
		
		this.remove(pane);
		model = new DefaultListModel<String>();
		if (names != null) {
			for (String name : names)
				model.addElement(prefix + name);
		
			if (model.isEmpty())
				model.addElement(prefix.toString());
		}
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		
		list.addMouseListener(listener);
		this.add(pane);
	}
}
