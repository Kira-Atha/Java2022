package be.huygebaert.DAO;

import java.sql.Connection;

import be.huygebaert.POJO.*;

public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn = DbConnection.getInstance();
	
//	public DAO<Classe> getClasseDAO(){
//		return new ClasseDAO(conn);
//	}
//	
//	public DAO<Professeur> getProfesseurDAO(){
//		return new ProfesseurDAO(conn);
//	}
//	
//	public DAO<Eleve> getEleveDAO(){
//		return new EleveDAO(conn);
//	}
//	
//	public DAO<Matiere> getMatiereDAO(){
//		return new MatiereDAO(conn);
//	}
}