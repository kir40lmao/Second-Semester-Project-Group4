package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Player;

public class PlayerDAO implements PlayerDAOIF{
	DBConnection dbcon = DBConnection.getInstance();
	Connection conn = dbcon.getDBcon();
	@Override
	public void createPlayer(String gamerTag) { //should work
		String sql = "INSERT INTO Players ([Gammer Tag], [Total Kills], [Total Deaths]) VALUES (?, ?, ?)";
		String sql2 = "INSERT INTO PlayerTeam (PlayerID, TeamID) VALUES (?, ?)";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, gamerTag);
			statement.setInt(2, 0);
			statement.setInt(3, 0);
			statement.executeUpdate();

			
			String sql_getPlayerID = "SELECT PlayerID FROM Players WHERE [Gammer Tag] = '"+gamerTag+"'";
			
			statement = conn.prepareStatement(sql_getPlayerID);
			ResultSet rs = statement.executeQuery();
			rs.next();
			int playerID = rs.getInt(1);
			
			statement = conn.prepareStatement(sql2);
			statement.setInt(1, playerID);
			statement.setInt(2, 1000);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Player findPlayerByName(String name) {
		Player player=null;
		try {	
			String sql = "SELECT * FROM Players WHERE [Gammer Tag] = '"+name+"'"; 
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			int playerID=0, totalKills=0, totalDeaths=0, teamID=0;
			String gamerTag="";
			while (result.next()){
				playerID = result.getInt("PlayerID");
			    gamerTag = result.getString("Gammer Tag");
			    totalKills = result.getInt("Total Kills");
			    totalDeaths = result.getInt("Total Deaths");
			}
			
			String teamsql = "SELECT TeamID FROM PlayerTeam WHERE PlayerID ='"+playerID+"'";
		    ResultSet teamResult = statement.executeQuery(teamsql);
		    while (teamResult.next()) {
		    	teamID=teamResult.getInt("TeamID");
		    }
		    
		    player = new Player(playerID, gamerTag, teamID, totalKills, totalDeaths);
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return player;
	}

	@Override
	public ArrayList<Player> findAvailablePlayers() {//extremely inefficient, can probably be solved with statement change
		ArrayList<Player> players=null;
		try {	
			String sql = "SELECT * FROM Players"; 
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
			    int playerID = result.getInt("PlayerID");
			    String gamerTag = result.getString(2);
			    int totalKills = result.getInt(3);
			    int totalDeaths = result.getInt(4);
			    String teamsql = "SELECT TeamID FROM PlayerTeam WHERE PlayerID ='"+playerID+"'";
			    ResultSet teamResult = statement.executeQuery(teamsql);
			    int teamID=0;
			    while (teamResult.next()) {
			    	teamID=teamResult.getInt("TeamID");
			    }
			    Player player = new Player(playerID, gamerTag, teamID, totalKills, totalDeaths);
			    //assumes that if player has no team, teamID is 0
			    if(player.getTeamID()==0)players.add(player);
			}
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return players;
	}

	@Override
	public ArrayList<Player> getAllPlayers() {
		Player player;
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<Integer> teamIDs = new ArrayList<>();
		int teamID=0;
		try {
			String sql = "SELECT * FROM Players"; 
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()){
			    int playerID = result.getInt("PlayerID");
			    String gamerTag = result.getString("Gammer Tag");
			    int totalKills = result.getInt("Total Kills");
			    int totalDeaths = result.getInt("Total Deaths");
			    
			    player = new Player(playerID, gamerTag, totalKills, totalDeaths);
			    players.add(player);
			}
			String teamSql = "SELECT TeamID FROM PlayerTeam ORDER BY PlayerID ";
			PreparedStatement teamStatement = conn.prepareStatement(teamSql);
			ResultSet teamResult = teamStatement.executeQuery();
			while(teamResult.next()) {
			    teamID=teamResult.getInt("TeamID");
			    teamIDs.add(teamID);
			}
			int index = 0;
			for(Player p : players) {
				p.setTeamID(teamIDs.get(index));
				index++;
			}
			return players;
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	

	@Override
	public Player updatePlayer(int playerID, String gamerTag, int teamID) {
		String sql ="UPDATE Players SET [Gammer Tag] = ? WHERE PlayerID = '"+playerID+"'" ;
		PreparedStatement statement;
		Player player=null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, gamerTag);
			statement.executeUpdate();
			
			String teamsql="UPDATE PlayerTeam SET TeamID = ? WHERE PlayerID = '"+playerID+"'";
			statement = conn.prepareStatement(teamsql);
			statement.setInt(1, teamID);
			statement.executeUpdate();
			
			player=findPlayerByName(gamerTag);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public boolean deletePlayer(int playerID) {
		boolean success=false;
		try {
		     
			String sql = "DELETE FROM Players WHERE PlayerID='"+playerID+"'";
			success=false;
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, playerID);
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				success=true;
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}	
		return success;
	}
	@Override
	
	//assumes the incoming parameters are match data, adds it to existing
	public Player updatePlayerAfterMatch(int playerID, int totalKills, int totalDeaths) {
		String dataFetcher="SELECT [Total Kills] AND [Total Deaths] AND [Gammer Tag] FROM Players WHERE PlayerID= '"+playerID+"'";
		int prevKills=0,prevDeaths=0;
		String gamerTag="0";
		String sql ="UPDATE Players WHERE PlayerID = '"+playerID+"' VALUES(?,?,?,?)" ;
		PreparedStatement statement=null;
		Player player=null;
		try {
		ResultSet result=statement.executeQuery(dataFetcher);
		while(result.next()) {
			prevKills=result.getInt("Total Kills");
			prevDeaths=result.getInt("Total Deaths");
			gamerTag=result.getString("Gammer Tag");
		}
		statement = conn.prepareStatement(sql);
		statement.setInt(3, (prevKills+totalKills));
		statement.setInt(4, (prevDeaths+totalDeaths));
		player = findPlayerByName(gamerTag);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
}
