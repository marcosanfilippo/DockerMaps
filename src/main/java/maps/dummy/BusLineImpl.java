package maps.dummy;

import java.util.ArrayList;
import java.util.List;

import maps.interfaces.BusLine;
import maps.interfaces.BusStop;

public class BusLineImpl implements BusLine {

	public BusLineImpl(String line, String description,List<BusStop> _bs) {
		super();
		this.line = new String(line);
		this.description = new String(description);
		busStops = new ArrayList<BusStop>();
		
		for(BusStop b : _bs)
		{
			addBusStop(b);
		}
	}

	private String line;
	private String description;
	private List<BusStop> busStops;
	
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
	public List<BusStop> getBusStops() {
		return new ArrayList<BusStop>(busStops);
	}

	@Override
	public void removeBusStop(BusStop busStop) {
		if (! busStops.contains(busStop)) return;
		busStops.remove(busStop);
		busStop.removeBusLine(this);
	}

	@Override
	public void addBusStop(BusStop busStop) {
		if ( busStops.contains(busStop) ) return;
		
		busStops.add(busStop);
		busStop.addBusLine(this);
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
