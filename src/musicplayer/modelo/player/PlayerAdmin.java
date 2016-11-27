package musicplayer.modelo.player;

import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

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
	
	public void playMusic(int index) {
		if (paused && index == currentMusic)
			unpause();
		else {
			if (paused)
				unpause();
			currentMusic = index;
			paused = false;
			stop();
			Musica mus = currPlaylist.getMusic(currentMusic);
			if (mus == null) return;
	
			player.prepare(mus);
			player.play();
			activelyStopped = false;
		}
	}
	
	public void playCurrentMusic() {
		if (paused)
			unpause();
		else {
			stop();
			Musica mus = currPlaylist.getMusic(currentMusic);
			if (mus == null) return;
	
			player.prepare(mus);
			player.play();
			activelyStopped = false;
		}
	}
	
	public void previous() {
		currentMusic = (currPlaylist.getSize() + currentMusic - 1) % currPlaylist.getSize();
		playCurrentMusic();
	}
	
	public void skip() {
		currentMusic = (currentMusic + 1)%currPlaylist.getSize();
		playCurrentMusic();
	}
	
	public void pause() {
		player.pause();
		paused = true;
	}
	
	public void unpause() {
		paused = false;
		player.unpause();
	}
	
	public void stop() {
		activelyStopped = true;
		player.stop();
	}
}
