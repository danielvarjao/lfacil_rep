package lfacil.analise.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioAnalise {

	boolean analiseUltimoSorteio;
	Integer analiseUltimosN;
	
}
