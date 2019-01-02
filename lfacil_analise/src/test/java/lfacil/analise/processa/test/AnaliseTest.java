package lfacil.analise.processa.test;

import java.util.List;

import org.junit.Test;

import lfacil.analise.entidade.Sorteio;
import lfacil.analise.processa.Analise;
import lfacil.analise.processa.FactoryBase;

public class AnaliseTest {
	
	FactoryBase fac = new FactoryBase();
	
	@Test
	public void analiseParImpar() {
		
		Sorteio sorteio = fac.getSorteio(1745);
		
		Analise anl = new Analise();
		anl.analiseParImpar(sorteio);
	}

	@Test
	public void analiseMaximoSalto() {
		
		Sorteio sorteio = fac.getSorteio(1745);
		
		Analise anl = new Analise();
		anl.analiseMaximoSalto(sorteio);

	}
	
	@Test
	public void analiseMaximoSucessivas() {
		
		Sorteio sorteio = fac.getSorteio(1745);
		
		FactoryBase fac = new FactoryBase();
		List<Integer> arr = fac.getDezenas(sorteio);
		
		System.out.println(arr.toString());
		
		Analise anl = new Analise();
		anl.analiseMaximoSucessivas(sorteio);
	}
	
}
