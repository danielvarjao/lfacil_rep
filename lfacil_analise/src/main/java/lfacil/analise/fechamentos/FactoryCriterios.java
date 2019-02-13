package lfacil.analise.fechamentos;

import java.util.ArrayList;
import java.util.ResourceBundle;

import lfacil.analise.entidade.CriterioAnalise;
import lfacil.analise.entidade.CriterioFechamento;

public class FactoryCriterios {
	
	static ResourceBundle res = ResourceBundle.getBundle("criterios");
	
	public static CriterioFechamento getCriteriosFechamento() {
		
		CriterioFechamento crit = CriterioFechamento.builder()
				.qtdDezenas(Integer.parseInt(res.getString("qtdDezenas")))
				.qtdJogos(Integer.parseInt(res.getString("qtdJogos")))
				.qtdDezenasAposta(Integer.parseInt(res.getString("qtdDezenasAposta")))
				.qtdDezenasPares(Integer.parseInt(res.getString("qtdDezenasPares")))
				.qtdDezenasImpares(Integer.parseInt(res.getString("qtdDezenasImpares")))
				.gerarDezenasRandom(gerarDezenasRandom(res.getString("gerarDezenasRandom")))
				.gravarFechamento(gravarFechamento(res.getString("gravarFechamento")))
				.dezenasExcluidas(new ArrayList<Integer>())
				.dezenasFixas(new ArrayList<Integer>())
				.build();
		
		setDezenasExcluidas(crit);
		setDezenasFixas(crit);
		setQuantidadePorLinha(crit);
		setMaximos(crit);
		
		return crit;
	}
	
	

	public static CriterioAnalise getCriteriosAnalise() {
		
		CriterioAnalise crit = CriterioAnalise.builder()
				.analiseUltimoSorteio(res.getString("analiseUltimoSorteio").equalsIgnoreCase("S") ? true : false)
				.analiseUltimosN(Integer.parseInt(res.getString("analiseUltimosN")))
				.analiseRepeticaoUltimosN(Integer.parseInt(res.getString("analiseRepeticaoUltimosN")))
				.build();
		
		return crit;
	}

	
	private static boolean gerarDezenasRandom(String random) {
		
		return random.trim().equalsIgnoreCase("S") ? true : false;
	}
	
	private static boolean gravarFechamento(String gravar) {
		
		return gravar.trim().equalsIgnoreCase("S") ? true : false;
	}
	
	
	private static void setDezenasExcluidas(CriterioFechamento crit) {

		String strExcluidas = res.getString("dezenasExcluidas");
		String[] excluidas = strExcluidas.isEmpty() ? new String[0] : strExcluidas.split(",");
		
		for (String exc : excluidas) {
			crit.getDezenasExcluidas().add(Integer.parseInt(exc));
		}
		
	}
	
	private static void setDezenasFixas(CriterioFechamento crit) {

		String strFixas = res.getString("dezenasFixas");
		String[] fixas = strFixas.isEmpty() ? new String[0] : strFixas.split(",");
		
		for (String fix : fixas) {
			crit.getDezenasFixas().add(Integer.parseInt(fix));
		}
		
	}

	
	private static void setQuantidadePorLinha(CriterioFechamento crit) {
		
		crit.setQtdLinha1(res.getString("qtdLinha1").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha1"))); 
		crit.setQtdLinha2(res.getString("qtdLinha2").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha2")));
		crit.setQtdLinha3(res.getString("qtdLinha3").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha3")));
		crit.setQtdLinha4(res.getString("qtdLinha4").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha4")));
		crit.setQtdLinha5(res.getString("qtdLinha5").isEmpty() ? null : Integer.parseInt(res.getString("qtdLinha5")));
		
	}
	
	private static void setMaximos(CriterioFechamento crit) {
				
		crit.setMaximoSalto(res.getString("maximoSalto").isEmpty() ? null : Integer.parseInt(res.getString("maximoSalto")));
		crit.setMaximoSucessivas(res.getString("maximoSucessivas").isEmpty() ? null : Integer.parseInt(res.getString("maximoSucessivas")));
	}

}
