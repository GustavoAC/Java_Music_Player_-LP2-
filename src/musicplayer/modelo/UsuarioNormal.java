package modelo;

public class UsuarioNormal extends Usuario {
	private Playlist playlist;
	
	public UsuarioNormal(int id, String nome, int senha, Playlist playlist) {
		super(id, nome, senha);
		this.playlist = playlist;
	}
	
	public UsuarioNormal(int id, String nome, int senha) {
		super(id, nome, senha);
		playlist = new Playlist();
	}
	
	public void addMusic(Musica musica) {
		playlist.addMusic(musica); 
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	
}
	