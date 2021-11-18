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
		String categoryToPutInDb = obj.getClass().getEnclosingClass().getName();
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
		Category category = (Category) new Object();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar =" +id);
			if(result.first()) {
				category.setNum(result.getInt("IdCalendar"));
				
				
				result = this.connect.createStatement().executeQuery("SELECT * FROM cat_memb where IdCalendar = " + id);
				PersonDAO personDAO = new PersonDAO(this.connect);
				while(result.next()) {
					category.addPerson(personDAO.find(result.getInt("IdMember")));
				}
				result = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+id );
				if(result.first()) {
					category.setSingleManager((Manager)personDAO.find(result.getInt("IdManager")));
				}
				CalendarDAO calendarDAO = new CalendarDAO(this.connect);
				// car id identique
				category.setSingleCalendar(calendarDAO.find(id));
			}
			
			return category;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Category> findAll() {
		AbstractList<Category> categories = new ArrayList<Category>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar");
			while(result.next()) {
				Category category = (Category) new Object();

				category.setNum(result.getInt("IdCalendar"));
				
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cat_memb where IdCalendar ="+category.getNum());
				PersonDAO personDAO = new PersonDAO(this.connect);
				while(result2.next()) {
					category.addPerson(personDAO.find(result2.getInt("IdMember")));
				}
				result2 = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+category.getNum());
				if(result2.first()) {
					category.setSingleManager((Manager)personDAO.find(result2.getInt("IdManager")));
				}
				CalendarDAO calendarDAO = new CalendarDAO(this.connect);
				// car id identique
				category.setSingleCalendar(calendarDAO.find(category.getNum()));
				
				categories.add(category);
			}
			return categories;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
