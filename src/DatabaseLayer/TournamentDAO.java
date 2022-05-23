package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import ControllerLayer.MatchController;
import ModelLayer.Team;
import ModelLayer.Tournament;

public class TournamentDAO implements TournamentDAOIF{
	
	DBConnection dbcon = DBConnection.getInstance();
	Connection con = dbcon.getDBcon();
	
	String sql = "INSERT INTO Tournament ([Tournament Name], Date) VALUES (?, ?)";
	String sql2 = "INSERT INTO TournamentMatch (TournamentID, MatchID) VALUES ((SELECT TournamentID FROM Tournament WHERE TournamentID = ?), (SELECT MatchID FROM Matches WHERE MatchID = ?))";
	String sql3 = "INSERT INTO TournamentTeam (TournamentID, TeamID) VALUES ((SELECT TournamentID FROM Tournament WHERE TournamentID = ?), (SELECT TeamID FROM Teams WHERE TeamID = ?))";
	
	String sql_getMatchID = "SELECT MatchID FROM Matches WHERE MatchID = ?";
	String sql_getTeamID = "SELECT TeamID FROM Teams WHERE TeamID = ?";
	String sql_getTournamentID = "SELECT TournamentID FROM Tournament WHERE TournamentID = ?";
	
	PreparedStatement statement;
	int SQLtournamentID;
	MatchController mc = new MatchController();
	
	@Override
	public void createTournament(Tournament tournament) {
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, tournament.getTournamentName());
			statement.setDate(2, java.sql.Date.valueOf(tournament.getDate()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void createMatchUps(ArrayList<Team> teams, int tournamentID) {
		try {
			statement = con.prepareStatement(sql_getTournamentID);
			statement.setInt(1, tournamentID);
			ResultSet result1 = statement.executeQuery();
			result1.next();
			SQLtournamentID = result1.getInt(1);
			
			for(int i = 0; i < teams.size(); i++) {
				Team team = teams.get(i);
				
				statement = con.prepareStatement(sql_getTeamID);
				statement.setInt(1, team.getTeamID());
				ResultSet result3 = statement.executeQuery();
				result3.next();
				int teamID = result3.getInt(1);
				
				statement = con.prepareStatement(sql3);
				statement.setInt(1, SQLtournamentID);
				statement.setInt(2, teamID);
				statement.executeUpdate();
				
			}
			
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	     Calendar cal = Calendar.getInstance();
	     Date date = cal.getTime();
	     String todaysdate = dateFormat.format(date);
		
		for(int i = 0; i < teams.size() / 2; i += 2) {
			Team team1, team2;
			team1 = teams.get(i);
			team2 = teams.get(i+1);
			mc.createMatch(team1.getTeamID(), team2.getTeamID(), todaysdate);
			addTournamentMatches();	
		}
		
		for(int i = 0; i < teams.size()/2 - 1; i++) {
			mc.createMatch(0, 0, null);
			addTournamentMatches();
		}
	}
	@Override
	public void addTournamentMatches() {
		try {
			String sql_getMaxMatchID = "SELECT Max(MatchID) FROM Matches";
	
	        statement = con.prepareStatement(sql_getMaxMatchID);
	        ResultSet rs = statement.executeQuery();
	        rs.next();
	        int maxMatchID = rs.getInt(1);
			
			statement = con.prepareStatement(sql_getMatchID);
			statement.setInt(1, maxMatchID);
			ResultSet result2 = statement.executeQuery();
			result2.next();
			int matchID = result2.getInt(1);
			
			statement = con.prepareStatement(sql2);
			statement.setInt(1, SQLtournamentID);
			statement.setInt(2, matchID);
			statement.executeUpdate();
		
		}catch (SQLException e) {
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
			return allTournaments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public List<Tournament> getAllTournaments() {
		String sql = "SELECT * FROM Tournament";
		List<Tournament> allTournaments =HigherOrderFunctionForGetMethods(() -> sql);
		return allTournaments;
	}
	
	public List<Tournament> getTournamentByStatus(String status){
		String sql = "SELECT * FROM Tournament WHERE Status = '"+status+"'";
		List<Tournament> tournaments = HigherOrderFunctionForGetMethods(() -> sql);
		return tournaments;
	}
		
	@Override
	public Tournament findTournamentByName(String tournamentName){
		String sql = "SELECT * FROM Tournament WHERE [Tournament Name] = ?";
		try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, tournamentName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
            	Tournament t = new Tournament();
				t.setTournamentID(rs.getInt(1));
				t.setTournamentName(rs.getString(2));			    
				t.setDate(rs.getDate(3).toString());
			    t.setVenue(rs.getString(4));
			    t.setStatus(rs.getString(5));
			    return t;
			}
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public int getTournamentID(String tournamentName) {
		String sql = "Select * From Tournament Where [Tournament Name] = ?";
		PreparedStatement statement;
		int id = 0;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, tournamentName);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
			id = result.getInt("TournamentID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
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
