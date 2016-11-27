package musicplayer.visao;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import musicplayer.modelo.patriciatree.PatriciaTree;
import musicplayer.modelo.player.Musica;

/* Painel de músicas
 * É utilizado tanto para exibir a playlist atual quanto as músicas
 * lidas dos diretórios do usuário.
 * */

@SuppressWarnings("serial")
public class PainelMusicas extends JPanel {
	private DefaultListModel<String> model;
	private JList<String> list;
	private JScrollPane pane;
	private MouseListener listener;
	private PatriciaTree tree;

	
	public PainelMusicas(int x, int y, int width, int height, MouseListener listener) {
		super(new BorderLayout());
		this.setBounds(x, y, width, height);
		
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		this.listener = listener;
		tree = new PatriciaTree();
		
		this.add(pane);
		this.setVisible(true);

		list.addMouseListener(listener);	
	}
	
	
	public String getSelectedName() {
		return list.getSelectedValue();
	}
	

	public void list(ArrayList<Musica> musicas) {
		this.remove(pane);
		model = new DefaultListModel<String>();
		tree = new PatriciaTree();
		for (Musica mus : musicas) {
			model.addElement(mus.getFilename());
			tree.insert(mus.getFilename());
		}
		list = new JList<String>(model);
		pane = new JScrollPane(list);
		
		list.addMouseListener(listener);
		this.add(pane);
	}
	
	
	public void addMusic(String name) {
		model.addElement(name);
		tree.insert(name);
	}
	

	public void clear() {
		this.remove(pane);
		model = new DefaultListModel<String>();
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
