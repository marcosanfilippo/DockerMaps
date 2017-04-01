package maps.listeners;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import maps.dummy.BusLineImpl;
import maps.dummy.BusStopImpl;
import maps.interfaces.BusStop;

@WebListener
public class OurWebListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
    	ConcurrentHashMap<String, BusStopImpl> busStops = new ConcurrentHashMap<>();
    	ConcurrentHashMap<String, BusLineImpl> busLines = new ConcurrentHashMap<>();
    	
    	busStops.put("891",new BusStopImpl("891", "IV NOVEMBRE", 44.99331, 7.64493, new ArrayList<>()));
    	busStops.put("892",new BusStopImpl("892", "VITTORIO VENETO", 44.99485, 7.64657, new ArrayList<>()));
    	busStops.put("893",new BusStopImpl("893", "VITTORIO VENETO", 44.99521, 7.64727, new ArrayList<>()));
    	busStops.put("894",new BusStopImpl("894", "DIAZ", 44.99697, 7.64906, new ArrayList<>()));
    	busStops.put("895",new BusStopImpl("895", "DIAZ", 44.99708, 7.64955, new ArrayList<>()));
    	
    	ArrayList<BusStop> l14 = new ArrayList<>();
    	l14.add(busStops.get("891"));
    	l14.add(busStops.get("892"));
    	
    	ArrayList<BusStop> l1n = new ArrayList<>();
    	l1n.add(busStops.get("891"));
    	l1n.add(busStops.get("893"));
    	l1n.add(busStops.get("895"));
    	
    	ArrayList<BusStop> l35 = new ArrayList<>();
    	l35.add(busStops.get("891"));
    	l35.add(busStops.get("892"));
    	l35.add(busStops.get("893"));
    	l35.add(busStops.get("894"));
    	l35.add(busStops.get("895"));
    	
    	
    	ArrayList<BusStop> l35n = new ArrayList<>();
    	l35n.add(busStops.get("891"));
    	l35n.add(busStops.get("893"));
    	l35n.add(busStops.get("895"));
    	
    	
    	ArrayList<BusStop> l39 = new ArrayList<>();
    	l39.add(busStops.get("891"));
    	l39.add(busStops.get("893"));
    	
    	ArrayList<BusStop> l96 = new ArrayList<>();
    	l96.add(busStops.get("891"));
    	l96.add(busStops.get("892"));
    	l96.add(busStops.get("893"));
    	l96.add(busStops.get("894"));
    	l96.add(busStops.get("895"));
    	
    	busLines.put("14", new BusLineImpl("14", "Linea 14", l14));
    	busLines.put("1N", new BusLineImpl("1N", "Linea 1N", l1n));
    	busLines.put("35", new BusLineImpl("35", "Linea 35", l35));
    	busLines.put("35N", new BusLineImpl("35N", "Linea 35N", l35n));
    	busLines.put("39", new BusLineImpl("39", "Linea 39", l39));
    	busLines.put("96", new BusLineImpl("96", "Linea 96", l96));
    	
	    sce.getServletContext().setAttribute("busStops", busStops);
	    sce.getServletContext().setAttribute("busLines", busLines);
	    
	}

}
