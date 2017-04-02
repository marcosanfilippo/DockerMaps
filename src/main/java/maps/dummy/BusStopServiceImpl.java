package maps.dummy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import maps.interfaces.BusStop;
import maps.interfaces.BusStopService;

public class BusStopServiceImpl implements BusStopService {

	ConcurrentHashMap<String,BusStop> hm;
	
	public BusStopServiceImpl()
	{
		hm = new ConcurrentHashMap<>();
	}
	
	@Override
	public Map<String, BusStop> getAll() {		
		return new HashMap<String,BusStop>(hm);
	}

	@Override
	public BusStop getBusStop(String id) {
		return hm.get(id);
	}

	public void addBusStop(BusStop bs )
	{
		hm.put(bs.getId(), bs);
	}
}
