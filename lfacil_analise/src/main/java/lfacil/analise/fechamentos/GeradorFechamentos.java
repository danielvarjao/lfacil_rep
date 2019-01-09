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

		TreeSet<TreeSet<Integer>> fechamentos = new TreeSet<>();
		
		Random random = new Random();
		TreeSet<Integer> dezenas = new TreeSet<Integer>();
		
		for (int i=0; i < criterio.getQtdJogos(); i++) {
			
			TreeSet<Integer> listAtual = new TreeSet<>();
			while (listAtual.size() <= criterio.getQtdDezenasAposta()) {
				
				int numero = dezenasDisponiveis.get(random.nextInt(dezenasDisponiveis.size()));
				
				listAtual.add(numero);
				
			}
			
			fechamentos.add(listAtual);
			
		}
		
		System.out.println(fechamentos);

	}

	

}
