package lfacil.analise.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lfacil.analise.utils.LfacilUtils;

public class LfacilUtilsTest {

	@Test
	public void testQtdPares() {
		
		List<Integer> pares = new ArrayList<>();
		pares.add(1);
		pares.add(2);
		pares.add(3);
		pares.add(4);
		pares.add(5);
		
		Integer qtd = LfacilUtils.getQtdPares(pares);
		System.out.println(qtd + " pares");
		
	}
	
	@Test
	public void testQtdImpares() {
		
		List<Integer> impares = new ArrayList<>();
		impares.add(1);
		impares.add(2);
		impares.add(3);
		impares.add(4);
		impares.add(5);
		
		Integer qtd = LfacilUtils.getQtdImpares(impares);
		System.out.println(qtd + " impares");
		
	}
	
}
