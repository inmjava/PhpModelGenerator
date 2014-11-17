package br.gov.pr.apucarana.generator.modelgenerator.util;

import java.util.LinkedList;
import java.util.List;

import br.gov.pr.apucarana.generator.modelgenerator.model.Columns;
import br.gov.pr.apucarana.util.ApucaranaHibernateUtil;

public class HibernateUtil extends ApucaranaHibernateUtil{

	/* Transformando Hibernate Util em um Singleton - Início */
	private static final HibernateUtil instance = new HibernateUtil();

	private HibernateUtil() {}

	public static HibernateUtil getInstance() {
		return instance;
	}
	/* Transformando Hibernate Util em um Singleton - Fim */

	@Override
	@SuppressWarnings("unchecked")
	protected List<Class> getAnnotatedClasses() {
		LinkedList<Class> annotatedClasses = new LinkedList<Class>();
		annotatedClasses.add(Columns.class);
		return annotatedClasses;
	}

	@Override
	protected String getArquivoCfg() {
		return "hibernate.cfg.xml";
	}

}
