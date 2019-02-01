import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table 
{
	private int columnAmount;
	private int rowAmount;
	
	private String tableName;
	private String[] fieldNames;
	
	static Statement databaseStatement;
	
	static
	{
		databaseStatement = Database.databaseStatement;
	}
	
	Table(String tableName)
	{
		this.tableName = tableName;
		
		ResultSet entireTableRecord = readRecord("*");
		
		columnAmount = getColumnCount(entireTableRecord);
		rowAmount = getRowCount(entireTableRecord);
		
		try 
		{
			fieldNames = new String[columnAmount];
			
			for(int i = 0; i < columnAmount; i++)
			{
				fieldNames[i] = entireTableRecord.getMetaData().getColumnName(i+1);
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("creating table info issue");
			e.printStackTrace();
		}
	}

	private ResultSet readRecord(String fieldName) 
	{
		try 
		{
			ResultSet rec  = databaseStatement.executeQuery("select " + fieldName + " from " + tableName);
			return (rec.next()) ? rec : null;
		} 
		catch (SQLException e) 
		{
			System.out.println("Issue with read record");
			e.printStackTrace();
			return null;
		}
	}
	
	private boolean isInteger(String num)
	{
	  try 
	  { 
		  Integer.parseInt(num); 
	  } 
	  catch(NumberFormatException e) 
	  { 
	      return false; 
	  }	  
	  return true;
	}
	
	private int getRowCount(ResultSet entireTableRecord) 
	{
		int rowNumber = 0;
		try 
		{
			entireTableRecord.last();
			rowNumber = entireTableRecord.getRow();
			entireTableRecord.beforeFirst();
			entireTableRecord.next();
		} 
		catch (SQLException e) 
		{
			System.out.println("Failed to get row amount, error");
			rowNumber = 1;
			e.printStackTrace();
		} 
		
		return rowNumber;
	}

	private int getColumnCount(ResultSet entireTableRecord) 
	{
		try 
		{
			return entireTableRecord.getMetaData().getColumnCount();
		} 
		catch (SQLException e) 
		{
			System.out.println("Failed to get column amount, error");
			e.printStackTrace();
			return 1;
		}
	}
	
	public void insert(String tableName, String... args)
	{
		String inputDatabaseValues = "";
		
		for(int i = 0; i < args.length; i++)
		{
			if(!isInteger(args[i]))
			{
				inputDatabaseValues += "'" + args[i] + "'";
			}
			else
			{
				inputDatabaseValues += args[i];
			}
			if(i != (args.length-1)) inputDatabaseValues += ", ";		
		}
		
		try 
		{
			databaseStatement.executeUpdate("insert into " + tableName + " values(" + inputDatabaseValues + ")");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void delete(String tableName)
	{
		
	}
	
	public String[] retrieveValuesFromRecord(String fieldName)
	{
		ResultSet rec = readRecord(fieldName);
		String values[] = null;
		
		try 
		{
			values = new String[rowAmount];
			
			for(int i = 0; i < values.length; i++)
			{
				values[i] = rec.getObject(1).toString();
				rec.next();
			}
			return values;
		} 
		catch (SQLException e) 
		{
			System.out.println("retrieving single record problem");
			e.printStackTrace();
			return values;
		}	
	}
	
	public String[][] retrieveAllValuesFromRecord()
	{
		ResultSet rec = readRecord("*");
		String values[][] = null;
		
		try 
		{
			values = new String[rowAmount][];
			
			int u = 0;
			do
			{
				String newValues[] = new String [columnAmount];
				for(int i = 0; i < columnAmount; i++)
				{
					newValues[i] = rec.getObject(i+1).toString();
				}
				
				values[u] = newValues;
				u++;
			}
			while(rec.next());
			
			return values;
		} 
		catch (SQLException e) 
		{
			System.out.println("retrieving files problem");
			e.printStackTrace();
			return values;
		}
	}
}
