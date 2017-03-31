package maps.interfaces;

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
	
	public Long getId();
	public void setId(Long Id);
	
	public Long getName();
	public void setName(String Name);
	
	public Long getLat();
	public void setLat(Double Lat);
	
	public Long getLng();
	public void setLng(Double Lng);

}
