package DatabaseLayer;

import java.util.ArrayList;

import ModelLayer.Team;
import ModelLayer.Tournament;

public interface TournamentDAOIF {
	public void createTournament(Tournament tournament);
	public void createMatchUps(ArrayList<Team> teams, int tournamentID);
	public void addTournamentMatches();
	public Tournament findTournamentByID(int tournamentID);
	public void getAllTournaments();
	public void getUpcoming(String status);
	public void getOngoing(String status);
	public void getFinished(String status);
	public void updateTournament(String tournamentName, String date, String Venue, String status, String previousTournamentName);
	public void deleteTournament(int tournamentID);
}
