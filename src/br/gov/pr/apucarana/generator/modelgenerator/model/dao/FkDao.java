package br.gov.pr.apucarana.generator.modelgenerator.model.dao;

import java.util.Collection;
import br.gov.pr.apucarana.generator.modelgenerator.model.Fk;

/**
 * Interface para controle de objetos persistentes da classe Fk
 * 
 * Pattern Data Access Object
 * 
 * Mon Mar 01 14:34:24 BRT 2010
 *
 */
public interface FkDao {
	
	/**
	 * Salva objeto da classe Fk.
	 * 
	 * @param fk Objeto da classe Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void salvar(Fk fk) throws Exception;

	/**
	 * Altera objeto da classe Fk.
	 * 
	 * @param fk Objeto da classe Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void alterar(Fk fk) throws Exception;
	
	/**
	 * Exclui objeto da classe Fk.
	 * 
	 * @param fk Objeto da classe Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void excluir(Fk fk) throws Exception;
	
	/**
	 * Conta o n?mero objetos da classe Fk.
	 */
	public int contar() throws Exception;
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar(Fk example, Integer qtdPagina, Integer numPagina) throws Exception;
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar(Fk example) throws Exception;
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar(Integer qtdPagina, Integer numPagina) throws Exception;
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar() throws Exception;
	
	/**
	 * Obtem um objeto da classe Fk.
	 * 
	 * @param id Chave primaria do objeto
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Fk obter(long id) throws Exception;

}
