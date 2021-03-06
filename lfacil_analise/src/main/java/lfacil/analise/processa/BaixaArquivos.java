package lfacil.analise.processa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BaixaArquivos {


	public static void main(String[] args) {

		try {
			
			BaixaArquivos gerador = new BaixaArquivos();
			ParseHtmlBaseLfacil parser = new ParseHtmlBaseLfacil();
			
			gerador.deletarArquivos();
			gerador.downloadBaseResultados();
			gerador.extrairZip();
			parser.gerarTxtResultados();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private void deletarArquivos() {
		
		File file = new File(FactoryArquivos.getPathBase());
		file.mkdir();
		
		for (File arq : file.listFiles()) {
			if (arq.isFile() && !(arq.getName().endsWith(".properties"))) {
				arq.delete();
			}
		}
		//Arrays.stream(yourDir.listFiles((f, p) -> p.endsWith("YOUR_FILE_EXTENSION"))).forEach(File::delete);  
		System.out.println("Arquivos removidos.");
	}
	
	private void downloadBaseResultados() throws IOException {
		
		String link = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/D_lotfac.zip";
		
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		
		URL url = new URL(link);
		 
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		InputStream in = connection.getInputStream();
		FileOutputStream fis = new FileOutputStream(FactoryArquivos.getArquivoBaseZip());
		
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = in.read(buffer, 0, 1024)) != -1) {
			fis.write(buffer, 0, count);
		}
		
		fis.close();
		in.close();
		
		System.out.println("Download efetuado.");
		
	}
	
	private void extrairZip() throws IOException{
		
		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(FactoryArquivos.getArquivoBaseZip()));
		
		ZipEntry zipEntry = zis.getNextEntry();
		
		while (zipEntry != null) {
			
			String fileName = zipEntry.getName();
            File newFile = new File(FactoryArquivos.getPathBase() + "/" + fileName);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
	}
	
}
