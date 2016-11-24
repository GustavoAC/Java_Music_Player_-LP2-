package musicplayer.modelo.users;

import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;

public class UsuarioComum extends Usuario {
	private Playlist playlist;
	
	public UsuarioComum(int id, String nome, String senha, Playlist playlist) {
		super(id, nome, senha);
		this.playlist = playlist;
	}
	
	public UsuarioComum(int id, String nome, String senha) {
		this(id, nome, senha, new Playlist());
	}
	
	public void addMusic(Musica musica) {
		playlist.addMusic(musica); 
	}

	@Override
	public Playlist getCurrentPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	
}
	