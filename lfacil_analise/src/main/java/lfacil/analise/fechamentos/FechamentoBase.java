package lfacil.analise.fechamentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lfacil.analise.entidade.CriterioFechamento;

public abstract class FechamentoBase {
	
	protected List<Integer> dezenas;
	
	//Abstract Methods
	public abstract void gerarFechamentos(CriterioFechamento criterio);
	
	
	public void gerarDezenas(CriterioFechamento criterio) {
		
		dezenas = new ArrayList<Integer>();
		
		//
		
		dezenas.add(2);
		dezenas.add(3);
		dezenas.add(5);
		dezenas.add(6);
		dezenas.add(8);
		dezenas.add(9);
		dezenas.add(10);
		dezenas.add(11);
		dezenas.add(13);
		dezenas.add(14);
		dezenas.add(15);
		dezenas.add(16);
		dezenas.add(17);
		dezenas.add(19);
		dezenas.add(20);
		dezenas.add(21);
		dezenas.add(22);
		dezenas.add(23);
		dezenas.add(24);
		
		//
		
		System.out.println("Dezenas 1 -> " + this.dezenas);
		
		dezenas.clear(); /************/
		Random random = new Random();
		
		while(dezenas.size() < criterio.getQtdDezenas()) {
			
			int numero = random.nextInt(25) + 1;
			
			if (dezenas.contains(numero) || criterio.getDezenasExcluidas().contains(numero)) {
				continue;
			}
			
			dezenas.add(numero);
			
		}
		
		Collections.sort(dezenas);
		
		System.out.println("Dezenas 2 -> " + this.dezenas);
	}
	

}
