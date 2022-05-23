package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class BracketGeneration {

	public static void main(String[] args) {
		startBracketCreation();
	}
	
	public static void startBracketCreation() {
		JFrame bracket = new JFrame();
		
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
		
		JLabel teamFifteen = new JLabel("New label");
		teamFifteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFifteen.setBounds(870, 509, 161, 35);
		matchups.add(teamFifteen);
		
		JLabel teamFourteen = new JLabel("New label");
		teamFourteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFourteen.setBounds(870, 463, 161, 35);
		matchups.add(teamFourteen);
		
		JLabel teamThirteen = new JLabel("New label");
		teamThirteen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamThirteen.setBounds(870, 408, 161, 35);
		matchups.add(teamThirteen);
		
		JLabel teamTwelve = new JLabel("New label");
		teamTwelve.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamTwelve.setBounds(870, 351, 161, 35);
		matchups.add(teamTwelve);
		
		JLabel teamEleven = new JLabel("New label");
		teamEleven.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamEleven.setBounds(870, 297, 161, 35);
		matchups.add(teamEleven);
		
		JLabel teamTen = new JLabel("New label");
		teamTen.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamTen.setBounds(870, 242, 161, 35);
		matchups.add(teamTen);
		
		JLabel teamNine = new JLabel("New label");
		teamNine.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamNine.setBounds(870, 185, 161, 35);
		matchups.add(teamNine);
		
		JLabel teamEight = new JLabel("New label");
		teamEight.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamEight.setBounds(97, 566, 161, 35);
		matchups.add(teamEight);
		
		JLabel teamSeven = new JLabel("New label");
		teamSeven.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamSeven.setBounds(97, 509, 161, 35);
		matchups.add(teamSeven);
		
		JLabel teamSix = new JLabel("New label");
		teamSix.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamSix.setBounds(97, 463, 161, 35);
		matchups.add(teamSix);
		
		JLabel teamFive = new JLabel("New label");
		teamFive.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFive.setBounds(97, 408, 161, 35);
		matchups.add(teamFive);
		
		JLabel teamFour = new JLabel("New label");
		teamFour.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamFour.setBounds(97, 351, 161, 35);
		matchups.add(teamFour);
		
		JLabel teamThree = new JLabel("New label");
		teamThree.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamThree.setBounds(97, 297, 161, 35);
		matchups.add(teamThree);
		
		JLabel teamTwo = new JLabel("New label");
		teamTwo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamTwo.setBounds(97, 242, 161, 35);
		matchups.add(teamTwo);
		
		JLabel teamOne = new JLabel("New label");
		teamOne.setFont(new Font("Tahoma", Font.PLAIN, 26));
		teamOne.setBounds(97, 185, 161, 35);
		matchups.add(teamOne);
		
		
	}
}
