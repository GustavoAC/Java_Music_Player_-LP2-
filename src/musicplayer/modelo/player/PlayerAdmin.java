package musicplayer.modelo.player;

import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioComum;

public class PlayerAdmin {
	private Usuario user;
	private Playlist currPlaylist;
	private MusicPlayer player;
	private int currentMusic;
	
	// Nenhum construtor é permitido criar um novo usuario ou playlist
	public PlayerAdmin(Usuario user, Playlist currPlaylist) {
		this.user = user;
		this.currPlaylist = currPlaylist;
		currentMusic = 0;
		player = new MusicPlayer();
	}

	public Usuario getUser() {
		return user;
	}

	public Playlist getCurrPlaylist() {
		return currPlaylist;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void setCurrPlaylist(Playlist currPlaylist) {
		this.currPlaylist = currPlaylist;
	}

	public int getCurrentMusic() {
		return currentMusic;
	}

	public void setCurrentMusic(int currentMusic) {
		this.currentMusic = currentMusic;
	}
	
	public void addMusicToPlaylist(Musica music) {
		currPlaylist.addMusic(music);
	}
	
	public void playCurrentMusic() {
		Musica mus = currPlaylist.getMusic(currentMusic);
		if (mus == null) return;
		
		player.prepare(mus);
		player.play();
	}
	
	public void pause() {
		player.pause();
	}
	
	public void unpause() {
		player.play();
	}
	
	public void stop() {
		player.stop();
	}
	// teste
	public static void main(String[] args) throws InterruptedException {
		UsuarioComum uc = new UsuarioComum(10, "asd", "12123");
		Playlist pl = new Playlist();
		pl.addMusic(new Musica("test.mp3", "123"));
		PlayerAdmin pa = new PlayerAdmin(uc, pl);
		pa.playCurrentMusic();
				
		for (int i = 0; i < 20; ++i) {
			Thread.sleep(2000);
			pa.pause();
			Thread.sleep(2000);
			pa.unpause();
		}
		
		pa.stop();
	}
}
