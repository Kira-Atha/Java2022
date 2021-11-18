package be.huygebaert.program;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import be.huygebaert.DAO.DAO;
import be.huygebaert.DAO.DAOFactory;
import be.huygebaert.POJO.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	public JFrame signUp;
	private JTextField tf_Firstname, tf_Lastname, tf_Tel, tf_Pseudo;
	private JPasswordField pf_Password;
	private JLabel lb_Error,lb_Firstname, lb_Lastname, lb_Password, lb_Tel, lb_Pseudo;
	private JButton btn_Send, btn_Back;
	private ButtonGroup typeAccountGroup, typeCategoryGroup;
	private JRadioButton rbtn_Manager, rbtn_Member, rbtn_Treasurer, rbtn_Trialist, rbtn_TrailRider, rbtn_Cyclo,rbtn_Descender;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.signUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		signUp = new JFrame("SignUp");
		signUp.setBounds(0, 0, 800, 600);
		signUp.setLocationRelativeTo(null);
		signUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUp.setLayout(null);
		JPanel inSignUp = new JPanel();
		inSignUp.setBounds(20,20,500,300);
		inSignUp.setLayout(null);
		signUp.add(inSignUp);
		
		tf_Firstname = new JTextField();
		tf_Firstname.setBounds(100,30,150,20);
		tf_Lastname = new JTextField();
		tf_Lastname.setBounds(100,50,150,20);
		tf_Tel = new JTextField();
		tf_Tel.setBounds(100,70,150,20);
		tf_Pseudo = new JTextField();
		tf_Pseudo.setBounds(100,90,150,20);
		pf_Password = new JPasswordField();
		pf_Password.setBounds(100,120,150,20);
		lb_Firstname = new JLabel("Firstname");
		lb_Firstname.setBounds(0,30,90,20);
		lb_Lastname = new JLabel("Lastname");
		lb_Lastname.setBounds(0,50,90,20);
		lb_Tel = new JLabel("Tel");
		lb_Tel.setBounds(0,70,90,20);
		lb_Pseudo = new JLabel("Pseudo");
		lb_Pseudo.setBounds(0,90,90,20);
		lb_Password = new JLabel("Password");
		lb_Password.setBounds(0,120,90,20);
		btn_Send = new JButton("Send");
		btn_Back= new JButton("Back");
		
		JCheckBox chkb_Pass = new JCheckBox("Show password");
		chkb_Pass.setBounds(250, 120, 150, 20);
		inSignUp.add(chkb_Pass);

		chkb_Pass.addActionListener(e -> {
			if(chkb_Pass.isSelected()) {
				pf_Password.setEchoChar((char)0);
			}else {
				pf_Password.setEchoChar('*');
			}
		});
		
		inSignUp.add(lb_Firstname);
		inSignUp.add(tf_Firstname);
		inSignUp.add(lb_Lastname);
		inSignUp.add(tf_Lastname);
		inSignUp.add(lb_Password);
		inSignUp.add(pf_Password);
		inSignUp.add(lb_Tel);
		inSignUp.add(tf_Tel);
		inSignUp.add(tf_Pseudo);
		inSignUp.add(lb_Pseudo);
		
		
		btn_Send.setBounds(500,500,70,50);
		btn_Back.setBounds(400,500,70,50);
		signUp.getContentPane().add(btn_Send);
		signUp.getContentPane().add(btn_Back);
		
		JPanel panel_rbtn_TypeAccount = new JPanel();
		panel_rbtn_TypeAccount.setLayout(new GridLayout(3,1));
		panel_rbtn_TypeAccount.setBounds(0,200,100,100);
	
		rbtn_Manager = new JRadioButton("Manager");
		rbtn_Manager.setActionCommand("Manager");
		rbtn_Treasurer = new JRadioButton("Treasurer");
		rbtn_Treasurer.setActionCommand("Treasurer");
		rbtn_Member = new JRadioButton("Member",true);
		rbtn_Member.setActionCommand("Member");
		
		typeAccountGroup = new ButtonGroup();
		typeAccountGroup.add(rbtn_Manager);
		typeAccountGroup.add(rbtn_Treasurer);
		typeAccountGroup.add(rbtn_Member);
		panel_rbtn_TypeAccount.add(rbtn_Member);
		panel_rbtn_TypeAccount.add(rbtn_Manager);
		panel_rbtn_TypeAccount.add(rbtn_Treasurer);
		
		signUp.getContentPane().add(panel_rbtn_TypeAccount);
		
		JPanel panel_rbtn_TypeCategory = new JPanel();
		panel_rbtn_TypeCategory.setLayout(new GridLayout(4,1));
		panel_rbtn_TypeCategory.setBounds(100,200,100,100);
		typeCategoryGroup = new ButtonGroup();
		rbtn_Trialist = new JRadioButton("Trialist");
		rbtn_Trialist.setActionCommand("Trialist");
		rbtn_Cyclo = new JRadioButton("Cyclo",true);
		rbtn_Cyclo.setActionCommand("Cyclo");
		rbtn_TrailRider = new JRadioButton("TrailRider");
		rbtn_TrailRider.setActionCommand("TrailRider");
		rbtn_Descender = new JRadioButton("Descender");
		rbtn_Descender.setActionCommand("Descender");
		
		typeCategoryGroup.add(rbtn_Cyclo);
		typeCategoryGroup.add(rbtn_Descender);
		typeCategoryGroup.add(rbtn_TrailRider);
		typeCategoryGroup.add(rbtn_Trialist);
		panel_rbtn_TypeCategory.add(rbtn_Cyclo);
		panel_rbtn_TypeCategory.add(rbtn_Descender);
		panel_rbtn_TypeCategory.add(rbtn_Trialist);
		panel_rbtn_TypeCategory.add(rbtn_TrailRider);
		
		signUp.getContentPane().add(panel_rbtn_TypeCategory);
		
		
		
		btn_Send.addActionListener(e->{
			String firstname = tf_Firstname.getText();
			String lastname = tf_Lastname.getText();
			String tel = tf_Tel.getText();
			String pseudo = tf_Pseudo.getText();
			String password = String.valueOf(pf_Password.getPassword());
			boolean checkedAccount = typeAccountGroup.getSelection() !=null;
			String account = checkedAccount? typeAccountGroup.getSelection().getActionCommand():"";
			boolean checkedCategory = typeCategoryGroup.getSelection() !=null;
			String category = checkedCategory? typeCategoryGroup.getSelection().getActionCommand():"";
			String result = formValidation(firstname,lastname,tel,pseudo,password,account,category);
			
			lb_Error = new JLabel();
			lb_Error.setBounds(300,250, 400, 300);
			lb_Error.setForeground(Color.red);
			lb_Error.hide();
			signUp.getContentPane().add(lb_Error);
			if(result!="") {
				result="<html>"+result+"</html>";
				lb_Error.setText("");
				lb_Error.setText(result);
				lb_Error.show();
			}else {
				Category category_ = null;
				lb_Error.setText("");
				lb_Error.hide();
				// Alors envoyer résultat pour traitement
				DAOFactory adf = new DAOFactory();
				DAO<Person> personDAO = adf.getPersonDAO();
				
				if(category.equals("Trialist")){
					category_ =  Trialist.getInstance();
				}
				if(category.equals("Descender")){
					category_ =  Descender.getInstance();
				}
				if(category.equals("Cyclo")){
					category_ =  Cyclo.getInstance();
				}
				if(category.equals("TrailRider")) {
					category_ = TrailRider.getInstance();
				}
				
				if(account.equals("Treasurer")) {
					Treasurer treasurer = new Treasurer(firstname,lastname,password,tel,pseudo);
					if(!treasurer.equals(null)) {
						personDAO.create(treasurer);
						ConsultCalendar next = new ConsultCalendar();
						JFrame consultCalendar = next.consultCalendar;
						changeFrame(consultCalendar);
					}else {
						lb_Error.setText("This treasurer already exist in member !");
					}
				}
				if(account.equals("Member")) {
					Member member = new Member(firstname,lastname,password,tel,pseudo,category_);
						if(!member.equals(null)) {
							personDAO.create(member);
							ConsultCalendar next = new ConsultCalendar();
							JFrame consultCalendar = next.consultCalendar;
							changeFrame(consultCalendar);
						}else {
							lb_Error.setText("This member already exist !");
						}
				}
				if(account.equals("Manager")) {
					Manager manager = new Manager(firstname,lastname,password,tel,pseudo,category_);
					if(!manager.equals(null)) {
						personDAO.create(manager);
						ConsultCalendar next = new ConsultCalendar();
						JFrame consultCalendar = next.consultCalendar;
						changeFrame(consultCalendar);
					}else {
						lb_Error.setText("This manager already exist in member or the category chosen has already a manager !");
					}
				}
			}
		});
		btn_Back.addActionListener(e-> {
			Init previous = new Init();
			JFrame home = previous.init;
			changeFrame(home);
		});
	}
	public void changeFrame(JFrame window) {
		window.setVisible(true);
		signUp.dispose();
	}
	public String formValidation(String firstname, String lastname, String password, String pseudo, String tel, String typeAccount, String typeCategory) {
		String result="";
		
		if(firstname.equals("") || firstname.length() < 3) {
			result+="Invalid firstname";
			result+="<br/>";
		}
		if(lastname.equals("") || lastname.length() < 3) {
			result+="Invalid lastname";
			result+="<br/>";
		}
		if(password.equals("") || password.length() < 4 || password.length()>16) {
			result+="Invalid password. Password must be in 4 to 16 characters";
			result+="<br/>";
		}
		if(pseudo.equals("") || pseudo.length() < 3) {
			result+="Invalid pseudo";
			result+="<br/>";
		}
		if(tel.equals("") || tel.length() < 3) {
			result+="Invalid tel";
			result+="<br/>";
		}
		if(typeAccount.equals("") || typeAccount.equals(null)) {
			result+="Invalid account type";
			result+="<br/>";
		}
		if(typeCategory.equals("") || typeCategory.equals(null)) {
			result+="Invalid category type";
			result+="<br/>";
		}
		return result;
	}
}