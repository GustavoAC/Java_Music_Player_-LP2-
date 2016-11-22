package musicplayer.controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManipulator {
	public void writer(String path) throws IOException {
		File arquivo = new File(path);
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		//O true como argumento significa que a escrita
		//será feita no final do arquivo
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Teste");
		bw.newLine();
		bw.close();
		fw.close();
	}
	
	public void reader(String path) throws IOException {
		File arquivo = new File(path);
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			String linha = br.readLine();
			System.out.println(linha);
		}
		br.close();
		fr.close();
	}
	public ArrayList<File> listFiles (String path) {
		File pasta = new File(path);
		if (pasta.exists()) {
			File [] a = pasta.listFiles();
			ArrayList<File> arquivos = new ArrayList<File>();
			for (File f : a) {
				arquivos.add(f);
			}
			return arquivos;
		}
		return null;
	}
}
