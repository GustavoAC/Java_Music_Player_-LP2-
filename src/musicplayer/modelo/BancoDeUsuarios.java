package musicplayer.modelo;

import java.util.ArrayList;

public class BancoDeUsuarios {
	private Tree listaDeUsuarios;

	public BancoDeUsuarios(Tree listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}
	
	public BancoDeUsuarios() {
		listaDeUsuarios = new Tree();
	}
	
	public void addUsuario (int id, String nome, String senha, Playlist playlist) {
		listaDeUsuarios.insereUsuario(id, nome, senha, playlist);
	}
	
	public void addUsuario (int id, String nome, String senha, ArrayList<Playlist> playlists) {
		listaDeUsuarios.insereUsuario(id, nome, senha, playlists);
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
