package lfacil.analise.fechamentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.apache.commons.math3.util.CombinatoricsUtils;

import lfacil.analise.entidade.CriterioFechamento;

public abstract class FechamentoBase {
	
	protected TreeSet<Integer> dezenas;
	
	//Abstract Methods
	public abstract void gerarFechamentos(CriterioFechamento criterio);
		
	
	public void validarCondicaoInicial(CriterioFechamento criterio) throws Exception {

		if (criterio.getQtdDezenasAposta() > criterio.getQtdDezenas()) {
			throw new Exception("Quantidade de Dezenas para sorteio menor que quantidade de Dezenas por Aposta");
		}
		
		//Validar QTD Pares Impares nas dezenas sorteadas

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

		Long ret = CombinatoricsUtils.binomialCoefficient(numeroObjetos, posicoes);
				
		System.out.println("Combinacoes Possiveis: -> " + ret);
		
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
	
	public void imprimirRelacaoParImpar(List<Integer> dezenas) {
		
		List<Integer> pares = new ArrayList<Integer>();
		List<Integer> impares = new ArrayList<Integer>();
		
		for (int n : dezenas){

			if (n % 2 == 0){
				pares.add(n);
			}else{
				impares.add(n);
			}
		}
		
		System.out.println("Pares: -> " + pares.size() + " Impares: -> " + impares.size());
	}
	

}
