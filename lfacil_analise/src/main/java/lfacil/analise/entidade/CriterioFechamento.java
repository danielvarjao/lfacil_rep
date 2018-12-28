package lfacil.analise.entidade;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioFechamento {
	
	private int qtdDezenas;
	private int qtdJogos;
	private int qtdDezenasAposta;
	private int qtdDezenasPares;
	private int qtdDezenasImpares;
	private boolean gerarDezenasRandom;
	private List<Integer> dezenasExcluidas;
	private int maximoSalto;
	private int maximoSucessivas;
	private Integer qtdLinha1;
	private Integer qtdLinha2;
	private Integer qtdLinha3;
	private Integer qtdLinha4;
	private Integer qtdLinha5;

	
}
