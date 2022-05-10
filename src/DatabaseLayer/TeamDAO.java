package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Supplier;

import ModelLayer.Team;

public class TeamDAO implements TeamDAOIF{
	DBConnection dbcon = DBConnection.getInstance();
	Connection con = dbcon.getDBcon();
	Team team;
	@Override
	public void createTeam(String name) {
		String sql = "INSERT INTO Teams(TeamID,TeamName, Wins, Loses) VALUES(?, ?, ?, ?)";
		String sqlID ="SELECT LAST TeamID FROM Teams";
		PreparedStatement statement;
		try{
			int id = Integer.parseInt(sqlID);
			statement = con.prepareStatement(sql);
			statement.setInt(1, id+1);
			statement.setString(2, name);
			statement.setInt(3, 0);
			statement.setInt(4, 0);
			
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Team created");
			    //I know this shouldn't be here, just might use it for testing purposes later.
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		}

	@Override
	public void findTeamByID(int teamID) {
		try {	
			String sql = "SELECT * FROM Teams WHERE ID = '"+teamID+"'"; //change to name maybe
			String sqlPlayer = "SELECT * FROM PlayerTeam WHERE TeamID = '"+teamID+"'";
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql);
			ResultSet playerSQL = statement.executeQuery(sqlPlayer);
			 	
			//can put while expression within a higher order function and use lambdas to avoid code duplication
			//(will have to use same code in all get methods) - discuss with group
			while (result.next()){
			    int id = result.getInt("TeamID");
			    String teamName = result.getString("TeamName");
			    int wins = result.getInt("Wins");
			    int loses = result.getInt("Loses");
			    ArrayList<Integer> players = (ArrayList<Integer>) playerSQL.getArray("PlayerID");
			    
			    Team team = new Team(teamName, loses, players);
			    //testing purposes, REMOVE LATER
			    String output = "Team #%d: %d - %s - %s - %s - %s";
			    System.out.println(String.format(output, id,teamName,wins,loses));
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}
	public void HigherOrderFunctionForGetMethods(Supplier<String> stringSQL) {
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(stringSQL.get());
			while (result.next()){
			    int id = result.getInt("TeamID");
			    String teamName = result.getString("TeamName");
			    int wins = result.getInt("Wins");
			    int loses = result.getInt("Loses");
			    ArrayList<Object> players;
			    
			    Team team = new Team(teamName, loses, null);
}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void getElidgeable() {
		String sql = "";
		HigherOrderFunctionForGetMethods(() -> sql);
	}
	
	public void getAllTeams() {
		//higher order function + lambda could be used here;
		String sql = "SELECT * FROM Teams";
		HigherOrderFunctionForGetMethods(() -> sql);
	}

	@Override
	public void updateTeamName(int teamID, String name) {
		String sql ="UPDATE Team WHERE ID = '"+teamID+"'";
		
		int wins = 0;
		int loses = 0;
		PreparedStatement statement;
		//what CAN we update?
		try {
		statement = con.prepareStatement(sql);
		statement.setString(0, name);
		statement.setInt(4, wins);
		statement.setInt(5, loses);
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
