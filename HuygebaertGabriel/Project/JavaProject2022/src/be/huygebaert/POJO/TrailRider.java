package be.huygebaert.POJO;

public class TrailRider extends VTT{
	static TrailRider singleInstanceOfRider;
	
	private TrailRider() {
		Category.numCount++;
		this.num=Category.numCount;
		this.singleCalendar = new Calendar(num);
	}
	
	public static TrailRider getInstance() {
		if(singleInstanceOfRider == null) {
			singleInstanceOfRider = new TrailRider();
		}
		return singleInstanceOfRider;
	}
}
