package DatabaseLayer;

import java.util.List;

import ModelLayer.Tournament;

public interface TournamentDAOIF {
	public void createTournament(String tournamentName, String date);
	public Tournament findTournamentByID(int tournamentID);
	public void getAllTournaments();
	public List<Tournament> getUpcoming(String status);
	public List<Tournament> getOngoing(String status);
	public List<Tournament> getFinished(String status);
	public void updateTournament(String tournamentName, String date, String Venue, String status, String previousTournamentName);
	public void deleteTournament(int tournamentID);
}
