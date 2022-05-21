package DatabaseLayer;

import java.util.ArrayList;
import java.util.List;

import ModelLayer.Team;
import ModelLayer.Tournament;

public interface TournamentDAOIF {
	public void createTournament(Tournament tournament);
	public void createMatchUps(ArrayList<Team> teams, int tournamentID);
	public void addTournamentMatches();
	public Tournament findTournamentByName(String tournamentName);
	public List<Tournament> getAllTournaments();
	//public List<Tournament> getUpcoming(String status);
	//public List<Tournament> getOngoing(String status);
	//public List<Tournament> getFinished(String status);
	public void updateTournament(String tournamentName, String date, String Venue, String status, String previousTournamentName);
	public void deleteTournament(int tournamentID);
	public List<Tournament> getTournamentByStatus(String status);
	public int getTournamentID(String tournamentName);
}
