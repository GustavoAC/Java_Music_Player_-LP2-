package musicplayer.modelo.filemanagement;

import java.io.IOException;
import java.util.ArrayList;

import musicplayer.modelo.users.Usuario;
import musicplayer.modelo.users.UsuarioVip;
import musicplayer.modelo.users.UsuarioComum;

/* Estrutura do arquivo são vários conjuntos de 4 linhas
 * VIP/Not VIP
 * NOME
 * ID
 * SENHA
 * */

public class UserReader {
	private FileManipulator fm;
	private ArrayList<Usuario> users;
	
	public UserReader() {
		fm = new FileManipulator();
		users = new ArrayList<Usuario>();
		loadUsers();
	}
	
	public ArrayList<Usuario> getUsers() {
		return users;
	}
	
	public void loadUsers() {
		ArrayList<String> temp = null;
		try {
			temp = fm.read("./usuarios.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < temp.size(); i += 4) {
			if (temp.get(i).equals("VIP")) {
				users.add(new UsuarioVip(Integer.parseInt(temp.get(i+1)),
											temp.get(i+2),
											temp.get(i+3)));
			} else {
				users.add(new UsuarioComum(Integer.parseInt(temp.get(i+1)),
						temp.get(i+2),
						temp.get(i+3)));
			}
		}
	}
	
	public void addUsuario(Usuario user) {
		if (!users.contains(user)) {
			ArrayList<String> temp = new ArrayList<String>();
			if (user instanceof UsuarioVip)
				temp.add("VIP");
			else
				temp.add("Not VIP");
			temp.add(String.valueOf(user.getId()));
			temp.add(user.getNome());
			temp.add(user.getSenha());
			try {
				fm.write("./usuarios.dat", temp, true);
				users.add(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeUsuario(Usuario user) {
		if (users.contains(user)) {
			try {
				users.remove(user);
				ArrayList<String> temp = new ArrayList<String>();
				for (Usuario u : users) {
					if (u instanceof UsuarioVip)
						temp.add("VIP");
					else
						temp.add("Not VIP");
					temp.add(String.valueOf(u.getId()));
					temp.add(u.getNome());
					temp.add(u.getSenha());
				}
				fm.write("./usuarios.dat", temp, false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
