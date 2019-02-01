
public class Calc 
{
	public int multiply(int i, int j) 
	{
		return (i*j);
	}

	public String divide(int i, int j) 
	{	
		if(i==0) 
		{
			return "0";
		}
		else if(j==0)
		{
			return "Infinty";	
		}
		else
		{
			return i/j + "";
		}	
	}
}
