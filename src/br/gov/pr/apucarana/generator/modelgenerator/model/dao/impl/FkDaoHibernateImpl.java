package br.gov.pr.apucarana.generator.modelgenerator.model.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import br.gov.pr.apucarana.generator.modelgenerator.util.HibernateUtil3;
import br.gov.pr.apucarana.generator.modelgenerator.model.Fk;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.FkDao;

/**
 * Implementacao do acesso a dados da classe Fk via 
 * Hibernate
 * 
 * Pattern Data Access Object
 *
 * Mon Mar 01 14:34:24 BRT 2010
 *
 */
 public class FkDaoHibernateImpl implements FkDao {
	
	private static boolean dev = false;
	
	public FkDaoHibernateImpl() {
		
	}
	
	/**
	 * Salva objeto da classe Fk.
	 * 
	 * @param fk Objeto da classe Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void salvar(Fk fk) throws Exception {
		Session session = HibernateUtil3.getInstance().getSession();
		try {
			HibernateUtil3.getInstance().beginTransaction();	
			session.save(fk);
			HibernateUtil3.getInstance().commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil3.getInstance().rollbackTransaction();
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil3.getInstance().closeSession();
		}
	}

	
	/**
	 * Altera objeto da classe Fk.
	 * 
	 * @param fk Objeto da classe Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void alterar(Fk fk) throws Exception {
		Session session = HibernateUtil3.getInstance().getSession();
		try {
			HibernateUtil3.getInstance().beginTransaction();
			session.update(fk);
			HibernateUtil3.getInstance().commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil3.getInstance().rollbackTransaction();
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil3.getInstance().closeSession();
		}
	}
	
	/**
	 * Exclui objeto da classe Fk.
	 * 
	 * @param fk Objeto da classe Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public void excluir(Fk fk) throws Exception {
		Session session = HibernateUtil3.getInstance().getSession();
		try {
			HibernateUtil3.getInstance().beginTransaction();
			session.delete(fk);
			HibernateUtil3.getInstance().commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil3.getInstance().rollbackTransaction();
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil3.getInstance().closeSession();
		}
	}
	
	/**
	 * Conta o n?mero objetos da classe Fk.
	 */
	public int contar() throws Exception {
		Session session = HibernateUtil3.getInstance().getSession();
		try {
			Criteria q = session.createCriteria(Fk.class).setProjection(Projections.rowCount());
			return (Integer) q.list().get(0);
		} catch (HibernateException e) {
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil3.getInstance().closeSession();
		}
	}
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	@SuppressWarnings("unchecked")
	public Collection<Fk> listar(Fk example, Integer qtdPagina, Integer numPagina) throws Exception {
		Collection<Fk> coll = new ArrayList<Fk>();
		Session session = HibernateUtil3.getInstance().getSession();
		try {
			Criteria q = session.createCriteria(Fk.class);
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
			List<Fk> list = q.list();
			coll = list;
		} catch (HibernateException e) {
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil3.getInstance().closeSession();
		}
		return coll;
	}
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @param example Objeto com atributos para listagem 
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar(Fk example) throws Exception {
		return this.listar(example, null, null);
	}
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @param qtdPagina quantidade de itens listados em cada pagina 
	 * @param numPagina numero da pagina a ser buscada
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar(Integer qtdPagina, Integer numPagina) throws Exception {
		return this.listar(null, qtdPagina, numPagina);
	}
	
	/**
	 * Listagem de objetos da classe Fk.
	 * 
	 * @return Lista de objetos Fk
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Collection<Fk> listar() throws Exception {
		return this.listar(null, null, null);
	}
		
	/**
	 * Obtem um objeto da classe Fk.
	 * 
	 * @param id Chave primaria do objeto
	 * @throws Exception Caso ocorra erro com hibernate/conexao.
	 */
	public Fk obter(long id) throws Exception {
		Session session = HibernateUtil3.getInstance().getSession();
		try {
			return (Fk)session.get(Fk.class, id);
		} catch (HibernateException e) {
			if (dev) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			HibernateUtil3.getInstance().closeSession();
		}
	}
}
