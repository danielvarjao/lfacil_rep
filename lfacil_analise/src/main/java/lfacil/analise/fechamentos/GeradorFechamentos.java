package lfacil.analise.fechamentos;

import lfacil.analise.entidade.CriterioFechamento;

public class GeradorFechamentos extends FechamentoBase {
	
	
	public static void main(String[] args) {
		
		CriterioFechamento criterio = FactoryCriterios.getCriteriosFechamento();

		FechamentoBase fech = new GeradorFechamentos();
		fech.gerarDezenas(criterio);
		fech.gerarFechamentos(criterio);

	}
	

	@Override
	public void gerarFechamentos(CriterioFechamento criterio) {
		// TODO Auto-generated method stub

	}

	

}
