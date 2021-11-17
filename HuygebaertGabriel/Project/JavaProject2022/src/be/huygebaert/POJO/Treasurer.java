package be.huygebaert.POJO;

import java.util.List;

public class Treasurer extends Person {
	private static final long serialVersionUID = 1L;

	public Treasurer(String firstname, String lastname, String password, String tel, String pseudo) {
		try {
			if(signUp()) {
				Person.idCount++;
				this.id = Person.idCount;
				this.firstname = firstname;
				this.lastname=lastname;
				this.password=password;
				this.tel=tel;
				this.pseudo=pseudo;
			}else {
				//throws Exception;
			}
		}catch(Exception e) {
			System.out.println("Treasurer doesn't create");
		}
	}
	// Va permettre ou non l'instanciation de l'objet => il ne sera cr�� que lorsqu'il y aura une inscription.
	@Override
	public boolean signUp() {
		// Juste v�rifier que ce tr�sorier n'existe pas en tant que membre avant de l'ajouter
		List<Member> allMembers = Member.getAllMembers();
		for(Member memb:allMembers) {
			if(!memb.firstname.equals(this.firstname) && !memb.lastname.equals(this.lastname) || !memb.pseudo.equals(this.pseudo)) {
				return true;
			}
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
