package be.huygebaert.POJO;

public class Cyclo extends Category{
	static Cyclo singleInstanceOfCyclo;
	
	private Cyclo() {
		Category.numCount++;
		this.num=Category.numCount;
		this.singleCalendar = new Calendar(this.num);
	}
	public static Cyclo getInstance() {
		if(singleInstanceOfCyclo == null) {
			singleInstanceOfCyclo = new Cyclo();
		}
		return singleInstanceOfCyclo;
	}
}