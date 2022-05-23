package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import ModelLayer.Player;
import ModelLayer.Team;

public class TeamDAO implements TeamDAOIF {
	DBConnection dbcon = DBConnection.getInstance();
	Connection con = dbcon.getDBcon();
	Team team;

	@Override

	public void createTeam(String name) {
		String sql = "INSERT INTO Teams(Wins,Loses,[Team Name]) VALUES(?, ?, ?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setInt(2, 0);
			statement.setString(3, name);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Team> HigherOrderFunctionForGetMethods(Supplier<String> stringSQL, Supplier<String> tName) {
		List<Team> teamList = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement(stringSQL.get());
			if (tName.get() == null) {

			} else {
				statement.setString(1, tName.get());
			}
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int id = result.getInt("TeamID");
				String teamName = result.getString("Team Name");
				int wins = result.getInt("Wins");
				int loses = result.getInt("Loses");
				ArrayList<Player> players = PopulateArray(id);

				team = new Team(teamName, wins, loses, id, players);
				teamList.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	public ArrayList<Player> PopulateArray(int teamID) {
		String teamSQL = "SELECT * FROM Players WHERE PlayerID = ?";
		ArrayList<Player> players = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement(teamSQL);
			List<Integer> playerIDs = getPlayerIDFromTeams(teamID);
			for (int i = 0; i < playerIDs.size(); i++) {
				int playersID = playerIDs.get(i);
				statement.setInt(1, playersID);
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					int playerID = result.getInt("PlayerID");
					String gamerTag = result.getString("Gammer Tag");
					int totalKills = result.getInt("Total Kills");
					int totalDeaths = result.getInt("Total Deaths");
					Player player = new Player(playerID, gamerTag, teamID, totalKills, totalDeaths);
					players.add(player);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return players;
	}
  
	public List<Integer> getPlayerIDFromTeams(int teamID) {
		String sql = "SELECT PlayerID FROM PlayerTeam WHERE TeamID = ?";
		List<Integer> playerIDs = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, teamID);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int playerID = result.getInt("PlayerID");
				playerIDs.add(playerID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerIDs;
	}

	@Override
	public List<Team> getEligible() {
		List<Team> allTeams = getAllTeams();
		List<Team> eligibleTeams = new ArrayList<>();
		for (int i = 0; i < allTeams.size(); i++) {
			if (allTeams.get(i).getPlayers().size() > 4) {
				Team team = allTeams.get(i);
				eligibleTeams.add(team);
			}
		}
		return eligibleTeams;
	}

	public List<Team> getAllTeams() {
		String sql = "SELECT * FROM Teams";
		List<Team> allTeams = HigherOrderFunctionForGetMethods(() -> sql, () -> null);
		return allTeams;
	}

	@Override
	public Team findTeamByID(int teamID) {
		String sql = "SELECT * FROM Teams WHERE TeamID = " + "'" + teamID +"'";
		HigherOrderFunctionForGetMethods(() -> sql, () -> "null");
		return team;
	}

	public Team findTeamByName(String teamName) {
		String sql = "SELECT * FROM Teams WHERE [Team Name] = ?";
		HigherOrderFunctionForGetMethods(() -> sql, () -> teamName);
		return team;
	}

	@Override
	public void updateTeamStats(int winningTeamID, int losingTeamID, int matchID) {
		String updateWinner = "UPDATE Teams Set Wins = Wins+1 WHERE TeamID = ?";
		String updateLoser = "UPDATE Teams Set Loses = Loses+1 Where TeamID = ?";
		// Better way to update wins and loses?
		try {
			PreparedStatement winner;
			PreparedStatement loser;
			List<Integer> winnersAndLosers = getWinningTeam(matchID);
			losingTeamID = winnersAndLosers.get(1);
			winningTeamID = winnersAndLosers.get(0);
			winner = con.prepareStatement(updateWinner);
			winner.setInt(1, winningTeamID);
			winner.executeUpdate();
			loser = con.prepareStatement(updateLoser);
			loser.setInt(1, losingTeamID);
			loser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getWinningTeam(int matchID) {
		String sql = "SELECT TeamOneID, TeamTwoID FROM MatchTeam WHERE MatchID = ?";
		String score = "SELECT Team One Score, Team Two Score FROM Matches WHERE MatchID = ?";
		int winningTeamID = 0;
		int losingTeamID = 0;
		List<Integer> winnersAndLosers = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			PreparedStatement getScore = con.prepareStatement(score);
			ResultSet result = statement.executeQuery();
			ResultSet resultScore = getScore.executeQuery();
			statement.setInt(1, matchID);
			getScore.setInt(1, matchID);
			int teamOneID = result.getInt("TeamOneID");
			int teamTwoID = result.getInt("TeamTwoID");
			int teamOneScore = resultScore.getInt("Team One Score");
			int teamTwoScore = resultScore.getInt("Team Two Score");

			if (teamOneScore < teamTwoScore) {
				winningTeamID = teamTwoID;
				losingTeamID = teamOneID;
			} else if (teamOneScore > teamTwoScore) {
				winningTeamID = teamOneID;
				losingTeamID = teamTwoID;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		winnersAndLosers.add(winningTeamID, losingTeamID);
		return winnersAndLosers;
	}

	public void updateTeamName(int id, String teamName) {
		String sql = "UPDATE Teams Set [Team Name] = ? WHERE TeamID = ?";

		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, teamName);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Team> getTeamsInTournament(String tournamentName) {
		List<Team> teamsInTournament = new ArrayList<>();
		List<Integer> teamIDs = getTeamIDsFromTournament(tournamentName);
		for(int i = 0;i < teamIDs.size();i++) {
			Team team = findTeamByID(teamIDs.get(i));
			teamsInTournament.add(team);
		}
		return teamsInTournament;
	}
	
	public List<Integer> getTeamIDsFromTournament(String tournamentName){
		String sql = "Select TeamID From TournamentTeam Where TournamentID = ?";
		List<Integer> teamIDs = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			TournamentDAO tdao = new TournamentDAO();
			int tournamentID = tdao.getTournamentID(tournamentName);
			statement.setInt(1, tournamentID);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int teamID = result.getInt("TeamID");
				teamIDs.add(teamID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamIDs;
	}
	
	public void addTeamsToTournament(int tournamentID, int teamID) {
		String sql = "Insert into TournamentTeam (TournamentID , TeamID ) Values(? , ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, tournamentID);
			statement.setInt(2, teamID);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
