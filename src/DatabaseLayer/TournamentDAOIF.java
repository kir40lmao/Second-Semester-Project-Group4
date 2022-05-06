package DatabaseLayer;

import java.sql.Date;

import ModelLayer.Tournament;

public interface TournamentDAOIF {
	public void createTournament(String name, Date date);
	public Tournament findTournamentByID(int tournamentID);
	public Tournament getAllTournaments();
	public Tournament getUpcoming();
	public Tournament getOngoing();
	public void updateTournament(int tournamentID);
	public void deleteTournament(int tournamentID);
}
