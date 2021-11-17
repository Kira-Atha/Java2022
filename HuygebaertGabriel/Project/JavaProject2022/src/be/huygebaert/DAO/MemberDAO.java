package be.huygebaert.DAO;

import java.sql.Connection;
import java.util.List;

import be.huygebaert.POJO.Member;

public class MemberDAO extends DAO<Member>{
	public MemberDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Member obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Member obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Member obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
