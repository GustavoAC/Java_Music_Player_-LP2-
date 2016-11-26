package musicplayer.visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.player.Musica;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener, KeyListener {
	
	private ControlePrincipal controle;
	
	private PainelMusicas musicasPlAtual;
	private PainelMusicas todasAsMusicas;
	private PainelPlaylists playlists;
	private JLabel nome_usuario = new JLabel("Nome Usuário");
	private JLabel isVip = new JLabel("Vip");
	private JLabel nome_pl = new JLabel("Nome Playlist");
	private JLabel todas = new JLabel("Todas as músicas");
	private JLabel play = new JLabel("Playlists");
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
	private JButton bs = new JButton("Stop");
	private JButton b4 = new JButton("Pause");
	private JButton b5 = new JButton("Post");
	private JButton b6 = new JButton("+ Playlist");
	private JTextField filtrarMusicas = new JTextField();
	private JTextField filtrarPlaylists = new JTextField();
	private JTextField filtrarTodasMusicas = new JTextField();

	public TelaPrincipal(ControlePrincipal controlePrincipal) {
		controle = controlePrincipal;
		musicasPlAtual = new PainelMusicas(controle, 625, 75, 250, 400);
		todasAsMusicas = new PainelMusicas(controle, 25, 325, 550, 150);
		playlists = new PainelPlaylists(controle, null, 325, 75, 250, 175);
		controle.initializePanels(todasAsMusicas, musicasPlAtual);
		
		this.setJMenuBar(menuBar);
		this.setLayout(null);
		
		nome_usuario.setBounds(25,0,250,50);
		nome_usuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		isVip.setBounds(25,25,250,50);
		isVip.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		nome_pl.setBounds(625,0,250,50); 
		nome_pl.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		filtrarMusicas.setBounds(625, 50, 250, 25);
		filtrarMusicas.addKeyListener(this);
		
		todas.setBounds(25,250,250,50); 
 		todas.setFont(new Font("Dialog", Font.PLAIN, 18));
 		
 		filtrarTodasMusicas.setBounds(25, 300, 550, 25);
 		filtrarTodasMusicas.addKeyListener(this);
		
 		play.setBounds(325,0,250,50); 
 		play.setFont(new Font("Dialog", Font.PLAIN, 18));
 		
 		filtrarPlaylists.setBounds(325, 50, 250, 25);
 		filtrarPlaylists.addKeyListener(this);
 		
 		b1.setBounds(25, 500, 90, 25);
 		b2.setBounds(240, 500, 90, 25);
 		b3.setBounds(330, 490, 90, 40);
 		bs.setBounds(420, 490, 60, 40);
 		b4.setBounds(480, 490, 90, 40);
 		b5.setBounds(570, 500, 90, 25);
 		b6.setBounds(785, 500, 90, 25);
 		
 		this.add(b1);
 		this.add(b2);
 		this.add(b3);
 		this.add(bs);
 		this.add(b4);
 		this.add(b5);
 		this.add(b6);
 		this.add(musicasPlAtual);
		this.add(playlists);
		this.add(nome_pl);
		this.add(play);
		this.add(todas);
		this.add(isVip);
		this.add(nome_usuario);
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
		bs.addActionListener(this);
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
		this.setResizable(false);
		this.setTitle("Music Player");
	}

	public void setNome_usuario(JLabel nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public void setIsVip(JLabel isVip) {
		this.isVip = isVip;
	}

	public void setMusicasPlAtual(PainelMusicas musicasPlAtual) {
		this.musicasPlAtual = musicasPlAtual;
	}

	public void setTodasAsMusicas(PainelMusicas todasAsMusicas) {
		this.todasAsMusicas = todasAsMusicas;
	}

	public void setPlaylists(PainelPlaylists playlists) {
		this.playlists = playlists;
	}

	public void start() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rItem1) {
			JOptionPane.showConfirmDialog(null, "Tocando música selecionada");
			controle.play(0);
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
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.showOpenDialog(null);
			if (jfc.getSelectedFile() != null) {
				System.out.println("entrei");
				ArrayList<Musica> musicas = controle.adicionarPasta(jfc.getSelectedFile().getAbsolutePath());
				todasAsMusicas.list(musicas);
			}
			revalidate();
			repaint();
		} else if (e.getSource() == b2) {
			controle.voltarMusica();
		} else if (e.getSource() == b3) {
			controle.play(musicasPlAtual.getSelectedIndex());
		} else if (e.getSource() == b4) {
			controle.pause();
		} else if (e.getSource() == b5) {
			controle.passarMusica();
		} else if (e.getSource() == bs) {
			JOptionPane.showConfirmDialog(null, "Stop");
			controle.stop();
		} else if (e.getSource() == b6) {
			JOptionPane.showConfirmDialog(null, "Nova playlist adicionada");
			controle.adicionarPlaylist(0);;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == filtrarTodasMusicas) {
			JOptionPane.showConfirmDialog(null, "Teste");
			//Alguma função com filtrarTodasMusicas.getText() como argumento
		} else if (e.getSource() == filtrarMusicas) {
			//Alguma função com filtrarMusicas.getText() como argumento
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
