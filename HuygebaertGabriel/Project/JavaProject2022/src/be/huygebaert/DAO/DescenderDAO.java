package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.huygebaert.POJO.Descender;
import be.huygebaert.POJO.Manager;
import be.huygebaert.POJO.TrailRider;

public class DescenderDAO extends DAO<Descender>{
	
	public DescenderDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Descender obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Descender obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Descender obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Descender find(int id) {
		Descender instanceDesc = Descender.getInstance();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar =" +id);
			if(result.first()) {
				instanceDesc.setNum(result.getInt("IdCalendar"));
				
				
				result = this.connect.createStatement().executeQuery("SELECT * FROM cat_memb where IdCalendar = " + id);
				PersonDAO personDAO = new PersonDAO(this.connect);
				while(result.next()) {
					instanceDesc.addPerson(personDAO.find(result.getInt("IdMember")));
				}
				result = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar ="+id );
				if(result.first()) {
					instanceDesc.setSingleManager((Manager)personDAO.find(result.getInt("IdManager")));
				}
				CalendarDAO calendarDAO = new CalendarDAO(this.connect);
				// car id identique
				instanceDesc.setSingleCalendar(calendarDAO.find(id));
			}
			
			return instanceDesc;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return instanceDesc;
	}

	@Override
	public List<Descender> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
