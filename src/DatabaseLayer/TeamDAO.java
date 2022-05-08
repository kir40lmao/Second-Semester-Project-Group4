package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeamDAO implements TeamDAOIF{
	DBConnection dbcon = DBConnection.getInstance();
	Connection con = dbcon.getDBcon();
	
	@Override
	public void createTournament(String name) {
		String sql = "INSERT INTO Tournament(TournamentID, [Tournament Name], [Date], Venue, Status) VALUES(?, ?, ?, ?, ?)";
		
		PreparedStatement statement;
		try{
			String venue = "";
			String status = "";
			statement = con.prepareStatement(sql);
			//statement.setInt(); will we have to read all IDs within database to get the next ID or is there some other way??
			statement.setString(0, name);
			statement.setDate(0, null, null); //research which method is best for inserting date data in MSSQL
			statement.setString(0, venue);
			statement.setString(0, status);
			
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Tournament created");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		}

	@Override
	public void findTournament(int tournamentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllTournaments() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUpcoming() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOngoing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTournament(int tournamentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTournament(int tournamentID) {
		// TODO Auto-generated method stub
		
	}

}
