package musicplayer.controle;

import musicplayer.modelo.BancoDeUsuarios;
import musicplayer.modelo.MusicPlayer;
import musicplayer.modelo.Musica;
import musicplayer.modelo.Usuario;
import musicplayer.modelo.UsuarioComum;
import musicplayer.visao.TelaPrincipal;

public class ControlePrincipal {
	private BancoDeUsuarios banco;
	private MusicPlayer mp;
	// Parte gráfica
	
	public void tocarMusicaSelecionada(int index) {
		// TODO Auto-generated method stub
		
	}
	
	/* Teste do player
	public static void main(String[] args) {
		Usuario user = new UsuarioComum(12, "fulano", "12345");
		Musica music = new Musica("test.mp3", 120);
		MusicPlayer mplayer = new MusicPlayer(user, user.getCurrentPlaylist());
		mplayer.addMusicToPlaylist(music);
		mplayer.playCurrentMusic();
	}
	*/
	
	// Teste Visao
	public static void main(String[] args) {
		ControlePrincipal cp = new ControlePrincipal();
		TelaPrincipal tp = new TelaPrincipal(cp, 500, 300);
	}

	
}
