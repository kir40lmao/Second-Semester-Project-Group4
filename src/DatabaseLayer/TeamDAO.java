package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import ModelLayer.Team;

public class TeamDAO implements TeamDAOIF {
	DBConnection dbcon = DBConnection.getInstance();
	Connection con = dbcon.getDBcon();
	Team team;

	@Override

	public void createTeam(String name) {
		String sql = "INSERT INTO Teams(Wins,Loses,Team Name) VALUES(?, ?, ?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setInt(2, 0);
			statement.setString(3, name);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Team findTeamByID(int teamID) {
		try {
			String sql = "SELECT * FROM Teams WHERE TeamID = ? ";
			String sqlPlayer = "SELECT * FROM PlayerTeam WHERE TeamID = ? ";

			PreparedStatement statement = con.prepareStatement(sql, teamID);
			ResultSet result = statement.executeQuery(sql);
			// ResultSet playerSQL = statement.executeQuery(sqlPlayer);

			while (result.next()) {
				int id = result.getInt("TeamID");
				String teamName = result.getString("TeamName");
				int wins = result.getInt("Wins");
				int loses = result.getInt("Loses");
				// ArrayList<Integer> players = (ArrayList<Integer>)
				ArrayList<Integer> players = null;
				Team team = new Team(teamName, loses, players);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return team;

	}

	public List<Team> HigherOrderFunctionForGetMethods(Supplier<String> stringSQL) {
		List<Team> teamList = new ArrayList<>();
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(stringSQL.get());
			while (result.next()) {
				int id = result.getInt("TeamID");
				String teamName = result.getString("Team Name");
				int wins = result.getInt("Wins");
				int loses = result.getInt("Loses");
				ArrayList<Integer> players = null;
				
				team = new Team(teamName, wins, loses, id, players);
				teamList.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	@Override
	public List<Team> getEligible() {
		String sql = "SELECT * FROM Teams WHERE TeamID = (SELECT Distinct(TeamID) From PlayerTeam WHERE(SELECT COUNT(TeamID) FROM PlayerTeam) >4)";
		List<Team> eligibleTeams = HigherOrderFunctionForGetMethods(() -> sql);
		System.out.println(team.getTeamName());
		return eligibleTeams;
	}

	public List<Team> getAllTeams() {
		String sql = "SELECT * FROM Teams";
		List<Team> allTeams = HigherOrderFunctionForGetMethods(() -> sql);
		System.out.println(allTeams);
		return allTeams;
	}

	@Override
	public void updateTeamStats(int teamID, int wins, int loses) {
		String sql = "UPDATE Teams Set Wins = ?, Loses = ? WHERE TeamID = ?";

		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, wins);
			statement.setInt(2, loses);
			statement.setInt(3, teamID);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTeamName(int id, String teamName) {
		String sql = "UPDATE Teams Set Team Name = ? WHERE TeamID = ?";

		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, teamName);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
