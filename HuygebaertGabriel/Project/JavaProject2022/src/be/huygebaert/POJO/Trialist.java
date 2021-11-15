package be.huygebaert.POJO;

public class Trialist extends VTT{
	static Trialist singleInstanceOfTrialist;
	
	private Trialist(int num) {
		Trialist.num=num;
		num++;
		Calendar singleTrialistCalendar = new Calendar(num);
	}
	
	public static Trialist getInstance(int num) {
		if(singleInstanceOfTrialist == null) {
			singleInstanceOfTrialist= new Trialist(num);
		}
		return singleInstanceOfTrialist;
	}
}
