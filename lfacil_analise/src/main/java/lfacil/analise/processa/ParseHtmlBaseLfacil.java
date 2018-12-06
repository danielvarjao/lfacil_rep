package lfacil.analise.processa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	private final String path_html = "C:\\Projetos\\lfacil_analise\\src\\main\\resources\\D_LOTFAC.HTM";
	private final String baseTxt = "C:\\Projetos\\lfacil_analise\\src\\main\\resources\\result.txt";

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
					sorteio.setBola1(Integer.parseInt(tds.get(2).text()));
					sorteio.setBola2(Integer.parseInt(tds.get(3).text()));
					sorteio.setBola3(Integer.parseInt(tds.get(4).text()));
					sorteio.setBola4(Integer.parseInt(tds.get(5).text()));
					sorteio.setBola5(Integer.parseInt(tds.get(6).text()));
					sorteio.setBola6(Integer.parseInt(tds.get(7).text()));
					sorteio.setBola7(Integer.parseInt(tds.get(8).text()));
					sorteio.setBola8(Integer.parseInt(tds.get(9).text()));
					sorteio.setBola9(Integer.parseInt(tds.get(10).text()));
					sorteio.setBola10(Integer.parseInt(tds.get(11).text()));
					sorteio.setBola11(Integer.parseInt(tds.get(12).text()));
					sorteio.setBola12(Integer.parseInt(tds.get(13).text()));
					sorteio.setBola13(Integer.parseInt(tds.get(14).text()));
					sorteio.setBola14(Integer.parseInt(tds.get(15).text()));
					sorteio.setBola15(Integer.parseInt(tds.get(16).text()));
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
		

		
	}
	
	

}
