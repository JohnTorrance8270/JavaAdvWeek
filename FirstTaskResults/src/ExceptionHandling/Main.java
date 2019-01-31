package ExceptionHandling;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		int a, b, c;
		
		try
		{
			CoolExceptionExample ce = new CoolExceptionExample();
			ce.tax(2000, 8);
			
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
			
			c = a/b;
			
			System.out.println("working Code " + c);
		}
		catch(CustomExecption e)
		{
			System.out.println("too many days off, your fired!");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Please send two numbers");
		}
		catch(NumberFormatException e)
		{
			System.out.println("send only numbers please");
		}
		catch(ArithmeticException e)
		{
			System.out.println("cant divide anything by zero");
		}
		catch(Exception e)
		{
			System.out.println("you really broke it");
		}
		finally
		{
			System.out.println("hello");
		}
	}
}
