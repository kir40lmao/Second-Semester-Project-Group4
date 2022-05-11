package UILayer;

import ControllerLayer.TournamentController;

public class Test {

	public static void main(String[] args) {
		TournamentController tc = new TournamentController();
		tc.createTournament("Test Tournament 1", "2022-09-12");
		tc.createTournament("Test Tournament 2", "2022-10-12");
		tc.getAllTournaments();

	}

}
