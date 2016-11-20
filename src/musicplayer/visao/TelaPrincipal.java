package musicplayer.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import musicplayer.controle.ControlePrincipal;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener {
	
	private ControlePrincipal controle;
	
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
	
	public TelaPrincipal(ControlePrincipal controle, int width, int height) {
		this.controle = controle;
		
		this.setJMenuBar(menuBar);
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
		
		rItem1.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setTitle("Music Player");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rItem1) {
			JOptionPane.showConfirmDialog(null, "Somente um teste");
			controle.tocarMusicaSelecionada(0);
		}
	}
	
	public static void main(String[] args) {
		TelaPrincipal tp = new TelaPrincipal(new ControlePrincipal(), 600, 400);
	}
}
