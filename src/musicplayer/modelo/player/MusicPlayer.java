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
	private boolean stopped;
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
	
	public void pause() {
		if (activeThread != null) {
			activeThread.suspend();
			stopped = true;
		}
	}
	
	public void stop() {
		if (advPlayer != null)
			advPlayer.close();
	}
	
	public void play() {
		if (stopped) {
			activeThread.resume();
			stopped = true;
		} else {
			if (activeThread != null && activeThread.isAlive()) {
				advPlayer.stop();
				activeThread.interrupt();
			}
			activeThread = new Thread(this);
			activeThread.setDaemon(true);
			activeThread.start();
		}
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
