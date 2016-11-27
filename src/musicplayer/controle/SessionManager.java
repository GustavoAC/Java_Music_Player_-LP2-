package musicplayer.controle;

import java.util.ArrayList;

import musicplayer.modelo.filemanagement.DirectoryReader;
import musicplayer.modelo.filemanagement.MusicReader;
import musicplayer.modelo.filemanagement.PlaylistReader;
import musicplayer.modelo.filemanagement.UserReader;
import musicplayer.modelo.player.Playlist;
import musicplayer.modelo.users.Usuario;

/*
 * Gerencia a "sess�o" do programa, isto �, mant�m o controle de todas
 * as informa��es j� salvas das execu��es passadas e de escrever novas
 * informa��es da sess�o atual
 * */

public class SessionManager {
	// diretorios.dat
	private DirectoryReader dirReader;
	
	// musicas.dat
	private MusicReader musicReader;
	
	// playlist_xxx.dat
	private PlaylistReader playReader;
	
	// usuarios.dat
	private UserReader userReader;
	
	public SessionManager() {
		dirReader = new DirectoryReader();
		musicReader = new MusicReader();
		playReader = new PlaylistReader();
		userReader = new UserReader();
		setPlaylistsToUsers();
	}
	
	public void setPlaylistsToUsers() {
		playReader.setPlaylistsToUsers(userReader);
	}
	
	public ArrayList<Usuario> getUserList() {
		return userReader.getUsers();
	}
	
	public Playlist getCurrentPlaylist() {
		return musicReader.getPlaylist();
	}
	
	public DirectoryReader getDirReader() {
		return dirReader;
	}

	public MusicReader getMusicReader() {
		return musicReader;
	}

	public PlaylistReader getPlayReader() {
		return playReader;
	}

	public UserReader getUserReader() {
		return userReader;
	}
}
