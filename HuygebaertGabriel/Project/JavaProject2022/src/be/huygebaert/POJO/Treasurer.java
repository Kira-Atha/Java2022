package be.huygebaert.POJO;

import java.util.List;

public class Treasurer extends Person {
	private static final long serialVersionUID = 7206955388975555505L;

	public Treasurer() {}

	public Treasurer(String firstname, String lastname, String password, String tel, String pseudo) {
		try {
			if(signUp(firstname,lastname,pseudo)) {
				Person.idCount++;
				this.id = Person.idCount;
				this.firstname = firstname;
				this.lastname=lastname;
				this.password=password;
				this.tel=tel;
				this.pseudo=pseudo;
			}
		}catch(Exception e) {
			System.out.println("Treasurer doesn't create");
		}
	}

	// Va permettre ou non l'instanciation de l'objet => il ne sera créé que lorsqu'il y aura une inscription.
	@Override
	public boolean signUp(String firstname, String lastname, String pseudo) {
		// Juste vérifier que ce trésorier n'existe pas en tant que membre avant de l'ajouter
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
	private void sendPaymentReminderLetter() {
		
	}
	
	private void payDriver() {
		
	}
	
	private void claimForfeit() {
		
	}
}
