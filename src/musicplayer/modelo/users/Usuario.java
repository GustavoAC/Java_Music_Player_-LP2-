package musicplayer.modelo.users;

import java.lang.Comparable;

import musicplayer.modelo.player.Playlist;

public abstract class Usuario implements Comparable<Usuario> {
	private int id;
	private String nome;
	private String senha;
	
	public Usuario(int id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	
	public int compareTo(Usuario outroUsuario) {
        if (this.id < outroUsuario.id) {
            return -1;
        }
        if (this.id > outroUsuario.id) {
            return 1;
        }
        return 0;
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public abstract Playlist getCurrentPlaylist();
	
}
