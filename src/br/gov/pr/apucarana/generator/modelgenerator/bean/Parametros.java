package br.gov.pr.apucarana.generator.modelgenerator.bean;

import java.util.Collection;
import java.util.LinkedList;

public class Parametros {

	private Tabela tabela;

	public Parametros(Tabela tabela) {
		this.setTabela(tabela);
	}

	public String getName() {
		return this.getTabela().getName();
	}

	public String getNameCamel() {
		return this.getTabela().getNameCamel();
	}

	public Collection<Coluna> getColunas() {
		return this.getTabela().getColunas();
	}
	
	public Collection<Coluna> getColunasFk() {
		return this.getTabela().getColunasFk();
	}
	
	public Collection<Coluna> getColunasFkPk() {
		return this.getTabela().getColunasFkPk();
	}
	
	public Collection<Coluna> getChavesPrimarias() {
		return this.getTabela().getChavesPrimarias();
	}

	public Collection<Coluna> getTodasColunas() {
		Collection<Coluna> todas = new LinkedList<Coluna>();
		todas.addAll(getChavesPrimarias());
		todas.addAll(getColunas());
		return todas;
	}
	
	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	public String getNameModel() {
		return this.getTabela().getNameModel();
	}

	public String getNameMapper() {
		return this.getTabela().getNameMapper();
	}

	public String getNameGateway() {
		return this.getTabela().getNameGateway();
	}
	
	public String getNameBanco() {
		return this.getTabela().getNameBanco();
	}
	
	public boolean isPossuidoraPk(){
		return getChavesPrimariasEFkPk().size() > 0 || hasTabelaExtends();
	}
	
	public boolean isArrayPk(){
		return getChavesPrimariasEFkPk().size() > 1;
	}
	
	public String getPkNmOrArrayPkNm(){
		return this.getTabela().getPkNmOrArrayPkNm();
	}
	
	public Collection<Coluna> getChavesPrimariasEFkPk() {
		return this.getTabela().getChavesPrimariasEFkPk();
	}
	
	public String getPkTypeOrArray(){
		return this.getPkTypeOrArray(false);
	}
	
	public String getPkTypeOrArray(boolean tipoModelo){
		return this.getTabela().getPkTypeOrArray(tipoModelo);
	}
	
	public String getPkParameterNames(String variavel){
		return this.getTabela().getPkParameterNames(variavel);
	}
	
	public String getPkDataOrPkDataArrayPkParameterNames(String variavel){
		return this.getTabela().getPkDataOrPkDataArrayPkParameterNames(variavel);
	}
	
	public Coluna getFirstPkColumn(){
		return this.getTabela().getFirstPkColumn();
	}
	
	public Collection<Tabela> getTabelasFk() {
		return this.getTabela().getTabelasFk();
	}

	public String getGetName(){
		return this.getTabela().getGetName();
	}
	
	public String getSetName(){
		return this.getTabela().getSetName();
	}
	
	public Tabela getTabelaExtends(){
		return this.getTabela().getTabelaExtends();
	}
	
	public boolean hasTabelaExtends(){
		return this.getTabela().hasTabelaExtends();		
	}
	
	public boolean hasUpdateMethod(){
		return this.getTabela().hasUpdateMethod();		
	}
	
	public String getVarNameCamel() {
		return this.getTabela().getVarNameCamel();
	}
}