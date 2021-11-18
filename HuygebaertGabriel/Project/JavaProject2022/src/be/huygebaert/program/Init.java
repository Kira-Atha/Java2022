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
import be.huygebaert.POJO.TrailRider;
import be.huygebaert.POJO.Trialist;

import java.awt.event.ActionListener;
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
		if(categoryDAO.findAll().isEmpty()) {
			categoryDAO.create(Cyclo.getInstance());
			categoryDAO.create(Descender.getInstance());
			categoryDAO.create(TrailRider.getInstance());
			categoryDAO.create(Trialist.getInstance());
		}
	}
}
