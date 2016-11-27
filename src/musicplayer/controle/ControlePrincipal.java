package musicplayer.controle;

import java.util.ArrayList;

import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.PlayerAdmin;
import musicplayer.modelo.player.Playlist;
import musicplayer.modelo.users.BancoDeUsuarios;
import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioVip;
import musicplayer.visao.PainelMusicas;
import musicplayer.visao.TelaPrincipal;


/*
 * Faz a ligação entre a parte visual, as classes do modelo, e o gerenciador
 * da sessão atual.
 * */

public class ControlePrincipal {
	private SessionManager sessionManager;
	private BancoDeUsuarios banco;
	private PlayerAdmin playerAdmin;
	private TelaPrincipal telaPrincipal;
	private Usuario currentUser;
	
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
				telaPrincipal.getNome_usuario().setText(currentUser.getNome());
				if (currentUser instanceof UsuarioVip) {
					telaPrincipal.getIsVip().setText("VIP");
				} else {
					telaPrincipal.getIsVip().setText("Normal");
				}
				telaPrincipal.start();
			} else {
				showLogin();
			}
		}
	}
	
	public BancoDeUsuarios getBanco() {
		return banco;
	}

	public void adicionarMusica(String str) {
		int index;
		for (index = 0; index < sessionManager.getDirReader().getValidFiles().size(); index++)
			if (sessionManager.getDirReader().getValidFiles().get(index).getFilename().equals(str))
				break;
		
		Musica mus = sessionManager.getDirReader().getValidFiles().get(index);
		// MusicReader e PlayerAdmin compartilham a mesma playlist
		sessionManager.getMusicReader().addMusic(mus);
	}
	
	public ArrayList<Musica> tocarPlaylistSelecionada(String name) {
		Playlist pl = new Playlist();
		ArrayList<Musica> array = null;
		for (Playlist temp : ((UsuarioVip) currentUser).getPlaylists())
			if (temp.getNome().equals(name))
				array = temp.getMusicas();
		
		for (Musica mus : array)
			pl.addMusic(mus);
		sessionManager.getMusicReader().setNewPlaylist(pl);
		playerAdmin.setCurrPlaylist(pl);
		return pl.getMusicas();
	}
	
	public void listarUsuarios() {
		banco.listar();
	}
	
	public int registarUsuario(Usuario usuario) {		
		if (currentUser instanceof UsuarioVip) {
			if (banco.addUsuario(usuario)) {
				sessionManager.getUserReader().addUsuario(usuario);
				return 0;
			} else {
				return 1;
			}
		}
		return 2;
	}
	
	public ArrayList<Musica> adicionarPasta(String path) {
		sessionManager.getDirReader().addDirectory(path);
		return sessionManager.getDirReader().getValidFiles();
	}
	
	public void voltarMusica() {
		Musica m = playerAdmin.previous();
		if (m !=  null) {
			telaPrincipal.getCurrentMusic().setText("Tocando: " + m.getFilename());
		}
	}
	
	public void play(String str) {
		Musica m = playerAdmin.playMusic(str);
		if (m !=  null) {
			telaPrincipal.getCurrentMusic().setText("Tocando: " + m.getFilename());
		}
	}
	
	public void pause() {
		playerAdmin.pause();
	}
	
	public void stop() {
		playerAdmin.stop();
		telaPrincipal.getCurrentMusic().setText("Tocando: ");
	}
	
	
	public void passarMusica() {
		Musica m = playerAdmin.skip();
		if (m !=  null) {
			telaPrincipal.getCurrentMusic().setText("Tocando: " + m.getFilename());
		}
	}
	
	public ArrayList<Playlist> adicionarPlaylist(String name) {
		if (currentUser instanceof UsuarioVip) {
			Playlist pl = new Playlist();
			pl.setNome(name);
			for (Musica mus : playerAdmin.getCurrPlaylist().getMusicas())
				pl.addMusic(mus);
			
			((UsuarioVip) currentUser).addPlaylist(pl);
			sessionManager.getPlayReader().addPlaylist(pl, currentUser);
			return sessionManager.getPlayReader().getPlaylists();
		}
		return null;
	}
	
	public void initializePanels(PainelMusicas todasAsMusicas, PainelMusicas musicasPlAtual) {
		todasAsMusicas.list(sessionManager.getDirReader().getValidFiles());
		musicasPlAtual.list(sessionManager.getMusicReader().getPlaylist().getMusicas());
	}

	public void clearCurrPlaylist() {
		sessionManager.getMusicReader().clear();
	}
	
	public static void main(String[] args) {
		ControlePrincipal cp = new ControlePrincipal();
		cp.showLogin();
	}
}
