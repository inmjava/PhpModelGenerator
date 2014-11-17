package br.gov.pr.apucarana.generator.modelgenerator.util;

import java.util.LinkedList;
import java.util.List;

import br.gov.pr.apucarana.generator.modelgenerator.model.Fk;
import br.gov.pr.apucarana.util.ApucaranaHibernateUtil;

public class HibernateUtil3 extends ApucaranaHibernateUtil{

	/* Transformando Hibernate Util em um Singleton - Início */
	private static final HibernateUtil3 instance = new HibernateUtil3();

	private HibernateUtil3() {}

	public static HibernateUtil3 getInstance() {
		return instance;
	}
	/* Transformando Hibernate Util em um Singleton - Fim */

	@Override
	@SuppressWarnings("unchecked")
	protected List<Class> getAnnotatedClasses() {
		LinkedList<Class> annotatedClasses = new LinkedList<Class>();
		annotatedClasses.add(Fk.class);
		return annotatedClasses;
	}

	@Override
	protected String getArquivoCfg() {
		return "hibernate3.cfg.xml";
	}

}
