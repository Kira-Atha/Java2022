package be.huygebaert.DAO;

import be.huygebaert.POJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
//	public abstract DAO<Classe> getClasseDAO();
//	
//	public abstract DAO<Professeur> getProfesseurDAO();
//	
//	public abstract DAO<Eleve> getEleveDAO();
//		
//	public abstract DAO<Matiere> getMatiereDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
}