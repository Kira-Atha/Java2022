package be.huygebaert.POJO;

public class Descender extends VTT {
	static Descender singleInstanceOfDescenders;
	
	private Descender(int num) {
		Descender.num=num;
		num++;
		Calendar singleDescenderCalendar = new Calendar(num);
	}
	
	public static Descender getInstance(int num) {
		if(singleInstanceOfDescenders==null) {
			singleInstanceOfDescenders=new Descender(num);
		}
		return singleInstanceOfDescenders;
	}
}
