package lfacil.analise.fechamentos;

import java.io.IOException;
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
		
		
		int controleLoop = 0;	
		while (fechamentos.size() < criterio.getQtdJogos()) {
			
			if (controleLoop > combParImpar) {
				break;
			}
			
			TreeSet<Integer> listAtual = new TreeSet<>();
			
			if (!criterio.isGerarDezenasRandom())
				listAtual.addAll(criterio.getDezenasFixas());
			
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
			try {
				gravarFechamento(fechamentos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		imprimirFechamento(fechamentos);

	}

	

}
