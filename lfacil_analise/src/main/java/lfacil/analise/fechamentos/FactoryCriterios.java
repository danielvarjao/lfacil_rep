package lfacil.analise.fechamentos;

import java.util.ResourceBundle;

import lfacil.analise.entidade.CriterioFechamento;

public class FactoryCriterios {
	
	static ResourceBundle res = ResourceBundle.getBundle("criterios");
	
	public static CriterioFechamento getCriterios() {
		
		CriterioFechamento crit = CriterioFechamento.builder()
				.qtdDezenas(Integer.parseInt(res.getString("qtdDezenas")))
				.qtdJogos(Integer.parseInt(res.getString("qtdJogos")))
				.qtdDezenasAposta(Integer.parseInt(res.getString("qtdDezenasAposta")))
				.qtdDezenasPares(Integer.parseInt(res.getString("qtdDezenasPares")))
				.qtdDezenasImpares(Integer.parseInt(res.getString("qtdDezenasImpares")))
				.gerarDezenasRandom(gerarDezenasRandom(res.getString("gerarDezenasRandom")))
				.build();
		
		setDezenasExcluidas(crit);
		setQuantidadePorLinha(crit);
		setMaximos(crit);
		
		return crit;
	}

	
	private static boolean gerarDezenasRandom(String random) {
		
		return random.trim().equals("S") ? true : false;
	}
	
	
	private static void setDezenasExcluidas(CriterioFechamento crit) {
		// TODO Auto-generated method stub
		
	}

	
	private static void setQuantidadePorLinha(CriterioFechamento crit) {
		
		crit.setQtdLinha1(res.getString("qtdLinha1").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha1"))); 
		crit.setQtdLinha2(res.getString("qtdLinha2").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha2")));
		crit.setQtdLinha3(res.getString("qtdLinha3").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha3")));
		crit.setQtdLinha4(res.getString("qtdLinha4").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha4")));
		crit.setQtdLinha5(res.getString("qtdLinha5").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha5")));
		
	}
	
	private static void setMaximos(CriterioFechamento crit) {
		// maximoSalto=
		// maximoSucessivas=
		
	}

}
