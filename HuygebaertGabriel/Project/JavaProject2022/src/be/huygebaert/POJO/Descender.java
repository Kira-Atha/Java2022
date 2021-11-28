package be.huygebaert.POJO;

public class Descender extends VTT {
	private static final long serialVersionUID = -2213836681647297285L;
	static Descender singleInstanceOfDescenders;
	
	private Descender() {
		Category.numCount++;
		this.num = Category.numCount;
		this.singleCalendar = new Calendar(num,this);
	}
	
	public static Descender getInstance() {
		if(singleInstanceOfDescenders==null) {
			singleInstanceOfDescenders=new Descender();
		}
		return singleInstanceOfDescenders;
	}
}