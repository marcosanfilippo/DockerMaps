package maps.dummy;

import maps.interfaces.BusLine;
import maps.interfaces.BusLineStop;
import maps.interfaces.BusStop;

public class BusLineStopImpl implements BusLineStop {

	BusStop busStop;
	BusLine busLine;
	Integer sequence;
	
	public BusLineStopImpl(BusStop busStop, BusLine busLine, Integer sequence) throws Exception {
		super();
		this.busStop = busStop;
		this.busLine = busLine;
		this.sequence = sequence;
		
		busStop.addBusLineStop(this);
		busLine.addBusLineStop(this);
	}
	
	@Override
	public BusStop getBusStop() {
		return busStop;
	}

	@Override
	public void setBusStop(BusStop bs) throws Exception {
		if ( bs == busStop ) return;
		
		BusStop old = busStop;
		busStop = bs;
		
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
		
		BusLine old = busLine;
		busLine = bl;
		
		old.removeBusLineStop(this);
		busLine.addBusLineStop(this);

	}

	@Override
	public Integer getSequenceNumber() {
		return sequence;
	}

	@Override
	public void setSequenceNumber(Integer seq) {
		sequence = seq;
	}

}
