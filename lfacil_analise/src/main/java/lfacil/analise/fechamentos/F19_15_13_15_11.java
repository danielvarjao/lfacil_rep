package lfacil.analise.fechamentos;

import lfacil.analise.entidade.CriterioFechamento;

/*
 * 
 19 dezenas desdobradas em 11 apostas com garantia de 13 pontos acertando as 15 sorteadas.
 
 */

public class F19_15_13_15_11 extends FechamentoBase {
	
	public static void main(String[] args) {
		
		CriterioFechamento criterio = CriterioFechamento.builder()
				.qtdDezenas(19)
				.qtdJogos(11)
				.build();

		FechamentoBase fech = new F19_15_13_15_11();
		fech.gerarDezenas(criterio);
		fech.gerarFechamentos();
		
		
	}
	
	
	@Override
	public void gerarFechamentos() {
		// TODO Auto-generated method stub
		
	}

	
	
}
