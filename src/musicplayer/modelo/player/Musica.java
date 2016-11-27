package musicplayer.modelo.player;

/* 
 * Classe que representa uma m�sica. 
 * Cont�m o caminho absoluto e o nome do arquivo da m�sica
 * */

public class Musica {
	private String absPath;
	private String filename;
	
	public Musica(String path, String filename) {
		this.absPath = path;
		this.setFilename(filename);
	}

	public String getPath() {
		return absPath;
	}

	public void setPath(String path) {
		this.absPath = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
