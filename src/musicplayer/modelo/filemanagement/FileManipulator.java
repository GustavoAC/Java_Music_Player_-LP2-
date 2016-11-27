package musicplayer.modelo.filemanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/*
 * Classe para realizar leitura e escrita de arquivo simples
 * */
public class FileManipulator {
	
	public void write(String path, ArrayList<String> list, boolean append) throws IOException {
		File arquivo = new File(path);
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		//O true como argumento significa que a escrita
		//será feita no final do arquivo
		FileWriter fw = new FileWriter(arquivo, append);
		BufferedWriter bw = new BufferedWriter(fw);
		for (String s : list) {
			bw.write(s);
			bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	public ArrayList<String> read(String path) throws IOException {
		File arquivo = new File(path);
		ArrayList<String> ret = new ArrayList<String>();
		if (arquivo.exists()) {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				ret.add(br.readLine());
			}
			br.close();
			fr.close();
		} else {
			// Só será o caso no primeiro load de cada um dos managers
			arquivo.createNewFile();
		}
		
		return ret;
	}
	public ArrayList<File> listFiles (String path) {
		File pasta = new File(path);
		ArrayList<File> arquivos = new ArrayList<File>();
		if (pasta.exists()) {
			File[] a = pasta.listFiles();
			for (File f : a)
				arquivos.add(f);
		} else {
			// Só será no caso do primeiro load das Playlists
			pasta.mkdir();
		}
		return arquivos;
	}
}
