package DatabaseLayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


public class DBConnection {   
	
	private static final String  driver = "jdbc:sqlserver://hildur.ucn.dk\\SQLExpress:1433;";
    private static final String  databaseName = ";databaseName=CSC-CSD-S212_10407567;";
    
    private static String  userName = ";user=CSC-CSD-S212_10407567";
    private static String password = ";password=Password1!;";
   
    private DatabaseMetaData dma;
    private static Connection con;
    
    private static DBConnection  instance = null;

    private DBConnection()
    {
    	String url = driver + databaseName + userName + password;

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");
          
        }
        catch(Exception e){
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url);
            con.setAutoCommit(true);
            dma = con.getMetaData();
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }
        catch(Exception e){
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }
    }
    public static void closeConnection()
    {
       	try{
            con.close();
            instance= null;
            System.out.println("The connection is closed");
        }
         catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
         }
    }
		
    public Connection getDBcon()
    {
       return con;
    }

    public static boolean instanceIsNull()
    {
       return (instance == null);
    }    

    public static DBConnection getInstance()
    {
        if (instance == null)
        {
          instance = new DBConnection();
        }
        return instance;
    }

}

