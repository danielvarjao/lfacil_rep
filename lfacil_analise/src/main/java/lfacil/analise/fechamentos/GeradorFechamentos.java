package lfacil.analise.fechamentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

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
		
		List<Integer> dezenasDisponiveis = new ArrayList<>(dezenas);

		List<TreeSet<Integer>> fechamentos = new ArrayList<>();
		
		Random random = new Random();
		
		
		for (int i=0; i < criterio.getQtdJogos(); i++) {
			
			TreeSet<Integer> listAtual = new TreeSet<>();
			while (listAtual.size() <= criterio.getQtdDezenasAposta()) {
				
				int numero = dezenasDisponiveis.get(random.nextInt(dezenasDisponiveis.size()));
				
				listAtual.add(numero);
				
			}
			
			if (!fechamentos.contains(listAtual)) {
				fechamentos.add(listAtual);
			}
			else {
				System.out.println("REPETIDO");
			}
			
		}
		
		System.out.println("Fechamentos gerados: ");
		
		for (TreeSet<Integer> tree : fechamentos) {
			System.out.println(tree);
		}

	}

	

}
