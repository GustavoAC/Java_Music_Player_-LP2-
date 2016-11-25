package musicplayer.controle;

import musicplayer.modelo.users.BancoDeUsuarios;
import musicplayer.modelo.player.PlayerAdmin;
import musicplayer.controle.SessionManager;
import musicplayer.visao.TelaPrincipal;

public class ControlePrincipal {
	private SessionManager sessionManager;
	private BancoDeUsuarios banco;
	private PlayerAdmin mp;
	private TelaPrincipal telaPrincipal;
	
	
	// Parte gráfica
	
	public ControlePrincipal() {
		sessionManager = new SessionManager();
		banco = new BancoDeUsuarios(sessionManager.getUserList());
		mp = new PlayerAdmin(sessionManager.getCurrentPlaylist());
		telaPrincipal = new TelaPrincipal(this);
	}
	
	public void start() {
		// login aqui
		telaPrincipal.start();
	}	
	
	public BancoDeUsuarios getBanco() {
		return banco;
	}
	
	public void tocarMusicaSelecionada(int index) {
		// TODO Auto-generated method stub	
	}

	public void adicionarMusica(int index) {
		
		
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
