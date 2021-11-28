package be.huygebaert.POJO;

import java.util.ArrayList;
import java.util.List;

import be.huygebaert.DAO.DAO;
import be.huygebaert.DAO.DAOFactory;
import be.huygebaert.DAO.MemberDAO;

public class Member extends Person{
	private static final long serialVersionUID = 5312718583319369493L;

	private double balance;
	private List<Category> memberCategories;
	private List <Velo> memberVelos;
	private Vehicle memberVehicle = null;
	private List<Register> memberRegisters;
	
	public Member() {}
	
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
				
				memberCategories = new ArrayList<Category>();
				this.memberCategories.add(category);
				// 
				memberVelos = new ArrayList<Velo>();
				Velo velo = new Velo();
				this.memberVelos.add(velo);
				
				memberRegisters = new ArrayList<Register>();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Member(String firstname, String lastname, String password, String tel, String pseudo) {
		Person.idCount++;
		this.id = Person.idCount;
		this.firstname = firstname;
		this.lastname=lastname;
		this.password=password;
		this.tel=tel;
		this.pseudo=pseudo;
		memberCategories = new ArrayList<Category>();
		memberVelos = new ArrayList<Velo>();
		memberRegisters = new ArrayList<Register>();
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Category> getMemberCategories() {
		return memberCategories;
	}
	public void setMemberCategories(List<Category> memberCategories) {
		this.memberCategories = memberCategories;
	}
	public static List<Member> getAllMembers(){
		DAOFactory adf = new DAOFactory();
		DAO<Member> memberDAO = adf.getMemberDAO();
		
		return memberDAO.findAll();
	}
	
	public static List<Member> getMemberRegister(Register register){
		List<Member> memberRegisters = null;
		
		return memberRegisters;
	}

	public List <Velo> getMemberVelos() {
		return memberVelos;
	}

	public void setMemberVelos(List <Velo> memberVelos) {
		this.memberVelos = memberVelos;
	}

	public Vehicle getMemberVehicle() {
		return memberVehicle;
	}

	public void setMemberVehicle(Vehicle memberVehicle) {
		this.memberVehicle = memberVehicle;
	}

	public List<Register> getMemberRegisters() {
		return memberRegisters;
	}

	public void setMemberRegisters(List<Register> memberRegisters) {
		this.memberRegisters = memberRegisters;
	}

	@Override
	public boolean signUp(String firstname, String lastname, String pseudo) {
		List<Member> allMembers = Member.getAllMembers();
		if(!allMembers.isEmpty()) {
			for(Member memb:allMembers) {
				if(!memb.firstname.equals(this.firstname) && !memb.lastname.equals(this.lastname) && !memb.pseudo.equals(this.pseudo)) {
					return true;
				}
			}
		}else {
			return true;
		}
		return false;
	}
	public void calculateBalance() {
		
	}
	public void verifyBalance() {
		
	}
	
}
