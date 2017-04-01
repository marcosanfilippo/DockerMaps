package maps.interfaces;

import java.util.List;

public interface BusStop {
	
	/**
	 * 
	 * create table if not exists BusStop (
		  id varchar(20) not null,
		  name varchar(255) not null,
		  lat double precision,
		  lng double precision,
		  primary key (id)
		);

	 */
	
	public String getId();
	public void setId(String Id);
	
	public String getName();
	public void setName(String Name);
	
	public Double getLat();
	public void setLat(Double Lat);
	
	public Double getLng();
	public void setLng(Double Lng);
	
	public List<BusLine> getBusLines();
	public void removeBusLine(BusLine busLine);
	public void addBusLine(BusLine busLine);

}
