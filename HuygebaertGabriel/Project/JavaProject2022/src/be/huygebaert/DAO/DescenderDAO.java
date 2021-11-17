package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

import be.huygebaert.POJO.Descender;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Descender> find() {
		// TODO Auto-generated method stub
		return null;
	}
}
