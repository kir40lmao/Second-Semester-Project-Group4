package DatabaseLayer;

import java.util.List;

import ModelLayer.Tournament;

public interface TournamentDAOIF {
	public void createTournament(Tournament t);
	public Tournament findTournamentByID(int tournamentID);
	public List<Tournament> getAllTournaments();
	public List<Tournament> getUpcoming(String status);
	public List<Tournament> getOngoing(String status);
	public List<Tournament> getFinished(String status);
	public void updateTournament(int tournamentID, String tournamentName, String date, String Venue, String status);
	public void deleteTournament(int tournamentID);
}
