import java.awt.Color;


public class InvisibleBall extends Ball
{
	private int runCounter = 0;
	public InvisibleBall(double x, double y, double size, Color c, double xVel, double yVel, Box box,Score score)
    {
        super(x, y, size,c,xVel,yVel,box,score);
    }
	
	public void move()
	{
		pause(Math.random()*200);
	}
}
