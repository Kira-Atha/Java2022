package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

import be.huygebaert.POJO.Trialist;

public class TrialistDAO extends DAO<Trialist>{
	public TrialistDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Trialist obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Trialist obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Trialist obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Trialist find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trialist> find() {
		// TODO Auto-generated method stub
		return null;
	}
}
