package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelLayer.Match;


public class MatchDAO implements MatchDAOIF{
	DBConnection dbcon = DBConnection.getInstance();
	Connection conn = dbcon.getDBcon();
	
	@Override
	public void createMatch(Match match) {
		String sql = "INSERT INTO Matches ([Team One Score], [Team Two Score], DATE) VALUES (?, ?, ?)";
		String sql2 = "INSERT INTO MatchTeam (MatchID, TeamOneID, TeamTwoID) VALUES ((SELECT MatchID FROM Matches WHERE MatchID = ?), (SELECT TeamID FROM Teams WHERE TeamID = ?), (SELECT TeamID FROM Teams WHERE TeamID = ?))";
		String sql3 = "INSERT INTO MatchPlayerStats (MatchID, PlayerID, [Player Kills], [Player Deaths]) VALUES (?, ?, ?, ?)";
		
		String sql_getPlayers = "SELECT * FROM PlayerTeam where TeamID = ? or TeamID = ?";
		String sql_getMatchID = "SELECT Max(MatchID) FROM Matches";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setInt(1, match.getTeamOneScore());
			statement.setInt(2, match.getTeamTwoScore());
			statement.setDate(3, java.sql.Date.valueOf(match.getDate()));
			statement.executeUpdate();
			
			
			statement = conn.prepareStatement(sql_getMatchID);
			ResultSet rs = statement.executeQuery();
			rs.next();
			int matchID = rs.getInt(1);
			
			statement = conn.prepareStatement(sql2);
			statement.setInt(1, matchID);
			statement.setInt(2, match.getTeamOneID());
			statement.setInt(3, match.getTeamTwoID());
			statement.executeUpdate();
			
			PreparedStatement statement_players = conn.prepareStatement(sql_getPlayers);
			statement_players.setInt(1, match.getTeamOneID());
			statement_players.setInt(2, match.getTeamTwoID());
			
			ResultSet resultSetPlayers = statement_players.executeQuery();
	
			conn.commit();
			while (resultSetPlayers.next()) {
				int playerID = resultSetPlayers.getInt("PlayerID");
				System.out.println(playerID);
				statement = conn.prepareStatement(sql3);
				statement.setInt(1, matchID);
				statement.setInt(2, playerID);
				statement.setInt(3, 0);
				statement.setInt(4, 0);
				statement.executeUpdate();
			}
			
		}
		 catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Match getMatchDetails(int matchID) {
		Match match = null;
		try {
			int teamOneID = 0, teamTwoID = 0, teamOneScore = 0, teamTwoScore = 0;
			String date = null;
			Integer[][] playerStats = new Integer[10][3];;
			
			
			String sql = "SELECT * FROM Matches where MatchID = " + matchID;
			String sql2 = "SELECT * FROM MatchTeam where MatchID = " + matchID;
			
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			Statement statement2 = conn.createStatement();
			ResultSet result2 = statement2.executeQuery(sql2);

			 
			while (result.next()){
			    teamOneScore = result.getInt("Team One Score");
			    teamTwoScore = result.getInt("Team Two Score");
			    date = result.getDate("Date").toString();
			}
			int count = 0;
			while (result2.next()){
				if (count == 0) {
					teamOneID = result2.getInt("TeamID");
					count++;
				}
				if (count == 1)
					teamTwoID = result2.getInt("TeamID");
			}
			
			count = 0;
			
			String sql3 = "SELECT * FROM MatchPlayerStats where MatchID = " + matchID;
			Statement statement3 = conn.createStatement();
			ResultSet result3 = statement3.executeQuery(sql3);
			
			while (result3.next()) {
				int playerID = result3.getInt("PlayerID");
				int kills = result3.getInt("Player kills");
				int deaths = result3.getInt("Player deaths");
				playerStats[count][0] = playerID;
				playerStats[count][1] = kills;
				playerStats[count][2] = deaths;
				count++;
			}
	
			match = new Match(matchID, teamOneID, teamTwoID, teamOneScore, teamTwoScore, date, playerStats);
			
			/*System.out.println(matchID);
			System.out.println(teamOneID);
			System.out.println(teamOneScore);
			System.out.println(teamTwoID);
			System.out.println(teamTwoScore);
			System.out.println(date);
			for (int i = 0; i<10; i++) {
				System.out.println(playerStats[i][0] + " " + playerStats[i][1] + " " + playerStats[i][2]);
			} */
			  
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return match;
	}
	
	public List<Match> getAllMatchesFromTournament(int tournamentID){
		List<Match> matches = new ArrayList<>();
		
		String sql = "SELECT MatchID FROM TournamentMatch where TournamentID = " + tournamentID;
		
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()){
			    int matchID = result.getInt("MatchID");
			    Match match = getMatchDetails(matchID);
			    matches.add(match);
			}
		}   
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return matches;
	}

	@Override
	public void updateMatchScore(int matchID, int teamOneScore, int teamTwoScore) {
		try {  
			String sql = "UPDATE Matches SET [Team One Score]=?, [Team Two Score]=? where MatchID = " + matchID;
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, teamOneScore);
			statement.setInt(2, teamTwoScore);
				

			int rows = statement.executeUpdate();
			if (rows > 0) {
			    System.out.println("Update team score successful");
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}


	@Override
	public void updatePlayerMatchStats(int matchID, int playerID, int playerKills, int playerDeaths) {
		try {  
			String sql = "UPDATE MatchPlayerStats SET [Player Kills]=?, [Player Deaths]=? WHERE(MatchID=? and PlayerID=?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(3, matchID);
			statement.setInt(4, playerID);
			statement.setInt(1, playerKills);
			statement.setInt(2, playerDeaths);

			 
			int rows = statement.executeUpdate();
			if (rows > 0) {
			    System.out.println("Update player kd successful");
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}

}
