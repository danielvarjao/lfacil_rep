package lfacil.analise.fechamentos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.apache.commons.math3.util.CombinatoricsUtils;

import lfacil.analise.entidade.CriterioFechamento;
import lfacil.analise.entidade.Sorteio;
import lfacil.analise.processa.FactoryArquivos;
import lfacil.analise.utils.LfacilUtils;

public abstract class FechamentoBase {
	
	protected TreeSet<Integer> dezenas;
	protected Long combParImpar;
	

	//Abstract Methods
	public abstract void gerarFechamentos(CriterioFechamento criterio);
		
	
	public void validarCondicaoInicial(CriterioFechamento criterio) throws Exception {

		if (criterio.getQtdDezenasAposta() > criterio.getQtdDezenas()) {
			throw new Exception("Quantidade de Dezenas para sorteio menor que quantidade de Dezenas por Aposta");
		}
		
		//Validar QTD Pares Impares nas dezenas sorteadas
		int qtdImparDezenasSelec = LfacilUtils.getQtdImpares(this.dezenas);
		int qtdParesDezenasSelec = LfacilUtils.getQtdPares(this.dezenas);
		
		if (qtdImparDezenasSelec < criterio.getQtdDezenasImpares() 
				|| qtdParesDezenasSelec < criterio.getQtdDezenasPares()) {
			
			throw new Exception("Quantidade de Pares/Impares para sorteio menor que condições do criterio");
		}

	}
	
	
	public void gerarDezenas(CriterioFechamento criterio) {
		
		dezenas = new TreeSet<Integer>();
		
		Random random = new Random();
		
		while(dezenas.size() < criterio.getQtdDezenas()) {
			
			int numero = random.nextInt(25) + 1;
			
			if (!criterio.isGerarDezenasRandom() && criterio.getDezenasExcluidas().contains(numero)) {
				continue;
			}
			
			dezenas.add(numero);
			
		}
		
		System.out.println("Dezenas -> " + dezenas);
		imprimirRelacaoParImpar(new ArrayList<Integer>(dezenas));
	}


	public void gerarNumeroCombinacoes(CriterioFechamento criterio) {
		
		Integer numeroObjetos = criterio.getQtdDezenas();
		Integer posicoes = criterio.getQtdDezenasAposta();

		Long combTotal = CombinatoricsUtils.binomialCoefficient(numeroObjetos, posicoes);
				
		System.out.println("Combinacoes Possiveis Total: -> " + combTotal);
		
		int qtdImparDezenasSelec = LfacilUtils.getQtdImpares(this.dezenas);
		int qtdParesDezenasSelec = LfacilUtils.getQtdPares(this.dezenas);
		
		Long combPar = CombinatoricsUtils.binomialCoefficient(qtdParesDezenasSelec, criterio.getQtdDezenasPares());
		Long combImpar = CombinatoricsUtils.binomialCoefficient(qtdImparDezenasSelec, criterio.getQtdDezenasImpares());
		
		
		System.out.println("Pares -> " + combPar);
		System.out.println("Impares -> " + combImpar);
		
		this.combParImpar = combPar * combImpar;
		
		System.out.println("Combinacoes Possiveis Par/Impar: -> " + combParImpar);
	}
	
	public boolean validaParImpar(TreeSet<Integer> listAtual, CriterioFechamento criterio) {

		int qtdPares = LfacilUtils.getQtdPares(new ArrayList<Integer>(listAtual));
		int qtdImpares = LfacilUtils.getQtdImpares(new ArrayList<Integer>(listAtual));

		if (qtdPares == criterio.getQtdDezenasPares() && qtdImpares == criterio.getQtdDezenasImpares())
			return true;
		else
			return false;
	}
		
	public void imprimirFechamento(List<TreeSet<Integer>> fechamentos) {
		
		System.out.println("Fechamentos gerados: ");
		
		for (TreeSet<Integer> fechamento : fechamentos) {
			
			List<String> fechFormat = new ArrayList<>();
			
			for (Integer num : fechamento) {
				fechFormat.add(String.format("%02d", num));
			}
			
			System.out.print(fechFormat + " ");
			imprimirRelacaoParImpar(new ArrayList<Integer>(fechamento));
		}
		
	}
	
	public void gravarFechamento(List<TreeSet<Integer>> fechamentos) throws IOException {
		
		File arquivoFechamento = new File(FactoryArquivos.getArquivoUltimoFechamento());

		FileOutputStream fos = new FileOutputStream(arquivoFechamento);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for (TreeSet<Integer> fechamento : fechamentos) {
			
			List<String> fechFormat = new ArrayList<>();
			
			for (Integer num : fechamento) {
				fechFormat.add(String.format("%02d", num));
			}
			
			bw.write(fechFormat.toString());
			bw.newLine();
		}
		
		
		bw.close();

		
		System.out.println("Arquivo de fechamento gravado.");
		
	}
	
	
	public void imprimirRelacaoParImpar(List<Integer> dezenas) {
		
		System.out.println("Pares: -> " + LfacilUtils.getQtdPares(dezenas) + " Impares: -> " + LfacilUtils.getQtdImpares(dezenas));
	}
	

}
