package musicplayer.modelo.bst;

import musicplayer.modelo.users.Usuario;

/*
 * Nó da árvore binária de busca
 * */
public class No {
	
	private Usuario usuario;

    public No(Usuario usuario) {
        this.usuario = usuario;
    }
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

   
    
}
