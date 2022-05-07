package ControllerLayer;

import java.sql.Date;
import java.util.List;

import DatabaseLayer.TournamentDAO;
import DatabaseLayer.TournamentDAOIF;


public class TournamentController {
	TournamentDAOIF tdao;
	public TournamentController() {
		tdao = new TournamentDAO();
	}
	public void createTournament(String tournamentName, String date) {
		tdao.createTournament(tournamentName, date);
	}
	findTournamentByID();
	getAllTournaments();
	getUpcoming();
	getOngoing();*/
	public void updateTournament(int tournamentID, String tournamentName, String date, String venue, boolean status) {
		tdao.updateTournament(tournamentID, tournamentName, date, venue, status);
	}
	//deleteTournament();
}
