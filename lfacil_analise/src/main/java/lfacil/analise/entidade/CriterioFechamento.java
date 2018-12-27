package lfacil.analise.entidade;

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
	
}
