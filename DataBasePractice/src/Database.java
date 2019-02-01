import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database 
{
	static Statement databaseStatement;
	List<Table> tables;
	
	Database(String driverFilePathway, String databaseLocation, String username, String password)
	{
		establishConnection(driverFilePathway, databaseLocation, username, password);
		setupDatabasePropeties();
	}
	
	static
	{
		databaseStatement = null;
	}
	
	private void establishConnection(String driverFilePathway, String databaseLocation, String username, String password)
	{
		try
		{
			Class.forName(driverFilePathway);
			Connection conn = DriverManager.getConnection(databaseLocation, username, password);
			databaseStatement = conn.createStatement();
		}
		catch (SQLException e) 
		{
			System.out.println("SQL problem");
			e.printStackTrace();
			
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver problem");
			e.printStackTrace();
		}
	}
	
	public void createTable(String tableName)
	{
		if(tables==null) tables = new ArrayList<Table>();
		
		Table table = new Table(tableName);
		String[] values = table.retrieveValuesFromRecord("Marks");
		//String[][] values = javeBase.retrieveAllValuesFromRecord("school");
		
		System.out.println("values: " + values[2]);
		
		//tables.add(new Table(tableName));
	}
	
	private void setupDatabasePropeties()
	{
		
	}
	
	@SuppressWarnings("unused")
	private boolean isNonNumeric(String word)
	{
		return word.chars().allMatch(Character::isLetter);
	}
}
