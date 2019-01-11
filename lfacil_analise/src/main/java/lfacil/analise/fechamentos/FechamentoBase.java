package lfacil.analise.fechamentos;

import java.util.Random;
import java.util.TreeSet;

import org.apache.commons.math3.util.Combinations;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.MathUtils;

import lfacil.analise.entidade.CriterioFechamento;

public abstract class FechamentoBase {
	
	protected TreeSet<Integer> dezenas;
	
	//Abstract Methods
	public abstract void gerarFechamentos(CriterioFechamento criterio);
	
	
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
	}


	public void gerarNumeroCombinacoes(CriterioFechamento criterio) {
		
		Integer numeroObjetos = criterio.getQtdDezenas();
		Integer posicoes = criterio.getQtdDezenasAposta();

		Long ret = CombinatoricsUtils.binomialCoefficient(numeroObjetos, posicoes);
				
		System.out.println("Combinacoes Possiveis: -> " + ret);
		
		
	}
	

}
