package musicplayer.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;


// extends Thread?
public class MusicPlayer {
	private Usuario user;
	private Playlist currPlaylist;
	private int currentMusic;
	private AdvancedPlayer advPlayer;
	
	// Nenhum construtor é permitido criar um novo usuario ou playlist
	public MusicPlayer(Usuario user, Playlist currPlaylist) {
		this.user = user;
		this.currPlaylist = currPlaylist;
		currentMusic = 0;
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
	
	/* Falta:
	 * - Pausar
	 * - Continuar após pausa
	 * - Avançar depois de terminar
	 * (provavelmente mover o index para a classe Playlist)
	 */
	
	public void addMusicToPlaylist(Musica music) {
		currPlaylist.addMusic(music);
	}
	
	// Mostly undone
	public void playCurrentMusic() {
		Musica mus = currPlaylist.getMusic(currentMusic);
		if (mus == null) return;
		
		try {
			FileInputStream fis = new FileInputStream(mus.getPath());
			advPlayer = new AdvancedPlayer(fis);
			advPlayer.play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
