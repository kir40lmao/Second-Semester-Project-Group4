package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.TournamentController;

class TestDeleteTourney { //use TestCreateGoodTournament first
	TournamentController tc = new TournamentController();
	@Test
	void test() {
		String testName="FinalTestTourney";
		boolean success;
		tc.deleteTournament(tc.findTournamentByName(testName).getTournamentID());
		try {
			tc.findTournamentByName(testName);
			success=false;
		}catch(Exception e) {
			success=true;
		}
		assertEquals(true, success);
	}

}
