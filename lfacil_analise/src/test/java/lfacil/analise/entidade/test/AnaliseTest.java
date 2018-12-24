package lfacil.analise.entidade.test;

import java.util.List;

import org.junit.Test;

import lfacil.analise.processa.Analise;
import lfacil.analise.processa.FactoryBase;

public class AnaliseTest {

	@Test
	public void analiseMaximoSalto() {
		
		Analise anl = new Analise();
		anl.analiseMaximoSalto();

	}
	
	@Test
	public void analiseMaximoSucessivas() {
		
		FactoryBase fac = new FactoryBase();
		List<Integer> arr = fac.getDezenas(fac.getLastSorteio());
		
		System.out.println(arr.toString());
		
		Analise anl = new Analise();
		anl.analiseMaximoSucessivas();
	}
	
}
