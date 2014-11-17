package br.gov.pr.apucarana.generator.modelgenerator.bean;

import java.util.Collection;

import br.gov.pr.apucarana.generator.modelgenerator.util.Util;

public class Coluna {

	private String nameBd;
	private String tipo;
	private Tabela tabelaPai;
	private Tabela tabelaFk;
	private Coluna colunaFk;

	public String getNameBd() {
		return nameBd;
	}

	public void setNameBd(String nameBd) {
		this.nameBd = nameBd;
	}

	public String getVarNameCamel() {
		return Util.bdToCamelCase(this.getNameBd());
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNameCamel() {
		return Util.bdToCamelCase(this.getNameBd());
	}

	public String getSetName() {
		return Util.getSetName(this.getNameBd());
	}

	public String getGetName() {
		return Util.getGetName(this.getNameBd());
	}
	
	public Tabela getTabelaFk() {
		return tabelaFk;
	}

	public void setTabelaFk(Tabela tabelaFk) {
		this.tabelaFk = tabelaFk;
	}
	
	public Coluna getColunaFk() {
		return colunaFk;
	}

	public String getSetNameColunaFk() {
		return Util.getSetName(this.getNameBd());
	}

	public String getGetNameColunaFk() {
		return Util.getGetName(this.getNameBd());
	}

	public void setColunaFk(Coluna colunaFk) {
		this.colunaFk = colunaFk;
	}
	
	public Tabela getTabelaPai() {
		return tabelaPai;
	}

	public void setTabelaPai(Tabela tabelaPai) {
		this.tabelaPai = tabelaPai;
	}

	public String getAttCasted() {
		String code = "";
		if(this.tabelaFk != null) {
			code = "$" + this.getVarNameCamel();
		} else if (this.getTipo().equals("date")) {
			code = "date($" + this.getNameCamel()+ ")";
		} else if (this.getTipo().equals("int")) {
			code = "(" + this.getTipo() + ") $" + this.getNameCamel();
		}else if (this.getTipo().equals("string")){
			code = "str_replace(\"\\\\\\\\\", \"\\\\\", str_replace(\"\\\\\\\"\", \"\\\"\", $" + this.getNameCamel() +"))";
		}
		return code;
	}
	
	public boolean isColunaFkPk(Collection<Coluna> fkspks){
		return fkspks.contains(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Coluna)obj).getNameBd().equals(this.getNameBd()) && ((Coluna)obj).getTabelaPai().getName().equals(this.getTabelaPai().getName());
	}

	public String getEqualOrLike() {
		return this.getTipo().equals("string") ? "like" : "=";
	}
}
