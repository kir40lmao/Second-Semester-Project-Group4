package ControllerLayer;

import DatabaseLayer.TeamDAO;
import DatabaseLayer.TeamDAOIF;

public class TeamController {
	TeamDAOIF teamDAO;
	
	public TeamController() {
		teamDAO = new TeamDAO();
	}
	
	public void createTeam(String teamName) {
		teamDAO.createTeam(teamName);
	}
	
	public void findTeamByID(int id) {
		teamDAO.findTeamByID(id);
	}
	
	public void getEligible() {
		teamDAO.getEligible();
	}
	
	public void updateTeamName(int id, String teamName) {
		teamDAO.updateTeamName(id, teamName);
	}
	
	public void updateTeamStats(int id, int wins, int loses) {
		teamDAO.updateTeamStats(id,wins,loses);
	}
	
	public void getAllTeams() {
		teamDAO.getAllTeams();
	}
}
