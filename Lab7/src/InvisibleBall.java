import java.awt.Color;

public class InvisibleBall extends Ball
{
	public static int maxTime = 15;
	private int runMax = (int) (Math.random() * ((1000/Box.pauseTime)*maxTime)) + 1;
	private int runCounter = 0;
	private boolean hiding = false;
	public static Box box;
	private boolean isVisible = false;
	
	public InvisibleBall(double x, double y, double size, Color c, double xVel, double yVel, Box box,Score score)
    {
        super(x, y, size,c,xVel,yVel,box,score);
        this.box = box;
    }
	
	public void move()
	{
		if(runCounter>runMax && hiding == true)
		{
			//Now ball is shown
			hiding = !hiding;
			runMax = (int) (Math.random() * ((1000/Box.pauseTime)*maxTime)) + 1;
			runCounter = 0;
		}
		
		if(runCounter>runMax && hiding == false)
		{
			//Now box is hidden
			hiding = !hiding;
			runMax = (1000/Box.pauseTime)*1;
			runCounter = 0;
		}
		
		if(hiding)
		{
			setVisible(false);
		}
		else
		{
			setVisible(true);
		}
		
		runCounter ++;
		super.move();
	}
}
