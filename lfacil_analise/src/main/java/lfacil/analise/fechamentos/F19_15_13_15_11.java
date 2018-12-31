package lfacil.analise.fechamentos;

import lfacil.analise.entidade.CriterioFechamento;

/*
 * 
 19 dezenas desdobradas em 11 apostas com garantia de 13 pontos acertando as 15 sorteadas.
 
 */

public class F19_15_13_15_11 extends FechamentoBase {
	
	public static void main(String[] args) {
		
		CriterioFechamento criterio = FactoryCriterios.getCriteriosFechamento();

		FechamentoBase fech = new F19_15_13_15_11();
		fech.gerarDezenas(criterio);
		fech.gerarFechamentos(criterio);
		
		
	}
	
	
	@Override
	public void gerarFechamentos(CriterioFechamento criterio) {
		
		int data[] = new int[this.dezenas.size()];
	
		this.gerarCombinacao(this.dezenas.toArray(new Integer[0]), data, 0, this.dezenas.size()-1, 0, 15); 
				
	}


	private void gerarCombinacao(Integer[] dezenas, int[] data, int start, int end, int index, int qtdJogos) {
		
		// Current combination is ready to be printed, print it 
        if (index == qtdJogos) 
        { 
            for (int j=0; j<qtdJogos; j++) 
                System.out.print(data[j]+" "); 
            System.out.println(""); 
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= qtdJogos-index; i++) 
        { 
            data[index] = dezenas[i]; 
            gerarCombinacao(dezenas, data, i+1, end, index+1, qtdJogos); 
        } 
        
	}
	
	

	
	
}
