package modelo;

import java.util.ArrayList;

public class UsuarioVip extends Usuario{
	private ArrayList<Playlist> playlists;

	public UsuarioVip(int id, String nome, int senha, ArrayList<Playlist> playlists) {
		super(id, nome, senha);
		this.playlists = playlists;
	}
	
	public UsuarioVip(int id, String nome, int senha) {
		super(id, nome, senha);
		playlists  = new ArrayList<Playlist>();
	}
	
	public void addPlaylist(Playlist playlist) {
		playlists.add(playlist); 
	}

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}
	
}
