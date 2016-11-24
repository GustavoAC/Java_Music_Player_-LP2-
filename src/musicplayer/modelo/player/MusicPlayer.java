package musicplayer.modelo.player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicPlayer implements Runnable {
	private AdvancedPlayer advPlayer;
	private Musica currMusic;
	private Thread activeThread;
	private boolean stopped;
	
	
	public void prepare(Musica mus) {
		currMusic = mus;
		try {
			FileInputStream fis = new FileInputStream(currMusic.getPath());
			advPlayer = new AdvancedPlayer(fis);
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public void pause() {
		activeThread.suspend();
		stopped = true;
	}
	
	public void stop() {
		advPlayer.close();
	}
	
	public void play() {
		if (stopped) {
			activeThread.resume();
			stopped = true;
		} else {
			if (activeThread != null && activeThread.isAlive())
				activeThread.interrupt();		
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
