package maps.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import maps.interfaces.BusLineStop;
import maps.interfaces.BusStop;

/*
 * create table if not exists BusStop (
  id varchar(20) not null,
  name varchar(255) not null,
  lat double precision,
  lng double precision,
  primary key (id)
);

create table if not exists BusLineStop (
  stopId varchar(20) not null,
  lineId varchar(20) not null,
  seqenceNumber smallint not null,
  primary key(stopId, lineId),
  foreign key (stopId) references BusStop(id),
  foreign key (lineId) references BusLine(line)
);
 */

//TODO double precision

@Entity
@Table(name="BusStop")
public class BusStopHibernateImpl implements BusStop {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="lat")
	private Double lat;
	@Column(name="lng")
	private Double lng;
	@OneToMany(mappedBy = "busStop")
	private List<BusLineStopHibernateImpl> busLineStops;
	
	public BusStopHibernateImpl()  {
		super();
		this.id = null;
		this.name = null;
		this.lat = null;
		this.lng = null;
		this.busLineStops = new ArrayList<BusLineStopHibernateImpl>();

	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String _id) {
			id = _id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String _name) {
		name = _name;
	}

	@Override
	public Double getLat() {
		return lat;
	}

	@Override
	public void setLat(Double _lat) {
		lat = _lat;
	}

	@Override
	public Double getLng() {
		return lng;
	}

	@Override
	public void setLng(Double _lng) {
		lng = _lng;
	}
	
	@Override
	public List<BusLineStop> getBusLineStops() {
		return new ArrayList<>(busLineStops);
	}

	@Override
	public void removeBusLineStop(BusLineStop busLineStop) throws Exception {
		if (! busLineStops.contains(busLineStop)) return;
		if ( ! (busLineStop instanceof BusLineStopHibernateImpl) ) throw new Exception("Invalid parameters");
		BusLineStopHibernateImpl blshi = (BusLineStopHibernateImpl) busLineStop;
		
		busLineStops.remove(blshi);
		
		busLineStop.setBusStop(null);
		if ( busLineStop.getBusLine() != null )
		{
			busLineStop.getBusLine().removeBusLineStop(blshi);
		}
	}

	@Override
	public void addBusLineStop(BusLineStop busLineStop) throws Exception {
		if (busLineStops.contains(busLineStop)) return;
		if ( ! (busLineStop instanceof BusLineStopHibernateImpl) ) throw new Exception("Invalid parameters");
		BusLineStopHibernateImpl blshi = (BusLineStopHibernateImpl) busLineStop;
		
		busLineStops.remove(blshi);
		
		busLineStop.setBusStop(this);
		if ( busLineStop.getBusLine() != null )
		{
			busLineStop.getBusLine().addBusLineStop(blshi);
		}	
	}

}
