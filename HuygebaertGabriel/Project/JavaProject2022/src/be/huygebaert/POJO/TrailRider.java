package be.huygebaert.POJO;

public class TrailRider extends VTT{
	private static final long serialVersionUID = 5834673873715943205L;
	static TrailRider singleInstanceOfRider;
	
	private TrailRider() {
		Category.numCount++;
		this.num=Category.numCount;
		this.singleCalendar = new Calendar(this.num,this);
	}
	
	public static TrailRider getInstance() {
		if(singleInstanceOfRider == null) {
			singleInstanceOfRider = new TrailRider();
		}
		return singleInstanceOfRider;
	}
}
