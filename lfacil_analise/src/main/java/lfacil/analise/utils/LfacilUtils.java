package lfacil.analise.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LfacilUtils {

	public static void imprimirFechamentoFormat(TreeSet<Integer> fechamento) {
	
		imprimirFechamentoFormat(new ArrayList<Integer>(fechamento));
	}
	
	public static void imprimirFechamentoFormat(List<Integer> dezenas) {
		
		List<String> fechFormat = new ArrayList<>();
		
		for (Integer num : dezenas) {
			fechFormat.add(String.format("%02d", num));
		}
		
		System.out.print(fechFormat + " ");
	}
	
	public static Integer getQtdPares(List<Integer> dezenas) {

		int pares = 0;
		for (int n : dezenas){

			if (n % 2 == 0){
				pares++;
			}
		}
		
		return pares;
	}

	public static Integer getQtdImpares(List<Integer> dezenas) {

		int impares = 0;
		for (int n : dezenas){

			if (n % 2 != 0){
				impares++;
			}
		}
		
		return impares;
	}
	
	public static Integer getQtdPares(TreeSet<Integer> dezenas) {
				
		return getQtdPares(new ArrayList<Integer>(dezenas));
	}

	public static Integer getQtdImpares(TreeSet<Integer> dezenas) {

		return getQtdImpares(new ArrayList<Integer>(dezenas));
	}
	
}
