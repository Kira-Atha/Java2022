package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.huygebaert.POJO.Cyclo;
import be.huygebaert.POJO.Descender;
import be.huygebaert.POJO.Manager;

public class CycloDAO extends DAO<Cyclo> {
	
	public CycloDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Cyclo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cyclo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cyclo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cyclo find(int id) {
		Cyclo instanceCyclo = Cyclo.getInstance();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar =" +id);
			if(result.first()) {
				instanceCyclo.setNum(result.getInt("IdCalendar"));
				
				result = this.connect.createStatement().executeQuery("SELECT * FROM Cat_Memb where IdCalendar = " + id);
				MemberDAO memberDAO = new MemberDAO(this.connect);
				ManagerDAO managerDAO = new ManagerDAO(this.connect);
				
				while(result.next()) {
					instanceCyclo.addPerson(memberDAO.find(result.getInt("IdMember")));
				}
				result = this.connect.createStatement().executeQuery("SELECT * FROM Manager where IdCalendar = "+id );
//				if(result.first()) {
//					instanceCyclo.addPerson(managerDAO.find(result.getInt("IdManager")));
//				}
				CalendarDAO calendarDAO = new CalendarDAO(this.connect);
				// car id identique
				instanceCyclo.setSingleCalendar(calendarDAO.find(id));
			}
			
			return instanceCyclo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return instanceCyclo;
	}

	@Override
	public List<Cyclo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
