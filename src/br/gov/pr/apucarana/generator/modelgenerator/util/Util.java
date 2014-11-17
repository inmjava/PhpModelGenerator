package br.gov.pr.apucarana.generator.modelgenerator.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Util {

	public static String bdToCamelCase(String bdName) {
		if (bdName.startsWith("cd_") || bdName.startsWith("tb_") || bdName.startsWith("vw_")) {
			bdName = bdName.substring(3);
		}
		String[] aBdName = bdName.toLowerCase().split("_");
		boolean first = true;
		String camelName = "";
		for (String slice : aBdName) {
			if (first) {
				camelName = slice;
				first = false;
			} else {
				camelName += slice.substring(0, 1).toUpperCase() + slice.substring(1);
			}
		}
		return camelName;
	}

	public static boolean nomesEq(String bdName, String camelName) {
		return bdToCamelCase(bdName).equals(camelName);
	}

	public static String tabelaBdToCamelCase(String tabelaBdName) {
		String camelName = bdToCamelCase(tabelaBdName);
		return camelName.substring(0, 1).toUpperCase() + camelName.substring(1);
	}
	
	public static String getSetName(String bdName){
		String camelName = bdToCamelCase(bdName);
		return "set"+camelName.substring(0, 1).toUpperCase() + camelName.substring(1);
	}

	public static String getGetName(String bdName){
		String camelName = bdToCamelCase(bdName);
		return "get"+camelName.substring(0, 1).toUpperCase() + camelName.substring(1);
	}

	public static void main(String[] args) {
		System.out.println(firstUc("asdfas"));
	}

	public static void escreverEmArquivo(String arquivo, String conteudo) {
		try {
			File file = new File(arquivo);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(arquivo)));
			out.println(conteudo);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String replaceBarraPorPonto(String entrada) {
		return entrada.replaceAll("/", "\\.");
	}

	public static String replacePontoPorBarra(String entrada) {
		return entrada.replaceAll("\\.", "/");
	}
	
	public static String firstUc(String word){
		if(word == null || word.length() <= 0)
			return word;
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}
}
