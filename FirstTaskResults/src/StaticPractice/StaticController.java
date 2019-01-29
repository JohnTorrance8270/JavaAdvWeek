package StaticPractice;

public class StaticController 
{
	static int nonInstanceVar = 0;
	int instanceVar = 0;
	
	StaticController()
	{
		nonInstanceVar++;
		instanceVar++;
	}
	
	public void run()
	{
		methodStatic();
	}
	
	static void methodStatic()
	{
		//instanceVar = 10;
		
		nonInstanceVar = 10;
	}
}
