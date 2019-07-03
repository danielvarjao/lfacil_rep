package lfacil.analise.processa;

import lfacil.analise.entidade.Sorteio;
import lfacil.analise.fechamentos.FactoryCriterios;

public class AnaliseRepDezenas extends Analise {

	
	public static void main(String[] args) {
		
		AnaliseRepDezenas anl = new AnaliseRepDezenas();
		anl.exec();

	}
	
	public AnaliseRepDezenas() {
		
		criterio = FactoryCriterios.getCriteriosAnalise();
		
		fac = new FactoryBase();
		
	}
	
	private void exec(){
		
		int[] reps = new int[25];
		
		int qtdSorteios = this.criterio.getAnaliseRepeticaoUltimosN();
		
		for (Sorteio sorteio : fac.getLastNSorteios(qtdSorteios)){
			
			for (int i = 0; i < 15; i++) {
				
				int dezena = sorteio.getListSorteadas().get(i);
				reps[dezena-1]++;
			}
			
		}
		
		System.out.println("Análise de dezenas últimos " + qtdSorteios + " sorteios.");
		for (int i = 0; i < 25; i++) {
			System.out.println("Dezena " + (i+1) + " -> " + reps[i]);
		}
		
	}

}
