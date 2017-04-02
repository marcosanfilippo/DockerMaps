package maps.dummy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import maps.interfaces.BusLine;
import maps.interfaces.BusLineService;

public class BusLineServiceImpl implements BusLineService {

	ConcurrentHashMap<String,BusLine> hm;
	
	public BusLineServiceImpl()
	{
		hm = new ConcurrentHashMap<>();
	}
	
	@Override
	public Map<String, BusLine> getAll() {		
		return new HashMap<String,BusLine>(hm);
	}

	@Override
	public BusLine getBusLine(String line) {
		return hm.get(line);
	}

	public void addBusLine(BusLine bl )
	{
		hm.put(bl.getLine(), bl);
	}
}
