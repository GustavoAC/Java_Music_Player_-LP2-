package musicplayer.controle;

import java.util.ArrayList;

import musicplayer.modelo.filemanagement.DirectoryReader;
import musicplayer.modelo.filemanagement.MusicReader;
import musicplayer.modelo.filemanagement.PlaylistReader;
import musicplayer.modelo.filemanagement.UserReader;
import musicplayer.modelo.player.Playlist;
import musicplayer.modelo.users.Usuario;

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

/*
	// Fazer função para inicializar os displays da Visao
	public void inicializar(TelaPrincipal tp, ControlePrincipal cp) {
		iniAllMusic(tp);
		iniPlaylists(tp);
		iniPlaylistAtual(tp);
		iniUserReader(cp);
	}
	

	private void iniAllMusic(TelaPrincipal tp) {
		ArrayList<Musica> m = dirReader.getValidFiles();
		Playlist pl = new Playlist();
		for (Musica musica : m)
			pl.addMusic(musica);
		tp.setTodasAsMusicas(new PainelMusicas(new ControlePrincipal(), pl, 550, 150, 25, 325));
	}
	
	private void iniPlaylists(TelaPrincipal tp) {
		ArrayList<Playlist> p = playReader.getPlaylists();
		tp.setPlaylists(new PainelPlaylists(new ControlePrincipal(), p, 250, 175, 325, 75));
	}
	
	private void iniPlaylistAtual(TelaPrincipal tp) {
		Playlist pl = musicReader.getPlaylist();
		tp.setMusicasPlAtual(new PainelMusicas(new ControlePrincipal(), pl, 250, 400, 625, 75));
		
	}
	
	private void iniUserReader(ControlePrincipal cp) {
		ArrayList<Usuario> u = userReader.getUsers();
		for (Usuario usuario : u) {
			boolean isVip = false;
			if (usuario instanceof UsuarioVip) {
				isVip = true;
			}
			cp.getBanco().addUsuario(usuario.getId(), usuario.getNome(), usuario.getSenha(), isVip);
		}
	}
*/
}
