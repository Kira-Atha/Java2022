package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.huygebaert.POJO.Category;
import be.huygebaert.POJO.Cyclo;
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
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from Calendar WHERE IdCalendar ="+id);
			if(result.first()) {
				TrailRider instanceTrailRider = TrailRider.getInstance();
				MemberDAO memberDAO = new MemberDAO(this.connect);
				ManagerDAO managerDAO = new ManagerDAO(this.connect);
				CalendarDAO calendarDAO = new CalendarDAO(this.connect);
				
				instanceTrailRider.setSingleCalendar(calendarDAO.find(instanceTrailRider.getNum()));
				
				result = this.connect.createStatement().executeQuery(
						"SELECT * FROM Calendar INNER JOIN Cat_Memb "
						+ "ON Calendar.IdCalendar = Cat_Memb.IdCalendar "
						+ "INNER JOIN Member "
						+ "ON Cat_Memb.IdMember = Member.IdMember "
						+ "WHERE IdCalendar ="+instanceTrailRider.getNum());
				while(result.next()) {
					instanceTrailRider.addPerson(memberDAO.find(result.getInt("IdMember")));
				}
				result = this.connect.createStatement().executeQuery(
						"SELECT * FROM Calendar INNER JOIN Manager "
						+ "ON Calendar.IdCalendar = Manager.IdCalendar "
						+ "WHERE IdCalendar ="+instanceTrailRider.getNum());
				
				while(result.next()) {
					// Bien qu'il n'y ait qu'un seul manager, faire result.first() pose probl�me.
					// .next() va tout de m�me s'arr�ter au bout du premier et unique manager rencontr� pour cette cat�gorie.
					instanceTrailRider.addPerson(managerDAO.find(result.getInt("IdManager")));
				}
				return instanceTrailRider;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TrailRider> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
