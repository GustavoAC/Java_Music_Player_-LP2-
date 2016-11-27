package musicplayer.visao;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioComum;
import musicplayer.modelo.users.UsuarioVip;


@SuppressWarnings("serial")
public class TelaLogin extends JFrame {
	private JLabel nome = new JLabel ("Nome:  ");
	private JLabel id = new JLabel   ("ID:    ");
	private JLabel senha = new JLabel("Senha: ");
	private JTextField tnome = new JTextField();
	private JTextField tid = new JTextField();
	private JPasswordField tsenha = new JPasswordField();
	private JButton b1 = new JButton("Submeter");
	
	public TelaLogin (String title, ActionListener listener) {
		this.setLayout(null);
		
		nome.setBounds(10,10,100,30);
		tnome.setBounds(55,10,200,25);
		id.setBounds(10,40,100,30);
		tid.setBounds(55,40,200,25);
		senha.setBounds(10,70,100,30);
		tsenha.setBounds(55,70,200,25);
		b1.setBounds(90,110,100,30);
		
		this.add(nome);
		this.add(tnome);
		this.add(id);
		this.add(tid);
		this.add(senha);
		this.add(tsenha);
		this.add(b1);
		
		b1.addActionListener(listener);
		
		this.setSize(280,200);
		this.setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public Usuario createUser(boolean isVip) {
		int userId;
		try {
			userId = Integer.parseInt(tid.getText());
		} catch (Exception e) {
			return null;
		}
		
		if (isVip)
			return new UsuarioVip(userId, tnome.getText(), tsenha.getText());
		else
			return new UsuarioComum(userId, tnome.getText(), tsenha.getText());
	}
	
	public int getUserId() {
		try {
			return Integer.parseInt(tid.getText());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void close() {
		this.dispose();
	}
}
