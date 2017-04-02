package maps.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import maps.dummy.BusLineImpl;
import maps.dummy.BusLineServiceImpl;
import maps.dummy.BusLineStopImpl;
import maps.dummy.BusStopImpl;
import maps.dummy.BusStopServiceImpl;
import maps.hibernate.service.BusLineServiceHibernateImpl;
import maps.hibernate.service.BusStopServiceHibernateImpl;
import maps.interfaces.BusLineStop;

@WebListener
public class OurWebListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Boolean demoMode = false;
		
		try
		{
			if ( demoMode )
			{
				BusLineServiceImpl busLineServiceImpl = new BusLineServiceImpl();
				BusStopServiceImpl busStopServiceImpl = new BusStopServiceImpl();
		    	
		    	busStopServiceImpl.addBusStop(new BusStopImpl("891", "IV NOVEMBRE", 44.99331, 7.64493, new ArrayList<>()));
		    	busStopServiceImpl.addBusStop(new BusStopImpl("892", "VITTORIO VENETO", 44.99485, 7.64657, new ArrayList<>()));
		    	busStopServiceImpl.addBusStop(new BusStopImpl("893", "VITTORIO VENETO", 44.99521, 7.64727, new ArrayList<>()));
		    	busStopServiceImpl.addBusStop(new BusStopImpl("894", "DIAZ", 44.99697, 7.64906, new ArrayList<>()));
		    	busStopServiceImpl.addBusStop(new BusStopImpl("895", "DIAZ", 44.99708, 7.64955, new ArrayList<>()));
		    	
		    	busLineServiceImpl.addBusLine(new BusLineImpl("14", "Linea 14", null));
		    	busLineServiceImpl.addBusLine(new BusLineImpl("1N", "Linea 1N", null));
		    	busLineServiceImpl.addBusLine(new BusLineImpl("35", "Linea 35", null));
		    	busLineServiceImpl.addBusLine(new BusLineImpl("35N", "Linea 35N", null));
		    	busLineServiceImpl.addBusLine(new BusLineImpl("39", "Linea 39", null));
		    	busLineServiceImpl.addBusLine(new BusLineImpl("96", "Linea 96", null));
		    	
		    	ArrayList<BusLineStop> l14 = new ArrayList<>();
		    	l14.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("891"),busLineServiceImpl.getBusLine("14"),1));
		    	l14.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("892"),busLineServiceImpl.getBusLine("14"),2));
		    	
		    	ArrayList<BusLineStop> l1n = new ArrayList<>();
		    	l1n.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("891"),busLineServiceImpl.getBusLine("1N"),1));
		    	l1n.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("893"),busLineServiceImpl.getBusLine("1N"),2));
		    	l1n.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("895"),busLineServiceImpl.getBusLine("1N"),3));
		    	
		    	ArrayList<BusLineStop> l35 = new ArrayList<>();
		    	l35.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("891"),busLineServiceImpl.getBusLine("35"),1));
		    	l35.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("892"),busLineServiceImpl.getBusLine("35"),2));
		    	l35.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("893"),busLineServiceImpl.getBusLine("35"),3));
		    	l35.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("894"),busLineServiceImpl.getBusLine("35"),4));
		    	l35.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("895"),busLineServiceImpl.getBusLine("35"),5));
		    	
		    	ArrayList<BusLineStop> l35n = new ArrayList<>();
		    	l35n.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("891"),busLineServiceImpl.getBusLine("35N"),1));
		    	l35n.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("893"),busLineServiceImpl.getBusLine("35N"),2));
		    	l35n.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("895"),busLineServiceImpl.getBusLine("35N"),3));
		
		    	ArrayList<BusLineStop> l39 = new ArrayList<>();
		    	l39.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("891"),busLineServiceImpl.getBusLine("39"),1));
		    	l39.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("893"),busLineServiceImpl.getBusLine("39"),2));
		    	
		    	ArrayList<BusLineStop> l96 = new ArrayList<>();
		    	l96.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("891"),busLineServiceImpl.getBusLine("96"),1));
		    	l96.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("892"),busLineServiceImpl.getBusLine("96"),2));
		    	l96.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("893"),busLineServiceImpl.getBusLine("96"),3));
		    	l96.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("894"),busLineServiceImpl.getBusLine("96"),4));
		    	l96.add(new BusLineStopImpl(busStopServiceImpl.getBusStop("895"),busLineServiceImpl.getBusLine("96"),5));
		    	
			    sce.getServletContext().setAttribute("busStopService", busStopServiceImpl);
			    sce.getServletContext().setAttribute("busLineService", busLineServiceImpl);
			    
			}else{
				BusLineServiceHibernateImpl busLineServiceImpl = new BusLineServiceHibernateImpl();
				BusStopServiceHibernateImpl busStopServiceImpl = new BusStopServiceHibernateImpl();
			    sce.getServletContext().setAttribute("busStopService", busStopServiceImpl);
			    sce.getServletContext().setAttribute("busLineService", busLineServiceImpl);			
			}
		}catch(Exception e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}

}
