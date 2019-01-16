package lfacil.analise.fechamentos.test;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Test;

public class FechamentoBaseTest {
	
	@Test
	public void testCombinacoes() {
	
		Long ret = CombinatoricsUtils.binomialCoefficient(10, 8);
		
		System.out.println("Combinacoes Possiveis: -> " + ret);
	}

}
