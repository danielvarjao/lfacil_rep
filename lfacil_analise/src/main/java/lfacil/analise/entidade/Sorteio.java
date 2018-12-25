package lfacil.analise.entidade;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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

	
	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public Integer getBola1() {
		return bola1;
	}

	public void setBola1(String bola1) {
		this.bola1 = Integer.parseInt(bola1);
	}

	public Integer getBola2() {
		return bola2;
	}

	public void setBola2(String bola2) {
		this.bola2 = Integer.parseInt(bola2);
	}

	public Integer getBola3() {
		return bola3;
	}

	public void setBola3(String bola3) {
		this.bola3 = Integer.parseInt(bola3);
	}

	public Integer getBola4() {
		return bola4;
	}

	public void setBola4(String bola4) {
		this.bola4 = Integer.parseInt(bola4);
	}

	public Integer getBola5() {
		return bola5;
	}

	public void setBola5(String bola5) {
		this.bola5 = Integer.parseInt(bola5);
	}

	public Integer getBola6() {
		return bola6;
	}

	public void setBola6(String bola6) {
		this.bola6 = Integer.parseInt(bola6);
	}

	public Integer getBola7() {
		return bola7;
	}

	public void setBola7(String bola7) {
		this.bola7 = Integer.parseInt(bola7);
	}

	public Integer getBola8() {
		return bola8;
	}

	public void setBola8(String bola8) {
		this.bola8 = Integer.parseInt(bola8);
	}

	public Integer getBola9() {
		return bola9;
	}

	public void setBola9(String bola9) {
		this.bola9 = Integer.parseInt(bola9);
	}

	public Integer getBola10() {
		return bola10;
	}

	public void setBola10(String bola10) {
		this.bola10 = Integer.parseInt(bola10);
	}

	public Integer getBola11() {
		return bola11;
	}

	public void setBola11(String bola11) {
		this.bola11 = Integer.parseInt(bola11);
	}

	public Integer getBola12() {
		return bola12;
	}

	public void setBola12(String bola12) {
		this.bola12 = Integer.parseInt(bola12);
	}

	public Integer getBola13() {
		return bola13;
	}

	public void setBola13(String bola13) {
		this.bola13 = Integer.parseInt(bola13);
	}

	public Integer getBola14() {
		return bola14;
	}

	public void setBola14(String bola14) {
		this.bola14 = Integer.parseInt(bola14);
	}

	public Integer getBola15() {
		return bola15;
	}

	public void setBola15(String bola15) {
		this.bola15 = Integer.parseInt(bola15);
	}

}
