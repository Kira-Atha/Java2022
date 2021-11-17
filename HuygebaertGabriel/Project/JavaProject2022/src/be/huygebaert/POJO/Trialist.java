package be.huygebaert.POJO;

public class Trialist extends VTT{
	static Trialist singleInstanceOfTrialist;
	
	private Trialist() {
		Category.numCount++;
		this.num=Category.numCount;
		this.singleCalendar = new Calendar(num);
	}
	
	public static Trialist getInstance() {
		if(singleInstanceOfTrialist == null) {
			singleInstanceOfTrialist= new Trialist();
		}
		return singleInstanceOfTrialist;
	}
}
