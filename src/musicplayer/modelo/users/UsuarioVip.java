package musicplayer.modelo.users;

import java.util.ArrayList;

import musicplayer.modelo.player.Playlist;

public class UsuarioVip extends Usuario{
	private ArrayList<Playlist> playlists;
	int currentIndex;

	public UsuarioVip(int id, String nome, String senha, ArrayList<Playlist> playlists) {
		super(id, nome, senha);
		this.playlists = playlists;
		currentIndex = 0;
	}
	
	public UsuarioVip(int id, String nome, String senha) {
		this(id, nome, senha, new ArrayList<Playlist>());
		playlists.add(new Playlist());
	}
	
	public void addPlaylist(Playlist playlist) {
		playlists.add(playlist);
	}

	public Playlist getCurrentPlaylist() {
		return playlists.get(currentIndex);
	}
	
	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}
}
