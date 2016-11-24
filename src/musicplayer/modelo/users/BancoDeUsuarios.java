package musicplayer.modelo.users;

import musicplayer.modelo.bst.No;
import musicplayer.modelo.bst.Tree;

public class BancoDeUsuarios {
	private Tree listaDeUsuarios;

	public BancoDeUsuarios(Tree listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}
	
	public BancoDeUsuarios() {
		listaDeUsuarios = new Tree();
	}
	
	public void addUsuario (int id, String nome, String senha, boolean isVip) {
		if (isVip) 
			listaDeUsuarios.insereUsuario(new UsuarioVip(id, nome, senha));
		else
			listaDeUsuarios.insereUsuario(new UsuarioComum(id, nome, senha));
	}
	
	public void addUsuario (No usuario) {
		listaDeUsuarios.inserir(usuario);
	}
	
	public boolean remove(int id) {
		return listaDeUsuarios.remove(id);
	}
	
	public No buscar (int id) {
		return listaDeUsuarios.busca(id);
	}
	
}
