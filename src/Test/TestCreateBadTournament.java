package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.TournamentController;

class TestCreateBadTournament {
	TournamentController tc = new TournamentController();
	@Test
	void test() {
		boolean success=false;
		try {
			String testName= "FinalTestTourney";
			String testDate="Not-a-date";
			tc.createTournament(testName, testDate);
			assertEquals(testDate, tc.findTournamentByName(testName).getDate());
			success=true;
		}catch(Exception e) {
			success=false;
		}
		assertEquals(false,success);
	}

}
