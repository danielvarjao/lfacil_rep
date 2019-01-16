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
	
}
