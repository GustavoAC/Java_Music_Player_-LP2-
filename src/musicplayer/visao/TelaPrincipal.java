package musicplayer.visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import musicplayer.controle.ControlePrincipal;
import musicplayer.modelo.player.Musica;
import musicplayer.modelo.player.Playlist;
import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioVip;

/* Tela Principal
 * Cont�m e controla o comportamento de todos os elementos que
 * s�o exibidos na tela principal do programa
 * */

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener, KeyListener {
	
	private ControlePrincipal controle;
	
	private PainelMusicas musicasPlAtual;
	private PainelMusicas todasAsMusicas;
	private PainelPlaylists playlists;
	private TelaLogin telaLogin;
	
	private JLabel nome_usuario = new JLabel("");
	private JLabel isVip = new JLabel("");
	private JLabel currentMusicLabel = new JLabel("");
	private JLabel nome_pl = new JLabel("Playlist Atual");
	private JLabel todas = new JLabel("Todas as m�sicas");
	private JLabel play = new JLabel("Playlists");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu reproducaoMenu = new JMenu("Reprodu��o");
	private JMenu userMenu = new JMenu("Usu�rios");
	private JMenuItem rItem1 = new JMenuItem("Limpar Playlist Atual");
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
		
		MouseListener todasListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				@SuppressWarnings("unchecked")
				JList<String> theList = (JList<String>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String str = theList.getSelectedValue();
						musicasPlAtual.addMusic(str);
						controle.adicionarMusica(str);
					}
				}
			}
		};
		
		MouseListener atualListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				@SuppressWarnings("unchecked")
				JList<String> theList = (JList<String>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String str = theList.getSelectedValue();
						controle.play(str);
					}
				}
			}
		};
		
		MouseListener playlistListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				@SuppressWarnings("unchecked")
				JList<String> theList = (JList<String>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String name = theList.getSelectedValue();
						musicasPlAtual.list(controle.tocarPlaylistSelecionada(name));
						revalidate();
						repaint();
					}
				}
			}
		};
		
		musicasPlAtual = new PainelMusicas(625, 75, 250, 400, atualListener);
		todasAsMusicas = new PainelMusicas(25, 325, 550, 150, todasListener);
		playlists = new PainelPlaylists(325, 75, 250, 175, playlistListener);
		controle.initializePanels(todasAsMusicas, musicasPlAtual);
		
		this.setJMenuBar(menuBar);
		this.setLayout(null);
		
		nome_usuario.setBounds(25,0,250,50);
		nome_usuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		isVip.setBounds(25,25,250,50);
		isVip.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		currentMusicLabel.setBounds(25,50,250,50);
		currentMusicLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		
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
		this.add(currentMusicLabel);
		this.add(nome_usuario);
		this.add(todasAsMusicas);
		this.add(filtrarMusicas);
		this.add(filtrarTodasMusicas);
		this.add(filtrarPlaylists);
		menuBar.add(reproducaoMenu);
		reproducaoMenu.add(rItem1);
		
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
		uItem1.addActionListener(this);
		uItem2.addActionListener(this);
		uItem3.addActionListener(this);
		uItem4.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setResizable(false);
		this.setTitle("Music Player");
	}
	
	
	
	public JLabel getNome_usuario() {
		return nome_usuario;
	}



	public JLabel getIsVip() {
		return isVip;
	}



	public JLabel getCurrentMusic() {
		return currentMusicLabel;
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
			controle.clearCurrPlaylist();
			musicasPlAtual.clear();
			revalidate();
			repaint();
		} else if (e.getSource() == uItem1) {
			controle.listarUsuarios();
		} else if (e.getSource() == uItem2) {
			controle.showLogin();
		} else if (e.getSource() == uItem3) {
			telaLogin = new TelaLogin("Registrar usu�rio comum", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int control = controle.registarUsuario(telaLogin.createUser(false));
					telaLogin.close();
					if (control == 0)
						JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
					else if (control == 1)
						JOptionPane.showMessageDialog(null, "Falha no cadastro, existem dados em conflito");
					else
						JOptionPane.showMessageDialog(null, "Somente usuarios VIP podem cadastrar usuarios");
				}
			});
		} else if (e.getSource() == uItem4) {
			telaLogin = new TelaLogin("Registrar usu�rio VIP", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int control = controle.registarUsuario(telaLogin.createUser(true));
					telaLogin.close();
					if (control == 0)
						JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
					else if (control == 1)
						JOptionPane.showMessageDialog(null, "Falha no cadastro, existem dados em conflito");
					else
						JOptionPane.showMessageDialog(null, "Somente usuarios VIP podem cadastrar usuarios");
				}
			});
		} else if (e.getSource() == b1) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.showOpenDialog(null);
			if (jfc.getSelectedFile() != null) {
				ArrayList<Musica> musicas = controle.adicionarPasta(jfc.getSelectedFile().getAbsolutePath());
				todasAsMusicas.list(musicas);
			}
			revalidate();
			repaint();
		} else if (e.getSource() == b2) {
			controle.voltarMusica();
		} else if (e.getSource() == b3) {
			controle.play(musicasPlAtual.getSelectedName());
		} else if (e.getSource() == b4) {
			controle.pause();
		} else if (e.getSource() == b5) {
			controle.passarMusica();
		} else if (e.getSource() == bs) {
			controle.stop();
		} else if (e.getSource() == b6) {
			String name = JOptionPane.showInputDialog("Nome da playlist");
			ArrayList<Playlist> apl = controle.adicionarPlaylist(name);
			if (apl != null) {
				playlists.list(apl);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(null, "Somente usu�rios VIP podem criar playlists.");
			}
		}
	}
	
	public void loadPlaylists(Usuario currentUser) {
		if (currentUser instanceof UsuarioVip) {
			playlists.list(((UsuarioVip) currentUser).getPlaylists());
		}
	}
	
	public void showLogin() {
		telaLogin = new TelaLogin("Login", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario user = telaLogin.createUser(false);
				telaLogin.close();
				controle.login(user);
			}
		});
	}

	public Usuario login() {
		if (telaLogin != null)
			return telaLogin.createUser(false);
		else
			return null;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == filtrarTodasMusicas) {
			todasAsMusicas.update(filtrarTodasMusicas.getText());
			revalidate();
			repaint();
		} else if (e.getSource() == filtrarMusicas) {
			musicasPlAtual.update(filtrarMusicas.getText());
			revalidate();
			repaint();
		} else if (e.getSource() == filtrarPlaylists) {
			playlists.update(filtrarPlaylists.getText());
			revalidate();
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
