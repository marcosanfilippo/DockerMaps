package maps.hibernate;

import java.io.Serializable;

public class BusLineStopIdHibernate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BusStopHibernateImpl busStop;
	BusLineHibernateImpl busLine;
}
