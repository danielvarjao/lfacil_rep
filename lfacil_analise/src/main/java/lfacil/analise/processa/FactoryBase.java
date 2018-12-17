package lfacil.analise.processa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lfacil.analise.entidade.Sorteio;

public class FactoryBase {
	
	//private final String baseTxt = "C:\\Projetos\\lfacil_rep\\lfacil_analise\\src\\main\\resources\\result.txt";
	
	List<Sorteio> base;
	
	public FactoryBase() {

		try {
			this.loadBaseTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadBaseTxt() throws IOException {

		base = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FactoryArquivos.getFileBaseTxt()))) {
			String line;
			while ((line = br.readLine()) != null) {

				String[] linha = line.split(";");

				Sorteio sort = new Sorteio();
				sort.setConcurso(linha[0]);
				sort.setBola1(linha[1]);
				sort.setBola2(linha[2]);
				sort.setBola3(linha[3]);
				sort.setBola4(linha[4]);
				sort.setBola5(linha[5]);
				sort.setBola6(linha[6]);
				sort.setBola7(linha[7]);
				sort.setBola8(linha[8]);
				sort.setBola9(linha[9]);
				sort.setBola10(linha[10]);
				sort.setBola11(linha[11]);
				sort.setBola12(linha[12]);
				sort.setBola13(linha[13]);
				sort.setBola14(linha[14]);
				sort.setBola15(linha[15]);
						
				base.add(sort);

			}
		}

	}
	
	public Sorteio getSorteio(Integer numeroSorteio) {
		
		return this.base.get(numeroSorteio - 1);
	}
	
	public Sorteio getLastSorteio() {
		
		int ultimoIndex = this.base.size() - 1;
		return this.base.get(ultimoIndex);
	}
	
	public List<Sorteio> getLastNSorteios(Integer numeroSorteios){
		
		List<Sorteio> lista = new ArrayList<Sorteio>();
		
		int ultimoIndex = this.base.size() - 1;
		
		for (int i = ultimoIndex; i>(ultimoIndex - numeroSorteios); i--) {

			lista.add(this.base.get(i));
		}
		
		return lista;
		
	}
	
	public List<Integer> getDezenas(Sorteio sorteio) {
		
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(sorteio.getBola1());
		ret.add(sorteio.getBola2());
		ret.add(sorteio.getBola3());
		ret.add(sorteio.getBola4());
		ret.add(sorteio.getBola5());
		ret.add(sorteio.getBola6());
		ret.add(sorteio.getBola7());
		ret.add(sorteio.getBola8());
		ret.add(sorteio.getBola9());
		ret.add(sorteio.getBola10());
		ret.add(sorteio.getBola11());
		ret.add(sorteio.getBola12());
		ret.add(sorteio.getBola13());
		ret.add(sorteio.getBola14());
		ret.add(sorteio.getBola15());
		
		return ret;
	}
}
