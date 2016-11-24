package musicplayer.controle;

import musicplayer.modelo.filemanagement.DirectoryReader;
import musicplayer.modelo.filemanagement.PlaylistReader;
import musicplayer.modelo.filemanagement.UserReader;

public class SessionManager {
	// diretorios.dat
	private DirectoryReader dirReader;
	
	// musicas.dat
	
	
	// playlist_xxx.dat
	private PlaylistReader playReader;
	
	// usuarios.dat
	private UserReader userReader;
	
	public SessionManager() {
		dirReader = new DirectoryReader();
		
		playReader = new PlaylistReader();
		userReader = new UserReader();
	}
	
	// Fazer função para inicializar os displays da Visao
	
}
