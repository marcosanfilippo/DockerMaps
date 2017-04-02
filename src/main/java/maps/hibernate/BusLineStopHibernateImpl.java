package maps.hibernate;

import javax.persistence.*;

import maps.interfaces.BusLine;
import maps.interfaces.BusLineStop;
import maps.interfaces.BusStop;

/*
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
@Table(name="BusLineStop")
@IdClass(BusLineStopIdHibernate.class)
public class BusLineStopHibernateImpl implements BusLineStop {

	@Id
	@ManyToOne
	@JoinColumn(name = "stopId", nullable = false)
	BusStopHibernateImpl busStop;
	@Id
	@ManyToOne
	@JoinColumn(name = "lineId", nullable = false)
	BusLineHibernateImpl busLine;
	@Column(name = "sequenceNumber")
	Short sequence;
	
	public BusLineStopHibernateImpl()  {
		super();
		this.busStop = null;
		this.busLine = null;
		this.sequence = null;

	}
	
	@Override
	public BusStop getBusStop() {
		return busStop;
	}

	@Override
	public void setBusStop(BusStop bs) throws Exception {
		if ( bs == busStop ) return;
		if ( ! (bs instanceof BusStopHibernateImpl) ) throw new Exception("Invalid parameters");
		BusStopHibernateImpl bshi = (BusStopHibernateImpl) bs;
		
		BusStopHibernateImpl old = busStop;
		busStop = bshi;
		
		old.removeBusLineStop(this);
		busStop.addBusLineStop(this);
	}

	@Override
	public BusLine getBusLine() {
		return busLine;
	}

	@Override
	public void setBusLine(BusLine bl) throws Exception {
		if ( bl == busLine ) return;
		if ( ! (bl instanceof BusLineHibernateImpl) ) throw new Exception("Invalid parameters");
		BusLineHibernateImpl blhi = (BusLineHibernateImpl) bl;
		
		BusLineHibernateImpl old = busLine;
		busLine = blhi;
		
		old.removeBusLineStop(this);
		busLine.addBusLineStop(this);

	}

	@Override
	public Integer getSequenceNumber() {
		return new Integer(sequence);
	}

	@Override
	public void setSequenceNumber(Integer seq) {
		sequence = new Short(seq.shortValue());
	}

}
