package FancyCalc;

public class MultiCalc extends CalcWindow
{
	MultiCalc(String windowName, String buttonText, int numOne, int numTwo) 
	{
		super(windowName, buttonText, numOne, numTwo);
	}

	@Override
	protected void response() 
	{
		T3.setText(this.numOne * this.numTwo + "");
	}
}
