package musicplayer.modelo.filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;
import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioVip;

/*
 * Classe que lê e escreve playlists criadas pelos usuarios
 * */

/* Estrutura dos arquivos
 * NOMEDOUSUARIODONO - IDDOUSUARIODONO
 * NOMEDAPLAYLIST
 * ABSPATH
 * FILENAME
 * */

public class PlaylistReader {
	private FileManipulator fm;
	private ArrayList<String> ownerData;
	private ArrayList<Playlist> playlists;
	private HashMap<String, Integer> playlistNumber;
	private int playlistCounter = 0;
	
	public PlaylistReader() {
		fm = new FileManipulator();
		ownerData = new ArrayList<String>();
		playlists = new ArrayList<Playlist>();
		playlistNumber = new HashMap<String, Integer>();
		
		loadPlaylists();
	}
	
	public void loadPlaylists() {
		ArrayList<File> temp = fm.listFiles("./playlists/");
		for (File f : temp)
			loadPlaylist(f);
	}
	
	private void loadPlaylist(File f) {
		ArrayList<String> read = null;
		try {
			read = fm.read(f.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int playlistCode = Integer.parseInt(f.getName().substring(f.getName().length()-6, f.getName().length()-3));
		if (playlistCode >= playlistCounter)
			playlistCounter = playlistCode + 1;
		
		
		Playlist pl = new Playlist();
		ownerData.add(read.get(0));
		pl.setNome(read.get(1));
		for (int i = 2; i < read.size(); i += 2)
			pl.addMusic(new Musica(read.get(i), read.get(i+1)));
		
		playlistNumber.put(pl.getNome(), playlistCode);
		playlists.add(pl);
	}
	
	public void addPlaylist(Playlist pl, Usuario owner) {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(owner.getNome() + " - " + owner.getId());
		temp.add(pl.getNome());
		ArrayList<Musica> musicas = pl.getMusicas();
		for (Musica m : musicas) {
			temp.add(m.getPath());
			temp.add(m.getFilename());
		}
		
		int number;
		if (playlistNumber.containsKey(pl.getNome())) {
			for (Playlist tempPl : playlists) {
				if (tempPl.getNome().equals(pl.getNome())) {
					playlists.remove(tempPl);
					playlists.add(pl);
					break;
				}
			}
			number = playlistNumber.get(pl.getNome());
		} else {
			playlists.add(pl);
			ownerData.add(owner.getNome() + " - " + owner.getId());
			number = playlistCounter++;
		}
		try {
			fm.write("./playlists/" + String.format("%03d", number) + ".pl", temp, false);
			playlistNumber.put(pl.getNome(), number);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylistsToUsers(UserReader userReader) {
		ArrayList<Usuario> users = userReader.getUsers();
		UsuarioVip temp = null;
		for (Usuario user : users) {
			if (user instanceof UsuarioVip) {
				temp = (UsuarioVip) user;
				for (int i = 0; i < playlists.size(); i++)
					if (ownerData.get(i).equals(user.getNome() + " - " + user.getId()))
						temp.addPlaylist(playlists.get(i));
			}
		}
	}	
}
