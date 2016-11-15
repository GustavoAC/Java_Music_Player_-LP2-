package modelo;

public class Musica {
	private String path;
	private int duracao;
	
	public Musica(String path, int duracao) {
		this.path = path;
		this.duracao = duracao;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
