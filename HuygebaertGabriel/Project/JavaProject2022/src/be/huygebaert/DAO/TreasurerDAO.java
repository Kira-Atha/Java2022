package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

import be.huygebaert.POJO.Treasurer;

public class TreasurerDAO extends DAO<Treasurer> {
	public TreasurerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Treasurer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Treasurer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Treasurer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Treasurer find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Treasurer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
