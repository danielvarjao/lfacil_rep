package lfacil.analise.processa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Analise {
	
	FactoryBase fac;
	
	int[] dzn_full;

	
	int[] dzn_ultimoSort =  {1,3,4,5,7,8,9,10,11,14,15,21,22,23,24};

	public static void main(String[] args) {
		
		Analise anl = new Analise();
		
		anl.load();
		anl.ultimoSorteio();		
		anl.analiseParImpar();
		anl.analiseLinhas();
	}
	
	private void load(){
		fac = new FactoryBase();
		
		dzn_full = IntStream.range(1, 26).toArray();
	}
	
	
	
	private void ultimoSorteio(){
		
		System.out.println("Ultimo Sorteio: " + this.fac.getLastSorteio());
		System.out.println("####################");
			
	}
	
	private void analiseParImpar(){
		
		List<Integer> pares = new ArrayList<Integer>();
		List<Integer> impares = new ArrayList<Integer>();
			
		for (int n : fac.getDezenas(fac.getLastSorteio())){
			
			if (n % 2 == 0){
				pares.add(n);
			}else{
				impares.add(n);
			}
		}
		
		System.out.println("Pares: " + pares + " -> " + pares.size());
		System.out.println("Impares: " + impares + " -> " + impares.size());
		System.out.println("####################");
		
	}
	
	private void analiseLinhas(){
		
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
		
		for (int n : fac.getDezenas(fac.getLastSorteio())){
			
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
		
	}
	
}
