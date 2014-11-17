package br.gov.pr.apucarana.generator.modelgenerator.model.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import br.gov.pr.apucarana.generator.modelgenerator.util.HibernateUtil;
import br.gov.pr.apucarana.generator.modelgenerator.model.Columns;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.ColumnsDao;

/**
 * Implementacao do acesso a dados da classe Columns via 
 * Hibernate
 * 
 * Pattern Data Access Object
 *
 * Mon Mar 01 14:52:02 BRT 2010
 *
 */
 public class ColumnsDaoHibernateImpl implements ColumnsDao {
	
	private static boolean dev = false;
	
	public ColumnsDaoHibernateImpl() {
		
	}
	
	/**
	 * Salva objeto da classe Columns.
	 * 
	 * @param columns Objeto da classe Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void salvar(Columns columns) throws Exception {
		Session session = HibernateUtil.getInstance().getSession();
		try {
			HibernateUtil.getInstance().beginTransaction();	
			session.save(columns);
			HibernateUtil.getInstance().commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.getInstance().rollbackTransaction();
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil.getInstance().closeSession();
		}
	}

	
	/**
	 * Altera objeto da classe Columns.
	 * 
	 * @param columns Objeto da classe Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void alterar(Columns columns) throws Exception {
		Session session = HibernateUtil.getInstance().getSession();
		try {
			HibernateUtil.getInstance().beginTransaction();
			session.update(columns);
			HibernateUtil.getInstance().commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.getInstance().rollbackTransaction();
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil.getInstance().closeSession();
		}
	}
	
	/**
	 * Exclui objeto da classe Columns.
	 * 
	 * @param columns Objeto da classe Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void excluir(Columns columns) throws Exception {
		Session session = HibernateUtil.getInstance().getSession();
		try {
			HibernateUtil.getInstance().beginTransaction();
			session.delete(columns);
			HibernateUtil.getInstance().commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.getInstance().rollbackTransaction();
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil.getInstance().closeSession();
		}
	}
	
	/**
	 * Conta o n?mero objetos da classe Columns.
	 */
	public int contar() throws Exception {
		Session session = HibernateUtil.getInstance().getSession();
		try {
			Criteria q = session.createCriteria(Columns.class).setProjection(Projections.rowCount());
			return (Integer) q.list().get(0);
		} catch (HibernateException e) {
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil.getInstance().closeSession();
		}
	}
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	@SuppressWarnings("unchecked")
	public Collection<Columns> listar(Columns example, Integer qtdPagina, Integer numPagina) throws Exception {
		Collection<Columns> coll = new ArrayList<Columns>();
		Session session = HibernateUtil.getInstance().getSession();
		try {
			Criteria q = session.createCriteria(Columns.class);
			if(example != null){
				Example sample = Example.create(example);
				sample.enableLike();
				sample.excludeZeroes();
				q.add(sample);
			}
			if (qtdPagina != null && numPagina != null) {
				q.setMaxResults(qtdPagina.intValue());
				q.setFirstResult( (numPagina.intValue()-1) * qtdPagina.intValue() );
			}
			List<Columns> list = q.list();
			coll = list;
		} catch (HibernateException e) {
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil.getInstance().closeSession();
		}
		return coll;
	}
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar(Columns example) throws Exception {
		return this.listar(example, null, null);
	}
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar(Integer qtdPagina, Integer numPagina) throws Exception {
		return this.listar(null, qtdPagina, numPagina);
	}
	
	/**
	 * Listagem de objetos da classe Columns.
	 * 
	 * @return Lista de objetos Columns
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Columns> listar() throws Exception {
		return this.listar(null, null, null);
	}
		
	/**
	 * Obtem um objeto da classe Columns.
	 * 
	 * @param id Chave primaria do objeto
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Columns obter(long id) throws Exception {
		Session session = HibernateUtil.getInstance().getSession();
		try {
			return (Columns)session.get(Columns.class, id);
		} catch (HibernateException e) {
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil.getInstance().closeSession();
		}
	}
}
