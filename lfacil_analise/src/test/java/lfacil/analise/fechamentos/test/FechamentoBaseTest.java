package lfacil.analise.fechamentos.test;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Assert;
import org.junit.Test;

import lfacil.analise.entidade.CriterioFechamento;
import lfacil.analise.fechamentos.FactoryCriterios;
import lfacil.analise.fechamentos.FechamentoBase;
import lfacil.analise.fechamentos.GeradorFechamentos;

public class FechamentoBaseTest {
	
	@Test
	public void testCombinacoes() {
	
		Long ret = CombinatoricsUtils.binomialCoefficient(10, 8);
		
		System.out.println("Combinacoes Possiveis: -> " + ret);
	}
	
	
	@Test
	public void gerarDezenas() {
		
		CriterioFechamento criterio = FactoryCriterios.getCriteriosFechamento();
		
		FechamentoBase fech = new GeradorFechamentos();
		fech.gerarDezenas(criterio);	
	}
	
	
	@Test
	public void gerarDezenasQuantidade() {
		
		CriterioFechamento criterio = FactoryCriterios.getCriteriosFechamento();
		
		FechamentoBase fech = new GeradorFechamentos();
		fech.gerarDezenas(criterio);
		
		Assert.assertTrue(criterio.getQtdDezenas() == fech.dezenas.size());
	}
	
	@Test
	public void gerarDezenasValidarFixas() {
		
		CriterioFechamento criterio = FactoryCriterios.getCriteriosFechamento();
		
		FechamentoBase fech = new GeradorFechamentos();
		fech.gerarDezenas(criterio);
		
		if (!criterio.isGerarDezenasRandom()) {

			boolean condicao = true;
			
			loopExterno:
			for (int i = 0; i < 100; i++) { 

				for (Integer num : criterio.getDezenasFixas()) {
					
					if (!fech.dezenas.contains(num)){
						condicao = false;
						break loopExterno;
					}
				}

			}

			Assert.assertTrue(condicao);

		}
	}
	
}
