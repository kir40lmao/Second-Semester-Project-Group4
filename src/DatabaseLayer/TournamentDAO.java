package DatabaseLayer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import ModelLayer.Tournament;

public class TournamentDAO implements TournamentDAOIF{
	
	DBConnection dbcon = DBConnection.getInstance();
	Connection con = dbcon.getDBcon();
	
	@Override
	public void createTournament(String tournamentName, String date) {
		try {
			String sql = "INSERT INTO Tournament ([Tournament Name], Date) VALUES (?, ?)";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, tournamentName);
			statement.setDate(2, java.sql.Date.valueOf(date));
			statement.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tournament> HigherOrderFunctionForGetMethods(Supplier<String> stringSQL) {
		List<Tournament> allTournaments = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(stringSQL.get());
            while (rs.next()){
            	Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    allTournaments.add(t);
			}
            System.out.println(allTournaments);
			return allTournaments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	public void getAllTournaments() {
	        String sql = "SELECT * FROM Tournament";
	        HigherOrderFunctionForGetMethods(() -> sql);
	}
		
	
	
	
	@Override
	public Tournament findTournamentByID(int tournamentID){
		try {
		     
			String sql = "SELECT * FROM Tournament WHERE TournamentID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
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
	
	/*@Override
	public List<Tournament> getAllTournaments(){
		List<Tournament> tList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Tournament";
			 
			Statement statement = con.createStatement();
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
	}*/
	
	@Override
	public List<Tournament> getUpcoming(String status){
		List<Tournament> tListUpcoming = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Tournament WHERE Status = ?";
			 
			PreparedStatement statement = con.prepareStatement(sql);
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
			 
			PreparedStatement statement = con.prepareStatement(sql);
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
			 
			PreparedStatement statement = con.prepareStatement(sql);
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
	public void updateTournament(String tournamentName, String date, String venue, String status, String previousTournamentName){
		try {  
			String sql = "UPDATE Tournament SET [Tournament Name]=?, Date=?, Venue=?, Status=? WHERE [Tournament Name]=?";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, tournamentName);
			statement.setDate(2, java.sql.Date.valueOf(date));
			statement.setString(3, venue);
			statement.setString(4, status);
			statement.setString(5, previousTournamentName);
			statement.executeUpdate();
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}
	
	@Override
	public void deleteTournament(int tournamentID){
		try {
		     
			String sql = "DELETE FROM Tournament WHERE TournamentID=?";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			statement.executeUpdate();
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}		
	}
}
