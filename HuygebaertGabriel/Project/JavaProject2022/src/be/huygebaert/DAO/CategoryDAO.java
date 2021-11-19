package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import be.huygebaert.POJO.Category;
import be.huygebaert.POJO.Cyclo;
import be.huygebaert.POJO.Descender;
import be.huygebaert.POJO.Manager;
import be.huygebaert.POJO.TrailRider;
import be.huygebaert.POJO.Trialist;

public class CategoryDAO extends DAO<Category> {
	
	public CategoryDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Category obj) {
		String categoryToPutInDb = obj.getClass().getSimpleName();
		try {
		    PreparedStatement ps0 = this.connect.prepareStatement("INSERT INTO Calendar VALUES (?,?)");
		    ps0.setInt(1, obj.getNum());
	        ps0.setString(2,categoryToPutInDb);
	        int isOk0 = ps0.executeUpdate();
	        
	        if(isOk0 == 1 ) {
	        	return true;
	        }
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category find(int id) {
		return null;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		MemberDAO memberDAO = new MemberDAO(this.connect);
		ManagerDAO managerDAO = new ManagerDAO(this.connect);
		CalendarDAO calendarDAO = new CalendarDAO(this.connect);
		
		Cyclo instanceCyclo = Cyclo.getInstance();
		Descender instanceDescender = Descender.getInstance();
		TrailRider instanceTrailRider = TrailRider.getInstance();
		Trialist instanceTrialist = Trialist.getInstance();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar ="+instanceCyclo.getNum());
			if(result.first()) {
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cat_Memb where IdCalendar ="+instanceCyclo.getNum());
				
				while(result2.next()) {
					instanceCyclo.addPerson(memberDAO.find(result2.getInt("IdMember")));
				}
				result2 = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+instanceCyclo.getNum());
//				if(result2.first()) {
//					instanceCyclo.addPerson(managerDAO.find(result2.getInt("IdManager")));
//				}
				// car id identique
				//instanceCyclo.setSingleCalendar(calendarDAO.find(instanceCyclo.getNum()));
				categories.add(instanceCyclo);
			}else {
				// Pas la peine d'aller plus loin s'il ne trouve pas déjà la première catégorie puisque les 4 sont créées en même temps
				return categories;
			}
				
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar ="+instanceDescender.getNum());
			if(result.first()) {
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cat_Memb where IdCalendar ="+instanceDescender.getNum());
				while(result2.next()) {
					instanceDescender.addPerson(memberDAO.find(result2.getInt("IdMember")));
				}
//				result2 = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+instanceDescender.getNum());
//				if(result2.first()) {
//					instanceDescender.setSingleManager((Manager)managerDAO.find(result2.getInt("IdManager")));
//				}
				// car id identique
				//instanceDescender.setSingleCalendar(calendarDAO.find(instanceDescender.getNum()));
				
				categories.add(instanceDescender);
			}
		
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar ="+instanceTrialist.getNum());
			if(result.first()) {
			
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cat_Memb where IdCalendar ="+instanceTrialist.getNum());
				while(result2.next()) {
					instanceTrialist.addPerson(memberDAO.find(result2.getInt("IdMember")));
				}
//				result2 = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+instanceTrialist.getNum());
//				if(result2.first()) {
//					instanceTrialist.setSingleManager((Manager)managerDAO.find(result2.getInt("IdManager")));
//				}
				// car id identique
				//instanceTrialist.setSingleCalendar(calendarDAO.find(instanceTrialist.getNum()));
				
				categories.add(instanceTrialist);
			}
			
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar ="+instanceTrailRider.getNum());
			if(result.first()) {
			
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cat_Memb where IdCalendar ="+instanceTrailRider.getNum());
				while(result2.next()) {
					instanceTrailRider.addPerson(memberDAO.find(result2.getInt("IdMember")));
				}
//				result2 = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+instanceTrailRider.getNum());
//				if(result2.first()) {
//					instanceTrailRider.setSingleManager((Manager)managerDAO.find(result2.getInt("IdManager")));
//				}
				// car id identique
				//instanceTrailRider.setSingleCalendar(calendarDAO.find(instanceCyclo.getNum()));
				
				categories.add(instanceTrailRider);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
}
