package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import be.huygebaert.POJO.Cyclo;
import be.huygebaert.POJO.Descender;
import be.huygebaert.POJO.Manager;
import be.huygebaert.POJO.Member;
import be.huygebaert.POJO.Person;
import be.huygebaert.POJO.TrailRider;
import be.huygebaert.POJO.Treasurer;
import be.huygebaert.POJO.Trialist;

public class PersonDAO extends DAO<Person> {
	public PersonDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Person obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			try {
			    PreparedStatement ps0 = this.connect.prepareStatement("INSERT INTO Member VALUES (?,?,?,?,?,?,?)");
			    ps0.setInt(1, member.getId());
		        ps0.setString(2, member.getFirstname());
		        ps0.setString(3, member.getLastname());
		        ps0.setString(4, member.getPassword());
		        ps0.setString(5, member.getTel());
		        ps0.setDouble(6, member.getBalance());
		        ps0.setString(7, member.getPseudo());
		        int isOk0 = ps0.executeUpdate();

		        
		        PreparedStatement ps1 = this.connect.prepareStatement("INSERT INTO Cat_Memb VALUES (?,?)");
		        ps1.setInt(1, member.getId());
		        ps1.setInt(2, member.getMemberCategories().get(0).getNum());
		        int isOk1 = ps1.executeUpdate();
		        
		        member.getMemberCategories().get(0).addPerson(member);
		        
		        if(isOk0 == 1 && isOk1 == 1) {
		        	return true;
		        }
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		if(obj instanceof Manager) {
			Manager manager = (Manager) obj;
			try {
			    PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Member VALUES (?,?,?,?,?,?,?)");
			    ps.setInt(1, manager.getId());
		        ps.setString(2, manager.getFirstname());
		        ps.setString(3, manager.getLastname());
		        ps.setString(4, manager.getPassword());
		        ps.setString(5, manager.getTel());
		        ps.setString(6, manager.getPseudo());
		        ps.setInt(7, manager.getCategory().getNum());
		        
		        manager.getCategory().addPerson(manager);
		        int isOk = ps.executeUpdate();

		        if(isOk == 1) {
		        	return true;
		        }
				
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		if(obj instanceof Treasurer) {
			Treasurer treasurer = (Treasurer) obj;
			try {
			    PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Member VALUES (?,?,?,?,?,?)");
			    ps.setInt(1, treasurer.getId());
		        ps.setString(2, treasurer.getFirstname());
		        ps.setString(3, treasurer.getLastname());
		        ps.setString(4, treasurer.getPassword());
		        ps.setString(5, treasurer.getTel());
		        ps.setString(6, treasurer.getPseudo());
		        int isOk = ps.executeUpdate();

		        if(isOk == 1) {
		        	return true;
		        }
				
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person find(int id) {
		Member member;
		Manager manager;
		Treasurer treasurer;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Member WHERE IdMember = " +id);
			if(result.first()){
				// Compl�ter avec info de base
				member = new Member(result.getString("Firstname"),result.getString("Lastname"),result.getString("Password"),result.getString("Tel"),result.getString("Pseudo"));
				member.setBalance(result.getDouble("Balance"));
				member.setId(result.getInt("IdMember"));
				// Compl�ter avec les cat�gories
				result = this.connect.createStatement().executeQuery("SELECT * FROM cat_memb where IdMember =  " + id);
				CategoryDAO categoryDAO = new CategoryDAO(this.connect);
				while(result.next()) {
					// L'id du calendrier = l'id de la cat�gorie ( type )
					member.getMemberCategories().add(categoryDAO.find(result.getInt("IdCalendar")));
				}
				return member;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Manager WHERE IdManager = " +id);
			if(result.first()){
				// Compl�ter avec info de base
				manager = new Manager(result.getString("Firstname"),result.getString("Lastname"),result.getString("Password"),result.getString("Tel"),result.getString("Pseudo"));
				manager.setId(result.getInt("IdManager"));
				// Compl�ter avec la cat�gorie
				CategoryDAO categoryDAO = new CategoryDAO(this.connect);
				manager.setCategory(categoryDAO.find(result.getInt("IdCalendar")));
				
				return manager;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Treasurer WHERE IdTreasurer = " +id);
			if(result.first()){
				// Compl�ter avec info de base
				treasurer = new Treasurer(result.getString("Firstname"),result.getString("Lastname"),result.getString("Password"),result.getString("Tel"),result.getString("Pseudo"));
				treasurer.setId(result.getInt("IdTreasurer"));
				return treasurer;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Person> findAll() {
		AbstractList<Person> allPersons = new ArrayList<Person>();
		Member member;
		Manager manager;
		Treasurer treasurer;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Member");
			while(result.next()){
				// Compl�ter avec info de base
				member = new Member(result.getString("Firstname"),result.getString("Lastname"),result.getString("Password"),result.getString("Tel"),result.getString("Pseudo"));
				member.setBalance(result.getDouble("Balance"));
				member.setId(result.getInt("IdMember"));
				// Compl�ter avec les cat�gories
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cat_memb where IdMember =  " + result.getInt("IdMember"));
				CategoryDAO categoryDAO = new CategoryDAO(this.connect);
				while(result2.next()) {
					// L'id du calendrier = l'id de la cat�gorie ( type )
					member.getMemberCategories().add(categoryDAO.find(result2.getInt("IdCalendar")));	
				}
				allPersons.add(member);
			}
			
			result = this.connect.createStatement().executeQuery("SELECT * FROM Manager");
			while(result.next()){
				// Compl�ter avec info de base
				manager = new Manager(result.getString("Firstname"),result.getString("Lastname"),result.getString("Password"),result.getString("Tel"),result.getString("Pseudo"));
				manager.setId(result.getInt("IdManager"));
				// Compl�ter avec les cat�gories
				CategoryDAO categoryDAO = new CategoryDAO(this.connect);
				manager.setCategory(categoryDAO.find(result.getInt("IdCalendar")));
				allPersons.add(manager);
			}
			result = this.connect.createStatement().executeQuery("SELECT * FROM Treasurer");
			while(result.next()){
				// Compl�ter avec info de base
				treasurer = new Treasurer(result.getString("Firstname"),result.getString("Lastname"),result.getString("Password"),result.getString("Tel"),result.getString("Pseudo"));
				treasurer.setId(result.getInt("IdManager"));
				allPersons.add(treasurer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return allPersons;
	}
}
