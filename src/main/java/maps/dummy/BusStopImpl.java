package maps.dummy;

import java.util.ArrayList;
import java.util.List;

import maps.interfaces.BusLineStop;
import maps.interfaces.BusStop;

public class BusStopImpl implements BusStop {

	private String id;
	private String name;
	private Double lat;
	private Double lng;
	private List<BusLineStop> busLineStops;
	
	public BusStopImpl(String id, String name, Double lat, Double lng, List<BusLineStop> _bl) throws Exception {
		super();
		this.id = new String(id);
		this.name = new String(name);
		this.lat = new Double(lat);
		this.lng = new Double(lng);
		this.busLineStops = new ArrayList<BusLineStop>();
		
		for(BusLineStop b : _bl)
		{
			addBusLineStop(b);
		}
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
		busLineStops.remove(busLineStop);
		
		busLineStop.setBusStop(null);
		if ( busLineStop.getBusLine() != null )
		{
			busLineStop.getBusLine().removeBusLineStop(busLineStop);
		}
	}

	@Override
	public void addBusLineStop(BusLineStop busLineStop) throws Exception {
		if (busLineStops.contains(busLineStop)) return;
		busLineStops.remove(busLineStop);
		
		busLineStop.setBusStop(this);
		if ( busLineStop.getBusLine() != null )
		{
			busLineStop.getBusLine().addBusLineStop(busLineStop);
		}	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BusStopImpl other = (BusStopImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
