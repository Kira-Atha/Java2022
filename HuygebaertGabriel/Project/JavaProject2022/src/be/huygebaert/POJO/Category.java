package be.huygebaert.POJO;

import java.util.List;

abstract public class Category {
	// Num category = num calendar => more easier
	protected static int num = 0;
	private Manager singleManager;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		Category.num = num;
	}
	public boolean addPerson(Person person) {
		return false;
	}

	public static List <Category> getAllCategories() {
		List <Category> categories = null;
		
		return categories;
	}
	public static Category getCategory(int num) {
		Category category = null;
		return category;
	}
}