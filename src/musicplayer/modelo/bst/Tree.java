package musicplayer.modelo.bst;

import musicplayer.modelo.users.Usuario;

/* Implementação da árvore binária de busca
 * Contém tanto os métodos tradicionais quanto métodos
 * focados na implementação visual da árvore
 */

public class Tree {	
	private No root;
	private Tree leftTree;
	private Tree rightTree;
	
	public Tree(){
		// construtor vazio
	}
	
	public Tree getRightTree() {
		return rightTree;
	}
	
	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}
	
	public Tree getLeftTree() {
		return leftTree;
	}
	
	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}
	
	 public No getRoot() {
	        return root;
	 }

	public void setRoot(No root) {
	        this.root = root;
	}
	
	/* Insere um Aluno na árvore, de acordo com as informações passadas por parâmetro
	 */ 
	public boolean insereUsuario(Usuario user) {
		return inserir(new No(user));
		
    }
	
	/* Insere um No na árvore
	 */ 
	public boolean inserir(No no) {
		if(this.root == null) {
		   this.root = no;
		   return true;
		} else {
			if (root.getUsuario().compareTo(no.getUsuario()) == -1) {
				if (this.rightTree == null)
					this.rightTree = new Tree();
				if (this.rightTree.inserir(no))
					return true;
			} else if (root.getUsuario().compareTo(no.getUsuario()) == 1) {
				if (this.leftTree == null)
					this.leftTree = new Tree();
				if (this.leftTree.inserir(no))
					return true;
			}
		}
		return false;
	}
	
	
	/* Remove um No da árvore
	 * O No a ser removido é determinado pela matricula passada por parâmetro  
	 * A função retorna true se o No for removido e false caso contrário
	 */
	public boolean remove (int id) {
		if (this.root == null) {
			return false;
		}
		if (this.root.getUsuario().getId() == id) {
			if (this.leftTree == null && this.rightTree == null) {
				this.root = null;
			} else if (this.leftTree != null && this.rightTree == null) {
				this.root = this.leftTree.root;
				this.rightTree = this.leftTree.rightTree;
				this.leftTree = this.leftTree.leftTree;
			} else if (this.leftTree == null && this.rightTree != null) {
				this.root = this.rightTree.root;
				this.leftTree = this.rightTree.leftTree;
				this.rightTree = this.rightTree.rightTree;
			} else {
				Tree ant = this;
				Tree atual = this.leftTree;
				while (atual.rightTree != null) {
					ant = atual;
					atual = atual.rightTree;
				}
				this.root = atual.root;
				if (ant == this) {
					this.leftTree = atual.leftTree;
				} else {
					ant.rightTree = atual.leftTree;
				}
			}
			return true;
		}
		Tree ant = null;
		Tree atual = this;
		while (atual != null && atual.root.getUsuario().getId() != id) {
			if (atual.root.getUsuario().getId() > id) {
				ant = atual;
				atual = atual.leftTree;
			} else {
				ant = atual;
				atual = atual.rightTree;
			}
		}
		
		if (atual == null) {
			return false;
		}
		
		if (atual.leftTree == null && atual.rightTree == null) {
			if (ant.leftTree == atual) {
				ant.leftTree = null;
			} else {
				ant.rightTree = null;
			}
		} else if (atual.leftTree != null && atual.rightTree == null) {
			if (ant.leftTree == atual) {
				ant.leftTree = atual.leftTree;
			} else {
				ant.rightTree = atual.leftTree;
			}
		} else if (atual.leftTree == null && atual.rightTree != null) {
			if (ant.leftTree == atual) {
				ant.leftTree = atual.rightTree;
			} else {
				ant.rightTree = atual.rightTree;
			}
		} else {
			Tree ant2 = atual;
			Tree atual2 = atual.leftTree;
			while (atual2.rightTree != null) {
				ant2 = atual2;
				atual2 = atual2.rightTree;
			}
			atual.root = atual2.root;
			if (ant2 == atual) {
				atual.leftTree = atual2.leftTree;
			} else {
				ant2.rightTree = atual2.leftTree;
			}
		}
		return true;
	}
	

	/* Busca um No na árvore
	 * O No a ser buscado é determinado pela matricula passada por parâmetro
	 * A função retorna o No em questão, se ele for encontrado
	 * Ou um No vazio, caso contrário  
	 */
	public Usuario busca(int id) {
		if (root == null)
			return null;
		
		if (root.getUsuario().getId() == id) { 
			return root.getUsuario();
		}
		
		// Se nao encontrar, retorna no nulo
		if (leftTree == null && rightTree == null)
			return null;
		
		if (root.getUsuario().getId() > id) {
			return leftTree.busca(id);
		} else {
			return rightTree.busca(id);
		}
	}
	
	public void percorrerInOrdem() {
		if (root == null)
			return;
		
		if (leftTree != null) leftTree.percorrerInOrdem();
		System.out.println(root.getUsuario().getNome() + " - " + root.getUsuario().getId());
		if (rightTree != null) rightTree.percorrerInOrdem();
	}
}