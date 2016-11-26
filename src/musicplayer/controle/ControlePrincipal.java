package musicplayer.controle;

import musicplayer.modelo.users.BancoDeUsuarios;
import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.player.PlayerAdmin;
import musicplayer.modelo.player.Musica;

import java.util.ArrayList;

import musicplayer.controle.SessionManager;
import musicplayer.visao.PainelMusicas;
import musicplayer.visao.PainelPlaylists;
import musicplayer.visao.TelaPrincipal;

public class ControlePrincipal {
	private SessionManager sessionManager;
	private BancoDeUsuarios banco;
	private PlayerAdmin playerAdmin;
	private TelaPrincipal telaPrincipal;
	private Usuario currentUser;
	
	// Parte gráfica
	
	public ControlePrincipal() {
		sessionManager = new SessionManager();
		banco = new BancoDeUsuarios(sessionManager.getUserList());
		playerAdmin = new PlayerAdmin(sessionManager.getCurrentPlaylist());
		telaPrincipal = new TelaPrincipal(this);
	}
	
	public void showLogin() {
		telaPrincipal.showLogin();
	}
	
	public void login(Usuario read) {
		if (read == null)
			showLogin();
		else {
			Usuario realUser = banco.buscar(read.getId());
			if (realUser != null &&
				read.getNome().equals(realUser.getNome()) &&
				read.getSenha().equals(realUser.getSenha())) {
				currentUser = realUser;
				telaPrincipal.loadPlaylists(currentUser);
				telaPrincipal.start();
			} else {
				showLogin();
			}
		}
	}
	
	public BancoDeUsuarios getBanco() {
		return banco;
	}

	public void adicionarMusica(int index) {
		Musica mus = sessionManager.getDirReader().getValidFiles().get(index);
		playerAdmin.addMusicToPlaylist(mus);
		sessionManager.getMusicReader().addMusic(mus);
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
	
	public ArrayList<Musica> adicionarPasta(String path) {
		sessionManager.getDirReader().addDirectory(path);
		return sessionManager.getDirReader().getValidFiles();
	}
	
	public void voltarMusica() {
		playerAdmin.previous();
	}
	
	public void play(int index) {
		playerAdmin.setCurrentMusic(index);
		playerAdmin.playCurrentMusic();
	}
	
	public void pause() {
		playerAdmin.pause();
	}
	
	public void stop() {
		playerAdmin.stop();
	}
	
	public void passarMusica() {
		playerAdmin.skip();
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
		cp.showLogin();
	}

	public void initializePanels(PainelMusicas todasAsMusicas, PainelMusicas musicasPlAtual) {
		todasAsMusicas.list(sessionManager.getDirReader().getValidFiles());
		musicasPlAtual.list(sessionManager.getMusicReader().getPlaylist().getMusicas());
	}
}
