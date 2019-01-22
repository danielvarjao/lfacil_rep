package lfacil.analise.fechamentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import lfacil.analise.entidade.CriterioFechamento;

public class GeradorFechamentos extends FechamentoBase {
	
	
	public static void main(String[] args) {
		
		CriterioFechamento criterio = FactoryCriterios.getCriteriosFechamento();

		try {

			FechamentoBase fech = new GeradorFechamentos();
			fech.gerarDezenas(criterio);
			
			fech.validarCondicaoInicial(criterio);
			
			fech.gerarNumeroCombinacoes(criterio);
			fech.gerarFechamentos(criterio);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	@Override
	public void gerarFechamentos(CriterioFechamento criterio) {
		
		List<Integer> dezenasDisponiveis = new ArrayList<>(dezenas);

		List<TreeSet<Integer>> fechamentos = new ArrayList<>();
		
		Random random = new Random();
		
		
		//for (int i=0; i < criterio.getQtdJogos(); i++) {
		int controleLoop = 0;	
		while (fechamentos.size() < criterio.getQtdJogos()) {
			
			if (controleLoop > combParImpar) {
				break;
			}
			
			TreeSet<Integer> listAtual = new TreeSet<>();
			while (listAtual.size() < criterio.getQtdDezenasAposta()) {
				
				int numero = dezenasDisponiveis.get(random.nextInt(dezenasDisponiveis.size()));
				
				listAtual.add(numero);
				
			}
			
			if (!fechamentos.contains(listAtual) && validaParImpar(listAtual, criterio)) {
				fechamentos.add(listAtual);
			}
			else {
				//System.out.println("REPETIDO");
			}
		
			controleLoop++;
		}
		
		if (criterio.isGravarFechamento()) {
			gravarFechamento(fechamentos);
		}
				
		imprimirFechamento(fechamentos);

	}


//	private boolean validaParImpar(TreeSet<Integer> listAtual, CriterioFechamento criterio) {
//		
//		int qtdPares = LfacilUtils.getQtdPares(new ArrayList<Integer>(listAtual));
//		int qtdImpares = LfacilUtils.getQtdImpares(new ArrayList<Integer>(listAtual));
//		
//		if (qtdPares == criterio.getQtdDezenasPares() && qtdImpares == criterio.getQtdDezenasImpares())
//			return true;
//		else
//			return false;
//	}

	

}
