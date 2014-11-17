package br.gov.pr.apucarana.generator.modelgenerator.model.dao.factory;

import br.gov.pr.apucarana.generator.modelgenerator.model.dao.FkDao;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.impl.FkDaoHibernateImpl;

/**
 * Factory de instancias da classe Fk
 * 
 * Pattern Data Access Object
 *
 * Mon Mar 01 14:34:24 BRT 2010
 *
 */
public class FkDaoFactory {
	
	public static final int HIBERNATE = 0;
	
	public static FkDao createFkDao(int whichFactory) {
		switch (whichFactory) {
	    	case HIBERNATE: 
	    		return new FkDaoHibernateImpl();
	    	default:
			return null;
		}
	}
	
	public static FkDao createFkDao() {
		return FkDaoFactory.createFkDao(FkDaoFactory.HIBERNATE);
	}
	
}
