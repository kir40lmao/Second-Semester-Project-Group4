package DatabaseLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ModelLayer.Match;
import dataaccess.DBConnection;

public class MatchDAO implements MatchDAOIF{
	DBConnection dbcon = DBConnection.getInstance();
	Connection conn = dbcon.getDBcon();
	
	@Override
	public void createMatch(Match match) {
		String sql = "INSERT INTO Match (matchID, teamOneID, teamTwoID, teamOneScore, teamTwoScore, date) VALUES (?, ?, ?, ?, ?, ?)";
		 
		PreparedStatement statement;
		
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, match.getMatchID());
			statement.setInt(2, match.getTeamOneID());
			statement.setInt(3, match.getTeamTwoID());
			statement.setInt(4, match.getTeamOneScore());
			statement.setInt(5, match.getTeamTwoScore());
			statement.setDate(6, match.getDate());

			int rows = statement.executeUpdate();
			if (rows > 0) {
			    System.out.println("A new match was added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Match getMatchDetails(int matchID) {
		try {
			int teamOneID, teamTwoID, teamOneScore, teamTwoScore;
			Date date;
			Integer[][] playerStats;
			
			
			String sql = "SELECT * FROM Match where matchID = " + matchID;
			String sql2 = "SELECT * FROM MatchTeam where matchID = " + matchID;
			String sql3 = "SELECT * FROM MatchPlayer where matchID = " + matchID;
			
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			Statement statement2 = conn.createStatement();
			ResultSet result2 = statement.executeQuery(sql2);
			
			Statement statement3 = conn.createStatement();
			ResultSet result3 = statement.executeQuery(sql3);

			 
			while (result.next()){
			    teamOneScore = result2.getInt("Team One Score");
			    teamTwoScore = result2.getInt("Team Two Score");
			    date = result.getDate("Date");
			}
			
			while (result2.next()){
				teamOneID = result.getInt("Team One ID");
			    teamTwoID = result.getInt("Team Two ID");
			}
			
			playerStats = new Integer[10][3];
			int count = 0;
			
			while (result3.next()) {
				int playerID = result3.getInt("PlayerID");
				String sql4 = "SELECT * FROM MatchPlayerStats where match ID = " + matchID + " and playerID = " + playerID;
				Statement statement4 = conn.createStatement();
				ResultSet result4 = statement.executeQuery(sql4);
				while(result4.next()) {
					int kills = result4.getInt("Player kills");
					int deaths = result4.getInt("Player deaths");
					playerStats[count][0] = playerID;
					playerStats[count][1] = kills;
					playerStats[count][2] = deaths;
				}
				count++;
			}
			
			Match match = new Match(matchID, teamOneID, teamTwoID, teamOneScore, teamTwoScore, date, playerStats);
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateMatchDetails(int matchID) {
		
		
	}


	@Override
	public void setMatchDetails(int matchID, int playerID, int playerKills, int playerDeaths) {
		try {  
			String sql = "UPDATE MatchPlayerStats SET MatchID=?, PlayerID=?, Player Kills=?, Player Deaths=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, matchID);
			statement.setInt(2, playerID);
			statement.setInt(3, playerKills);
			statement.setInt(4, playerDeaths);

			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("Update player kd successful");
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}

}
