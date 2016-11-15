package musicplayer.controle;

import musicplayer.modelo.BancoDeUsuarios;
import musicplayer.modelo.MusicPlayer;
import musicplayer.modelo.Musica;
import musicplayer.modelo.Usuario;
import musicplayer.modelo.UsuarioComum;

public class SysMain {
	private BancoDeUsuarios banco;
	private MusicPlayer mp;
	// Parte gráfica
	
	public static void main(String[] args) {
		Usuario user = new UsuarioComum(12, "fulano", "12345");
		Musica music = new Musica("test.mp3", 120);
		MusicPlayer mplayer = new MusicPlayer(user, user.getCurrentPlaylist());
		mplayer.addMusicToPlaylist(music);
		mplayer.playCurrentMusic();
	}
}
