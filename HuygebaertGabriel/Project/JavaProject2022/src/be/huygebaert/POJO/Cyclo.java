package be.huygebaert.POJO;

public class Cyclo extends Category{
	static Cyclo singleInstanceOfCyclo;
	
	private Cyclo(int num) {
		Cyclo.num = num;
		num++;
		Calendar singleCycloCalendar = new Calendar(num);
	}
	public static Cyclo getInstance(int num) {
		if(singleInstanceOfCyclo == null) {
			singleInstanceOfCyclo = new Cyclo(num);
		}
		return singleInstanceOfCyclo;
	}
}