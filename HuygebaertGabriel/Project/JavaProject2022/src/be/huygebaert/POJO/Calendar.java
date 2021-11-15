package be.huygebaert.POJO;

import java.util.List;

public class Calendar {
	private int num;
	private List <Outing> outings;
	
	public Calendar(int num) {
		this.num = num;
		// Composition de Category, attention ! UN CALENDRIER par catégorie !
	}

	public int getNum() {
		return num;
	}
	public List <Outing> getOutings() {
		return outings;
	}
	public boolean addOutgoing() {
		return false;
	}	
	public boolean updateOuting(Outing outing) {
		return false;
	}
	public boolean deleteOuting(Outing outing) {
		return false;
	}
	public Calendar getInstanceOfCalendar(Category category) {
		Calendar calendar = null;
		return calendar;
	}
}