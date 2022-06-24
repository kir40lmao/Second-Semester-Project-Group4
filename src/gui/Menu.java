package gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import ControllerLayer.MatchController;
import ControllerLayer.PlayerController;
import ControllerLayer.TeamController;
import ControllerLayer.TournamentController;
import ControllerLayer.VenueController;
import ModelLayer.Player;
import ModelLayer.Team;
import ModelLayer.Tournament;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class Menu {

	private static CardLayout cl_base;
	public static JFrame frame;
	private JTextField txt_gamer_tag;
	private JTextField tournamentNameField;
	private JTextField tournamentDateField;
	private JTextField teamNameField;
	private JTextField gamerTagField;
	List<String> addedTeams = new ArrayList<String>();
	DefaultListModel managementMenuAddedTeams = new DefaultListModel();
	List<Team> teamList = new ArrayList<>();
	Login login_window;
	private JTextField textField_search_gamer;

	PlayerController pc = new PlayerController();
	MatchController mc = new MatchController();
	TeamController teamc = new TeamController();
	TournamentController tournamentc = new TournamentController();
	private JTextField txt_player_team_ID;
	private JTextField txt_search_team;
	private JTextField textField_4;
	private JTextField textTeamNameInput;
	JFrame popup = new JFrame("Tournament Details");
	private JTextField tournamentSearchBar;
	private JTextField nameBar;
	private JTextField dateBar;
	private JTextField venueField;
	private JTextField statusField;
	private static int width;
	private static int height;
	private static Menu single_Instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					int framewidth = frame.getWidth();
					int frameheight = frame.getHeight();
					setWidth(framewidth);
					setHeight(frameheight);
					frame.setVisible(false);
					Menu window = getInstance();
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
		Image icon = Toolkit.getDefaultToolkit().getImage("logo_icon.png");
		frame.setIconImage(icon);

	}

	public void newLogin() {
		// setVisible(false);
		login_window = new Login();
		login_window.show_new();

	}

	public static void logInCard() {
		cl_base.show(frame.getContentPane(), "managerMenu");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl_base = new CardLayout(0, 0);
		frame.getContentPane().setLayout(cl_base);

		JPanel userMenu = new JPanel();
		frame.getContentPane().add(userMenu, "userMenu");
		userMenu.setLayout(null);

		if (Login.logged_in) {
			cl_base.show(frame.getContentPane(), "managerMenu");
		} else {
			cl_base.show(frame.getContentPane(), "userMenu");
		}
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(Color.LIGHT_GRAY);
		menuBar_1.setBounds(0, 0, getWidth(), 35);
		userMenu.add(menuBar_1);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Check Forum");
		mntmNewMenuItem_10.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_10.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessBuilder builder = new ProcessBuilder("run.bat");
				try {
					Process process = builder.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
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
			String[] values = new String[] { "David P", "Kiril", "David B", "Kornel", "Akos" };

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
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		btnNewButton.setBounds(40, 632, 160, 56);
		userMenu.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("News");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(313, 168, 249, 28);
		userMenu.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("On-Going Tournaments");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(747, 177, 249, 28);
		userMenu.add(lblNewLabel_2_1);

		JLabel userMenuBG = new JLabel();
		userMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		userMenuBG.setBounds(0, 34, getWidth(), getHeight());
		userMenu.add(userMenuBG);

		JPanel managerMenu = new JPanel();
		frame.getContentPane().add(managerMenu, "managerMenu");
		managerMenu.setLayout(null);
		// frame.getContentPane().add(frame.getContentPane(), "managerMenu");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, getWidth(), 35);
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
		label_for_team_id.setForeground(Color.WHITE);
		label_for_team_id.setBounds(516, 157, 135, 30);
		teamManagementMenu.add(label_for_team_id);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.GREEN);
		lblNewLabel_5.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(441, 284, 210, 30);
		teamManagementMenu.add(lblNewLabel_5);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manage Teams");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText("");
				label_for_team_id.setText("");
				txt_search_team.setText("");
				lblNewLabel_5.setText("");
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
		label_for_player_id.setForeground(Color.WHITE);
		label_for_player_id.setBounds(538, 173, 135, 30);
		playerManagementMenu.add(label_for_player_id);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.GREEN);
		lblNewLabel_4.setBounds(463, 341, 210, 23);
		playerManagementMenu.add(lblNewLabel_4);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Manage Players");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				textField_search_gamer.setText("");
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
				lblNewLabel_4.setText("");
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
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(49, 634, 135, 41);

		managerMenu.add(btnNewButton_2);

		JLabel lblNewLabel_3 = new JLabel("Welcome!");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		lblNewLabel_3.setBounds(419, 86, 343, 52);
		managerMenu.add(lblNewLabel_3);

		JLabel manMenuBG = new JLabel();
		manMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		manMenuBG.setBounds(0, 34, getWidth(), getHeight());
		managerMenu.add(manMenuBG);

		JPanel teamCreationMenu = new JPanel();
		teamCreationMenu.setLayout(null);
		frame.getContentPane().add(teamCreationMenu, "teamCreationMenu");

		JMenuBar menuBar1 = new JMenuBar();
		menuBar1.setBackground(Color.LIGHT_GRAY);
		menuBar1.setBounds(0, 0, getWidth(), 35);
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
				lblNewLabel_5.setText("");
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
				lblNewLabel_4.setText("");
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

		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
			}
		});
		btnNewButton_2_1.setBounds(40, 647, 135, 41);
		teamCreationMenu.add(btnNewButton_2_1);

		JLabel lblNewLabel_1_5 = new JLabel("Team Creation Menu");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		lblNewLabel_1_5.setBounds(463, 44, 359, 35);
		teamCreationMenu.add(lblNewLabel_1_5);

		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setForeground(Color.WHITE);
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamName.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
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
				cl_base.show(frame.getContentPane(), "teamManagementMenu");
				textField_4.setText(teamName);
				label_for_team_id.setText("" + teamc.findTeamByName(teamName).getTeamID());
			}
		});
		btnNewButton_2_1_1.setBounds(365, 171, 151, 41);
		teamCreationMenu.add(btnNewButton_2_1_1);

		JLabel teamCreationMenuBG = new JLabel("");
		teamCreationMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		teamCreationMenuBG.setBounds(0, 34, getWidth(), getHeight());
		teamCreationMenu.add(teamCreationMenuBG);

		JMenuBar menuBar11 = new JMenuBar();
		menuBar11.setBackground(Color.LIGHT_GRAY);
		menuBar11.setBounds(0, 0, getWidth(), 35);
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
				lblNewLabel_5.setText("");
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
				lblNewLabel_4.setText("");
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

		JButton btnBackFromTeamManagement = new JButton("Back");
		btnBackFromTeamManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
			}
		});
		btnBackFromTeamManagement.setBounds(40, 647, 135, 41);
		teamManagementMenu.add(btnBackFromTeamManagement);

		JLabel lblNewLabel_1_4 = new JLabel("Team Management Menu");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(463, 44, 359, 35);
		teamManagementMenu.add(lblNewLabel_1_4);

		JLabel search_team_label_1 = new JLabel("Search team");
		search_team_label_1.setForeground(Color.WHITE);
		search_team_label_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		search_team_label_1.setBounds(103, 157, 210, 35);
		teamManagementMenu.add(search_team_label_1);

		JLabel info_label_player_1_1 = new JLabel("Team name");
		info_label_player_1_1.setForeground(Color.WHITE);
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
		search_team_button_1.setForeground(Color.WHITE);
		search_team_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String team_name = txt_search_team.getText();
				Team team = teamc.findTeamByName(team_name);
				label_for_team_id.setText("" + team.getTeamID());
				textField_4.setText(team.getTeamName());
				lblNewLabel_5.setText("");
			}
		});
		search_team_button_1.setFocusPainted(false);
		search_team_button_1.setContentAreaFilled(false);
		search_team_button_1.setBounds(103, 259, 210, 23);
		teamManagementMenu.add(search_team_button_1);

		JLabel info_label_search_team = new JLabel("");
		info_label_search_team.setHorizontalAlignment(SwingConstants.CENTER);
		info_label_search_team.setForeground(Color.RED);
		info_label_search_team.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		info_label_search_team.setBounds(103, 284, 210, 30);
		teamManagementMenu.add(info_label_search_team);

		JButton save_changes_button_player_1 = new JButton("Save changes");
		save_changes_button_player_1.setForeground(Color.WHITE);
		save_changes_button_player_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int teamID = Integer.parseInt(label_for_team_id.getText());
				String teamName = textField_4.getText();
				teamc.updateTeamName(teamID, teamName);
				label_for_team_id.setText("");
				textField_4.setText("");
				lblNewLabel_5.setText("Successfully changed");
			}
		});
		save_changes_button_player_1.setFocusPainted(false);
		save_changes_button_player_1.setContentAreaFilled(false);
		save_changes_button_player_1.setBounds(441, 259, 210, 23);
		teamManagementMenu.add(save_changes_button_player_1);

		JLabel info_label_player_3 = new JLabel("Team name");
		info_label_player_3.setForeground(Color.WHITE);
		info_label_player_3.setBounds(441, 198, 83, 30);
		teamManagementMenu.add(info_label_player_3);

		JLabel info_label_team_id_1 = new JLabel("Team ID");
		info_label_team_id_1.setForeground(Color.WHITE);
		info_label_team_id_1.setBounds(441, 157, 83, 30);
		teamManagementMenu.add(info_label_team_id_1);

		JLabel teamManagementMenuBG = new JLabel("");
		teamManagementMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		teamManagementMenuBG.setBounds(0, 34, getWidth(), getHeight());
		teamManagementMenu.add(teamManagementMenuBG);

		JPanel playerCreationMenu = new JPanel();
		playerCreationMenu.setForeground(Color.WHITE);
		playerCreationMenu.setLayout(null);
		frame.getContentPane().add(playerCreationMenu, "playerCreationMenu");

		JMenuBar menuBar111 = new JMenuBar();
		menuBar111.setBackground(Color.LIGHT_GRAY);
		menuBar111.setBounds(0, 0, getWidth(), 35);
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
				lblNewLabel_5.setText("");
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
				lblNewLabel_4.setText("");
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

		JButton btnNewButton_2_5 = new JButton("Back");
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
			}
		});
		btnNewButton_2_5.setBounds(40, 647, 135, 41);
		playerCreationMenu.add(btnNewButton_2_5);

		JLabel lblNewLabel_1_3 = new JLabel("Player Creation Menu");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(463, 44, 359, 35);
		playerCreationMenu.add(lblNewLabel_1_3);

		JLabel lblPlayerGamerTag = new JLabel("Player Gamer Tag");
		lblPlayerGamerTag.setForeground(Color.WHITE);
		lblPlayerGamerTag.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerGamerTag.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
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
				cl_base.show(frame.getContentPane(), "playerManagementMenu");
				txt_gamer_tag.setText(gamerTag);
				txt_player_team_ID.setText("" + pc.findPlayerByName(gamerTag).getTeamID());
				label_for_player_id.setText("" + pc.findPlayerByName(gamerTag).getPlayerID());
			}
		});
		btnNewButton_6.setBounds(521, 182, 135, 35);
		playerCreationMenu.add(btnNewButton_6);

		JLabel playerCreationMenuBG = new JLabel("");
		playerCreationMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		playerCreationMenuBG.setBounds(0, 34, getWidth(), getHeight());
		playerCreationMenu.add(playerCreationMenuBG);

		JMenuBar menuBar1111 = new JMenuBar();
		menuBar1111.setBackground(Color.LIGHT_GRAY);
		menuBar1111.setBounds(0, 0, getWidth(), 35);
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
				lblNewLabel_5.setText("");
				lblNewLabel_5.setText("");
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
				lblNewLabel_4.setText("");
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

		JButton btnNewButton_2_51 = new JButton("Back");
		btnNewButton_2_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
			}
		});
		btnNewButton_2_51.setBounds(40, 647, 135, 41);
		playerManagementMenu.add(btnNewButton_2_51);

		txt_gamer_tag = new JTextField();
		txt_gamer_tag.setBounds(538, 214, 135, 30);
		playerManagementMenu.add(txt_gamer_tag);
		txt_gamer_tag.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Player Management Menu");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(463, 44, 359, 35);
		playerManagementMenu.add(lblNewLabel_1_2);

		JLabel info_label_player = new JLabel("Gamer tag");
		info_label_player.setForeground(Color.WHITE);
		info_label_player.setBounds(463, 214, 83, 30);
		playerManagementMenu.add(info_label_player);

		JLabel info_label_player_id = new JLabel("Player ID");
		info_label_player_id.setForeground(Color.WHITE);
		info_label_player_id.setBounds(463, 173, 83, 30);
		playerManagementMenu.add(info_label_player_id);

		JButton save_changes_button_player = new JButton("Save changes");
		save_changes_button_player.setForeground(Color.BLACK);
		save_changes_button_player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int playerID = Integer.parseInt(label_for_player_id.getText());
				int teamID = Integer.parseInt(txt_player_team_ID.getText());
				String gamerTag = txt_gamer_tag.getText();
				pc.updatePlayerDetails(playerID, gamerTag, teamID);
				txt_gamer_tag.setText("");
				txt_player_team_ID.setText("");
				label_for_player_id.setText("");
				lblNewLabel_4.setText("Successfully changed");
			}
		});
		save_changes_button_player.setFocusPainted(false);
		save_changes_button_player.setContentAreaFilled(false);
		save_changes_button_player.setBounds(463, 307, 210, 23);
		playerManagementMenu.add(save_changes_button_player);

		JLabel info_label_player_1 = new JLabel("Gamer tag");
		info_label_player_1.setForeground(Color.WHITE);
		info_label_player_1.setBounds(125, 214, 83, 30);
		playerManagementMenu.add(info_label_player_1);

		textField_search_gamer = new JTextField();
		textField_search_gamer.setColumns(10);
		textField_search_gamer.setBounds(200, 214, 135, 30);
		playerManagementMenu.add(textField_search_gamer);

		JLabel info_label_search_player = new JLabel("");
		info_label_search_player.setHorizontalAlignment(SwingConstants.CENTER);
		info_label_search_player.setForeground(Color.RED);
		info_label_search_player.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		info_label_search_player.setBounds(125, 300, 210, 30);
		playerManagementMenu.add(info_label_search_player);

		JButton search_player_button = new JButton("Find");
		search_player_button.setForeground(Color.BLACK);
		search_player_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gamer_tag = textField_search_gamer.getText();
				try {
					info_label_search_player.setText("");
					Player player = pc.findPlayerByName(gamer_tag);
					label_for_player_id.setText("" + player.getPlayerID());
					txt_gamer_tag.setText(player.getGamerTag());
					txt_player_team_ID.setText("" + player.getTeamID());
					lblNewLabel_4.setText("");

				} catch (Exception exc) {
					info_label_search_player.setText("Could not find player");
				}
			}
		});
		search_player_button.setFocusPainted(false);
		search_player_button.setContentAreaFilled(false);
		search_player_button.setBounds(125, 275, 210, 23);
		playerManagementMenu.add(search_player_button);

		JLabel search_player_label = new JLabel("Search player");
		search_player_label.setForeground(Color.WHITE);
		search_player_label.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		search_player_label.setBounds(125, 173, 210, 35);
		playerManagementMenu.add(search_player_label);

		JLabel info_label_player_2 = new JLabel("Team ID");
		info_label_player_2.setForeground(Color.WHITE);
		info_label_player_2.setBounds(463, 255, 83, 30);
		playerManagementMenu.add(info_label_player_2);

		txt_player_team_ID = new JTextField();
		txt_player_team_ID.setColumns(10);
		txt_player_team_ID.setBounds(538, 255, 135, 30);
		playerManagementMenu.add(txt_player_team_ID);

		JLabel playerManagementMenuBG = new JLabel("");
		playerManagementMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		playerManagementMenuBG.setBounds(0, 34, getWidth(), getHeight());
		playerManagementMenu.add(playerManagementMenuBG);

		JPanel tournamentCreationMenu = new JPanel();
		tournamentCreationMenu.setLayout(null);
		frame.getContentPane().add(tournamentCreationMenu, "tournamentCreationMenu");

		JMenuBar menuBar11111 = new JMenuBar();
		menuBar11111.setBackground(Color.LIGHT_GRAY);
		menuBar11111.setBounds(0, 0, getWidth(), 35);
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
				lblNewLabel_5.setText("");
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
				lblNewLabel_4.setText("");
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

		JButton btnNewButton_2_511 = new JButton("Back");
		btnNewButton_2_511.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
			}
		});
		btnNewButton_2_511.setBounds(40, 679, 135, 41);
		tournamentCreationMenu.add(btnNewButton_2_511);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 117, 135, 35);
		tournamentCreationMenu.add(lblNewLabel);

		tournamentNameField = new JTextField();
		getTournamentNameField().setBounds(40, 152, 135, 20);
		tournamentCreationMenu.add(getTournamentNameField());
		getTournamentNameField().setColumns(10);

		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setForeground(Color.WHITE);
		lblVenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenue.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblVenue.setBounds(40, 316, 135, 35);
		tournamentCreationMenu.add(lblVenue);

		JScrollPane venueScroll = new JScrollPane();
		venueScroll.setBounds(40, 362, 135, 119);
		tournamentCreationMenu.add(venueScroll);
		venueScroll.setVisible(false);
		lblVenue.setVisible(false);

		DefaultListModel DLM_Venue = new DefaultListModel();
		JList venueList = new JList(DLM_Venue);
		venueScroll.setViewportView(venueList);
		VenueController venueController = new VenueController();
		String[] venues = venueController.getAvailableVenues();
		for (int i = 0; i < venues.length; i++) {
			DLM_Venue.add(i, venues[i]);
		}

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDate.setBounds(40, 218, 135, 35);
		tournamentCreationMenu.add(lblDate);

		tournamentDateField = new JTextField();
		tournamentDateField.setColumns(10);
		tournamentDateField.setBounds(40, 253, 135, 20);
		tournamentCreationMenu.add(tournamentDateField);

		JLabel lblAvailableTeams = new JLabel("Available Teams");
		lblAvailableTeams.setForeground(Color.WHITE);
		lblAvailableTeams.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableTeams.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblAvailableTeams.setBounds(411, 117, 135, 35);
		tournamentCreationMenu.add(lblAvailableTeams);
		lblAvailableTeams.setVisible(false);

		JLabel lblAddedTeams = new JLabel("Added Teams");
		lblAddedTeams.setForeground(Color.WHITE);
		lblAddedTeams.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddedTeams.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblAddedTeams.setBounds(809, 117, 135, 35);
		tournamentCreationMenu.add(lblAddedTeams);
		lblAddedTeams.setVisible(false);

		JScrollPane availableTeamsSctroll = new JScrollPane();
		availableTeamsSctroll.setBounds(343, 152, 268, 327);
		tournamentCreationMenu.add(availableTeamsSctroll);
		availableTeamsSctroll.setVisible(false);

		DefaultListModel DLM_AT = new DefaultListModel();
		JList availiableTeams = new JList(DLM_AT);
		availableTeamsSctroll.setViewportView(availiableTeams);
		List<Team> availiableTeamsList = teamc.getEligible();

		for (int i = 0; i < availiableTeamsList.size(); i++) {
			DLM_AT.add(i, availiableTeamsList.get(i).getTeamName());
		}

		JScrollPane addedTeamsScroll = new JScrollPane();
		addedTeamsScroll.setBounds(756, 150, 268, 331);
		tournamentCreationMenu.add(addedTeamsScroll);
		addedTeamsScroll.setVisible(false);
		DefaultListModel DLM_AddedTeams = new DefaultListModel();
		JList addedTeamsList = new JList(DLM_AddedTeams);
		addedTeamsScroll.setViewportView(addedTeamsList);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 11));
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setVisible(false);
		lblStatus.setBounds(85, 499, 46, 14);
		tournamentCreationMenu.add(lblStatus);

		JScrollPane statusScroll = new JScrollPane();
		statusScroll.setBounds(40, 524, 135, 119);
		tournamentCreationMenu.add(statusScroll);
		statusScroll.setVisible(false);

		DefaultListModel DLM_Status = new DefaultListModel();
		JList statusList = new JList(DLM_Status);
		statusScroll.setViewportView(statusList);
		String[] status = new String[] { "Ongoing", "Finished", "Scheduled" };
		for (int i = 0; i < status.length; i++) {
			DLM_Status.add(i, status[i]);
		}

		JButton generateBracket = new JButton("Generate Bracket");
		generateBracket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tournamentName = getTournamentNameField().getText();
				int tournamentID = tournamentc.getTournamentID(tournamentName);
				for (int i = 0; i < addedTeams.size(); i++) {
					String teamName = addedTeams.get(i);
					Team team = teamc.findTeamByName(teamName);
					teamList.add(team);
				}
				tournamentc.createMatchUps((ArrayList<Team>) teamList, tournamentID);
				BracketGeneration.startBracketCreation();
			}
		});
		generateBracket.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		generateBracket.setBounds(1049, 589, 222, 54);
		tournamentCreationMenu.add(generateBracket);
		generateBracket.setVisible(false);

		JButton btnAddTeamsToTournament = new JButton("Add Selected Teams to Tournament");
		btnAddTeamsToTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tournamentName = getTournamentNameField().getText();
				int tournamentID = tournamentc.getTournamentID(tournamentName);
				String teamName = (String) availiableTeams.getSelectedValue();
				Team team = teamc.findTeamByName(teamName);
				int id = team.getTeamID();
				int i = 0;
				if (addedTeams.contains(teamName) == false && addedTeams.size() < 16) {
					teamc.addTeamsToTournament(tournamentID, id);
					DLM_AddedTeams.add(i, teamName);
					addedTeams.add(teamName);
					i++;
					int index = DLM_AT.indexOf(teamName);
					DLM_AT.remove(index);
				}
				if (addedTeams.size() == 4 || addedTeams.size() == 8 || addedTeams.size() == 16) {
					generateBracket.setVisible(true);
				}
			}
		});
		btnAddTeamsToTournament.setBounds(343, 490, 268, 35);
		tournamentCreationMenu.add(btnAddTeamsToTournament);
		btnAddTeamsToTournament.setVisible(false);

		JButton btnRemoveTeamFromTournament = new JButton("Remove Selected Team From Tournament");
		btnRemoveTeamFromTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tournamentName = getTournamentNameField().getText();
				int tournamentID = tournamentc.getTournamentID(tournamentName);
				String teamName = (String) addedTeamsList.getSelectedValue();
				Team team = teamc.findTeamByName(teamName);
				int teamID = team.getTeamID();
				teamc.removeTeamFromTournament(tournamentID, teamID);
				int index = DLM_AddedTeams.indexOf(teamName);
				DLM_AddedTeams.remove(index);
				int indexAT = availiableTeams.getLastVisibleIndex();
				DLM_AT.add(indexAT + 1, teamName);
				addedTeams.remove(teamName);
				if (!(addedTeams.size() == 4 || addedTeams.size() == 8 || addedTeams.size() == 16)) {
					generateBracket.setVisible(false);
				}
			}
		});
		btnRemoveTeamFromTournament.setBounds(756, 492, 268, 35);
		tournamentCreationMenu.add(btnRemoveTeamFromTournament);
		btnRemoveTeamFromTournament.setVisible(false);

		JLabel confirmationTextTournamentCreation = new JLabel("");
		confirmationTextTournamentCreation.setForeground(Color.GREEN);
		confirmationTextTournamentCreation.setBounds(1049, 733, 222, 14);
		tournamentCreationMenu.add(confirmationTextTournamentCreation);

		JButton confirmTournamentCreation = new JButton("Confirm Creation");
		confirmTournamentCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tournamentName = getTournamentNameField().getText();
				String Date = tournamentDateField.getText();
				tournamentc.createTournament(tournamentName, Date);
				confirmationTextTournamentCreation.setText("Tournament Created Successfully!");
				confirmTournamentCreation.setVisible(false);
				addedTeamsScroll.setVisible(true);
				lblAddedTeams.setVisible(true);
				availableTeamsSctroll.setVisible(true);
				lblAvailableTeams.setVisible(true);
				venueScroll.setVisible(true);
				lblVenue.setVisible(true);
				statusScroll.setVisible(true);
				lblStatus.setVisible(true);
				btnRemoveTeamFromTournament.setVisible(true);
				btnAddTeamsToTournament.setVisible(true);

			}
		});
		confirmTournamentCreation.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		confirmTournamentCreation.setBounds(1049, 670, 222, 54);
		tournamentCreationMenu.add(confirmTournamentCreation);

		JButton confirmTournamentVenue = new JButton("Confirm Creation");
		confirmTournamentVenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String venue = (String) venueList.getSelectedValue();
				String tournamentName = getTournamentNameField().getText();
				String Date = tournamentDateField.getText();
				String status = (String) statusList.getSelectedValue();
				tournamentc.updateTournament(tournamentName, Date, venue, status, tournamentName);
				confirmationTextTournamentCreation.setText("Tournament Venue Added Successfully!");
			}
		});

		confirmTournamentVenue.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		confirmTournamentVenue.setBounds(1049, 670, 222, 54);
		tournamentCreationMenu.add(confirmTournamentVenue);

		JLabel lblNewLabel_1 = new JLabel("Tournament Creation Menu");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(463, 44, 359, 35);
		tournamentCreationMenu.add(lblNewLabel_1);

		JLabel tournamentCreationMenuBG = new JLabel("");
		tournamentCreationMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		tournamentCreationMenuBG.setBounds(0, 34, getWidth(), getHeight());
		tournamentCreationMenu.add(tournamentCreationMenuBG);

		JPanel tournamentManagementMenu = new JPanel();
		tournamentManagementMenu.setLayout(null);
		frame.getContentPane().add(tournamentManagementMenu, "tournamentManagementMenu");

		JMenuBar menuBar111111 = new JMenuBar();
		menuBar111111.setBackground(Color.LIGHT_GRAY);
		menuBar111111.setBounds(0, 0, getWidth(), 35);
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
				lblNewLabel_5.setText("");
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
				lblNewLabel_4.setText("");
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
				nameBar.setText("");
				dateBar.setText("");
				tournamentSearchBar.setText("");
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

		JButton btnNewButton_2_6 = new JButton("Back");
		btnNewButton_2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "managerMenu");
			}
		});
		btnNewButton_2_6.setBounds(40, 647, 135, 41);
		tournamentManagementMenu.add(btnNewButton_2_6);

		JLabel lblNewLabel_1_1 = new JLabel("Tournament Management Menu");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(463, 44, 359, 35);
		tournamentManagementMenu.add(lblNewLabel_1_1);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(687, 157, 316, 386);
		tournamentManagementMenu.add(scrollPane_9);

		JList addedTeamList = new JList(managementMenuAddedTeams);
		scrollPane_9.setViewportView(addedTeamList);

		JScrollPane scrollPane_9_1 = new JScrollPane();
		scrollPane_9_1.setBounds(264, 157, 316, 386);
		tournamentManagementMenu.add(scrollPane_9_1);

		DefaultListModel avTeams = new DefaultListModel();
		JList availableTeamList = new JList(avTeams);
		scrollPane_9_1.setViewportView(availableTeamList);
		/*
		 * for(int i = 0;i < availiableTeamsList.size(); i++) { avTeams.add(i,
		 * availiableTeamsList.get(i).getTeamName()); }
		 */

		JLabel lblNewLabel_41 = new JLabel("Available teams");
		lblNewLabel_41.setForeground(Color.WHITE);
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_41.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_41.setBounds(327, 112, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_41);

		JLabel lblNewLabel_4_1 = new JLabel("Added teams");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(748, 112, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Name");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_4_2.setBounds(20, 146, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_2_1 = new JLabel("Date");
		lblNewLabel_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_4_2_1.setBounds(20, 212, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_4_2_1);

		JLabel lblNewLabel_4_2_1_1 = new JLabel("Venue");
		lblNewLabel_4_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_4_2_1_1.setBounds(20, 279, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_4_2_1_1);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 313, 206, 121);
		tournamentManagementMenu.add(scrollPane_8);

		DefaultListModel venueListM = new DefaultListModel();
		JList venueList1 = new JList(venueListM);
		scrollPane_8.setViewportView(venueList1);
		for (int i = 0; i < venues.length; i++) {
			venueListM.add(i, venues[i]);
		}
		scrollPane_8.setVisible(false);
		venueList1.setVisible(false);

		JLabel lblNewLabel_4_2_2 = new JLabel("Tournament search bar");
		lblNewLabel_4_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_4_2_2.setBounds(1048, 159, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_4_2_2);

		JButton btnModifyTournamentDetails = new JButton("Modify tournament details");

		JLabel storeName = new JLabel("");
		storeName.setBounds(1088, 410, 105, 26);
		tournamentManagementMenu.add(storeName);
		storeName.setVisible(false);

		JLabel updateLabel = new JLabel("");
		updateLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		updateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateLabel.setForeground(Color.GREEN);
		updateLabel.setBounds(1048, 497, 202, 46);
		tournamentManagementMenu.add(updateLabel);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread t1 = new Thread(new Runnable() {
					@Override
					public void run() {

						try {
							Thread.sleep(2500);

							String tournamentSearch = tournamentSearchBar.getText();
							storeName.setText(tournamentSearchBar.getText());

							Tournament tournament = tournamentc.findTournamentByName(tournamentSearch);

							nameBar.setText(tournament.getTournamentName());
							dateBar.setText(tournament.getDate());
							venueField.setText(tournament.getVenue());
							statusField.setText(tournament.getStatus());
							venueList1.setVisible(false);
							scrollPane_8.setVisible(false);
							btnModifyTournamentDetails.setVisible(true);
							updateLabel.setText("");

							List<Team> teamsInTournament = teamc.getTeamsInTournament(tournamentSearch);
							for (int i = 0; i < teamsInTournament.size(); i++) {
								managementMenuAddedTeams.add(i, teamsInTournament.get(i).getTeamName());
							}

							for (int i = 0; i < availiableTeamsList.size(); i++) {
								avTeams.add(i, availiableTeamsList.get(i).getTeamName());
							}

							for (int i = 0; i < teamsInTournament.size(); i++) {
								avTeams.removeElement(teamsInTournament.get(i).getTeamName());
							}
							tournamentSearchBar.setText("");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				t1.start();
			}
		});
		searchButton.setBounds(1159, 221, 89, 23);
		tournamentManagementMenu.add(searchButton);

		JButton addTeamButton = new JButton("Add team");
		addTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tournamentName = nameBar.getText();
				int tournamentID = tournamentc.getTournamentID(tournamentName);
				String teamName = (String) availableTeamList.getSelectedValue();
				Team team = teamc.findTeamByName(teamName);
				int id = team.getTeamID();
				int i = 0;
				if (managementMenuAddedTeams.contains(teamName) == false && managementMenuAddedTeams.size() < 16) {
					teamc.addTeamsToTournament(tournamentID, id);
					managementMenuAddedTeams.add(i, teamName);
					// managementMenuAddedTeams.add(teamName);
					i++;
					int index = avTeams.indexOf(teamName);
					avTeams.remove(index);
				}
			}
		});
		addTeamButton.setBounds(264, 554, 316, 35);
		tournamentManagementMenu.add(addTeamButton);

		JButton removeTeamButton = new JButton("Remove team");
		removeTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tournamentName = nameBar.getText();
				int tournamentID = tournamentc.getTournamentID(tournamentName);
				String teamName = (String) addedTeamList.getSelectedValue();
				Team team = teamc.findTeamByName(teamName);
				int teamID = team.getTeamID();
				teamc.removeTeamFromTournament(tournamentID, teamID);
				int index = managementMenuAddedTeams.indexOf(teamName);
				managementMenuAddedTeams.remove(index);
				int indexAT = availableTeamList.getLastVisibleIndex();
				avTeams.add(indexAT + 1, teamName);
				managementMenuAddedTeams.removeElement(teamName);
			}
		});
		removeTeamButton.setBounds(687, 554, 316, 35);
		tournamentManagementMenu.add(removeTeamButton);

		JScrollPane scrollPane_8_1 = new JScrollPane();
		scrollPane_8_1.setBounds(10, 467, 206, 121);
		tournamentManagementMenu.add(scrollPane_8_1);

		DefaultListModel statusListM = new DefaultListModel();
		JList statusList1 = new JList(statusListM);
		scrollPane_8_1.setViewportView(statusList1);
		for (int i = 0; i < status.length; i++) {
			statusListM.add(i, status[i]);
		}
		scrollPane_8_1.setVisible(false);

		JButton confirmButton = new JButton("Confirm update");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String updatedName = (String) nameBar.getText();
				String updatedDate = (String) dateBar.getText();
				String updatedVenue = (String) venueList1.getSelectedValue();
				String updatedStatus = (String) statusList1.getSelectedValue();
				String previousName = storeName.getText();

				tournamentc.updateTournament(updatedName, updatedDate, updatedVenue, updatedStatus, previousName);

				btnModifyTournamentDetails.setVisible(true);
				confirmButton.setVisible(false);
				updateLabel.setText("Details modified");
				venueField.setVisible(true);
				scrollPane_8.setVisible(false);
				venueList1.setVisible(false);
				scrollPane_8_1.setVisible(false);
				statusField.setVisible(true);

				managementMenuAddedTeams.removeAllElements();

				avTeams.removeAllElements();
				for (int i = 0; i < availiableTeamsList.size(); i++) {
					avTeams.add(i, availiableTeamsList.get(i).getTeamName());
				}

				venueField.setText("");
				statusField.setText("");
				nameBar.setText("");
				dateBar.setText("");
				avTeams.clear();
			}
		});
		confirmButton.setBounds(1046, 618, 202, 35);
		tournamentManagementMenu.add(confirmButton);
		confirmButton.setVisible(false);

		tournamentSearchBar = new JTextField();
		tournamentSearchBar.setColumns(10);
		tournamentSearchBar.setBounds(1042, 194, 206, 26);
		tournamentManagementMenu.add(tournamentSearchBar);

		nameBar = new JTextField();
		nameBar.setColumns(10);
		nameBar.setBounds(10, 176, 206, 26);
		tournamentManagementMenu.add(nameBar);

		dateBar = new JTextField();
		dateBar.setColumns(10);
		dateBar.setBounds(10, 242, 206, 26);
		tournamentManagementMenu.add(dateBar);

		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("Status");
		lblNewLabel_4_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel_4_2_1_1_1.setBounds(20, 433, 188, 34);
		tournamentManagementMenu.add(lblNewLabel_4_2_1_1_1);

		venueField = new JTextField();
		venueField.setColumns(10);
		venueField.setBounds(10, 324, 206, 26);
		tournamentManagementMenu.add(venueField);

		statusField = new JTextField();
		statusField.setColumns(10);
		statusField.setBounds(10, 463, 206, 26);
		tournamentManagementMenu.add(statusField);

		btnModifyTournamentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venueList1.setSelectedValue(venueField.getText(), true);
				statusList1.setSelectedValue(statusField.getText(), true);

				confirmButton.setVisible(true);
				btnModifyTournamentDetails.setVisible(false);
				updateLabel.setText("");
				venueField.setVisible(false);
				scrollPane_8.setVisible(true);
				venueList1.setVisible(true);
				scrollPane_8_1.setVisible(true);
				statusField.setVisible(false);
			}
		});
		btnModifyTournamentDetails.setBounds(1046, 554, 202, 35);
		tournamentManagementMenu.add(btnModifyTournamentDetails);

		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon("BackGround Custom.png"));
		BackGround.setBounds(0, 34, getWidth(), getHeight());
		tournamentManagementMenu.add(BackGround);
		btnModifyTournamentDetails.setVisible(false);

		//
		JPanel teamSearchMenu = new JPanel();
		teamSearchMenu.setLayout(null);
		frame.getContentPane().add(teamSearchMenu, "teamSearchMenu");

		JMenuBar menuBar_1_1 = new JMenuBar();
		menuBar_1_1.setBackground(Color.LIGHT_GRAY);
		menuBar_1_1.setBounds(0, 0, 1281, 35);
		teamSearchMenu.add(menuBar_1_1);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		btnNewButton_1.setBounds(39, 632, 160, 56);
		teamSearchMenu.add(btnNewButton_1);

		textTeamNameInput = new JTextField();
		textTeamNameInput.setBounds(295, 208, 196, 20);
		teamSearchMenu.add(textTeamNameInput);
		textTeamNameInput.setColumns(10);

		JLabel lblFeedbackMessage = new JLabel("New label");
		lblFeedbackMessage.setForeground(Color.RED);
		lblFeedbackMessage.setBounds(311, 254, 141, 14);
		teamSearchMenu.add(lblFeedbackMessage);
		lblFeedbackMessage.setVisible(false);

		JLabel lblWinsLosses = new JLabel();
		lblWinsLosses.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		lblWinsLosses.setForeground(Color.WHITE);
		lblWinsLosses.setBounds(351, 342, 152, 50);
		teamSearchMenu.add(lblWinsLosses);
		lblWinsLosses.setVisible(false);

		JLabel lblTeamStats = new JLabel("Team Stats:");
		lblTeamStats.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		lblTeamStats.setForeground(Color.WHITE);
		lblTeamStats.setBounds(351, 317, 152, 14);
		teamSearchMenu.add(lblTeamStats);
		lblTeamStats.setVisible(false);

		JScrollPane scrollPanePlayers = new JScrollPane();
		scrollPanePlayers.setBounds(756, 227, 240, 322);
		teamSearchMenu.add(scrollPanePlayers);

		JList listOfPlayers = new JList();
		scrollPanePlayers.setViewportView(listOfPlayers);

		JButton btnSearchPlayerStats = new JButton("Search player stats");
		btnSearchPlayerStats.setVisible(false);
		btnSearchPlayerStats.setBounds(756, 559, 240, 21);
		teamSearchMenu.add(btnSearchPlayerStats);

		scrollPanePlayers.setVisible(false);
		listOfPlayers.setVisible(false);

		JButton btnTeamSearch = new JButton("Search");
		btnTeamSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				String[] players = new String[500];

				for (Team t : teamc.getAllTeams()) {
					int index = 0;
					if (textTeamNameInput.getText().equals(t.getTeamName())) {
						for (Player p : teamc.PopulateArray(t.getTeamID())) {
							players[index] = p.getGamerTag();
							index++;
						}
						lblFeedbackMessage.setVisible(false);
						success = true;
						scrollPanePlayers.setVisible(true);
						listOfPlayers.setVisible(true);
						lblTeamStats.setVisible(true);
						lblWinsLosses.setVisible(true);
						btnSearchPlayerStats.setVisible(true);
						lblWinsLosses.setText("Wins: " + t.getWins() + "  Losses: " + t.getLoses());
					}
				}
				listOfPlayers.setModel(new AbstractListModel() {
					public int getSize() {
						return players.length;
					}

					public Object getElementAt(int index) {
						return players[index];
					}

				});
				if (!success) {
					lblFeedbackMessage.setText("Invalid Team Name");
					scrollPanePlayers.setVisible(false);
					listOfPlayers.setVisible(false);
					lblFeedbackMessage.setVisible(true);
					lblWinsLosses.setVisible(false);
					lblTeamStats.setVisible(false);
					btnSearchPlayerStats.setVisible(false);
				}

			}
		});

		btnTeamSearch.setBounds(520, 207, 89, 23);
		teamSearchMenu.add(btnTeamSearch);

		JLabel lblNewLabel_7 = new JLabel("Team Name:");
		lblNewLabel_7.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(196, 211, 89, 14);
		teamSearchMenu.add(lblNewLabel_7);

		JLabel teamSearchMenuBG = new JLabel("");
		teamSearchMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		teamSearchMenuBG.setBounds(0, 34, getWidth(), getHeight());
		teamSearchMenu.add(teamSearchMenuBG);

		JPanel playerSearchMenu = new JPanel();
		playerSearchMenu.setLayout(null);
		frame.getContentPane().add(playerSearchMenu, "playerSearchMenu");

		JMenuBar menuBar_1_2 = new JMenuBar();
		menuBar_1_2.setBackground(Color.LIGHT_GRAY);
		menuBar_1_2.setBounds(0, 0, 1281, 35);
		playerSearchMenu.add(menuBar_1_2);

		JTextField textPlayerNameInput = new JTextField();
		textPlayerNameInput.setBounds(295, 208, 196, 20);
		playerSearchMenu.add(textPlayerNameInput);
		textPlayerNameInput.setColumns(10);

		JLabel lblFeedbackMessage2 = new JLabel("");
		lblFeedbackMessage2.setForeground(Color.RED);
		lblFeedbackMessage2.setBounds(311, 254, 141, 14);
		playerSearchMenu.add(lblFeedbackMessage2);
		lblFeedbackMessage2.setVisible(false);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		btnNewButton_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		btnNewButton_3.setBounds(39, 632, 160, 56);
		playerSearchMenu.add(btnNewButton_3);

		JLabel lblKillsDeaths = new JLabel("");
		lblKillsDeaths.setBounds(351, 342, 284, 50);
		playerSearchMenu.add(lblKillsDeaths);
		lblKillsDeaths.setVisible(false);

		JLabel lblStat = new JLabel("Player Stats:");
		lblStat.setForeground(Color.WHITE);
		lblStat.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		lblStat.setBounds(256, 296, 107, 35);
		playerSearchMenu.add(lblStat);
		lblStat.setVisible(false);

		JLabel lblPlayerTeam = new JLabel();
		lblPlayerTeam.setBounds(774, 198, 208, 50);
		playerSearchMenu.add(lblPlayerTeam);
		lblPlayerTeam.setVisible(false);

		JButton btnShowTeamStats = new JButton("Show team stats");
		btnShowTeamStats.setBounds(809, 276, 127, 21);
		playerSearchMenu.add(btnShowTeamStats);
		btnShowTeamStats.setVisible(false);

		JButton btnPlayerSearch = new JButton("Search");
		btnPlayerSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				Player p = pc.findPlayerByName(textPlayerNameInput.getText());
				int teamID = 0;

				for (Player player : pc.getAllPlayers()) {

					if (player.getGamerTag().equals(p.getGamerTag())) {
						success = true;
						teamID = player.getTeamID();
					}
				}
				if (success) {

					lblFeedbackMessage.setVisible(false);
					lblStat.setVisible(true);
					lblKillsDeaths.setVisible(true);
					lblKillsDeaths.setText("Kills: " + p.getTotalKills() + "  Deaths: " + p.getTotalDeaths());
					lblPlayerTeam.setVisible(true);
					lblPlayerTeam.setText(teamc.findTeamByID(teamID).getTeamName());
					btnShowTeamStats.setVisible(true);

				} else {
					lblFeedbackMessage2.setText("Invalid Player Name");
					lblFeedbackMessage.setVisible(true);
					lblKillsDeaths.setVisible(false);
					lblStat.setVisible(false);
					lblPlayerTeam.setVisible(false);
					btnShowTeamStats.setVisible(false);

				}

			}
		});

		btnPlayerSearch.setBounds(520, 207, 89, 23);
		playerSearchMenu.add(btnPlayerSearch);

		JLabel lblNewLabel_8 = new JLabel("Player Tag:");
		lblNewLabel_8.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 12));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(198, 210, 95, 17);
		playerSearchMenu.add(lblNewLabel_8);

		JLabel playerSearchMenuBG = new JLabel("");
		playerSearchMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		playerSearchMenuBG.setBounds(0, 34, getWidth(), getHeight());
		playerSearchMenu.add(playerSearchMenuBG);

		JPanel tournamentHistoryMenu = new JPanel();
		tournamentHistoryMenu.setLayout(null);
		frame.getContentPane().add(tournamentHistoryMenu, "tournamentHistoryMenu");

		JMenuBar menuBar_1_3 = new JMenuBar();
		menuBar_1_3.setBackground(Color.LIGHT_GRAY);
		menuBar_1_3.setBounds(0, 0, 1281, 35);
		tournamentHistoryMenu.add(menuBar_1_3);

		JScrollPane ongoingTournamentsScroll = new JScrollPane();
		ongoingTournamentsScroll.setBounds(515, 138, 230, 216);
		tournamentHistoryMenu.add(ongoingTournamentsScroll);

		DefaultListModel DLM = new DefaultListModel();
		JList onGoingTournaments = new JList(DLM);
		ongoingTournamentsScroll.setViewportView(onGoingTournaments);
		List<Tournament> ongoingTournamentsList = tournamentc.getTournamentByStatus("Ongoing");
		for (int i = 0; i < ongoingTournamentsList.size(); i++) {
			DLM.add(i, ongoingTournamentsList.get(i).getTournamentName());
		}

		JScrollPane finishedTournamentsScroll = new JScrollPane();
		finishedTournamentsScroll.setBounds(948, 138, 230, 216);
		tournamentHistoryMenu.add(finishedTournamentsScroll);

		DefaultListModel DLM_finished = new DefaultListModel();
		JList finishedTournaments = new JList(DLM_finished);
		finishedTournamentsScroll.setViewportView(finishedTournaments);
		List<Tournament> finishedTournamentsList = tournamentc.getTournamentByStatus("Finished");
		for (int i = 0; i < finishedTournamentsList.size(); i++) {
			DLM_finished.add(i, finishedTournamentsList.get(i).getTournamentName());
		}

		JScrollPane scheduledTournamentsScroll = new JScrollPane();
		scheduledTournamentsScroll.setBounds(80, 138, 230, 216);
		tournamentHistoryMenu.add(scheduledTournamentsScroll);

		DefaultListModel DLM_scheduled = new DefaultListModel();
		JList scheduledTournaments = new JList(DLM_scheduled);
		scheduledTournamentsScroll.setViewportView(scheduledTournaments);
		List<Tournament> scheduledTournamentsList = tournamentc.getTournamentByStatus("Scheduled");
		for (int i = 0; i < scheduledTournamentsList.size(); i++) {
			DLM_scheduled.add(i, scheduledTournamentsList.get(i).getTournamentName());
		}

		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "userMenu");
			}
		});
		btnNewButton_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		btnNewButton_4.setBounds(39, 632, 160, 56);
		tournamentHistoryMenu.add(btnNewButton_4);

		btnSearchPlayerStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) listOfPlayers.getSelectedValue();
				cl_base.show(frame.getContentPane(), "playerSearchMenu");
				textPlayerNameInput.setText(selected);
				btnPlayerSearch.doClick();
			}
		});

		popup.setSize(720, 480);
		popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel tournamentDetails = new JPanel();

		JScrollPane teamsInTournamentScroll = new JScrollPane();
		teamsInTournamentScroll.setSize(440, 560);
		tournamentDetails.add(teamsInTournamentScroll);

		DefaultListModel DLM_teamsInTournament = new DefaultListModel();
		JList teamsInTournamentList = new JList(DLM_teamsInTournament);
		teamsInTournamentScroll.setViewportView(teamsInTournamentList);

		JButton btnGoToTournamentDetails = new JButton("Go to Tournament Details");
		btnGoToTournamentDetails.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 17));
		btnGoToTournamentDetails.setBounds(947, 458, 231, 45);
		btnGoToTournamentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popup.setVisible(true);
				popup.getContentPane().add(tournamentDetails);
				List<Team> teamsList = new ArrayList<>();
				// teamsList.clear();
				DLM_teamsInTournament.clear();
				if (!(finishedTournaments.getSelectedValue() == null)
						&& (scheduledTournaments.getSelectedValue() == null)
						&& (onGoingTournaments.getSelectedValue() == null)) {
					String tournamentName = (String) finishedTournaments.getSelectedValue();
					teamsList = teamc.getTeamsInTournament(tournamentName);
				} else if (!(scheduledTournaments.getSelectedValue() == null)
						&& (finishedTournaments.getSelectedValue() == null)
						&& (onGoingTournaments.getSelectedValue() == null)) {
					String tournamentName = (String) scheduledTournaments.getSelectedValue();
					teamsList = teamc.getTeamsInTournament(tournamentName);
				} else if (!(onGoingTournaments.getSelectedValue() == null)
						&& (scheduledTournaments.getSelectedValue() == null)
						&& (finishedTournaments.getSelectedValue() == null)) {
					String tournamentName = (String) onGoingTournaments.getSelectedValue();
					teamsList = teamc.getTeamsInTournament(tournamentName);
				} else {
					// add a JLabel as an error message if they have selected more than one
					// tournament or no tournament
				}
				for (int i = 0; i < teamsList.size(); i++) {
					DLM_teamsInTournament.add(i, teamsList.get(i).getTeamName());
				}
				onGoingTournaments.clearSelection();
				scheduledTournaments.clearSelection();
				finishedTournaments.clearSelection();
			}

		});
		tournamentHistoryMenu.add(btnGoToTournamentDetails);

		JLabel lblNewLabel_9 = new JLabel("Scheduled Tournaments");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(80, 92, 230, 35);
		tournamentHistoryMenu.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("Ongoing Tournaments");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(515, 92, 230, 35);
		tournamentHistoryMenu.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("Finished Tournaments");
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2.setForeground(Color.WHITE);
		lblNewLabel_9_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
		lblNewLabel_9_2.setBounds(948, 92, 230, 35);
		tournamentHistoryMenu.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("Tournament History Menu");
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3.setForeground(Color.WHITE);
		lblNewLabel_9_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
		lblNewLabel_9_3.setBounds(515, 46, 230, 35);
		tournamentHistoryMenu.add(lblNewLabel_9_3);

		JLabel tournamentHistoryMenuBG = new JLabel("");
		tournamentHistoryMenuBG.setIcon(new ImageIcon("BackGround Custom.png"));
		tournamentHistoryMenuBG.setBounds(0, 34, getWidth(), getHeight());
		tournamentHistoryMenu.add(tournamentHistoryMenuBG);

		btnShowTeamStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_base.show(frame.getContentPane(), "teamSearchMenu");
				textTeamNameInput.setText(lblPlayerTeam.getText());
				btnTeamSearch.doClick();
			}
		});
	}

	public static void setWidth(int framewidth) {
		width = framewidth;
	}

	public int getWidth() {
		return width;
	}
	
	public static void setHeight(int frameheight) {
		height = frameheight;
	}

	public int getHeight() {
		return height;
	}

	public JTextField getTournamentNameField() {
		return tournamentNameField;
	}
    public static Menu getInstance(){
        if (single_Instance == null)
            single_Instance = new Menu();
 
        return single_Instance;
    }
}
