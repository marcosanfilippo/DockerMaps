package maps.interfaces;

public interface BusLineStop {
	
	/**
	 * 
	 * create table if not exists BusLineStop (
		  stopId varchar(20) not null,
		  lineId varchar(20) not null,
		  seqenceNumber smallint not null,
		  primary key(stopId, lineId),
		  foreign key (stopId) references BusStop(id),
		  foreign key (lineId) references BusLine(line)
		);

	 */
	
	public Long getStopId();
	public void setStopId(Long StopId);
	
	public Long getLineId();
	public void setLineId(Long LineId);
	
	public Long getSequenceNumber();
	public void setSequenceNumber(Long SequenceNumber);
	
	

}
