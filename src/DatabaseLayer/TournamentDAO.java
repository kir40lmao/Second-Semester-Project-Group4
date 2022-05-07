package DatabaseLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import ModelLayer.Tournament;


public class TournamentDAO implements TournamentDAOIF{
	
	Tournament tournament = new Tournament();
	DBConnection dbcon = DBConnection.getInstance();
	Connection conn = dbcon.getDBcon();
	
	@Override
	public void createTournament(String name, String date){
		String sql = "INSERT INTO Tournament (TournamentName, Date) VALUES (?, ?)";
		 
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1,name);
			statement.setDate(2, java.sql.Date.valueOf(date));
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Tournament findTournamentByID(int tournamentID){
		
	}
	@Override
	public Tournament getAllTournaments(){
		
	}
	@Override
	public Tournament getUpcoming(){
		
	}
	@Override
	public Tournament getOngoing() {
		
	}
	@Override
	public void updateTournament(int tournamentID, String tournamentName, Date date, String venue, boolean status){
		try {  
			String sql = "UPDATE Tournament SET TournamentID=?, TournamentName=?, Date=?, Venue=?, Status=? WHERE TournamentName=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			statement.setString(2, tournamentName);
			statement.setDate(3, date);
			statement.setString(4, venue);
			statement.setBoolean(5, status);
			statement.setString(6, tournamentName);
			statement.executeUpdate();
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}
	@Override
	public void deleteTournament(int tournamentID){
		
	}
}
