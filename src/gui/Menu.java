package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

import ControllerLayer.MatchController;
import ControllerLayer.PlayerController;
import ControllerLayer.TeamController;
import ControllerLayer.TournamentController;
import ModelLayer.Player;
import ModelLayer.Team;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	public JFrame frame;
	private JTextField txt_gamer_tag;
	private JTextField textField_1;
	private JTextField txtSearchTeamMenu;
	private JTextField textField_3;
	private JTextField txtSearchPlayerMenu;
	private JTextField textField_5;
	private JTextField txtTournamentHistoryMenu;
	private JTextField tournamentNameField;
	private JTextField tournamentDateField;
	private JTextField teamNameField;
	private JTextField gamerTagField;
	
	Login login_window;
	private JTextField textField_search_gamer;
	
	PlayerController pc = new PlayerController();
	MatchController mc = new MatchController();
	TeamController teamc = new TeamController();
	TournamentController tournamentc = new TournamentController();
	private JTextField txt_player_team_ID;
	private JTextField txt_search_team;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
					window.frame.setTitle("XtremeSports app");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}
	
	public void newLogin() {
		//setVisible(false);
		login_window = new Login();
		login_window.show_new();

		}
		

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cl_base = new CardLayout(0, 0);
		frame.getContentPane().setLayout(cl_base);
		
		JPanel userMenu = new JPanel();
		frame.getContentPane().add(userMenu, "userMenu");
		userMenu.setLayout(null);
		
		if(Login.logged_in) {
			cl_base.show(frame.getContentPane(), "managerMenu");
		}
		else {
			cl_base.show(frame.getContentPane(), "userMenu");
		}
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 1281, 35);
		menuBar_1.setBackground(Color.LIGHT_GRAY);
		userMenu.add(menuBar_1);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Check Forum");
		mntmNewMenuItem_10.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_10.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Search Team");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamSearchMenu");
			}
		});
		mntmNewMenuItem_9.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_9.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Search Player");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerSearchMenu");
			}
		});
		mntmNewMenuItem_8.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_8.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tournament History");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentHistoryMenu");
			}
		});
		mntmNewMenuItem_7.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_7.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar_1.add(mntmNewMenuItem_7);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(null);
		separator_1.setBackground(Color.LIGHT_GRAY);
		menuBar_1.add(separator_1);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.LIGHT_GRAY);
		menuBar_1.add(separator_6);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Log In Icon");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newLogin();
			}
		});
		mntmNewMenuItem_12.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_12.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar_1.add(mntmNewMenuItem_12);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(756, 227, 240, 322);
		userMenu.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"David P", "Kiril", "David B", "Kornel", "Akos"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(313, 227, 243, 322);
		userMenu.add(panel_1);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
				//frame.getContentPane().add(managerMenu, "name_15084022880400");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(40, 632, 160, 56);
		userMenu.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("News");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(313, 168, 249, 28);
		userMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("On-Going Tournaments");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(747, 177, 249, 28);
		userMenu.add(lblNewLabel_2_1);
		
		JPanel managerMenu = new JPanel();
		frame.getContentPane().add(managerMenu, "managerMenu");
		managerMenu.setLayout(null);
		//frame.getContentPane().add(frame.getContentPane(), "managerMenu");
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 1281, 35);
		managerMenu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Team Management");
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Create Teams");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JPanel teamManagementMenu = new JPanel();
		teamManagementMenu.setLayout(null);
		frame.getContentPane().add(teamManagementMenu, "teamManagementMenu");
		
		JLabel label_for_team_id = new JLabel("<<team id>>");
		label_for_team_id.setBounds(516, 157, 135, 30);
		teamManagementMenu.add(label_for_team_id);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Player Management");
		mnNewMenu_1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Create Player");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JPanel playerManagementMenu = new JPanel();
		playerManagementMenu.setLayout(null);
		frame.getContentPane().add(playerManagementMenu, "playerManagementMenu");
		
		JLabel label_for_player_id = new JLabel("<<player id>>");
		label_for_player_id.setBounds(538, 173, 135, 30);
		playerManagementMenu.add(label_for_player_id);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Manage Players");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Tournament");
		mnNewMenu_2.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		menuBar.add(separator);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("log out");
		mntmNewMenuItem_6.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.LIGHT_GRAY);
		menuBar.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.LIGHT_GRAY);
		menuBar.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.LIGHT_GRAY);
		menuBar.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.LIGHT_GRAY);
		menuBar.add(separator_5);
		menuBar.add(mntmNewMenuItem_6);
		
		JButton btnNewButton_2 = new JButton("Quit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		btnNewButton_2.setBounds(49, 634, 135, 41);
		
		
		managerMenu.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome!");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(419, 86, 343, 52);
		managerMenu.add(lblNewLabel_3);
		
		JPanel teamCreationMenu = new JPanel();
		teamCreationMenu.setLayout(null);
		frame.getContentPane().add(teamCreationMenu, "teamCreationMenu");
		
		JMenuBar menuBar1 = new JMenuBar();
		menuBar1.setBackground(Color.LIGHT_GRAY);
		menuBar1.setBounds(0, 0, 1281, 35);
		teamCreationMenu.add(menuBar1);
		
		JMenu mnNewMenu1 = new JMenu("Team Management");
		mnNewMenu1.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(mnNewMenu1);
		
		JMenuItem mntmNewMenuItem1 = new JMenuItem("Create Teams");
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu1.add(mntmNewMenuItem1);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu1.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_11 = new JMenu("Player Management");
		mnNewMenu_11.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(mnNewMenu_11);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Create Player");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_11.add(mntmNewMenuItem_21);
		
		JMenuItem mntmNewMenuItem_31 = new JMenuItem("Manage Players");
		mntmNewMenuItem_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_11.add(mntmNewMenuItem_31);
		
		JMenu mnNewMenu_21 = new JMenu("Tournament");
		mnNewMenu_21.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(mnNewMenu_21);
		
		JMenuItem mntmNewMenuItem_41 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_21.add(mntmNewMenuItem_41);
		
		JMenuItem mntmNewMenuItem_51 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_21.add(mntmNewMenuItem_51);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(separator1);
		
		JMenuItem mntmNewMenuItem_61 = new JMenuItem("log out");
		mntmNewMenuItem_61.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(separator_21);
		
		JSeparator separator_31 = new JSeparator();
		separator_31.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(separator_31);
		
		JSeparator separator_41 = new JSeparator();
		separator_41.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(separator_41);
		
		JSeparator separator_51 = new JSeparator();
		separator_51.setBackground(Color.LIGHT_GRAY);
		menuBar1.add(separator_51);
		menuBar1.add(mntmNewMenuItem_61);
		
		JButton btnNewButton_2_1 = new JButton("Quit");
		btnNewButton_2_1.setBounds(40, 647, 135, 41);
		teamCreationMenu.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Team Creation Menu");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_5.setBounds(463, 44, 359, 35);
		teamCreationMenu.add(lblNewLabel_1_5);
		
		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTeamName.setBounds(40, 162, 135, 35);
		teamCreationMenu.add(lblTeamName);
		
		teamNameField = new JTextField();
		teamNameField.setBounds(154, 171, 151, 20);
		teamCreationMenu.add(teamNameField);
		teamNameField.setColumns(10);
		
		JButton btnNewButton_2_1_1 = new JButton("Confirm Team Creation");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamName = teamNameField.getText();
				teamc.createTeam(teamName);
			}
		});
		btnNewButton_2_1_1.setBounds(365, 171, 151, 41);
		teamCreationMenu.add(btnNewButton_2_1_1);
		
		JMenuBar menuBar11 = new JMenuBar();
		menuBar11.setBackground(Color.LIGHT_GRAY);
		menuBar11.setBounds(0, 0, 1281, 35);
		teamManagementMenu.add(menuBar11);
		
		JMenu mnNewMenu11 = new JMenu("Team Management");
		mnNewMenu11.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(mnNewMenu11);
		
		JMenuItem mntmNewMenuItem11 = new JMenuItem("Create Teams");
		mntmNewMenuItem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu11.add(mntmNewMenuItem11);
		
		JMenuItem mntmNewMenuItem_111 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu11.add(mntmNewMenuItem_111);
		
		JMenu mnNewMenu_111 = new JMenu("Player Management");
		mnNewMenu_111.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(mnNewMenu_111);
		
		JMenuItem mntmNewMenuItem_211 = new JMenuItem("Create Player");
		mntmNewMenuItem_211.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_111.add(mntmNewMenuItem_211);
		
		JMenuItem mntmNewMenuItem_311 = new JMenuItem("Manage Players");
		mntmNewMenuItem_311.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_111.add(mntmNewMenuItem_311);
		
		JMenu mnNewMenu_211 = new JMenu("Tournament");
		mnNewMenu_211.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(mnNewMenu_211);
		
		JMenuItem mntmNewMenuItem_411 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_411.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_211.add(mntmNewMenuItem_411);
		
		JMenuItem mntmNewMenuItem_511 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_511.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_211.add(mntmNewMenuItem_511);
		
		JSeparator separator11 = new JSeparator();
		separator11.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(separator11);
		
		JMenuItem mntmNewMenuItem_611 = new JMenuItem("log out");
		mntmNewMenuItem_611.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_611.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_211 = new JSeparator();
		separator_211.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(separator_211);
		
		JSeparator separator_311 = new JSeparator();
		separator_311.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(separator_311);
		
		JSeparator separator_411 = new JSeparator();
		separator_411.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(separator_411);
		
		JSeparator separator_511 = new JSeparator();
		separator_511.setBackground(Color.LIGHT_GRAY);
		menuBar11.add(separator_511);
		menuBar11.add(mntmNewMenuItem_611);
		
		JButton btnNewButton_2_2 = new JButton("Quit");
		btnNewButton_2_2.setBounds(40, 647, 135, 41);
		teamManagementMenu.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Team Management Menu");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(463, 44, 359, 35);
		teamManagementMenu.add(lblNewLabel_1_4);
		
		JLabel search_team_label_1 = new JLabel("Search team");
		search_team_label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		search_team_label_1.setBounds(103, 157, 210, 35);
		teamManagementMenu.add(search_team_label_1);
		
		JLabel info_label_player_1_1 = new JLabel("Team name");
		info_label_player_1_1.setBounds(103, 198, 83, 30);
		teamManagementMenu.add(info_label_player_1_1);
		
		txt_search_team = new JTextField();
		txt_search_team.setColumns(10);
		txt_search_team.setBounds(178, 198, 135, 30);
		teamManagementMenu.add(txt_search_team);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(516, 198, 135, 30);
		teamManagementMenu.add(textField_4);
		
		
		JButton search_team_button_1 = new JButton("Find");
		search_team_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String team_name = txt_search_team.getText();
				Team team = teamc.findTeamByName(team_name);
				label_for_team_id.setText("" + team.getTeamID());
				textField_4.setText(team.getTeamName());
			}
		});
		search_team_button_1.setFocusPainted(false);
		search_team_button_1.setContentAreaFilled(false);
		search_team_button_1.setBounds(103, 259, 210, 23);
		teamManagementMenu.add(search_team_button_1);
		
		JLabel info_label_search_team = new JLabel("");
		info_label_search_team.setHorizontalAlignment(SwingConstants.CENTER);
		info_label_search_team.setForeground(Color.RED);
		info_label_search_team.setFont(new Font("Tahoma", Font.BOLD, 12));
		info_label_search_team.setBounds(103, 284, 210, 30);
		teamManagementMenu.add(info_label_search_team);
		
		JButton save_changes_button_player_1 = new JButton("Save changes");
		save_changes_button_player_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int teamID = Integer.parseInt(label_for_team_id.getText());
				String teamName = textField_4.getText();
				teamc.updateTeamName(teamID, teamName);
			}
		});
		save_changes_button_player_1.setFocusPainted(false);
		save_changes_button_player_1.setContentAreaFilled(false);
		save_changes_button_player_1.setBounds(441, 259, 210, 23);
		teamManagementMenu.add(save_changes_button_player_1);
		
		JLabel info_label_player_3 = new JLabel("Team name");
		info_label_player_3.setBounds(441, 198, 83, 30);
		teamManagementMenu.add(info_label_player_3);
		
		JLabel info_label_team_id_1 = new JLabel("Team ID");
		info_label_team_id_1.setBounds(441, 157, 83, 30);
		teamManagementMenu.add(info_label_team_id_1);
		
		JPanel playerCreationMenu = new JPanel();
		playerCreationMenu.setLayout(null);
		frame.getContentPane().add(playerCreationMenu, "playerCreationMenu");
		
		JMenuBar menuBar111 = new JMenuBar();
		menuBar111.setBackground(Color.LIGHT_GRAY);
		menuBar111.setBounds(0, 0, 1281, 35);
		playerCreationMenu.add(menuBar111);
		
		JMenu mnNewMenu111 = new JMenu("Team Management");
		mnNewMenu111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(mnNewMenu111);
		
		JMenuItem mntmNewMenuItem111 = new JMenuItem("Create Teams");
		mntmNewMenuItem111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu111.add(mntmNewMenuItem111);
		
		JMenuItem mntmNewMenuItem_1111 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_1111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu111.add(mntmNewMenuItem_1111);
		
		JMenu mnNewMenu_1111 = new JMenu("Player Management");
		mnNewMenu_1111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(mnNewMenu_1111);
		
		JMenuItem mntmNewMenuItem_2111 = new JMenuItem("Create Player");
		mntmNewMenuItem_2111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_1111.add(mntmNewMenuItem_2111);
		
		JMenuItem mntmNewMenuItem_3111 = new JMenuItem("Manage Players");
		mntmNewMenuItem_3111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_1111.add(mntmNewMenuItem_3111);
		
		JMenu mnNewMenu_2111 = new JMenu("Tournament");
		mnNewMenu_2111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(mnNewMenu_2111);
		
		JMenuItem mntmNewMenuItem_4111 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_4111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_2111.add(mntmNewMenuItem_4111);
		
		JMenuItem mntmNewMenuItem_5111 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_5111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_2111.add(mntmNewMenuItem_5111);
		
		JSeparator separator111 = new JSeparator();
		separator111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(separator111);
		
		JMenuItem mntmNewMenuItem_6111 = new JMenuItem("log out");
		mntmNewMenuItem_6111.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_6111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_2111 = new JSeparator();
		separator_2111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(separator_2111);
		
		JSeparator separator_3111 = new JSeparator();
		separator_3111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(separator_3111);
		
		JSeparator separator_4111 = new JSeparator();
		separator_4111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(separator_4111);
		
		JSeparator separator_5111 = new JSeparator();
		separator_5111.setBackground(Color.LIGHT_GRAY);
		menuBar111.add(separator_5111);
		menuBar111.add(mntmNewMenuItem_6111);
		
		JButton btnNewButton_2_5 = new JButton("Quit");
		btnNewButton_2_5.setBounds(40, 647, 135, 41);
		playerCreationMenu.add(btnNewButton_2_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("Player Creation Menu");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(463, 44, 359, 35);
		playerCreationMenu.add(lblNewLabel_1_3);
		
		JLabel lblPlayerGamerTag = new JLabel("Player Gamer Tag");
		lblPlayerGamerTag.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerGamerTag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerGamerTag.setBounds(68, 180, 135, 35);
		playerCreationMenu.add(lblPlayerGamerTag);
		
		gamerTagField = new JTextField();
		gamerTagField.setBounds(194, 189, 317, 20);
		playerCreationMenu.add(gamerTagField);
		gamerTagField.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Confirm Creation");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gamerTag = gamerTagField.getText();
				pc.createPlayer(gamerTag);
			}
		});
		btnNewButton_6.setBounds(521, 182, 135, 35);
		playerCreationMenu.add(btnNewButton_6);
		
		JMenuBar menuBar1111 = new JMenuBar();
		menuBar1111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.setBounds(0, 0, 1281, 35);
		playerManagementMenu.add(menuBar1111);
		
		JMenu mnNewMenu1111 = new JMenu("Team Management");
		mnNewMenu1111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(mnNewMenu1111);
		
		JMenuItem mntmNewMenuItem1111 = new JMenuItem("Create Teams");
		mntmNewMenuItem1111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu1111.add(mntmNewMenuItem1111);
		
		JMenuItem mntmNewMenuItem_11111 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_11111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu1111.add(mntmNewMenuItem_11111);
		
		JMenu mnNewMenu_11111 = new JMenu("Player Management");
		mnNewMenu_11111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(mnNewMenu_11111);
		
		JMenuItem mntmNewMenuItem_21111 = new JMenuItem("Create Player");
		mntmNewMenuItem_21111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_11111.add(mntmNewMenuItem_21111);
		
		JMenuItem mntmNewMenuItem_31111 = new JMenuItem("Manage Players");
		mntmNewMenuItem_31111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_11111.add(mntmNewMenuItem_31111);
		
		JMenu mnNewMenu_21111 = new JMenu("Tournament");
		mnNewMenu_21111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(mnNewMenu_21111);
		
		JMenuItem mntmNewMenuItem_41111 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_41111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_21111.add(mntmNewMenuItem_41111);
		
		JMenuItem mntmNewMenuItem_51111 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_51111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_21111.add(mntmNewMenuItem_51111);
		
		JSeparator separator1111 = new JSeparator();
		separator1111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(separator1111);
		
		JMenuItem mntmNewMenuItem_61111 = new JMenuItem("log out");
		mntmNewMenuItem_61111.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_61111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_21111 = new JSeparator();
		separator_21111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(separator_21111);
		
		JSeparator separator_31111 = new JSeparator();
		separator_31111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(separator_31111);
		
		JSeparator separator_41111 = new JSeparator();
		separator_41111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(separator_41111);
		
		JSeparator separator_51111 = new JSeparator();
		separator_51111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.add(separator_51111);
		menuBar1111.add(mntmNewMenuItem_61111);
		
		JButton btnNewButton_2_51 = new JButton("Quit");
		btnNewButton_2_51.setBounds(40, 647, 135, 41);
		playerManagementMenu.add(btnNewButton_2_51);
		
		txt_gamer_tag = new JTextField();
		txt_gamer_tag.setBounds(538, 214, 135, 30);
		playerManagementMenu.add(txt_gamer_tag);
		txt_gamer_tag.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Player Management Menu");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(463, 44, 359, 35);
		playerManagementMenu.add(lblNewLabel_1_2);
		
		JLabel info_label_player = new JLabel("Gamer tag");
		info_label_player.setBounds(463, 214, 83, 30);
		playerManagementMenu.add(info_label_player);
		
		JLabel info_label_player_id = new JLabel("Player ID");
		info_label_player_id.setBounds(463, 173, 83, 30);
		playerManagementMenu.add(info_label_player_id);
		
		JButton save_changes_button_player = new JButton("Save changes");
		save_changes_button_player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int playerID = Integer.parseInt(label_for_player_id.getText());
				int teamID = Integer.parseInt(txt_player_team_ID.getText());
				String gamerTag = txt_gamer_tag.getText();
				pc.updatePlayerDetails(playerID, gamerTag, teamID);
			}
		});
		save_changes_button_player.setFocusPainted(false);
		save_changes_button_player.setContentAreaFilled(false);
		save_changes_button_player.setBounds(463, 307, 210, 23);
		playerManagementMenu.add(save_changes_button_player);
		
		JLabel info_label_player_1 = new JLabel("Gamer tag");
		info_label_player_1.setBounds(125, 214, 83, 30);
		playerManagementMenu.add(info_label_player_1);
		
		textField_search_gamer = new JTextField();
		textField_search_gamer.setColumns(10);
		textField_search_gamer.setBounds(200, 214, 135, 30);
		playerManagementMenu.add(textField_search_gamer);
		
		JLabel info_label_search_player = new JLabel("");
		info_label_search_player.setHorizontalAlignment(SwingConstants.CENTER);
		info_label_search_player.setForeground(Color.RED);
		info_label_search_player.setFont(new Font("Tahoma", Font.BOLD, 12));
		info_label_search_player.setBounds(125, 300, 210, 30);
		playerManagementMenu.add(info_label_search_player);
		
		JButton search_player_button = new JButton("Find");
		search_player_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gamer_tag = textField_search_gamer.getText();
				try {
					info_label_search_player.setText("");
					Player player = pc.findPlayerByName(gamer_tag);
					label_for_player_id.setText("" + player.getPlayerID());
					txt_gamer_tag.setText(player.getGamerTag());
					txt_player_team_ID.setText(""+ player.getTeamID());
					
				}
				catch(Exception exc) {
					info_label_search_player.setText("Could not find player");
				}
			}
		});
		search_player_button.setFocusPainted(false);
		search_player_button.setContentAreaFilled(false);
		search_player_button.setBounds(125, 275, 210, 23);
		playerManagementMenu.add(search_player_button);
		
		JLabel search_player_label = new JLabel("Search player");
		search_player_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		search_player_label.setBounds(125, 173, 210, 35);
		playerManagementMenu.add(search_player_label);
		
		JLabel info_label_player_2 = new JLabel("Team ID");
		info_label_player_2.setBounds(463, 255, 83, 30);
		playerManagementMenu.add(info_label_player_2);
		
		txt_player_team_ID = new JTextField();
		txt_player_team_ID.setColumns(10);
		txt_player_team_ID.setBounds(538, 255, 135, 30);
		playerManagementMenu.add(txt_player_team_ID);
		
		JPanel tournamentCreationMenu = new JPanel();
		tournamentCreationMenu.setLayout(null);
		frame.getContentPane().add(tournamentCreationMenu, "tournamentCreationMenu");
		
		JMenuBar menuBar11111 = new JMenuBar();
		menuBar11111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.setBounds(0, 0, 1281, 35);
		tournamentCreationMenu.add(menuBar11111);
		
		JMenu mnNewMenu11111 = new JMenu("Team Management");
		mnNewMenu11111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(mnNewMenu11111);
		
		JMenuItem mntmNewMenuItem11111 = new JMenuItem("Create Teams");
		mntmNewMenuItem11111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu11111.add(mntmNewMenuItem11111);
		
		JMenuItem mntmNewMenuItem_111111 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu11111.add(mntmNewMenuItem_111111);
		
		JMenu mnNewMenu_111111 = new JMenu("Player Management");
		mnNewMenu_111111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(mnNewMenu_111111);
		
		JMenuItem mntmNewMenuItem_211111 = new JMenuItem("Create Player");
		mntmNewMenuItem_211111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_111111.add(mntmNewMenuItem_211111);
		
		JMenuItem mntmNewMenuItem_311111 = new JMenuItem("Manage Players");
		mntmNewMenuItem_311111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_111111.add(mntmNewMenuItem_311111);
		
		JMenu mnNewMenu_211111 = new JMenu("Tournament");
		mnNewMenu_211111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(mnNewMenu_211111);
		
		JMenuItem mntmNewMenuItem_411111 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_411111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_211111.add(mntmNewMenuItem_411111);
		
		JMenuItem mntmNewMenuItem_511111 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_511111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_211111.add(mntmNewMenuItem_511111);
		
		JSeparator separator11111 = new JSeparator();
		separator11111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(separator11111);
		
		JMenuItem mntmNewMenuItem_611111 = new JMenuItem("log out");
		mntmNewMenuItem_611111.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_611111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_211111 = new JSeparator();
		separator_211111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(separator_211111);
		
		JSeparator separator_311111 = new JSeparator();
		separator_311111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(separator_311111);
		
		JSeparator separator_411111 = new JSeparator();
		separator_411111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(separator_411111);
		
		JSeparator separator_511111 = new JSeparator();
		separator_511111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.add(separator_511111);
		menuBar11111.add(mntmNewMenuItem_611111);
		
		JButton btnNewButton_2_511 = new JButton("Quit");
		btnNewButton_2_511.setBounds(40, 647, 135, 41);
		tournamentCreationMenu.add(btnNewButton_2_511);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 117, 135, 35);
		tournamentCreationMenu.add(lblNewLabel);
		
		tournamentNameField = new JTextField();
		tournamentNameField.setBounds(40, 152, 135, 20);
		tournamentCreationMenu.add(tournamentNameField);
		tournamentNameField.setColumns(10);
		
		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVenue.setBounds(40, 316, 135, 35);
		tournamentCreationMenu.add(lblVenue);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(40, 362, 135, 119);
		tournamentCreationMenu.add(scrollPane_4);
		
		JList list_1 = new JList();
		scrollPane_4.setViewportView(list_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(40, 218, 135, 35);
		tournamentCreationMenu.add(lblDate);
		
		tournamentDateField = new JTextField();
		tournamentDateField.setColumns(10);
		tournamentDateField.setBounds(40, 253, 135, 20);
		tournamentCreationMenu.add(tournamentDateField);
		
		JLabel lblAvailableTeams = new JLabel("Available Teams");
		lblAvailableTeams.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableTeams.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvailableTeams.setBounds(411, 117, 135, 35);
		tournamentCreationMenu.add(lblAvailableTeams);
		
		JLabel lblAddedTeams = new JLabel("Added Teams");
		lblAddedTeams.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddedTeams.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddedTeams.setBounds(809, 117, 135, 35);
		tournamentCreationMenu.add(lblAddedTeams);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(343, 152, 268, 327);
		tournamentCreationMenu.add(scrollPane_5);
		
		JList list_2 = new JList();
		scrollPane_5.setViewportView(list_2);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(756, 150, 268, 331);
		tournamentCreationMenu.add(scrollPane_6);
		
		JList list_3 = new JList();
		scrollPane_6.setViewportView(list_3);
		
		JButton btnNewButton_5 = new JButton("Confirm Creation");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBounds(1049, 524, 222, 54);
		tournamentCreationMenu.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Tournament Creation Menu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(463, 44, 359, 35);
		tournamentCreationMenu.add(lblNewLabel_1);
		
		JPanel tournamentManagementMenu = new JPanel();
		tournamentManagementMenu.setLayout(null);
		frame.getContentPane().add(tournamentManagementMenu, "tournamentManagementMenu");
		
		JMenuBar menuBar111111 = new JMenuBar();
		menuBar111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.setBounds(0, 0, 1281, 35);
		tournamentManagementMenu.add(menuBar111111);
		
		JMenu mnNewMenu111111 = new JMenu("Team Management");
		mnNewMenu111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(mnNewMenu111111);
		
		JMenuItem mntmNewMenuItem111111 = new JMenuItem("Create Teams");
		mntmNewMenuItem111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamCreationMenu");
				teamNameField.setText("");
			}
		});
		mnNewMenu111111.add(mntmNewMenuItem111111);
		
		JMenuItem mntmNewMenuItem_1111111 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_1111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
			}
		});
		mnNewMenu111111.add(mntmNewMenuItem_1111111);
		
		JMenu mnNewMenu_1111111 = new JMenu("Player Management");
		mnNewMenu_1111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(mnNewMenu_1111111);
		
		JMenuItem mntmNewMenuItem_2111111 = new JMenuItem("Create Player");
		mntmNewMenuItem_2111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerCreationMenu");
				gamerTagField.setText("");
			}
		});
		mnNewMenu_1111111.add(mntmNewMenuItem_2111111);
		
		JMenuItem mntmNewMenuItem_3111111 = new JMenuItem("Manage Players");
		mntmNewMenuItem_3111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
			}
		});
		mnNewMenu_1111111.add(mntmNewMenuItem_3111111);
		
		JMenu mnNewMenu_2111111 = new JMenu("Tournament");
		mnNewMenu_2111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(mnNewMenu_2111111);
		
		JMenuItem mntmNewMenuItem_4111111 = new JMenuItem("Create Tournament");
		mntmNewMenuItem_4111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentCreationMenu");
			}
		});
		mnNewMenu_2111111.add(mntmNewMenuItem_4111111);
		
		JMenuItem mntmNewMenuItem_5111111 = new JMenuItem("Manage Tournaments");
		mntmNewMenuItem_5111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "tournamentManagementMenu");
			}
		});
		mnNewMenu_2111111.add(mntmNewMenuItem_5111111);
		
		JSeparator separator111111 = new JSeparator();
		separator111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(separator111111);
		
		JMenuItem mntmNewMenuItem_6111111 = new JMenuItem("log out");
		mntmNewMenuItem_6111111.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_6111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		
		JSeparator separator_2111111 = new JSeparator();
		separator_2111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(separator_2111111);
		
		JSeparator separator_3111111 = new JSeparator();
		separator_3111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(separator_3111111);
		
		JSeparator separator_4111111 = new JSeparator();
		separator_4111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(separator_4111111);
		
		JSeparator separator_5111111 = new JSeparator();
		separator_5111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.add(separator_5111111);
		menuBar111111.add(mntmNewMenuItem_6111111);
		
		JButton btnNewButton_2_6 = new JButton("Quit");
		btnNewButton_2_6.setBounds(40, 647, 135, 41);
		tournamentManagementMenu.add(btnNewButton_2_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tournament Management Menu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(463, 44, 359, 35);
		tournamentManagementMenu.add(lblNewLabel_1_1);
		
		JPanel teamSearchMenu = new JPanel();
		teamSearchMenu.setLayout(null);
		frame.getContentPane().add(teamSearchMenu, "teamSearchMenu");
		
		JMenuBar menuBar_1_1 = new JMenuBar();
		menuBar_1_1.setBackground(Color.LIGHT_GRAY);
		menuBar_1_1.setBounds(0, 0, 1281, 35);
		teamSearchMenu.add(menuBar_1_1);
		
		textField_1 = new JTextField();
		textField_1.setText("On-Going Tournaments");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(627, 93, 230, 35);
		teamSearchMenu.add(textField_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(627, 139, 230, 216);
		teamSearchMenu.add(scrollPane_1);
		
		txtSearchTeamMenu = new JTextField();
		txtSearchTeamMenu.setText("search team menu");
		txtSearchTeamMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchTeamMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSearchTeamMenu.setColumns(10);
		txtSearchTeamMenu.setBorder(null);
		txtSearchTeamMenu.setBackground(SystemColor.menu);
		txtSearchTeamMenu.setBounds(185, 93, 230, 35);
		teamSearchMenu.add(txtSearchTeamMenu);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(185, 139, 230, 216);
		teamSearchMenu.add(panel_1_1);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(40, 632, 160, 56);
		teamSearchMenu.add(btnNewButton_1);
		
		JPanel playerSearchMenu = new JPanel();
		playerSearchMenu.setLayout(null);
		frame.getContentPane().add(playerSearchMenu, "playerSearchMenu");
		
		JMenuBar menuBar_1_2 = new JMenuBar();
		menuBar_1_2.setBackground(Color.LIGHT_GRAY);
		menuBar_1_2.setBounds(0, 0, 1281, 35);
		playerSearchMenu.add(menuBar_1_2);
		
		textField_3 = new JTextField();
		textField_3.setText("On-Going Tournaments");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(SystemColor.menu);
		textField_3.setBounds(627, 93, 230, 35);
		playerSearchMenu.add(textField_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(627, 139, 230, 216);
		playerSearchMenu.add(scrollPane_2);
		
		txtSearchPlayerMenu = new JTextField();
		txtSearchPlayerMenu.setText("Search player menu");
		txtSearchPlayerMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchPlayerMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSearchPlayerMenu.setColumns(10);
		txtSearchPlayerMenu.setBorder(null);
		txtSearchPlayerMenu.setBackground(SystemColor.menu);
		txtSearchPlayerMenu.setBounds(185, 93, 230, 35);
		playerSearchMenu.add(txtSearchPlayerMenu);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(185, 139, 230, 216);
		playerSearchMenu.add(panel_1_2);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_3.setBounds(39, 632, 160, 56);
		playerSearchMenu.add(btnNewButton_3);
		
		JPanel tournamentHistoryMenu = new JPanel();
		tournamentHistoryMenu.setLayout(null);
		frame.getContentPane().add(tournamentHistoryMenu, "tournamentHistoryMenu");
		
		JMenuBar menuBar_1_3 = new JMenuBar();
		menuBar_1_3.setBackground(Color.LIGHT_GRAY);
		menuBar_1_3.setBounds(0, 0, 1281, 35);
		tournamentHistoryMenu.add(menuBar_1_3);
		
		textField_5 = new JTextField();
		textField_5.setText("On-Going Tournaments");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(SystemColor.menu);
		textField_5.setBounds(627, 93, 230, 35);
		tournamentHistoryMenu.add(textField_5);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(627, 139, 230, 216);
		tournamentHistoryMenu.add(scrollPane_3);
		
		txtTournamentHistoryMenu = new JTextField();
		txtTournamentHistoryMenu.setText("Tournament history menu");
		txtTournamentHistoryMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtTournamentHistoryMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTournamentHistoryMenu.setColumns(10);
		txtTournamentHistoryMenu.setBorder(null);
		txtTournamentHistoryMenu.setBackground(SystemColor.menu);
		txtTournamentHistoryMenu.setBounds(185, 93, 230, 35);
		tournamentHistoryMenu.add(txtTournamentHistoryMenu);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(185, 139, 230, 216);
		tournamentHistoryMenu.add(panel_1_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_4.setBounds(39, 632, 160, 56);
		tournamentHistoryMenu.add(btnNewButton_4);
		
		
	}
}
