package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Player;
import DatabaseLayer.DBConnection;

public class PlayerDAO implements PlayerDAOIF{
	DBConnection dbcon = DBConnection.getInstance();
	Connection conn = dbcon.getDBcon();
	@Override
	public void createPlayer(String gamerTag) { //should work
		String sql = "INSERT INTO Player (GamerTag,Total Kills,Total Deaths) VALUES (?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, gamerTag);
			statement.setInt(2, 0);
			statement.setInt(3, 0);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Player "+gamerTag+" created and added to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Player findPlayerByName(String name) {
		Player player=null;
		try {	
			String sql = "SELECT * FROM Players WHERE GamerTag = '"+name+"'"; 
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			int playerID=0, totalKills=0, totalDeaths=0, teamID=0;
			String gamerTag="0";
			while (result.next()){
			    playerID = result.getInt("PlayerID");
			    gamerTag = result.getString("GamerTag");
			    totalKills = result.getInt("Total Kills");
			    totalDeaths = result.getInt("Total Deaths");
			    String teamsql = "SELECT TeamID FROM PlayerTeam WHERE PlayerID ='"+playerID+"'";
			    ResultSet teamResult = statement.executeQuery(teamsql);
			    while (teamResult.next()) {
			    	teamID=teamResult.getInt("TeamID");
			    }
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
			    String gamerTag = result.getString("GamerTag");
			    int totalKills = result.getInt("Total Kills");
			    int totalDeaths = result.getInt("Total Deaths");
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
		ArrayList<Player> players=null;
		try {	
			String sql = "SELECT * FROM Players"; 
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
			    int playerID = result.getInt("PlayerID");
			    String gamerTag = result.getString("GamerTag");
			    int totalKills = result.getInt("Total Kills");
			    int totalDeaths = result.getInt("Total Deaths");
			    String teamsql = "SELECT TeamID FROM PlayerTeam WHERE PlayerID ='"+playerID+"'";
			    ResultSet teamResult = statement.executeQuery(teamsql);
			    int teamID=0;
			    while (teamResult.next()) {
			    	teamID=teamResult.getInt("TeamID");
			    }
			    Player player = new Player(playerID, gamerTag, teamID, totalKills, totalDeaths);
			    players.add(player);
			}
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return players;
	}

	@Override
	public Player updatePlayer(int playerID, String gamerTag, int teamID) {
		String sql ="UPDATE Players WHERE PlayerID = '"+playerID+"' VALUES(?,?,?,?)" ;
		PreparedStatement statement;
		Player player=null;
		try {
		statement = conn.prepareStatement(sql);
		statement.setString(2, gamerTag);
		String teamsql="UPDATE PlayerTeam WHERE PlayerID = '"+playerID+"'VALUES(?,?)";
		statement = conn.prepareStatement(teamsql);
		statement.setInt(2, teamID);
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
		String dataFetcher="SELECT [Total Kills] AND [Total Deaths] AND GamerTag FROM Players WHERE PlayerID= '"+playerID+"'";
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
			gamerTag=result.getString("GamerTag");
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
