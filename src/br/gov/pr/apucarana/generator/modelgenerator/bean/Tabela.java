package br.gov.pr.apucarana.generator.modelgenerator.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.gov.pr.apucarana.generator.modelgenerator.model.Columns;
import br.gov.pr.apucarana.generator.modelgenerator.model.Fk;
import br.gov.pr.apucarana.generator.modelgenerator.util.Util;

public class Tabela {

	private String name;
	private String nameBanco;
	private Coluna colunaFk;
	private Collection<Coluna> colunas;
	private Collection<Coluna> chavesPrimarias;
	private Collection<Coluna> colunasFk;
	private Collection<Coluna> colunasFkPk;
	private Collection<Tabela> tabelasFk;
	private Tabela tabelaExtends;
	private Tabela tabelaNM;
	private String nameModel;
	private String nameMapper;
	private String nameGateway;
	private boolean recursividade;

	public Tabela(String nameTabela, String nameBanco) throws Exception {
		this(nameTabela, nameBanco, true);
	}
	
	public Tabela(String nameTabela, String nameBanco, boolean recursividade) throws Exception {
		this.recursividade = recursividade;
		this.setName(nameTabela, nameBanco);
		this.setNameGateway("Default_Model_DbTable_" + this.getNameCamel());
		this.setNameMapper("Default_Model_Mapper_" + this.getNameCamel() + "Mapper");
		this.setNameModel("Default_Model_" + this.getNameCamel());
	}

	public String getName() {
		return name;
	}

	public void setName(String name, String nameBanco) throws Exception {
		this.name = name;
		this.setNameBanco(nameBanco);
		this.setColunas(nameBanco);
	}
	
	public Collection<Coluna> getChavesPrimarias() {
		return chavesPrimarias;
	}

	public Collection<Coluna> getColunas() {
		return colunas;
	}
	
	public String getNameBanco() {
		return nameBanco;
	}

	public void setNameBanco(String nameBanco) {
		this.nameBanco = nameBanco;
	}

	public Collection<Coluna> getColunasFk() {
		return colunasFk;
	}

	public void setColunasFk(Collection<Coluna> colunasFk) {
		this.colunasFk = colunasFk;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColunas(Collection<Coluna> colunas) {
		this.colunas = colunas;
	}

	public void setChavesPrimarias(Collection<Coluna> chavesPrimarias) {
		this.chavesPrimarias = chavesPrimarias;
	}

	public Collection<Coluna> getColunasFkPk() {
		return colunasFkPk;
	}

	public void setColunasFkPk(Collection<Coluna> colunasFkPk) {
		this.colunasFkPk = colunasFkPk;
	}

	public boolean isRecursividade() {
		return recursividade;
	}

	public void setRecursividade(boolean recursividade) {
		this.recursividade = recursividade;
	}

	public Coluna getColunaFk() {
		return colunaFk;
	}

	public void setColunaFk(Coluna colunaFk) {
		this.colunaFk = colunaFk;
	}

	public Collection<Tabela> getTabelasFk() {
		return tabelasFk;
	}

	public void setTabelasFk(Collection<Tabela> tabelasFk) {
		this.tabelasFk = tabelasFk;
	}

	public Tabela getTabelaExtends() {
		return tabelaExtends;
	}

	public void setTabelaExtends(Tabela tabelaExtends) {
		this.tabelaExtends = tabelaExtends;
	}

	public Tabela getTabelaNM() {
		return tabelaNM;
	}

	public void setTabelaNM(Tabela tabelaNM) {
		this.tabelaNM = tabelaNM;
	}
	
	public boolean isTabelaNM(){
		return (this.getTabelaNM() != null && !this.getTabelaNM().equals(""));
	}

	public void setColunas(String nameBanco) throws Exception {

		Collection<Columns> colunas = Columns.getColunas(nameBanco, this.getName());
		this.colunas = new ArrayList<Coluna>();
		this.colunasFk = new ArrayList<Coluna>();
		this.colunasFkPk = new ArrayList<Coluna>();
		this.chavesPrimarias = new ArrayList<Coluna>();
		this.tabelasFk = new ArrayList<Tabela>();
		this.tabelaExtends = null;
		
		if(this.recursividade)
			this.setTabelasFk(Fk.getTabelasEFksByTabelaDest(this.getName(), this.getNameBanco()));
		
		for (Columns column : colunas) {
			Coluna coluna = new Coluna();
			coluna.setTabelaPai(this);
			coluna.setNameBd(column.getColumn_name());
			coluna.setTipo(tiposMySql2Php(column.getColumn_type()));
			if (this.getName().startsWith("vw_")) {
				coluna.setTipo("string");
			}

			// verifica se coluna é fk
			Fk fk = null;
			if(this.recursividade)
				fk = Fk.getTabelaDestEPkByFk(this.getName(), column.getColumn_name());

			if (fk != null){

				if(fk.getIs_extends().equals("S")){
					this.tabelaExtends = new Tabela(fk.getTabela_dest(), this.getNameBanco(), false);
					Coluna colunaFk = new Coluna();
					colunaFk.setNameBd(fk.getFk_dest());
					colunaFk.setTipo("int"); // pode ser alterado se necessário
					
					this.tabelaExtends.setColunaFk(colunaFk);
					this.chavesPrimarias.add(coluna);
				}else{
					Coluna colunaFk = new Coluna();
					colunaFk.setNameBd(fk.getFk_dest());
					colunaFk.setTipo("int"); // pode ser alterado se necessário
		
					coluna.setColunaFk(colunaFk);
					coluna.setTabelaFk(new Tabela(fk.getTabela_dest(), this.getNameBanco(), false));
					this.colunasFk.add(coluna);
					if (column.getColumn_key().equals("PRI")) {
						this.colunasFkPk.add(coluna);
					}
				}
			} else if (column.getColumn_key().equals("PRI")) {
				this.chavesPrimarias.add(coluna);
			} else if (this.getName().startsWith("vw_") && column.getColumn_name().equals("id")) {
				coluna.setTipo("int");
				this.chavesPrimarias.add(coluna);
			} else {
				this.colunas.add(coluna);
			}
		}
	}

	public Coluna getFirstPkColumn(){
		return getChavesPrimariasEFkPk().iterator().next();
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	public String getNameMapper() {
		return nameMapper;
	}

	public void setNameMapper(String nameMapper) {
		this.nameMapper = nameMapper;
	}

	public String getNameGateway() {
		return nameGateway;
	}

	public void setNameGateway(String nameGateway) {
		this.nameGateway = nameGateway;
	}

	private String tiposMySql2Php(String type) {
		return type.toLowerCase().startsWith("varchar") ? "string" : type.toLowerCase().startsWith("datetime") ? "date" : type.toLowerCase().startsWith("int") ? "int" : "";
	}

	public String getNameCamel() {
		return Util.tabelaBdToCamelCase(this.getName());
	}

	public String getVarNameCamel() {
		return Util.bdToCamelCase(this.getName());
	}

	public String getSetName() {
		return Util.getSetName(this.getName());
	}

	public String getGetName() {
		return Util.getGetName(this.getName());
	}
	
	public boolean hasTabelaExtends() {
		return this.getTabelaExtends() != null;
	}
	
	public boolean hasUpdateMethod() {
		Collection<Coluna> fks = new ArrayList<Coluna>();
		fks.addAll(this.getColunasFk());
		fks.removeAll(this.getColunasFkPk());
		return this.getColunas().size() + fks.size() > 0;
	}

	public Collection<Coluna> getChavesPrimariasEFkPk() {
		List<Coluna> pks = new ArrayList<Coluna>();
		pks.addAll(getChavesPrimarias());
		pks.addAll(getColunasFkPk());
		return pks;
	}
	
	public String getPkNmOrArrayPkNm(){
		Collection<Coluna> chavesPrimarias = getChavesPrimariasEFkPk();
		if (chavesPrimarias.size() <= 0) {
			throw new RuntimeException("A tabela " + this.getName() + "não possui uma pk definida.");
		}
		if(chavesPrimarias.size() == 1){
			return "'" + chavesPrimarias.iterator().next().getNameBd() + "'";
		}
		String out = "array(";
		for (Coluna coluna : chavesPrimarias) {
			out += "'" + coluna.getNameBd() + "', ";
		}
		out = out.substring(0, out.length() - 2) + ")";
		return out;
	}
	
	public String getPkTypeOrArray(boolean tipoModelo){
		Collection<Coluna> chavesPrimarias = getChavesPrimariasEFkPk();
		if (chavesPrimarias.size() <= 0) {
			throw new RuntimeException("A tabela " + this.getName() + " não possui uma pk definida.");			
		}
		if(chavesPrimarias.size() == 1){
			return (tipoModelo && chavesPrimarias.iterator().next().isColunaFkPk(this.getColunasFkPk())) ? chavesPrimarias.iterator().next().getTabelaFk().getNameModel() : chavesPrimarias.iterator().next().getTipo();
		}
		return "array";
	}
	
	public String getPkParameterNames(String variavel){
		Collection<Coluna> chavesPrimarias = getChavesPrimariasEFkPk();
		if (chavesPrimarias.size() <= 0) {
			throw new RuntimeException("A tabela " + this.getName() + "não possui uma pk definida.");			
		}
		String out = "";
		for (Coluna coluna : chavesPrimarias) {
			out += "$" + coluna.getNameCamel() + ", ";
		}
		out = out.substring(0, out.length() - 2) + "";
		return out;
	}
	
	public String getPkDataOrPkDataArrayPkParameterNames(String variavel){
		if (chavesPrimarias.size() <= 0) {
			throw new RuntimeException("A tabela " + this.getName() + "não possui uma pk definida.");			
		}
		if(chavesPrimarias.size() == 1){
			return "$" + chavesPrimarias.iterator().next().getNameCamel();
		}
		String out = "array(";
		for (Coluna coluna : chavesPrimarias) {
			out += "'" + coluna.getNameCamel() + "' => $" + coluna.getNameCamel()+ ", ";
		}
		out = out.substring(0, out.length() - 2) + ")";
		return out;
	}
	
	public String getByColunaFK(){
		if(this.getColunaFk() == null || this.getColunaFk().getTabelaPai().getNameCamel().equals(Util.firstUc(this.getColunaFk().getNameCamel())))
			return "";
		return "By"+Util.firstUc(this.getColunaFk().getNameCamel());
	}
}
