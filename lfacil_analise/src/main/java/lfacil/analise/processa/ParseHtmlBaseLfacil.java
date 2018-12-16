package lfacil.analise.processa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lfacil.analise.entidade.Sorteio;

public class ParseHtmlBaseLfacil {
	
	private final String path_html = "C:\\Projetos\\lfacil_rep\\lfacil_analise\\src\\main\\resources\\D_LOTFAC.HTM";
	private final String baseTxt = "C:\\Projetos\\lfacil_rep\\lfacil_analise\\src\\main\\resources\\result.txt";

	public static void main(String[] args) {

		ParseHtmlBaseLfacil parse = new ParseHtmlBaseLfacil();
		
		try {
			parse.gerarTxtResultados();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private void gerarTxtResultados() throws IOException {
		
		File base = new File(this.path_html);
		
		List<Sorteio> listSorteios = new ArrayList<Sorteio>(); 
		
		Document doc = Jsoup.parse(base, null);
		
		Elements tables = doc.select("table");
		
		for (Element table : tables) {
			
			Elements trs = table.select("tr");
			
			for (Element tr : trs) {
				
				Elements tds = tr.select("td");
				
				if (tds.size() == 33) { //linha inicial de um sorteio
					
					Sorteio sorteio = new Sorteio();
					sorteio.setConcurso(tds.get(0).text());
					sorteio.setBola1(tds.get(2).text());
					sorteio.setBola2(tds.get(3).text());
					sorteio.setBola3(tds.get(4).text());
					sorteio.setBola4(tds.get(5).text());
					sorteio.setBola5(tds.get(6).text());
					sorteio.setBola6(tds.get(7).text());
					sorteio.setBola7(tds.get(8).text());
					sorteio.setBola8(tds.get(9).text());
					sorteio.setBola9(tds.get(10).text());
					sorteio.setBola10(tds.get(11).text());
					sorteio.setBola11(tds.get(12).text());
					sorteio.setBola12(tds.get(13).text());
					sorteio.setBola13(tds.get(14).text());
					sorteio.setBola14(tds.get(15).text());
					sorteio.setBola15(tds.get(16).text());
					sorteio.sort();
					
					listSorteios.add(sorteio);
					//System.out.println(sorteio);
				}

				
			}
			
		}
		
		
		File baseTxt = new File(this.baseTxt);
		
		FileOutputStream fos = new FileOutputStream(baseTxt);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for (Sorteio s : listSorteios) {
			bw.write(s.toString());
			bw.newLine();
		}
		bw.close();
		
		System.out.println("Base em TXT carregada.");
		
	}
	
	

}
