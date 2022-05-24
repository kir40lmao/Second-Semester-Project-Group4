package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.Menu;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class Login extends JFrame {
	
	public static boolean logged_in;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\res\\logo_icon.jpg"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel info_label = new JLabel("");
		info_label.setForeground(Color.RED);
		info_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		info_label.setBounds(50, 326, 287, 25);
		contentPane.add(info_label);
		
		JLabel logo_label = new JLabel("");
		logo_label.setHorizontalAlignment(SwingConstants.CENTER);
		logo_label.setIcon(new ImageIcon("C:\\Users\\Hidden\\eclipse-workspace\\EsportsManagment\\res\\es_logo2.png"));
		logo_label.setBounds(50, 24, 287, 163);
		contentPane.add(logo_label);
		
		JLabel username_label = new JLabel("Username");
		username_label.setForeground(Color.WHITE);
		username_label.setFont(new Font("Dialog", Font.BOLD, 18));
		username_label.setBounds(50, 198, 287, 25);
		contentPane.add(username_label);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setBounds(50, 228, 287, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password");
		password_label.setForeground(Color.WHITE);
		password_label.setFont(new Font("Dialog", Font.BOLD, 18));
		password_label.setBounds(50, 259, 287, 25);
		contentPane.add(password_label);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordField.setBounds(50, 290, 287, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String name, password;
				name = textField.getText();
				password = passwordField.getText();
				if(password.equals("admin") && name.equals("admin")) {
					setVisible(false);				
					Menu.logInCard();
				}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(352, 363, 109, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hidden\\eclipse-workspace\\Orders\\src\\res\\1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 484, 411);
		contentPane.add(lblNewLabel_1);
	}
	
	public void show_new() {
		textField.setText("");
		passwordField.setText("");
		setVisible(true);
	}
}
