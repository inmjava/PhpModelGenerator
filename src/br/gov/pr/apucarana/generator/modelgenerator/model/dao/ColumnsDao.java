package br.gov.pr.apucarana.generator.modelgenerator.model.dao;

import java.util.Collection;
import br.gov.pr.apucarana.generator.modelgenerator.model.Columns;

/**
 * Interface para controle de objetos persistentes da classe Columns
 * 
 * Pattern Data Access Object
 * 
 * Mon Mar 01 14:52:02 BRT 2010
 *
 */
public interface ColumnsDao {
	
	/**
	 * Salva objeto da classe Columns.
	 * 
	 * @param columns Objeto da classe Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void salvar(Columns columns) throws Exception;

	/**
	 * Altera objeto da classe Columns.
	 * 
	 * @param columns Objeto da classe Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void alterar(Columns columns) throws Exception;
	
	/**
	 * Exclui objeto da classe Columns.
	 * 
	 * @param columns Objeto da classe Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void excluir(Columns columns) throws Exception;
	
	/**
	 * Conta o n?mero objetos da classe Columns.
	 */
	public int contar() throws Exception;
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar(Columns example, Integer qtdPagina, Integer numPagina) throws Exception;
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar(Columns example) throws Exception;
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar(Integer qtdPagina, Integer numPagina) throws Exception;
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar() throws Exception;
	
	/**
	 * Obtem um objeto da classe Columns.
	 * 
	 * @param id Chave primaria do objeto
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Columns obter(long id) throws Exception;

}
