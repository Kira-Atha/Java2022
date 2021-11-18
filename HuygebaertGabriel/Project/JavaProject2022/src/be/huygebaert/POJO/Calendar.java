package be.huygebaert.POJO;

import java.util.List;

public class Calendar {
	private int num;
	private List <Outing> outings;
	private Category calendarCategory;
	
	public Calendar(int num) {
		this.num = num;
		// Composition de Category, attention ! UN CALENDRIER par catégorie !
	}

	public Calendar() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List <Outing> getOutings() {
		return outings;
	}
	
	public boolean addOuting() {
		Outing outing = new Outing();
		if(outing!=null) {
			this.outings.add(outing);
			return true;
		}
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

	public Category getCalendarCategory() {
		return calendarCategory;
	}

	public void setCalendarCategory(Category calendarCategory) {
		this.calendarCategory = calendarCategory;
	}
}