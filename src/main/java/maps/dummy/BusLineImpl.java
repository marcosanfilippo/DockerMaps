package maps.dummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import maps.interfaces.BusLine;
import maps.interfaces.BusLineStop;

public class BusLineImpl implements BusLine {

	private String line;
	private String description;
	private List<BusLineStop> busLineStops;
	
	
	public BusLineImpl(String line, String description,List<BusLineStop> _bs) throws Exception {
		super();
		this.line = new String(line);
		this.description = new String(description);
		busLineStops = new ArrayList<BusLineStop>();

		if ( _bs != null )
		{
			for(BusLineStop b : _bs)
			{
				addBusLineStop(b);
			}
		}
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
		List<BusLineStop> ret= new ArrayList<BusLineStop>(busLineStops);
		
		Collections.sort(ret, new Comparator<BusLineStop>(){
			  public int compare(BusLineStop p1, BusLineStop p2){
			    return p1.getSequenceNumber().compareTo(p2.getSequenceNumber());
			  }
			});
		
		return ret;
	}

	@Override
	public void removeBusLineStop(BusLineStop busLineStop) throws Exception {
		if (! busLineStops.contains(busLineStop)) return;
		busLineStops.remove(busLineStop);
		
		busLineStop.setBusLine(null);
		if ( busLineStop.getBusStop() != null )
		{
			busLineStop.getBusStop().removeBusLineStop(busLineStop);
		}
	}

	@Override
	public void addBusLineStop(BusLineStop busLineStop) throws Exception {
		if ( busLineStops.contains(busLineStop) ) return;
		busLineStops.add(busLineStop);
		
		busLineStop.setBusLine(this);
		if ( busLineStop.getBusStop() != null )
		{
			busLineStop.getBusStop().addBusLineStop(busLineStop);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusLineImpl other = (BusLineImpl) obj;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		return true;
	}

}
