package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

import be.huygebaert.POJO.Category;

public class CategoryDAO extends DAO<Category> {
	
	public CategoryDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> find() {
		// TODO Auto-generated method stub
		return null;
	}
}
