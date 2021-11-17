package be.huygebaert.POJO;

public class Descender extends VTT {
	static Descender singleInstanceOfDescenders;
	
	private Descender() {
		Category.numCount++;
		this.num = Category.numCount;
		this.singleCalendar = new Calendar(num);
	}
	
	public static Descender getInstance() {
		if(singleInstanceOfDescenders==null) {
			singleInstanceOfDescenders=new Descender();
		}
		return singleInstanceOfDescenders;
	}
}
