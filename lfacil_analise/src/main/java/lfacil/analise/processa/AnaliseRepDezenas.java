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
		
		for (Sorteio sorteio : fac.getLastNSorteios(this.criterio.getAnaliseRepeticaoUltimosN())){
			
			
		}
		
	}

}
