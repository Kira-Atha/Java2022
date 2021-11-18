package be.huygebaert.POJO;

import java.io.Serializable;
import java.util.List;

public class Member extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private double balance;

	private List<Category> memberCategories;
	private Velo memberVelo;
	private List<Vehicle> memberVehicles;
	private Register memberRegister;
	
	public Member(String firstname, String lastname, String password, String tel, String pseudo, Category category) {
		try {
			if(signUp(firstname,lastname,pseudo)) {
				Person.idCount++;
				this.id = Person.idCount;
				this.firstname = firstname;
				this.lastname=lastname;
				this.password=password;
				this.tel=tel;
				this.pseudo=pseudo;
				this.balance=0;
				this.memberCategories.add(category);
			}else {
				//lancer exception
			}
		}catch(Exception e) {
			System.out.println("Member doesn't create");
		}
	}
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String firstname, String lastname, String password, String tel, String pseudo) {
		// TODO Auto-generated constructor stub
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	// Va permettre ou non l'instanciation de l'objet => il ne sera créé que lorsqu'il y aura une inscription.
	@Override
	public boolean signUp(String firstname, String lastname, String pseudo) {
		// Juste vérifier que ce membre n'existe pas avant de l'ajouter
		List<Member> allMembers = getAllMembers();
		for(Member memb:allMembers) {
			if(!memb.firstname.equals(this.firstname) && !memb.lastname.equals(this.lastname) || !memb.pseudo.equals(this.pseudo)) {
				return true;
			}
		}
		return false;
	}
	public void calculateBalance() {
		
	}
	public void verifyBalance() {
		
	}
	
	public static List<Member> getAllMembers(){
		List<Member> members = null;
		
		return members;
	}
	
	public static List<Member> getMemberRegister(Register register){
		List<Member> memberRegisters = null;
		
		return memberRegisters;
	}
	public List<Category> getMemberCategories() {
		return memberCategories;
	}
}
