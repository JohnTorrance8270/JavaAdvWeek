import java.util.Scanner;

public class Input 
{
	static Scanner userInput = new Scanner(System.in);
	
	public static int getUserNumericInput()
	{
		if(userInput.hasNext())
		{
			if(userInput.hasNextInt())
			{	
				return userInput.nextInt();
			}
			else
			{
				userInput.next();	
			}
		}
		
		return -1;
	}
	
	public static int getUserNumericInput(int min, int max)
	{
		int userValue = -1;
		System.out.println("Please enter a number between " + min + " and " + max);
		
		if(userInput.hasNext())
		{
			if(userInput.hasNextInt())
			{	
				userValue = userInput.nextInt();
			}
		}
		
		if((userValue >= min) && (userValue <= max))
		{
			return userValue;
		}
		else
		{
			System.out.println("Invalid number please enter a number between " + min + " and " + max);
			userInput.nextLine();
			return getUserNumericInput(min, max);
		}
	}
	
	public static boolean getUserChoice()
	{
		System.out.println("If you wish to go again, enter y, anything else will end the program");
		String choice = null;
		
		if(userInput.hasNext())
		{
			if(userInput.hasNextLine())
			{	
				choice = userInput.next();
			}
		}
		
		return (choice.equals("y")) ? true : false;	
	}
}
