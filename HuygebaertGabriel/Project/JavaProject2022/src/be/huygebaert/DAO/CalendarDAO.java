package be.huygebaert.DAO;

import java.util.List;
import java.sql.Connection;
import be.huygebaert.POJO.Calendar;

public class CalendarDAO extends DAO<Calendar>{

	public CalendarDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Calendar obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Calendar obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Calendar obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Calendar find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Calendar> find() {
		// TODO Auto-generated method stub
		return null;
	}
}
