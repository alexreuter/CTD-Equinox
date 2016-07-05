import java.awt.Color;

public class PulsingBall extends Ball
{
	private boolean myIsShrinking = true;
	
	
	public PulsingBall(double x, double y, double size, Color c, double xVel, double yVel, Box box) 
	{
		super(x, y, size, c, xVel, yVel, box);
	}
	
	public void move()
    {
		super.move();
		
		if(myIsShrinking)
		{
			super.setSize(super.getWidth()-1,super.getWidth()-1);
			
			if(super.getWidth()<=2)
			{
				myIsShrinking = false;
			}
			
		}
		else
		{
			super.setSize(super.getWidth()+1,super.getWidth()+1);
			
			if(super.getWidth()>=10)
			{
				myIsShrinking = true;
			}
			
		}
    }
}
