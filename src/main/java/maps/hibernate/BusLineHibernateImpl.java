package maps.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import maps.interfaces.BusLine;
import maps.interfaces.BusLineStop;

/**
 * 
 * create table if not exists BusLine (
	  line varchar(20) not null,
	  description varchar(255),
	  primary key (line)
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

@Entity
@Table(name="BusLine")
public class BusLineHibernateImpl implements BusLine {

	@Id
	@Column(name="line")
	private String line;
	@Column(name="description")
	private String description;
	@OneToMany(mappedBy = "busLine")
	private List<BusLineStopHibernateImpl> busLineStops;
	
	public BusLineHibernateImpl()  {
		super();
		this.line = null;
		this.description = null;
		busLineStops = new ArrayList<BusLineStopHibernateImpl>();
	}


	
	@Override
	public String getLine() {
		return line;
	}

	@Override
	public void setLine(String _line) {
		line = _line;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String _description) {
		description = _description;
	}

	@Override
	public List<BusLineStop> getBusStops() {
		return new ArrayList<BusLineStop>(busLineStops);
	}
	
	@Override
	public void removeBusLineStop(BusLineStop busLineStop) throws Exception {
		if ( ! (busLineStop instanceof BusLineStopHibernateImpl) ) throw new Exception("Invalid parameters");
		BusLineStopHibernateImpl blshi = (BusLineStopHibernateImpl) busLineStop;

		if (! busLineStops.contains(blshi)) return;
		busLineStops.remove(blshi);
		
		busLineStop.setBusLine(null);
		if ( busLineStop.getBusStop() != null )
		{
			busLineStop.getBusStop().removeBusLineStop(blshi);
		}
	}

	@Override
	public void addBusLineStop(BusLineStop busLineStop) throws Exception {
		if ( ! (busLineStop instanceof BusLineStopHibernateImpl) ) throw new Exception("Invalid parameters");
		BusLineStopHibernateImpl blshi = (BusLineStopHibernateImpl) busLineStop;
		if ( busLineStops.contains(blshi) ) return;
		busLineStops.add(blshi);
		
		busLineStop.setBusLine(this);
		if ( busLineStop.getBusStop() != null )
		{
			busLineStop.getBusStop().addBusLineStop(blshi);
		}
	}
}
