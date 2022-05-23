package Test;

import static org.junit.jupiter.api.Assertions.*;

import DatabaseLayer.DBConnection;

class TestDatabaseConnection {
	@org.junit.jupiter.api.Test
	void testDatabaseConnection() {
		DBConnection.getInstance();
	}
}
