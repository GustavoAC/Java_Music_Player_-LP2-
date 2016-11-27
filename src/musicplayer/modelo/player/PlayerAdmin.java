package musicplayer.modelo.player;

import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/* Administrador do player de música 
 * Contém a playlist atual sendo tocada, controla qual a execução atual
 * e o que será feito quando chegar ao fim da mesma.
 */

public class PlayerAdmin {
	private Playlist currPlaylist;
	private MusicPlayer player;
	private int currentMusic;
	private boolean activelyStopped;
	private boolean paused;
	
	// Nenhum construtor é permitido criar um novo usuario ou playlist
	public PlayerAdmin(Playlist currPlaylist) {
		this.currPlaylist = currPlaylist;
		player = new MusicPlayer(new PlaybackListener() {
			@Override
			public void playbackFinished(PlaybackEvent e) {
				if (!activelyStopped) {
					skip();
				}
			}
		});
		currentMusic = 0;
		activelyStopped = false;
	}

	public Playlist getCurrPlaylist() {
		return currPlaylist;
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
	
	public Musica playMusic(String str) {
		int index;
		for (index = 0; index < currPlaylist.getSize(); index++)
			if (currPlaylist.getMusicas().get(index).getFilename().equals(str))
				break;
		
		if (paused)
			pause();
		currentMusic = index;
		paused = false;
		stop();
		Musica mus = currPlaylist.getMusic(currentMusic);
		if (mus == null) return null;

		player.prepare(mus);
		player.play();
		activelyStopped = false;
		return mus;
	}
	
	public Musica playCurrentMusic() {
		if (paused)
			pause();
		stop();
		Musica mus = currPlaylist.getMusic(currentMusic);
		if (mus == null) return null;

		player.prepare(mus);
		player.play();
		activelyStopped = false;
		return mus;
	}
	
	public Musica previous() {
		currentMusic = (currPlaylist.getSize() + currentMusic - 1) % currPlaylist.getSize();
		return playCurrentMusic();

	}
	
	public Musica skip() {
		currentMusic = (currentMusic + 1)%currPlaylist.getSize();
		return playCurrentMusic();
	}
	
	public void pause() {
		if (paused) {
			player.unpause();
			paused = false;
		} else {
			player.pause();
			paused = true;
		}
	}
	
	public void stop() {
		activelyStopped = true;
		player.stop();
	}
}
