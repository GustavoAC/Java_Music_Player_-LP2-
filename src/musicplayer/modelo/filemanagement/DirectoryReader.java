package musicplayer.modelo.filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import musicplayer.modelo.player.Musica;

public class DirectoryReader {
	private FileManipulator fm;
	private ArrayList<String> directories;
	
	public DirectoryReader() {
		fm = new FileManipulator();
		loadDirectories();
	}
	
	public void loadDirectories() {
		try {
			directories = fm.read("./diretorios.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addDirectory(String path) {
		if (!directories.contains(path)) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(path);
			try {
				fm.write("./diretorios.dat", temp, true);
				directories.add(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeDirectory(String path) {
		if (directories.contains(path)) {
			try {
				fm.write("./diretorios.dat", directories, false);
				directories.remove(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Musica> getValidFiles() {
		ArrayList<Musica> ret = new ArrayList<Musica>();
		for (String path : directories)
			ret.addAll(getValidFiles(path));
		return ret;
	}
	
	private ArrayList<Musica> getValidFiles(String path) {
		ArrayList<Musica> ret = new ArrayList<Musica>();
		ArrayList<File> files = fm.listFiles(path);
		for (File f : files) {
			// Se termina em mp3, adiciona a lista de musicas
			if (f.getName().substring(f.getName().length()-4).equals(".mp3"))
				ret.add(new Musica(f.getAbsolutePath(), f.getName()));
		}
		
		return ret;
	}
}
