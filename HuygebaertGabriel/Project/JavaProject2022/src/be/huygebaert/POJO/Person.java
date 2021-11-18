package be.huygebaert.POJO;

import java.io.Serializable;

abstract public class Person implements Serializable {
	private static final long serialVersionUID = 0L;
	protected static int idCount = 0;
	protected int id;
	protected String firstname;
	protected String lastname;
	protected String password;
	protected String tel;
	protected String pseudo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public boolean signIn() {
		
		return false;
	}
	public boolean signUp(String firstname, String lastname, String pseudo) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean signUp(String firstname, String lastname, String pseudo, Category category) {
		// TODO Auto-generated method stub
		return false;
	}
}
