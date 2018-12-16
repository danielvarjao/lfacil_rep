package lfacil.analise.entidade.test;

import org.junit.Test;

import lfacil.analise.entidade.Sorteio;

public class SorteioTest {

	
	@Test
	public void ordena() {
		
		Sorteio sort = Sorteio.builder()
				.bola1(10)
				.bola2(22)
				.bola3(2)
				.bola4(5)
				.bola5(4)
				.bola6(3)
				.bola7(6)
				.bola8(7)
				.bola9(8)
				.bola10(14)
				.bola11(16)
				.bola12(13)
				.bola13(20)
				.bola14(19)
				.bola15(1)
				.build();
		
		System.out.println(sort);
		
		sort.sort();
		
		System.out.println(sort);
		
	}
	
}
