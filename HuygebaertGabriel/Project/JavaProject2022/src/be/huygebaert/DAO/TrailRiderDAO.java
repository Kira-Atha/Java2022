package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrailRider> find() {
		// TODO Auto-generated method stub
		return null;
	}
}
