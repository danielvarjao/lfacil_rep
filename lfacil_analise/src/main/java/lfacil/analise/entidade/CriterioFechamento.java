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
	
	private Integer qtdDezenas;
	private Integer qtdJogos;
	private Integer qtdDezenasAposta;
	private Integer qtdDezenasPares;
	private Integer qtdDezenasImpares;
	private boolean gerarDezenasRandom;
	private List<Integer> dezenasExcluidas;
	private List<Integer> dezenasFixas;
	private Integer maximoSalto;
	private Integer maximoSucessivas;
	private Integer qtdLinha1;
	private Integer qtdLinha2;
	private Integer qtdLinha3;
	private Integer qtdLinha4;
	private Integer qtdLinha5;
	private boolean gravarFechamento;
	
}
