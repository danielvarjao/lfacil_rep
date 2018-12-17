package lfacil.analise.processa;

import java.io.File;
import java.util.ResourceBundle;

public class FactoryArquivos {
	
	static ResourceBundle res = ResourceBundle.getBundle("config");
	
	public static String getFileBaseTxt() {
		
		return new File(res.getString("baseTxt")).getAbsolutePath();
	}
	
	public static String getPathBase() {
		
		return new File(res.getString("path_base")).getAbsolutePath();
	}
	
	public static String getArquivoBaseHtml() {
		
		return new File(res.getString("arquivo_base_html")).getAbsolutePath();
	}
		
	public static String getArquivoBaseZip() {
		
		return new File(res.getString("arquivo_base_zip")).getAbsolutePath();
	}

}
