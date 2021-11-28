package be.huygebaert.POJO;

public class Cyclo extends Category{
	private static final long serialVersionUID = 7414304179685022563L;
	static Cyclo singleInstanceOfCyclo;
	
	private Cyclo() {
		Category.numCount++;
		this.num=Category.numCount;
		this.singleCalendar = new Calendar(this.num,this);
	}
	public static Cyclo getInstance() {
		if(singleInstanceOfCyclo == null) {
			singleInstanceOfCyclo = new Cyclo();
		}
		return singleInstanceOfCyclo;
	}
}