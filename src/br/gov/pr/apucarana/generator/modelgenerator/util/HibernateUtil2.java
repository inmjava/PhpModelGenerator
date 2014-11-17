package br.gov.pr.apucarana.generator.modelgenerator.util;

import java.util.LinkedList;
import java.util.List;

import br.gov.pr.apucarana.util.ApucaranaHibernateUtil;

public class HibernateUtil2 extends ApucaranaHibernateUtil{

	/* Transformando Hibernate Util em um Singleton - Início */
	private static final HibernateUtil2 instance = new HibernateUtil2();

	private HibernateUtil2() {}

	public static HibernateUtil2 getInstance() {
		return instance;
	}
	/* Transformando Hibernate Util em um Singleton - Fim */

	@Override
	@SuppressWarnings("unchecked")
	protected List<Class> getAnnotatedClasses() {
		LinkedList<Class> annotatedClasses = new LinkedList<Class>();
		return annotatedClasses;
	}

	@Override
	protected String getArquivoCfg() {
		return "hibernate2.cfg.xml";
	}

}
