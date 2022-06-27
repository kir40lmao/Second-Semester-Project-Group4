package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ControllerLayer.MatchController;
import ControllerLayer.TeamController;
import ControllerLayer.TournamentController;
import ModelLayer.Team;

import javax.swing.JLabel;
import java.awt.*;
import java.util.List;

public class BracketGeneration {
	static JFrame bracket = new JFrame();
	static MatchController mc = new MatchController();
	static TournamentController tourC = new TournamentController();
	static TeamController teamC = new TeamController();
	static Menu menu = Menu.getInstance();
	static List<String> teams;
	
	public static void main(String[] args) {
		getTeamsInTournament();
		Image icon = Toolkit.getDefaultToolkit().getImage("logo_icon.png");    
		bracket.setIconImage(icon); 
	}
	
	public static void startBracketCreation() {
		
		bracket = new JFrame("Bracket for Tournament");
		bracket.setSize(1080, 1080);
		bracket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bracket.setVisible(true);
		
		JPanel matchups = new JPanel();
		bracket.getContentPane().add(matchups);
		matchups.setLayout(null);
		
		JLabel teamSixteen = new JLabel("New label");
		teamSixteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamSixteen.setBounds(870, 566, 161, 35);
		matchups.add(teamSixteen);
		teamSixteen.setVisible(false);
		
		JLabel teamFifteen = new JLabel("New label");
		teamFifteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFifteen.setBounds(870, 509, 161, 35);
		matchups.add(teamFifteen);
		teamFifteen.setVisible(false);
		
		JLabel teamFourteen = new JLabel("New label");
		teamFourteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFourteen.setBounds(870, 463, 161, 35);
		matchups.add(teamFourteen);
		teamFourteen.setVisible(false);
		
		JLabel teamThirteen = new JLabel("New label");
		teamThirteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamThirteen.setBounds(870, 408, 161, 35);
		matchups.add(teamThirteen);
		teamThirteen.setVisible(false);
		
		JLabel teamTwelve = new JLabel("New label");
		teamTwelve.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamTwelve.setBounds(870, 351, 161, 35);
		matchups.add(teamTwelve);
		teamTwelve.setVisible(false);
		
		JLabel teamEleven = new JLabel("New label");
		teamEleven.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamEleven.setBounds(870, 297, 161, 35);
		matchups.add(teamEleven);
		teamEleven.setVisible(false);
		
		JLabel teamTen = new JLabel("New label");
		teamTen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamTen.setBounds(870, 242, 161, 35);
		matchups.add(teamTen);
		teamTen.setVisible(false);
		
		JLabel teamNine = new JLabel("New label");
		teamNine.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamNine.setBounds(870, 185, 161, 35);
		matchups.add(teamNine);
		teamNine.setVisible(false);
		
		JLabel teamEight = new JLabel("New label");
		teamEight.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamEight.setBounds(97, 566, 161, 35);
		matchups.add(teamEight);
		teamEight.setVisible(false);
		
		JLabel teamSeven = new JLabel("New label");
		teamSeven.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamSeven.setBounds(97, 509, 161, 35);
		matchups.add(teamSeven);
		teamSeven.setVisible(false);
		
		JLabel teamSix = new JLabel("New label");
		teamSix.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamSix.setBounds(97, 463, 161, 35);
		matchups.add(teamSix);
		teamSix.setVisible(false);
		
		JLabel teamFive = new JLabel("New label");
		teamFive.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFive.setBounds(97, 408, 161, 35);
		matchups.add(teamFive);
		teamFive.setVisible(false);
		
		JLabel teamFour = new JLabel("New label");
		teamFour.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFour.setBounds(97, 351, 161, 35);
		matchups.add(teamFour);
		teamFour.setVisible(false);
		
		JLabel teamThree = new JLabel("New label");
		teamThree.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamThree.setBounds(97, 297, 161, 35);
		matchups.add(teamThree);
		teamThree.setVisible(false);
		
		JLabel teamTwo = new JLabel("New label");
		teamTwo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamTwo.setBounds(97, 242, 161, 35);
		matchups.add(teamTwo);
		teamTwo.setVisible(false);
		
		JLabel teamOne = new JLabel("New label");
		teamOne.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamOne.setBounds(97, 185, 161, 35);
		matchups.add(teamOne);
		teamOne.setVisible(false);
		
		if(teams.size()==4) {
			teamOne.setVisible(true);
			teamTwo.setVisible(true);
			teamThree.setVisible(true);
			teamFour.setVisible(true);
		}
		
	}
	
	public static List<String> getTeamsInTournament(){
		String tournamentName = menu.getTournamentName();
		List<Team> teamsInTournament = teamC.getTeamsInTournament(tournamentName);
		for (int i = 0; i < teamsInTournament.size(); i++) {
			String teamName = teamsInTournament.get(i).getTeamName();
			teams.add(teamName);
			System.out.println(teamName);
			System.out.println(tournamentName);
		}
		startBracketCreation();
		return teams;
	}
}
