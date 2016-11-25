package musicplayer.controle;

import java.io.IOException;

import musicplayer.modelo.users.BancoDeUsuarios;
import musicplayer.modelo.player.MusicPlayer;
import musicplayer.controle.SessionManager;
import musicplayer.visao.TelaPrincipal;

public class ControlePrincipal {
	private BancoDeUsuarios banco;
	private MusicPlayer mp;
	private TelaPrincipal telaPrincipal;
	private SessionManager sessionManager;
	
	// Parte gráfica
	
	public ControlePrincipal() {
		sessionManager = new SessionManager();
		banco = new BancoDeUsuarios(sessionManager.getUserList());
	}
	
	public void start() {
		
	}
	
	public void tocarMusicaSelecionada(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarMusica(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void tocarPlaylistSelecionada(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void salvarPlaylistAtual(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void listarUsuarios(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void logar(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void registarUsuarioComum(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void registarUsuarioVIP(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarPasta(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void voltarMusica(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void play(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void pause(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void passarMusica(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarPlaylist(int index) {
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
		cp.start();
	}
}
