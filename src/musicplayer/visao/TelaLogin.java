package musicplayer.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TelaLogin extends JFrame implements ActionListener {
	private JLabel nome = new JLabel ("Nome:  ");
	private JLabel id = new JLabel   ("ID:    ");
	private JLabel senha = new JLabel("Senha: ");
	JTextField tnome = new JTextField();
	JTextField tid = new JTextField();
	JTextField tsenha = new JTextField();
	JButton b1 = new JButton("Submeter");
	
	public TelaLogin () {
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
		
		b1.addActionListener(this);
		
		this.setSize(280,200);
		this.setTitle("Login");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
		}
	}
	
	public static void main(String[] args) {
		
		TelaLogin mt = new TelaLogin();
	
	}
}
