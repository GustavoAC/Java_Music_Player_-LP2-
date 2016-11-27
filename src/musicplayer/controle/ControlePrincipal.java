package musicplayer.controle;

import musicplayer.modelo.users.BancoDeUsuarios;
import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioComum;
import musicplayer.modelo.users.UsuarioVip;
import musicplayer.modelo.player.PlayerAdmin;
import musicplayer.modelo.player.Musica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

	public void adicionarMusica(int index) {
		Musica mus = sessionManager.getDirReader().getValidFiles().get(index);
		sessionManager.getMusicReader().addMusic(mus);
		// MusicReader e PlayerAdmin compartilham o mesmo Array de músicas
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
	
	public void registarUsuarioComum() {
		JFrame frame = new JFrame();
		JLabel nome = new JLabel ("Nome:  ");
		JLabel id = new JLabel   ("ID:    ");
		JLabel senha = new JLabel("Senha: ");
		JTextField tnome = new JTextField();
		JTextField tid = new JTextField();
		JPasswordField tsenha = new JPasswordField();
		JButton b1 = new JButton("Submeter");
		
		frame.setLayout(null);
		
		nome.setBounds(10,10,100,30);
		tnome.setBounds(55,10,200,25);
		id.setBounds(10,40,100,30);
		tid.setBounds(55,40,200,25);
		senha.setBounds(10,70,100,30);
		tsenha.setBounds(55,70,200,25);
		b1.setBounds(90,110,100,30);
		
		frame.add(nome);
		frame.add(tnome);
		frame.add(id);
		frame.add(tid);
		frame.add(senha);
		frame.add(tsenha);
		frame.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioComum u = new UsuarioComum(Integer.parseInt(tid.getText()), tnome.getText(), tsenha.getText());
				boolean r = sessionManager.getUserReader().addUsuario(u);
				if (r) {
					JOptionPane.showConfirmDialog(null, "Usuario Comum registrado");
				} else {
					JOptionPane.showConfirmDialog(null, "Usuario Comum não registrado");
				}
			}
		});
		
		frame.setSize(280,200);
		frame.setResizable(false);
		frame.setTitle("Cadastro Usuario Comum");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void registarUsuarioVIP() {
		JFrame frame = new JFrame();
		JLabel nome = new JLabel ("Nome:  ");
		JLabel id = new JLabel   ("ID:    ");
		JLabel senha = new JLabel("Senha: ");
		JTextField tnome = new JTextField();
		JTextField tid = new JTextField();
		JPasswordField tsenha = new JPasswordField();
		JButton b1 = new JButton("Submeter");
		
		frame.setLayout(null);
		
		nome.setBounds(10,10,100,30);
		tnome.setBounds(55,10,200,25);
		id.setBounds(10,40,100,30);
		tid.setBounds(55,40,200,25);
		senha.setBounds(10,70,100,30);
		tsenha.setBounds(55,70,200,25);
		b1.setBounds(90,110,100,30);
		
		frame.add(nome);
		frame.add(tnome);
		frame.add(id);
		frame.add(tid);
		frame.add(senha);
		frame.add(tsenha);
		frame.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioVip u = new UsuarioVip(Integer.parseInt(tid.getText()), tnome.getText(), tsenha.getText());
				boolean r = sessionManager.getUserReader().addUsuario(u);
				if (r) {
					JOptionPane.showConfirmDialog(null, "Usuario Vip registrado");
				} else {
					JOptionPane.showConfirmDialog(null, "Usuario Vip não registrado");
				}
			}
		});
		
		frame.setSize(280,200);
		frame.setResizable(false);
		frame.setTitle("Cadastro Usuario Vip");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public ArrayList<Musica> adicionarPasta(String path) {
		sessionManager.getDirReader().addDirectory(path);
		return sessionManager.getDirReader().getValidFiles();
	}
	
	public void voltarMusica() {
		playerAdmin.previous();
	}
	
	public void play(int index) {
		Musica m = playerAdmin.playMusic(index);
		if (m !=  null) {
			telaPrincipal.getCurrentMusic().setText("Tocando: " + m.getFilename());
		}
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
