package musicplayer.modelo.filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;
import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioComum;
import musicplayer.modelo.users.UsuarioVip;

/* Estrutura do arquivo são vários conjuntos de 2 linhas
 * CAMINHO ABSOLUTO
 * NOME
 * */

public class MusicReader {
	private FileManipulator fm;
	private ArrayList<Musica> playlist;
	
	public MusicReader() {
		fm = new FileManipulator();
		playlist = new ArrayList<Musica>();
		loadMusics();
	}
	
	public void loadMusics() {
		ArrayList<String> temp = null;
		
		try {
			temp = fm.read("./playlist_padrao.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < temp.size(); i += 2) {
			playlist.add(new Musica(temp.get(i), temp.get(i+1)));
		}
	}
	
	public void addMusic(Musica music) {
		if (!playlist.contains(music)) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(music.getPath());
			temp.add(music.getFilename());
			try {
				fm.write("./playlist_padrao.dat", temp, true);
				playlist.add(music);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeMusic(Musica music) {
		if (playlist.contains(music)) {
			try {
				playlist.remove(music);
				ArrayList<String> temp = new ArrayList<String>();
				for (Musica m : playlist) {
					temp.add(m.getPath());
					temp.add(m.getFilename());
				}
				fm.write("./playlist_padrao.dat", temp, false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
