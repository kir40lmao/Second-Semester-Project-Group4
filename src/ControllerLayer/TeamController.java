package ControllerLayer;

import java.util.ArrayList;
import java.util.List;

import DatabaseLayer.TeamDAO;
import DatabaseLayer.TeamDAOIF;
import ModelLayer.Player;
import ModelLayer.Team;

public class TeamController {
	TeamDAOIF teamDAO;

	public TeamController() {
		teamDAO = new TeamDAO();
	}

	public void createTeam(String teamName) {
		teamDAO.createTeam(teamName);
	}

	public Team findTeamByID(int id) {
		Team team = teamDAO.findTeamByID(id);
		return team;
	}

	public List<Team> getEligible() {
		List<Team> eligibleTeams = teamDAO.getEligible();
		return eligibleTeams;
	}

	public void updateTeamName(int id, String teamName) {
		teamDAO.updateTeamName(id, teamName);
	}

	public void updateTeamStats(int id, int wins, int loses) {
		teamDAO.updateTeamStats(id, wins, loses);
	}

	public List<Team> getAllTeams() {
		return teamDAO.getAllTeams();
	}
	
	public ArrayList<Player> PopulateArray(int teamID){
		return teamDAO.PopulateArray(teamID);
	}

	public Team findTeamByName(String teamName) {
		Team team = teamDAO.findTeamByName(teamName);
		return team;
	}
	
	public List<Team> getTeamsInTournament(String tournamentName){
		List<Team> teamsInTournament = teamDAO.getTeamsInTournament(tournamentName);
		return teamsInTournament;
	}
	
	public void addTeamsToTournament(int tournamentID, int teamID) {
		teamDAO.addTeamsToTournament(tournamentID, teamID);
	}
	
	public void removeTeamFromTournament(int tournamentID, int teamID) {
		teamDAO.removeTeamFromTournament(tournamentID, teamID);
	}
}
