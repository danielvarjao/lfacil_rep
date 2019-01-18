package lfacil.analise.processa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lfacil.analise.entidade.CriterioAnalise;
import lfacil.analise.entidade.Sorteio;
import lfacil.analise.fechamentos.FactoryCriterios;

public class Analise {
	
	FactoryBase fac;
	CriterioAnalise criterio;
	
	int[] dzn_full = IntStream.range(1, 26).toArray();

	public static void main(String[] args) {
		
		Analise anl = new Analise();
		anl.exec();

	}
	
	public Analise() {
		
		criterio = FactoryCriterios.getCriteriosAnalise();
		
		fac = new FactoryBase();
		
	}
	
	private void exec(){
		
		for (Sorteio sorteio : fac.getLastNSorteios(this.criterio.getAnaliseUltimosN())){
			
			analiseParImpar(sorteio);
			analiseLinhas(sorteio);
			analiseAusentes(sorteio);
			analiseMaximoSalto(sorteio);
			analiseMaximoSucessivas(sorteio);
			System.out.println("####################\n");
		}
		
	}
	
	
	public void analiseParImpar(Sorteio sorteio){
		
		List<Integer> pares = new ArrayList<Integer>();
		List<Integer> impares = new ArrayList<Integer>();
			
		for (int n : fac.getDezenas(sorteio)){

			if (n % 2 == 0){
				pares.add(n);
			}else{
				impares.add(n);
			}
		}

		fac.imprimirSorteio(sorteio, true);
		System.out.println("Pares: " + pares + " -> " + pares.size());
		System.out.println("Impares: " + impares + " -> " + impares.size());
		System.out.println();

		pares.clear();
		impares.clear();
			
		
	}
	
	public void analiseLinhas(Sorteio sorteio){
		
		List<Integer> linha1 = Arrays.asList(new Integer[] {1,2,3,4,5});
		List<Integer> linha2 = Arrays.asList(new Integer[] {6,7,8,9,10});
		List<Integer> linha3 = Arrays.asList(new Integer[] {11,12,13,14,15});
		List<Integer> linha4 = Arrays.asList(new Integer[] {16,17,18,19,20});
		List<Integer> linha5 = Arrays.asList(new Integer[] {21,22,23,24,25});
		
		List<Integer> sortL1 = new ArrayList<Integer>();
		List<Integer> sortL2 = new ArrayList<Integer>();
		List<Integer> sortL3 = new ArrayList<Integer>();
		List<Integer> sortL4 = new ArrayList<Integer>();
		List<Integer> sortL5 = new ArrayList<Integer>();
		
		
		for (int n : fac.getDezenas(sorteio)){
			
			if (linha1.contains(n)){
				sortL1.add(n);
				continue;
			}
			
			if (linha2.contains(n)){
				sortL2.add(n);
				continue;
			}

			if (linha3.contains(n)){
				sortL3.add(n);
				continue;
			}

			if (linha4.contains(n)){
				sortL4.add(n);
				continue;
			}

			if (linha5.contains(n)){
				sortL5.add(n);
				continue;
			}
			
		}
		
		System.out.println("Linha 1 - " + sortL1);
		System.out.println("Linha 2 - " + sortL2);
		System.out.println("Linha 3 - " + sortL3);
		System.out.println("Linha 4 - " + sortL4);
		System.out.println("Linha 5 - " + sortL5);
		System.out.println();
		
	}
	
	public void analiseAusentes(Sorteio sorteio) {
		
		List<Integer> ausentes = new ArrayList<Integer>();
		
		for (int i=1; i<=25; i++) {
			
			if (!sorteio.getListSorteadas().contains(i)) {
				ausentes.add(i);
			}
		}
		
		System.out.println("Ausentes -> " + ausentes);
		System.out.println();
	}
	
	public void analiseMaximoSalto(Sorteio sorteio) {
		
		//TODO Pegar o intervalo do salto
		
		Integer[] arr = fac.getDezenas(sorteio).toArray(new Integer[0]);
		
		int salto = 0;
		for (int i=0, j=1; i < arr.length-1; i++, j++) {
			
			int saltoTemp = arr[j] - arr[i];
			salto = (saltoTemp > salto) ? saltoTemp : salto;
		}
		
		
		System.out.println("Máximo salto: " + --salto);
	}
	
	public void analiseMaximoSucessivas(Sorteio sorteio) {
	
		Integer[] arr = fac.getDezenas(sorteio).toArray(new Integer[0]);
		
		List<Integer> listSucessivas = new ArrayList<Integer>();
		
		for (int i=0; i < arr.length-1; i++) {
			
			int sucessivas = 1;
			int inicial = arr[i];
			int contador = 1;
			int posicaoSeguinte = i+1;
			boolean continua = true;
			
			while (continua) {
				
				if (inicial+contador == arr[posicaoSeguinte]) {
					sucessivas++;
					contador++;
					
					if (posicaoSeguinte < arr.length-1)
						posicaoSeguinte++;
				
				}else {
					continua = false;
					listSucessivas.add(sucessivas);
					continue;
				}
				
			}
		}
		
		
		System.out.println("Máximo sucessivas: " + Collections.max(listSucessivas));
		
	}
	
}
