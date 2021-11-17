package be.huygebaert.program;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ConsultCalendar {

	public JFrame consultCalendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultCalendar window = new ConsultCalendar();
					window.consultCalendar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultCalendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultCalendar = new JFrame();
		consultCalendar.setBounds(100, 100, 450, 300);
		consultCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
