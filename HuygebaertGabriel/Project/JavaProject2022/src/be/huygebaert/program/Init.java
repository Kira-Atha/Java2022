package be.huygebaert.program;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		Cyclo.getInstance();
		Descender.getInstance();
		TrailRider.getInstance();
		Trialist.getInstance();
	}
}
