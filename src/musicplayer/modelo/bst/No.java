package musicplayer.modelo.bst;

import musicplayer.modelo.users.Usuario;

/*
 * N� da �rvore bin�ria de busca
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
