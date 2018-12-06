package lfacil.analise.entidade;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sorteio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String concurso;
	private Integer bola1;
	private Integer bola2;
	private Integer bola3;
	private Integer bola4;
	private Integer bola5;
	private Integer bola6;
	private Integer bola7;
	private Integer bola8;
	private Integer bola9;
	private Integer bola10;
	private Integer bola11;
	private Integer bola12;
	private Integer bola13;
	private Integer bola14;
	private Integer bola15;
	
	
	public void sort() {
		
		Integer[] vetor = {bola1, bola2, bola3, bola4, bola5, bola6, bola7,
				bola8, bola9, bola10, bola11, bola12, bola13, bola14, bola15};
		
		Integer aux = 0;
		
		for (int x=0; x<vetor.length-1; x++) {
			for (int y=(x+1); y<vetor.length; y++) {
				
				if (vetor[x] > vetor[y]) {
					aux = vetor[x];
					vetor[x] = vetor[y];
					vetor[y] = aux;
					
				}

			}
		}
		
		this.bola1 = vetor[0];
		this.bola2 = vetor[1];
		this.bola3 = vetor[2];
		this.bola4 = vetor[3];
		this.bola5 = vetor[4];
		this.bola6 = vetor[5];
		this.bola7 = vetor[6];
		this.bola8 = vetor[7];
		this.bola9 = vetor[8];
		this.bola10 = vetor[9];
		this.bola11 = vetor[10];
		this.bola12 = vetor[11];
		this.bola13 = vetor[12];
		this.bola14 = vetor[13];
		this.bola15 = vetor[14];
		
	}
	
	@Override
	public String toString() {
		return concurso + ";" + String.format("%02d", bola1) + ";" + String.format("%02d", bola2) + ";" + 
				String.format("%02d", bola3) + ";" + String.format("%02d", bola4) + ";" + String.format("%02d", bola5) + ";" +
				String.format("%02d", bola6) + ";" + String.format("%02d", bola7) + ";" + String.format("%02d", bola8) + ";" + 
				String.format("%02d", bola9) + ";" + String.format("%02d", bola10) + ";" + String.format("%02d",bola11) + ";" + 
				String.format("%02d", bola12) + ";" + String.format("%02d", bola13) + ";" + String.format("%02d", bola14) + ";" + 
				String.format("%02d", bola15);
	}

}
