package lfacil.analise.processa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.ListIterator;

public class Conferidor {

	public static void main(String[] args) {

		try {
			
			Conferidor conf = new Conferidor();
			conf.confere();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void confere() throws IOException {
		
		File arquivoFechamento = new File(FactoryArquivos.getArquivoUltimoFechamento());
		
		List<String> lines = Files.readAllLines(arquivoFechamento.toPath());
		
		for (ListIterator<String> linha = lines.listIterator(); linha.hasNext(); ) {
			
			linha.set(calculaAcertos(linha.next()));
		}
		
		Files.write(arquivoFechamento.toPath(), lines);
		
		System.out.println("Conferência de fechamento realizada.");
	}


	/**
	 * Calcula acertos com base no último sorteio
	 * @param line
	 * @return String concatenada com numero de acertos
	 */
	private String calculaAcertos(String line) {

		FactoryBase fac = new FactoryBase(); //Colocar no construtor para obter uma vez só
		List<Integer> sorteadas = fac.getLastSorteio().getListSorteadas();
		
		String[] arrayLinha = line.split(",");
		
		Integer contador = 0;
		for (String dezena : arrayLinha) {
			
			if (sorteadas.contains(Integer.parseInt(dezena.trim().substring(0, 2)))) {
				contador++;
			}
		}
		
		if (contador >= 11) {
			return line.substring(0, 58) + " -> " + contador + "**";
		}
		
		//0 - 58 é o intervalo onde fica o fechamento em cada linha do arquivo
		return line.substring(0, 58) + " -> " + contador;
	}

}
