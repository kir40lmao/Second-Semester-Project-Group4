package ControllerLayer;

import DatabaseLayer.TeamDAO;
import DatabaseLayer.TeamDAOIF;

public class TeamController {
	TeamDAOIF teamDAO;
	
	public TeamController() {
		teamDAO = new TeamDAO();
	}
	
	public void createTeam() {
		teamDAO.createTeam(null);
	}
	
	public void findTeamByID() {
		teamDAO.findTeamByID(0);
	}
	
	public void getElidgeable() {
		teamDAO.getElidgeable();
	}
	
	public void updateTeamName() {
		teamDAO.updateTeamName(0, null);
	}
}
