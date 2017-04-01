package maps.interfaces;

import java.util.List;

public interface BusLine {
	
	/**
	 * 
	 * create table if not exists BusLine (
		  line varchar(20) not null,
		  description varchar(255),
		  primary key (line)
		);
	 */
	
	public String getLine();
	public void setLine(String line);
	
	public String getDescription();
	public void setDescription(String description);
	
	/***
	 * Return SORTED (by time)!
	 * @return
	 */
	public List<BusStop> getBusStops();
	public void removeBusStop(BusStop busStop);
	public void addBusStop(BusStop busStop);
	
}
