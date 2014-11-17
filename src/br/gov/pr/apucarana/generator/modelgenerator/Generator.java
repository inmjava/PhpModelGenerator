package br.gov.pr.apucarana.generator.modelgenerator;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Parametros;
import br.gov.pr.apucarana.generator.modelgenerator.bean.Tabela;
import br.gov.pr.apucarana.generator.modelgenerator.templates.GatewayTemplate;
import br.gov.pr.apucarana.generator.modelgenerator.templates.MapperTemplate;
import br.gov.pr.apucarana.generator.modelgenerator.templates.ModelTemplate;
import br.gov.pr.apucarana.generator.modelgenerator.util.Util;

public class Generator {

	private String dirCodGen;
	private Parametros parametros;

	public String getDirCodGen() {
		return dirCodGen;
	}

	public void setDirCodGen(String dirCodGen) {
		this.dirCodGen = dirCodGen;
	}

	public Parametros getParametros() {
		return parametros;
	}

	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}

	public Generator(String dirCodGer, String nomeTabela) throws Exception {
		this(dirCodGer, nomeTabela, null);
	}
	public Generator(String dirCodGer, String nomeTabela, String db) throws Exception {
		this.setParametros(new Parametros(new Tabela(nomeTabela, db)));
		this.setDirCodGen(dirCodGer);
	}

	public void gerarModel() {
		try {
			String code = new ModelTemplate().generate(this.getParametros());
			String path = this.getDirCodGen() + "/";
			Util.escreverEmArquivo(path + this.getParametros().getTabela().getNameCamel() + ".php", code);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gerarMapper() {
		try {
			String code = new MapperTemplate().generate(this.getParametros());
			String path = this.getDirCodGen() + "/";
			Util.escreverEmArquivo(path + "/Mapper/" + this.getParametros().getTabela().getNameCamel() + "Mapper.php", code);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gerarGateway() {
		try {
			String code = new GatewayTemplate().generate(this.getParametros());
			String path = this.getDirCodGen() + "/";
			Util.escreverEmArquivo(path + "/DbTable/" + this.getParametros().getTabela().getNameCamel() + ".php", code);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gerarTudo() {
		gerarModel();
		gerarMapper();
		gerarGateway();
	}
}
