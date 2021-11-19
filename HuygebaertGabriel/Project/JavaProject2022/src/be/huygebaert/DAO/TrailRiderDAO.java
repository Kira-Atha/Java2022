package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.huygebaert.POJO.Category;
import be.huygebaert.POJO.Manager;
import be.huygebaert.POJO.TrailRider;

public class TrailRiderDAO extends DAO<TrailRider> {
	public TrailRiderDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(TrailRider obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TrailRider obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TrailRider obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TrailRider find(int id) {
		TrailRider instanceTR = TrailRider.getInstance();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar =" +id);
			if(result.first()) {
				instanceTR.setNum(result.getInt("IdCalendar"));
				
				
				result = this.connect.createStatement().executeQuery("SELECT * FROM cat_memb where IdCalendar = " + id);
				PersonDAO personDAO = new PersonDAO(this.connect);
				while(result.next()) {
					instanceTR.addPerson(personDAO.find(result.getInt("IdMember")));
				}
				result = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+id );
				if(result.first()) {
					instanceTR.setSingleManager((Manager)personDAO.find(result.getInt("IdManager")));
				}
				CalendarDAO calendarDAO = new CalendarDAO(this.connect);
				// car id identique
				instanceTR.setSingleCalendar(calendarDAO.find(id));
			}
			
			return instanceTR;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return instanceTR;
	}

	@Override
	public List<TrailRider> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
