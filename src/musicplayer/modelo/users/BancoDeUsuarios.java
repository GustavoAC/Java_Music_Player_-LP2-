package musicplayer.modelo.users;

import java.util.ArrayList;

import musicplayer.modelo.bst.No;
import musicplayer.modelo.bst.Tree;

public class BancoDeUsuarios {
	private Tree arvoreDeUsuarios;

	public BancoDeUsuarios(Tree listaDeUsuarios) {
		this.arvoreDeUsuarios = listaDeUsuarios;
	}
	
	public BancoDeUsuarios() {
		arvoreDeUsuarios = new Tree();
	}
	
	public BancoDeUsuarios(ArrayList<Usuario> userList) {
		arvoreDeUsuarios = new Tree();
		for (Usuario u : userList)
			arvoreDeUsuarios.insereUsuario(u);
	}

	public void addUsuario (int id, String nome, String senha, boolean isVip) {
		if (isVip) 
			arvoreDeUsuarios.insereUsuario(new UsuarioVip(id, nome, senha));
		else
			arvoreDeUsuarios.insereUsuario(new UsuarioComum(id, nome, senha));
	}
	
	public void addUsuario (No usuario) {
		arvoreDeUsuarios.inserir(usuario);
	}
	
	public boolean remove(int id) {
		return arvoreDeUsuarios.remove(id);
	}
	
	public Usuario buscar (int id) {
		return arvoreDeUsuarios.busca(id);
	}

	public void listar() {
		System.out.println("== Lista de usuarios: ==");
		arvoreDeUsuarios.percorrerInOrdem();
	}
	
}
