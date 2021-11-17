package be.huygebaert.POJO;

import java.util.List;

abstract public class Category {
	// Num category = num calendar => more easier
	protected static int numCount = 0;
	protected int num;
	private Manager singleManager = null;
	private List<Member> memberCategories;
	protected Calendar singleCalendar=null;
	
	public int getNum() {
		return num;
	}

	public static List <Category> getAllCategories() {
		List <Category> categories = null;
		
		return categories;
	}
	public static Category getCategory(int num) {
		Category category = null;
		return category;
	}
	public List<Member> getMemberCategories() {
		return memberCategories;
	}
	public Manager getSingleManager() {
		return singleManager;
	}

	public void setSingleManager(Manager singleManager) {
		this.singleManager = singleManager;
	}
	
	
	public boolean addPerson(Person person) {
		if(person instanceof Member) {
			if(!memberCategories.contains(person)) {
				Member member = (Member) person;
				memberCategories.add(member);
			}
			return true;
		}
		if(person instanceof Manager) {
			if(singleManager==null) {
				Manager manager = (Manager) person;
				singleManager = manager;
				return true;
			}
		}
		
		return false;
	}
}