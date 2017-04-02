package maps.interfaces;

import java.util.Map;

public interface BusStopService {

	public Map<String, BusStop> getAll();
	public BusStop getBusStop(String id);
}
