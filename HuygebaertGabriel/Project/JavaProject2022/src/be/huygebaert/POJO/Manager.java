package be.huygebaert.POJO;

import java.util.List;

public class Manager extends Person {
	
	private static final long serialVersionUID = 1L;
	private Category category;
	
	public Manager(String firstname, String lastname, String password, String tel, String pseudo, Category category) {
		try {
			if(signUp(firstname, lastname,pseudo,category)) {
				Person.idCount++;
				this.id = Person.idCount;
				this.firstname = firstname;
				this.lastname=lastname;
				this.password=password;
				this.tel=tel;
				this.pseudo=pseudo;
				this.category = category;
			}else {
				// lancer exception
			}
		}catch(Exception e) {
			System.out.println("Manager doesn't create");
		}
	}
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	public Manager(String firstname, String lastname, String password, String tel, String pseudo) {
		// TODO Auto-generated constructor stub
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	// Va permettre ou non l'instanciation de l'objet => il ne sera cr�� que lorsqu'il y aura une inscription.
	@Override
	public boolean signUp(String firstname, String lastname, String pseudo,Category category) {
		// Y a -t-il d�j� un manager pour cette cat�gorie ? Si oui, ne pas permettre l'instanciation de l'objet
		if(category.getSingleManager() == null) {
			// Le manager existe peut-�tre d�j� en tant que membre ?
			List<Member> allMembers = Member.getAllMembers();
			for(Member memb:allMembers) {
				if(!memb.firstname.equals(this.firstname) && !memb.lastname.equals(this.lastname) || !memb.pseudo.equals(this.pseudo)) {
					return true;
				}
			}
		}
		return false;
	}
	public void manageCalendar() {
		
	}
}