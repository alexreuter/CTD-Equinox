import java.util.Scanner;
public class Problem1
{
	public static void main(String[] args) 
	{
		double x = 0,y = 0;
		int inCircle = 0;
		
		Scanner scan = new Scanner(System.in);
		long trial;
		System.out.println("How many darts do you want to throw? ");
		trial = scan.nextLong();
		
		System.out.println("Running...");
		
		for(int i = 0;i<trial;i++)
		{
			x = Math.random();
			y = Math.random();	
	
			if(distanceFormula(x,y)<=0.5)
			{
				inCircle++;
			}
		}
		System.out.println("Final approximation: " + ((double)inCircle/trial)*4);
	}
	
		
	
	public static double distanceFormula(double x,double y)
	{
		return Math.sqrt(Math.pow(0.5-x,2) + Math.pow(0.5-y,2));	
	}
	
}