package be.huygebaert.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract public class Category implements Serializable, AutoCloseable {
	private static final long serialVersionUID = -309839438964916689L;
	// Num category = num calendar 
	protected static int numCount = 0;
	protected int num;
	private Manager singleManager = null;
	private List<Member> categoryMembers = new ArrayList<Member>();
	protected Calendar singleCalendar;
	
	
	public Category() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num=num;
	}
	public static List <Category> getAllCategories() {
		List <Category> categories = null;
		
		return categories;
	}
	public static Category getCategory(int num) {
		Category category = null;
		return category;
	}
	public List<Member> getCategoryMembers() {
		return categoryMembers;
	}
	public Manager getSingleManager() {
		return singleManager;
	}
	public Calendar getSingleCalendar() {
		return this.singleCalendar;
	}
	public void setSingleManager(Manager singleManager) {
		this.singleManager = singleManager;
	}
	public void setSingleCalendar(Calendar singleCalendar) {
		this.singleCalendar = singleCalendar;
	}

	public boolean addPerson(Person person) {
		if(person instanceof Member) {
			if(!categoryMembers.contains(person)) {
				// ajout de la personne dans la liste des membres de la catégorie
				Member member = (Member) person;
				categoryMembers.add(member);
			}
			// Ajout de la catégorie à la liste du membre 
			if(!((Member) person).getMemberCategories().contains(this)) {
				((Member) person).getMemberCategories().add(this);
			}
		}
		if(person instanceof Manager) {
			if(singleManager==null) {
				Manager manager = (Manager) person;
				this.singleManager = manager;
				manager.setCategory(this);
			}
		}
		return false;
	}
	
	
	// Garbage collector passera 
	public void deleteCategory() {
		this.singleCalendar = null;
	}
	
	private boolean closed;
	
	public boolean isClosed() {
		return closed;
	}
	@Override
	public void close() throws Exception{
		closed = true;
	}
}