package musicplayer.modelo.player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;

public class MusicPlayer implements Runnable {
	private AdvancedPlayer advPlayer;
	private Musica currMusic;
	private Thread activeThread;
	private PlaybackListener stopListener;
	
	public MusicPlayer(PlaybackListener listener) {
		stopListener = listener;
	}
	
	public void prepare(Musica mus) {
		currMusic = mus;
		try {
			FileInputStream fis = new FileInputStream(currMusic.getPath());
			advPlayer = new AdvancedPlayer(fis);
			advPlayer.setPlayBackListener(stopListener);
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void pause() {
		if (activeThread != null)
			activeThread.suspend();
	}
	
	@SuppressWarnings("deprecation")
	public void unpause() {
		if (activeThread != null)
			activeThread.resume();
	}
	
	public void stop() {
		if (advPlayer != null)
			advPlayer.close();
	}
	
	public void play() {
		activeThread = new Thread(this);
		activeThread.setDaemon(true);
		activeThread.start();
	}
	
	@Override
	public void run() {
		try {
			advPlayer.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
}
