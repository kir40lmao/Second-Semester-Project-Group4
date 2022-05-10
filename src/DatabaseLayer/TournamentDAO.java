package DatabaseLayer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelLayer.Tournament;

public class TournamentDAO implements TournamentDAOIF{
	
	DBConnection dbcon = DBConnection.getInstance();
	Connection conn = dbcon.getDBcon();
	
	@Override
	//where should we create the object? because when reading, we create the object in the DAO because we have to. should we create the object in the createTournament in the DAO too so its more unified?
	public void createTournament(int tournamentID, String tournamentName, String date) {
		try {
			String sql = "INSERT INTO Tournament (TournamentID,[Tournament Name], Date) VALUES (?, ?, ?)";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			statement.setString(2, tournamentName);
			statement.setDate(3, java.sql.Date.valueOf(date));
			statement.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Tournament findTournamentByID(int tournamentID){
		try {
		     
			String sql = "SELECT * FROM Tournament WHERE TournamentID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			ResultSet rs = statement.executeQuery(); 
			if (rs.next()) {
				Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    return t;
			}
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Tournament> getAllTournaments(){
		List<Tournament> tList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Tournament";
			 
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			 
			while (rs.next()){
			    Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    tList.add(t);
			}
			return tList;
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Tournament> getUpcoming(String status){
		List<Tournament> tListUpcoming = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Tournament WHERE Status = ?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, status);
			ResultSet rs = statement.executeQuery(sql);
			 
			while (rs.next()){
			    Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    tListUpcoming.add(t);
			}
			return tListUpcoming;
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tournament> getOngoing(String status) {
		List<Tournament> tListOngoing = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Tournament WHERE Status = ?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, status);
			ResultSet rs = statement.executeQuery(sql);
			 
			while (rs.next()){
			    Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    tListOngoing.add(t);
			}
			return tListOngoing;
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Tournament> getFinished(String status) {
		List<Tournament> tListFinished = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Tournament WHERE Status = ?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, status);
			ResultSet rs = statement.executeQuery(sql);
			 
			while (rs.next()){
			    Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    tListFinished.add(t);
			}
			return tListFinished;
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateTournament(int tournamentID, String tournamentName, String date, String venue, String status, String previousTournamentName){
		try {  
			String sql = "UPDATE Tournament SET TournamentID=?, [Tournament Name]=?, Date=?, Venue=?, Status=? WHERE [Tournament Name]=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			statement.setString(2, tournamentName);
			statement.setDate(3, java.sql.Date.valueOf(date));
			statement.setString(4, venue);
			statement.setString(5, status);
			statement.setString(6, previousTournamentName);
			statement.executeUpdate();
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}
	
	@Override
	public void deleteTournament(int tournamentID){
		try {
		     
			String sql = "DELETE FROM Tournament WHERE TournamentID=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			statement.executeUpdate();
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}		
	}
}
