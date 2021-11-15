package be.huygebaert.POJO;

public class TrailRider extends VTT{
	static TrailRider singleInstanceOfRider;
	
	private TrailRider(int num) {
		TrailRider.num=num;
		num ++;
		Calendar singleTrailRiderCalendar = new Calendar(num);
	}
	
	public static TrailRider getInstance(int num) {
		if(singleInstanceOfRider == null) {
			singleInstanceOfRider = new TrailRider(num);
		}
		return singleInstanceOfRider;
	}
}
