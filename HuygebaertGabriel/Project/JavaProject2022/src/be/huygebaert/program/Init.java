package be.huygebaert.program;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

import be.huygebaert.DAO.DAO;
import be.huygebaert.DAO.DAOFactory;
import be.huygebaert.POJO.Category;
import be.huygebaert.POJO.Cyclo;
import be.huygebaert.POJO.Descender;
import be.huygebaert.POJO.Manager;
import be.huygebaert.POJO.TrailRider;
import be.huygebaert.POJO.Trialist;

import java.awt.event.ActionListener;
import java.util.AbstractList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Init {

	public JFrame init;
	private JButton btn_SignUp, btn_SignIn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Init window = new Init();
					window.init.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Init() {
		initialize();
		initCategories();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		init = new JFrame("Home");
		init.setBounds(0, 0, 800,600);
		init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init.getContentPane().setLayout(null);
		init.setLocationRelativeTo(null);
		
		btn_SignUp = new JButton("Sign Up");
		btn_SignUp.setBounds(200,200,100,30);
		init.getContentPane().add(btn_SignUp);
		
		btn_SignIn = new JButton("Sign In");
		btn_SignIn.setBounds(200,230,100,30);
		init.getContentPane().add(btn_SignIn);
		
		DAOFactory adf = new DAOFactory();

		btn_SignIn.addActionListener(e-> {
			SignIn next = new SignIn();
			JFrame nextFrame = next.signIn;
			changeFrame(nextFrame);
		});

		btn_SignUp.addActionListener(e-> {
			SignUp next = new SignUp();
			JFrame nextFrame = next.signUp;
			changeFrame(nextFrame);
		});
	}
	
	
	public void changeFrame(JFrame window) {
		window.setVisible(true);
		init.dispose();
	}
	public void initCategories() {
		DAOFactory adf = new DAOFactory();
		DAO<Category> categoryDAO = adf.getCategoryDAO();
		// Comme les catégories sont créées en même temps, si elles n'existent pas dans la base de données, findAll renverra une liste vide.
		
		Cyclo instanceCyclo = Cyclo.getInstance();
		Descender instanceDescender = Descender.getInstance();
		TrailRider instanceTrailRider = TrailRider.getInstance();
		Trialist instanceTrialist = Trialist.getInstance();
		
		List<Category> categories = categoryDAO.findAll();
		
		if(categories.isEmpty()) {
			categoryDAO.create(instanceCyclo);
			categoryDAO.create(instanceDescender);
			categoryDAO.create(instanceTrailRider);
			categoryDAO.create(instanceTrialist);
		}
		// TEST
//		for(Category category:categories) {
//			System.out.println(category.getClass().getSimpleName());
//			System.out.println(category.getSingleManager());
//			System.out.println(category.getCategoryMembers());
//			System.out.println(category.getSingleCalendar().getInstanceOfCalendar(category));
//		}
//		DAO<Manager> managerDAO = adf.getManagerDAO();
//		Manager manager = managerDAO.find(1);
//		System.out.println(manager.getFirstname());
//		System.out.println(manager.getCategory().getClass().getSimpleName());
//		
//		DAO<Cyclo> cycloDAO = adf.getCycloDAO();
//		instanceCyclo= cycloDAO.find(1);
		//System.out.println(instanceCyclo.getSingleManager().getFirstname());
		
	}
}