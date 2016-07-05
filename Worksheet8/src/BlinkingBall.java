import java.awt.Color;


public class BlinkingBall extends Ball
{
	
	public BlinkingBall(double x, double y, double size, Color c, double xVel, double yVel, Box box) 
	{
		super(x, y, size, c, xVel, yVel, box);
	}
	
	public void move()
    {
		super.move();
		
		if(getX() % 10 >=5)
		{
			setVisible(true);
		}
		else
		{
			setVisible(false);
		}
    }
}