package musicplayer.modelo.patriciatree;

import java.util.ArrayList;

public class PatriciaTree {
	private PatriciaNode root;
	private PatriciaTree[] subTrees;
	private static final int NULLNODE = 66;
	
	public PatriciaTree(String cont) {
		root = new PatriciaNode(cont);
		subTrees = new PatriciaTree[NULLNODE+1];
	}
	
	public PatriciaTree() {
		this("");
	}
	
	private int alphaNumericOrder(char in) {
		if ('0' <= in && in <= '9')
			return 2 + in - '0';
		else if ('A' <= in && in <= 'Z')
			return 14 + 2*(in - 'A');
		else if ('a' <= in && in <= 'z')
			return 15 + 2*(in - 'a');
		
		switch (in) {
		case ' ':
			return 0;
		case '.':
			return 1;
		case '-':
			return 12;
		case '_':
			return 13;
		}
		
		// Invalid Number
		return -1;
	}
	
	// create "add node" function later. Saves some space.
	public void insert(String cont) {
		// string already exists on tree/is null
		// talvez dê pra adicionar um nullnode aqui
		if (cont.equals("")) return;
		
		int i = 0;
		for (/* Empty */; i < root.getContent().length() && i < cont.length(); i++) {
			if (cont.charAt(i) != root.getContent().charAt(i))
				break;
		}
		
		// interrupted loop, forking the tree
		if (i != root.getContent().length() && i != cont.length()) {
			int posOld = alphaNumericOrder(root.getContent().charAt(i));
			int pos = alphaNumericOrder(cont.charAt(i));
			
			// invalid character
			if (pos < 0) return;
			
			PatriciaTree newPt = new PatriciaTree(root.getContent().substring(i));
			newPt.subTrees = this.subTrees;
			root.setContent(root.getContent().substring(0, i));
			this.subTrees = new PatriciaTree[NULLNODE+1];
			this.subTrees[posOld] = newPt;
			
			this.subTrees[pos] = new PatriciaTree(cont.substring(i));
		}
		
		// loop ended safely
		// equal sizes, current node works as stop point if not a repeated value
		if (cont.length() == root.getContent().length()) {
			if (subTrees[NULLNODE] == null)
				subTrees[NULLNODE] = new PatriciaTree();
		
		// root is longer than cont, make new node for cont and
		// give it a stop point, root goes deeper now
		} else if (cont.length() < root.getContent().length()) {
			int pos = alphaNumericOrder(root.getContent().charAt(i));
			
			PatriciaTree newPt = new PatriciaTree(root.getContent().substring(i));
			newPt.subTrees = this.subTrees;
			root.setContent(root.getContent().substring(0, i));
			this.subTrees = new PatriciaTree[NULLNODE+1];
			subTrees[pos] = newPt;
			
			subTrees[NULLNODE] = new PatriciaTree();
		
		// cont is longer than root, continue searching for correct place.
		// end search if new tree is needed.
		} else {
			int pos = alphaNumericOrder(cont.charAt(i));
			
			// invalid character
			if (pos < 0) return;
			
			if (subTrees[pos] == null) {
				subTrees[pos] = new PatriciaTree(cont.substring(i));
				subTrees[pos].subTrees[NULLNODE] = new PatriciaTree();
			} else {
				subTrees[pos].insert(cont.substring(i));
			}
		}	
	}
	
	/* Make an explanation here */
	public PatriciaTree searchForIteration(String target, StringBuilder searchBase) {
		// First call only. Gets the whole tree if empty target.
		if (target.equals("")) return this;
		
		int i = 0;
		for (/* Empty */; i < root.getContent().length() && i < target.length(); i++) {
			if (target.charAt(i) != root.getContent().charAt(i))
				break;
		}
		
		// interrupted loop, target not in Tree
		if (i != root.getContent().length() && i != target.length())
			return null;
		
		// completed loop
		// target is longer than root, continue seaching
		else if (root.getContent().length() < target.length()) {
			int pos = alphaNumericOrder(target.charAt(i));
			// invalid character or null subTree, not in tree.
			if (pos < 0 || subTrees[pos] == null)
				return null;
			
			searchBase.append(root.getContent());
			return subTrees[pos].searchForIteration(target.substring(i), searchBase);
		}
		
		// root equals target or root is longer than target,
		// current tree works as start point for iteration
		else {
			searchBase.append(root.getContent());
			return this;
		}
	}
	
	public ArrayList<String> iterate() {
		ArrayList<String> ret = new ArrayList<String>();
		
		for (int i = 0; i < 66; i++) {
			if (subTrees[i] != null) {
				ArrayList<String> temp = subTrees[i].iterate(subTrees[i].root.getContent());
				ret.addAll(temp);
			}
		}
		return ret;
	}
	
	public ArrayList<String> iterate(String searchBase) {
		System.out.println("Debug. searchBase: " + searchBase);
		
		ArrayList<String> ret = new ArrayList<String>();
		if (subTrees[66] != null) {
			ret.add(searchBase);
		}
		
		for (int i = 0; i < 66; i++) {
			if (subTrees[i] != null) {
				ArrayList<String> temp = subTrees[i].iterate(searchBase + subTrees[i].root.getContent());
				ret.addAll(temp);
			}
		}
		return ret;
	}
	
	// Not really needed, so let it be done last.
	public void remove() {
		
	}
	
	// Clears the tree.
	public void clear() {
		for (int i = 0; i < 65; i++)
			subTrees[i] = null;
	}
	
	public static void main(String[] args) {
		PatriciaTree pt = new PatriciaTree();
		pt.insert("agua");
		pt.insert("aguado");
		pt.insert("a");
		pt.insert("original");
		pt.insert("oregano");
		pt.insert("omar");
		pt.insert("iguana");
		pt.insert("123");
		pt.insert("parafuso");
		pt.insert("parafuseta");
		pt.insert("pi");
		pt.insert("po");
		
		ArrayList<String> result = pt.iterate();
		System.out.println("Achados: ");
		for (String string : result) {
			System.out.println(string);
		}
		
		// O StringBuilder tem que ser passado por referencia pra ser usado na
		// hora da impressão, classe estranha é gambiarra pra passar por parâmetro.
		StringBuilder base = new StringBuilder();
		PatriciaTree sub = pt.searchForIteration("o", base);
		result = sub.iterate();
		System.out.println("Base: " + base + " Achados: ");
		for (String string : result) {
			System.out.println(string);
		}
	}
}
