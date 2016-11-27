package musicplayer.modelo.users;

import java.util.ArrayList;

import musicplayer.modelo.bst.No;
import musicplayer.modelo.bst.Tree;

/* Banco de Usuarios
 * Mantém uma árvore de busca binária com todos os usuários registrados
 * */

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

	public boolean addUsuario (int id, String nome, String senha, boolean isVip) {
		if (isVip) 
			return arvoreDeUsuarios.insereUsuario(new UsuarioVip(id, nome, senha));
		else
			return arvoreDeUsuarios.insereUsuario(new UsuarioComum(id, nome, senha));
	}
	
	public boolean addUsuario(Usuario usuario) {
		return arvoreDeUsuarios.inserir(new No(usuario));
	}
	
	public boolean remove(int id) {
		return arvoreDeUsuarios.remove(id);
	}
	
	public Usuario buscar (int id) {
		return arvoreDeUsuarios.busca(id);
	}
	
	public void listar() {
		System.out.println("== Lista de Usuários registrados: ==");
		arvoreDeUsuarios.percorrerInOrdem();
	}
	
}
