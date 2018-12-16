package lfacil.analise.entidade.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import lfacil.analise.entidade.Sorteio;
import lfacil.analise.processa.FactoryBase;

public class FactoryBaseTest {

	FactoryBase fac = new FactoryBase();
	
	@Test
	public void getSorteio() {
		
		System.out.println("###### getSorteio ######");
		
		Integer numeroSorteio = 1000;
		Sorteio sorteio = fac.getSorteio(numeroSorteio);
		
		System.out.println("Sorteio " + ": " + sorteio + "\n");
		
		Assert.assertEquals(sorteio.getConcurso(), numeroSorteio.toString());
	}
	
	@Test
	public void getLastSorteio() {
		
		System.out.println("###### getLastSorteio ######");
		
		Sorteio sorteio = fac.getLastSorteio();
		System.out.println(sorteio + "\n");
		
		Assert.assertNotNull(sorteio);
	}
	
	@Test
	public void getLastNSorteios() {
		
		System.out.println("###### getLastNSorteios ######");
		
		int numero = 10;
		
		List<Sorteio> lista = fac.getLastNSorteios(numero);
		
		for (Sorteio s : lista) {
			System.out.println(s);
		}
		
		System.out.println();
		
		Assert.assertEquals(lista.size(), numero);
		
		
	}
	
	@Test
	public void getDezenas() {
		
//		System.out.println("###### getDezenas ######");
//		
//		Sorteio sorteio = fac.getSorteio(1745);
//		
//		List<Integer> dezenas = fac.getDezenas(sorteio);
//		
//		System.out.println(dezenas.toArray());
//		
//		Assert.assertEquals(sorteio.getBola5(), dezenas.get(4));
	}
	
	
	
	
	
}
