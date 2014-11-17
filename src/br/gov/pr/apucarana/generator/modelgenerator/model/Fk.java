package br.gov.pr.apucarana.generator.modelgenerator.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Coluna;
import br.gov.pr.apucarana.generator.modelgenerator.bean.Tabela;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.FkDao;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.factory.FkDaoFactory;

@Entity
@Table(name = "fk")
public class Fk {

	@Id
	private int id;
	private String tabela;
	private String fk;
	private String tabela_dest;
	private String fk_dest;
	private String is_extends;
	private String tabela_nm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getFk() {
		return fk;
	}

	public void setFk(String fk) {
		this.fk = fk;
	}

	public String getTabela_dest() {
		return tabela_dest;
	}

	public void setTabela_dest(String tabela_dest) {
		this.tabela_dest = tabela_dest;
	}

	public String getFk_dest() {
		return fk_dest;
	}

	public void setFk_dest(String fk_dest) {
		this.fk_dest = fk_dest;
	}
	
	public String getIs_extends() {
		return is_extends;
	}

	public void setIs_extends(String is_extends) {
		this.is_extends = is_extends;
	}
	
	public String getTabela_nm() {
		return tabela_nm;
	}

	public void setTabela_nm(String tabela_nm) {
		this.tabela_nm = tabela_nm;
	}

	public static Fk getTabelaDestEPkByFk(String tabela, String fk) throws Exception{
		FkDao fkDao = FkDaoFactory.createFkDao();
		Fk example = new Fk();
		example.setTabela(tabela);
		example.setFk(fk);
		Collection<Fk> collection = fkDao.listar(example);
		if(collection.size() <= 0)
			return null;
		return collection.iterator().next();
	}
	
	public static Collection<Tabela> getTabelasEFksByTabelaDest(String tabela, String nomeBd) throws Exception{
		FkDao fkDao = FkDaoFactory.createFkDao();
		Fk example = new Fk();
		example.setTabela_dest(tabela);
		Collection<Fk> collection = fkDao.listar(example);
		if(collection.size() <= 0)
			return new ArrayList<Tabela>();

		Collection<Tabela> collection2 = new ArrayList<Tabela>();
		for (Iterator<Fk> iterator = collection.iterator(); iterator.hasNext();) {
			Fk fk = iterator.next();
			Tabela tabelaOr = new Tabela(fk.getTabela(), nomeBd, false);
			Tabela tabelaPai = new Tabela(fk.getTabela_dest(), nomeBd, false);
			if(fk.getTabela_nm() != null && !fk.getTabela_nm().equals(""))
				tabelaOr.setTabelaNM(new Tabela(fk.getTabela_nm(), nomeBd, false));
			
			Coluna col = new Coluna();
			col.setNameBd(fk.getFk());
			col.setTipo("int"); // pode ser alterado se necessário
			
			tabelaOr.setColunaFk(col);
			tabelaOr.getColunaFk().setTabelaPai(tabelaPai);
			
			collection2.add(tabelaOr);
		}
		return collection2;
	}
	
	public static void main(String[] args) throws Exception {
		FkDao fkDao = FkDaoFactory.createFkDao();
		Fk fk2 = new Fk();
		fk2.setTabela_dest("tb_modulo");
		for (Fk fk : fkDao.listar(fk2)) {
			System.out.println(fk.getTabela());
		}
	}
}