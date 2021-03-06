package interfaceFun;

import java.util.Random;

public class SingletonExample 
{
	static SingletonExample singletonMath;
	private Random rand = new Random(); 
	private int objectId;
	
	private SingletonExample()
	{
		objectId = rand.nextInt(500) + 1;
	}
	
	public static SingletonExample createObject()
	{
		return (singletonMath == null) ? singletonMath = new SingletonExample() : singletonMath;
	}
	
	public int getObjectId()
	{
		return objectId;
	}
}
