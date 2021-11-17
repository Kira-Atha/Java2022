package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

import be.huygebaert.POJO.Cyclo;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cyclo> find() {
		// TODO Auto-generated method stub
		return null;
	}
}
