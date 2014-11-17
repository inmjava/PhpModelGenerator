package br.gov.pr.apucarana.generator.modelgenerator.model.dao.factory;

import br.gov.pr.apucarana.generator.modelgenerator.model.dao.ColumnsDao;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.impl.ColumnsDaoHibernateImpl;

/**
 * Factory de instancias da classe Columns
 * 
 * Pattern Data Access Object
 *
 * Mon Mar 01 14:52:02 BRT 2010
 *
 */
public class ColumnsDaoFactory {
	
	public static final int HIBERNATE = 0;
	
	public static ColumnsDao createColumnsDao(int whichFactory) {
		switch (whichFactory) {
	    	case HIBERNATE: 
	    		return new ColumnsDaoHibernateImpl();
	    	default:
			return null;
		}
	}
	
	public static ColumnsDao createColumnsDao() {
		return ColumnsDaoFactory.createColumnsDao(ColumnsDaoFactory.HIBERNATE);
	}
	
}
