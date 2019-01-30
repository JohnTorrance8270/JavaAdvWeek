package interfaceFun;

public class Two extends One
{
	public void nextGo()
	{
		System.out.println("Two");
	}
	
	@Override
	public void doTask() 
	{
		System.out.println("betterDoneTask");
	}
}
