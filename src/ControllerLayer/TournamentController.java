package ControllerLayer;

import java.util.List;

import DatabaseLayer.TournamentDAO;
import DatabaseLayer.TournamentDAOIF;
import ModelLayer.Tournament;

public class TournamentController {
	
	TournamentDAOIF tdao;
	
	public TournamentController() {
		tdao = new TournamentDAO();
	}
	
	public void createTournament(String tournamentName, String date) {
		tdao.createTournament(tournamentName, date);
	}
	
	public Tournament findTournamentByID(int tournamentID) {
		return tdao.findTournamentByID(tournamentID);
	}
	
	public void getAllTournaments() {
		 tdao.getAllTournaments();
	}
	
	public List<Tournament> getUpcoming(String status) {
		return tdao.getUpcoming(status);
	}
	
	public List<Tournament> getOngoing(String status) {
		return tdao.getOngoing(status);
	}
	
	public List<Tournament> getFinished(String status) {
		return tdao.getFinished(status);
	}
	
	public void updateTournament(String tournamentName, String date, String venue, String status, String previousTournamentName) {
		tdao.updateTournament(tournamentName, date, venue, status, previousTournamentName);
	}
	
	public void deleteTournament(int tournamentID) {
		tdao.deleteTournament(tournamentID);
	}
}
