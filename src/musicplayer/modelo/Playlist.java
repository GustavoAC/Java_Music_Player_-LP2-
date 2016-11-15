package musicplayer.modelo;

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

	public Musica getMusic(int index) {
		if (index < 0 || index > musicas.size())
			return null;
		return musicas.get(index);
	}
	
	public void removeMusica(int index) {
		musicas.remove(index);
	}
	
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
}
