package ControllerLayer;

import java.util.ArrayList;

import DatabaseLayer.TournamentDAO;
import DatabaseLayer.TournamentDAOIF;
import ModelLayer.Team;
import ModelLayer.Tournament;

public class TournamentController {
	
	TournamentDAOIF tdao;
	
	public TournamentController() {
		tdao = new TournamentDAO();
	}
	
	public void createTournament(String tournamentName, String date) {
		Tournament tournament = new Tournament(tournamentName, date);
		tdao.createTournament(tournament);
	}
	
	public void createMatchUps(ArrayList<Team> teams, int tournamentID) {
		tdao.createMatchUps(teams, tournamentID);
	}
	
	public Tournament findTournamentByID(int tournamentID) {
		return tdao.findTournamentByID(tournamentID);
	}
	
	public void addTournamentMatches() {
		tdao.addTournamentMatches();
	}
	
	public void getAllTournaments() {
		tdao.getAllTournaments();
	}
	
	public void getUpcoming(String status) {
		tdao.getUpcoming(status);
	}
	
	public void getOngoing(String status) {
		tdao.getOngoing(status);
	}
	
	public void getFinished(String status) {
		tdao.getFinished(status);
	}
	
	public void updateTournament(String tournamentName, String date, String venue, String status, String previousTournamentName) {
		tdao.updateTournament(tournamentName, date, venue, status, previousTournamentName);
	}
	
	public void deleteTournament(int tournamentID) {
		tdao.deleteTournament(tournamentID);
	}
}
