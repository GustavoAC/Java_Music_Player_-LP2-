package musicplayer.modelo.player;

import java.util.ArrayList;

public class Playlist {
	private String nome; 
	private ArrayList<Musica> musicas;

	public Playlist(String nome, ArrayList<Musica> musicas) {
		this.nome = nome;
		this.musicas = musicas;
	}
	
	public Playlist() {
		nome = "Default";
		musicas = new ArrayList<Musica>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addMusic(Musica musica) {
		musicas.add(musica); 
	}

	public boolean contains(Musica mus) {
		return musicas.contains(mus);
	}
	
	public Musica getMusic(int index) {
		if (index < 0 || index >= musicas.size())
			return musicas.get(0);
		return musicas.get(index);
	}
	
	public void removeMusica(int index) {
		musicas.remove(index);
	}
	
	public void removeMusica(Musica mus) {
		musicas.remove(mus);
	}
	
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
	
	public int getSize() {
		return this.musicas.size();
	}
}
