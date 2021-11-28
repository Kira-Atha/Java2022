package be.huygebaert.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import be.huygebaert.POJO.Category;
import be.huygebaert.POJO.Cyclo;
import be.huygebaert.POJO.Descender;
import be.huygebaert.POJO.Manager;
import be.huygebaert.POJO.TrailRider;
import be.huygebaert.POJO.Trialist;

public class CategoryDAO extends DAO<Category> {
	
	public CategoryDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Category obj) {
		String categoryToPutInDb = obj.getClass().getSimpleName();
		try {
		    PreparedStatement ps0 = this.connect.prepareStatement("INSERT INTO Calendar VALUES (?,?)");
		    ps0.setInt(1, obj.getNum());
	        ps0.setString(2,categoryToPutInDb);
	        int isOk0 = ps0.executeUpdate();
	        
	        if(isOk0 == 1 ) {
	        	return true;
	        }
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

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
		return null;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		
		Cyclo instanceCyclo = Cyclo.getInstance();
		Descender instanceDescender = Descender.getInstance();
		TrailRider instanceTrailRider = TrailRider.getInstance();
		Trialist instanceTrialist = Trialist.getInstance();
		
		CycloDAO cycloDAO = new CycloDAO(this.connect);
		TrailRiderDAO trailRiderDAO = new TrailRiderDAO(this.connect);
		DescenderDAO descenderDAO = new DescenderDAO(this.connect);
		TrialistDAO trialistDAO = new TrialistDAO(this.connect);
		
		if(cycloDAO.find(instanceCyclo.getNum())!=null) {
			categories.add(cycloDAO.find(instanceCyclo.getNum()));
		}
		
		if(descenderDAO.find(instanceDescender.getNum()) != null) {
			categories.add(descenderDAO.find(instanceDescender.getNum()));
		}
	
		if(trailRiderDAO.find(instanceTrailRider.getNum())!=null) {
			categories.add(trailRiderDAO.find(instanceTrailRider.getNum()));
		}
		
		if(trialistDAO.find(instanceTrialist.getNum())!=null) {
			categories.add(trialistDAO.find(instanceTrialist.getNum()));
		}

		return categories;
	}
}