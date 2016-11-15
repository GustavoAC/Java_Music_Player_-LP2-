package modelo;

import java.util.ArrayList;

public class Playlist {
	private ArrayList<Musica> musicas;

	public Playlist(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
	
	public Playlist() {
		musicas = new ArrayList<Musica>();
	}
	
	public void addMusic(Musica musica) {
		musicas.add(musica); 
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
}
