package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerLayer.MatchController;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Login login_window;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int height = (int) screenSize.getHeight();
    public static int width = (int) screenSize.getWidth();

	private JPanel base;
	

	public static void main(String[] args) {
		MatchController mc = new MatchController();
		mc.createMatch(1000, 1001, "2022-05-16");
		//mc.updatePlayerMatchStats(1002, 1001, 10, 12);
		//mc.updateMatchScore(1002, 16, 9);
		//mc.getMatchDetails(1002);
		//System.setProperty("sun.java2d.uiScale", "1.0");
		//GUI frame = new GUI();
		//frame.setVisible(true);
		//frame.setTitle("XtremeSports app - user version");
	}

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\res\\logo_icon.jpg"));
		setBounds(0, 0, 1940, 1080);
		base = new JPanel();
		base.setBackground(Color.WHITE);
		base.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(base);
		CardLayout cl_base = new CardLayout(0, 0);
		base.setLayout(cl_base);
		
		JPanel main_menu_logged_in = new JPanel();
		main_menu_logged_in.setOpaque(false);
		main_menu_logged_in.setLayout(null);
		
		JPanel main_menu_logged_out = new JPanel();
		main_menu_logged_out.setLayout(null);
		main_menu_logged_out.setOpaque(false);
		
		base.add(main_menu_logged_out, "main_menu_logged_out");
		base.add(main_menu_logged_in, "main_menu_logged_in");
		
		
		if(Login.logged_in) {
			cl_base.show(base, "main_menu_logged_in");
		}
		else {
			cl_base.show(base, "main_menu_logged_out");
		}
		
		JButton Logout_button = new JButton("Log out");
		Logout_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(base, "main_menu_logged_out");
				Login.logged_in = false;
				setTitle("XtremeSports app - user version");
			}
		});
		
		Logout_button.setFont(new Font("Dialog", Font.BOLD, 15));
		Logout_button.setFocusPainted(false);
		Logout_button.setBackground(Color.WHITE);
		Logout_button.setBounds(1250, 55, 120, 60);
		main_menu_logged_in.add(Logout_button);
		
		JLabel logo_label_main_menu = new JLabel("");
		logo_label_main_menu.setIcon(new ImageIcon("C:\\Users\\Hidden\\eclipse-workspace\\EsportsManagment\\res\\es_logo2.png"));
		logo_label_main_menu.setForeground(Color.BLACK);
		logo_label_main_menu.setFont(new Font("Tahoma", Font.PLAIN, 40));
		logo_label_main_menu.setBounds(65, 55, 314, 163);
		main_menu_logged_in.add(logo_label_main_menu);
		
		JLabel main_menu_background = new JLabel("");
		main_menu_background.setIcon(new ImageIcon("C:\\Users\\Hidden\\eclipse-workspace\\Orders\\src\\res\\google.jpg"));
		main_menu_background.setBounds(0, 0, 1940, 1031);
		main_menu_logged_in.add(main_menu_background);
		
		
		JButton log_in_button = new JButton("Log in");
		log_in_button.setFont(new Font("Dialog", Font.BOLD, 15));
		log_in_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newLogin();
			}
		});
		
		JLabel logo_label_search = new JLabel("");
		logo_label_search.setIcon(new ImageIcon("C:\\Users\\Hidden\\eclipse-workspace\\EsportsManagment\\res\\es_logo2.png"));
		logo_label_search.setForeground(Color.BLACK);
		logo_label_search.setFont(new Font("Tahoma", Font.PLAIN, 40));
		logo_label_search.setBounds(65, 55, 314, 163);
		main_menu_logged_out.add(logo_label_search);
		log_in_button.setFocusPainted(false);
		log_in_button.setBackground(Color.WHITE);
		log_in_button.setBounds(1250, 55, 120, 60);
		main_menu_logged_out.add(log_in_button);
		
		JLabel search_background = new JLabel("");
		search_background.setFont(new Font("Dialog", Font.BOLD, 12));
		search_background.setIcon(new ImageIcon("C:\\Users\\Hidden\\eclipse-workspace\\Orders\\src\\res\\google.jpg"));
		search_background.setBounds(0, 0, 1940, 1080);
		main_menu_logged_out.add(search_background);
	}

	public void newLogin() {
		setVisible(false);
		login_window = new Login();
		login_window.show_new();

	}
}

