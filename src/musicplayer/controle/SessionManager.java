package musicplayer.controle;

import java.util.ArrayList;

import musicplayer.modelo.filemanagement.DirectoryReader;
import musicplayer.modelo.filemanagement.MusicReader;
import musicplayer.modelo.filemanagement.PlaylistReader;
import musicplayer.modelo.filemanagement.UserReader;
import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;
import musicplayer.visao.PainelMusicas;
import musicplayer.visao.PainelPlaylists;
import musicplayer.visao.TelaPrincipal;

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
	}
	
	// Fazer função para inicializar os displays da Visao
	public void inicializar(TelaPrincipal tp) {
		iniAllMusic(tp);
		iniPlaylists(tp);
		iniPlaylistAtual(tp);
	}
	
	private void iniAllMusic(TelaPrincipal tp) {
		ArrayList<Musica> m = dirReader.getValidFiles();
		Playlist pl = new Playlist();
		for (Musica musica : m) {
			pl.addMusic(musica);
		}
		tp.setTodasAsMusicas(new PainelMusicas(new ControlePrincipal(), pl, 550, 150, 25, 325));
	}
	
	private void iniPlaylists(TelaPrincipal tp) {
		ArrayList<Playlist> p = playReader.getPlaylists();
		tp.setPlaylists(new PainelPlaylists(new ControlePrincipal(), p, 250, 175, 325, 75));
	}
	
	private void iniPlaylistAtual(TelaPrincipal tp) {
		ArrayList<Musica> m = musicReader.getPlaylist();
		Playlist pl = new Playlist();
		for (Musica musica : m) {
			pl.addMusic(musica);
		}
		tp.setMusicasPlAtual(new PainelMusicas(new ControlePrincipal(), pl, 250, 400, 625, 75));
		
	}
}
