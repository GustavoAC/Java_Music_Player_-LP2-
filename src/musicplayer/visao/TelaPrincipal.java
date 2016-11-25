package musicplayer.visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import musicplayer.controle.ControlePrincipal;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener {
	
	private ControlePrincipal controle;
	
	private PainelMusicas musicasPlAtual;
	private PainelMusicas todasAsMusicas;
	private PainelPlaylists playlists;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu reproducaoMenu = new JMenu("Reprodução");
	private JMenu userMenu = new JMenu("Usuários");
	private JMenuItem rItem1 = new JMenuItem("Tocar música selecionada");
	private JMenuItem rItem2 = new JMenuItem("Adicionar Música");
	private JMenuItem rItem3 = new JMenuItem("Tocar Playlist selecionada");
	private JMenuItem rItem4 = new JMenuItem("Salvar Playlist Atual");
	private JMenuItem uItem1 = new JMenuItem("Listar Usuarios");
	private JMenuItem uItem2 = new JMenuItem("Login");
	private JMenuItem uItem3 = new JMenuItem("Registrar Usuario Comum");
	private JMenuItem uItem4 = new JMenuItem("Registar VIP");
	private JButton b1 = new JButton("+ Pasta");
	private JButton b2 = new JButton("Prev");
	private JButton b3 = new JButton("Play");
	private JButton b4 = new JButton("Pause");
	private JButton b5 = new JButton("Post");
	private JButton b6 = new JButton("+ Playlist");
	private JTextField filtrarMusicas = new JTextField();
	private JTextField filtrarPlaylists = new JTextField();
	private JTextField filtrarTodasMusicas = new JTextField();
	
	

	public void setMusicasPlAtual(PainelMusicas musicasPlAtual) {
		this.musicasPlAtual = musicasPlAtual;
	}

	public void setTodasAsMusicas(PainelMusicas todasAsMusicas) {
		this.todasAsMusicas = todasAsMusicas;
	}

	public void setPlaylists(PainelPlaylists playlists) {
		this.playlists = playlists;
	}

	public void iniciar(ControlePrincipal controle) {
		this.controle = controle;
		this.setJMenuBar(menuBar);
		this.setLayout(null);
		
		JLabel nome_pl = new JLabel("Nome Playlist");
		nome_pl.setBounds(625,0,250,50); 
		nome_pl.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		filtrarMusicas.setBounds(625, 50, 250, 25);
		filtrarMusicas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				JOptionPane.showConfirmDialog(null, "Teste");
				//Alguma função com filtrarMusicas.getText() como argumento
			}
		});
		
		JLabel todas = new JLabel("Todas as músicas");
 		todas.setBounds(25,250,250,50); 
 		todas.setFont(new Font("Dialog", Font.PLAIN, 18));
 		
 		filtrarTodasMusicas.setBounds(25, 300, 550, 25);
 		filtrarTodasMusicas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				JOptionPane.showConfirmDialog(null, "Teste");
				//Alguma função com filtrarMusicas.getText() como argumento
			}
		});
		
		JLabel play = new JLabel("Playlists");
 		play.setBounds(325,0,250,50); 
 		play.setFont(new Font("Dialog", Font.PLAIN, 18));
 		
 		filtrarPlaylists.setBounds(325, 50, 250, 25);
 		filtrarPlaylists.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				JOptionPane.showConfirmDialog(null, "Teste");
				//Alguma função com filtrarMusicas.getText() como argumento
			}
		});
 		
		
 		b1.setBounds(25, 500, 90, 25);
 		b2.setBounds(270, 500, 90, 25);
 		b3.setBounds(360, 490, 90, 40);
 		b4.setBounds(450, 490, 90, 40);
 		b5.setBounds(540, 500, 90, 25);
 		b6.setBounds(785, 500, 90, 25);
 		
 		this.add(b1);
 		this.add(b2);
 		this.add(b3);
 		this.add(b4);
 		this.add(b5);
 		this.add(b6);
 		this.add(musicasPlAtual);
		this.add(playlists);
		this.add(nome_pl);
		this.add(play);
		this.add(todas);
		this.add(todasAsMusicas);
		this.add(filtrarMusicas);
		this.add(filtrarTodasMusicas);
		this.add(filtrarPlaylists);
		menuBar.add(reproducaoMenu);
		reproducaoMenu.add(rItem1);
		reproducaoMenu.add(rItem2);
		reproducaoMenu.addSeparator();
		reproducaoMenu.add(rItem3);
		reproducaoMenu.add(rItem4);
		
		menuBar.add(userMenu);
		userMenu.add(uItem1);
		userMenu.add(uItem2);
		userMenu.addSeparator();
		userMenu.add(uItem3);
		userMenu.add(uItem4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		rItem1.addActionListener(this);
		rItem2.addActionListener(this);
		rItem3.addActionListener(this);
		rItem4.addActionListener(this);
		uItem1.addActionListener(this);
		uItem2.addActionListener(this);
		uItem3.addActionListener(this);
		uItem4.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setTitle("Music Player");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rItem1) {
			JOptionPane.showConfirmDialog(null, "Tocando música selecionada");
			controle.tocarMusicaSelecionada(0);
		} else if (e.getSource() == rItem2) {
			JOptionPane.showConfirmDialog(null, "Música adicionada");
			controle.adicionarMusica(0);
		} else if (e.getSource() == rItem3) {
			JOptionPane.showConfirmDialog(null, "Tocando Playlist selecionada");
			controle.tocarPlaylistSelecionada(0);
		} else if (e.getSource() == rItem4) {
			JOptionPane.showConfirmDialog(null, "Playlist Atual salva");
			controle.salvarPlaylistAtual(0);
		} else if (e.getSource() == uItem1) {
			JOptionPane.showConfirmDialog(null, "Usuarios listados");
			controle.listarUsuarios(0);
		} else if (e.getSource() == uItem2) {
			JOptionPane.showConfirmDialog(null, "Login feito com sucesso");
			controle.logar(0);
		} else if (e.getSource() == uItem3) {
			JOptionPane.showConfirmDialog(null, "Usuario Comum registrado");
			controle.registarUsuarioComum(0);
		} else if (e.getSource() == uItem4) {
			JOptionPane.showConfirmDialog(null, "Usuario VIP registrado");
			controle.registarUsuarioVIP(0);
		} else if (e.getSource() == b1) {
			JOptionPane.showConfirmDialog(null, "Nova pasta adicionada");
			controle.adicionarPasta(0);;
		} else if (e.getSource() == b2) {
			JOptionPane.showConfirmDialog(null, "Voltar musica");
			controle.voltarMusica(0);
		} else if (e.getSource() == b3) {
			JOptionPane.showConfirmDialog(null, "Play");
			controle.play(0);
		} else if (e.getSource() == b4) {
			JOptionPane.showConfirmDialog(null, "Pause");
			controle.pause(0);
		} else if (e.getSource() == b5) {
			JOptionPane.showConfirmDialog(null, "Passar música");
			controle.passarMusica(0);
		} else if (e.getSource() == b6) {
			JOptionPane.showConfirmDialog(null, "Nova playlist adicionada");
			controle.adicionarPlaylist(0);;
		}
	}
	
	public static void main(String[] args) {
		TelaPrincipal tp = new TelaPrincipal();
		tp.iniciar(new ControlePrincipal());
	}
}
