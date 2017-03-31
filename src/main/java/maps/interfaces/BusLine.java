package maps.interfaces;

public interface BusLine {
	
	/**
	 * 
	 * create table if not exists BusLine (
		  line varchar(20) not null,
		  description varchar(255),
		  primary key (line)
		);
	 */
	
	public Long getLine();
	public void setLine(Long line);
	
	public Long getDescription();
	public void setDescription(String description);

}
