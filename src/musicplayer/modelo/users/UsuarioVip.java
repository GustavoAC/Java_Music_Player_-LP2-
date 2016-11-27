package musicplayer.modelo.users;

import java.util.ArrayList;

import musicplayer.modelo.player.Playlist;

public class UsuarioVip extends Usuario{
	private ArrayList<Playlist> playlists;

	public UsuarioVip(int id, String nome, String senha, ArrayList<Playlist> playlists) {
		super(id, nome, senha);
		this.playlists = playlists;
	}
	
	public UsuarioVip(int id, String nome, String senha) {
		this(id, nome, senha, new ArrayList<Playlist>());
	}
	
	public void addPlaylist(Playlist playlist) {
		for (Playlist pl : playlists) {
			if (pl.getNome().equals(playlist.getNome())) {
				playlists.remove(pl);
				playlists.add(playlist);
				return;
			}
		}
		playlists.add(playlist);
	}
	
	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}
}
