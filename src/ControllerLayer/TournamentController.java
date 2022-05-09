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
		Tournament t = new Tournament(tournamentName, date);
		tdao.createTournament(t);
	}
	
	public Tournament findTournamentByID(int tournamentID) {
		return tdao.findTournamentByID(tournamentID);
	}
	
	public List<Tournament> getAllTournaments() {
		return tdao.getAllTournaments();
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
	
	public void updateTournament(int tournamentID, String tournamentName, String date, String venue, String status) {
		tdao.updateTournament(tournamentID, tournamentName, date, venue, status);
	}
	
	public void deleteTournament(int tournamentID) {
		tdao.deleteTournament(tournamentID);
	}
}
