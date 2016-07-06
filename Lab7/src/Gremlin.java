import java.awt.Color;

import acm.graphics.GOval;


public class Gremlin extends InvisibleBall
{
	private int maxTime = 600;
	private boolean hiding = false;
	private Score myScore; 
	private static int size = 80; 
	private Ball[] myBalls; 
	private int runMax = (int) (Math.random() * maxTime) + 1;
	private int runCounter = 0;
	
	public Gremlin(Color c,Box box,Score score,Ball[] myBalls)
    {
		super(((box.getWidth()-size)*Math.random()),((box.getHeight()-size)*Math.random()),size,c,0.0,0.0,box,score);
		myScore = score;
		InvisibleBall.maxTime = 5;
		this.myBalls = myBalls;
    }
	
	public void move()
	{
		if(runCounter>runMax)
		{
			hiding = !hiding;
			//This is to avoid a weird jumping where it changes location before hiding
			setVisible(false);
			runMax = (int) (Math.random() * maxTime) + 1;
			super.setLocation(((box.getWidth()-size)*Math.random()),((box.getHeight()-size)*Math.random()));
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
		
		for(int i = 0;i<myBalls.length;i++)
		{
			if(this.contains(myBalls[i].getX(),myBalls[i].getY()) && hiding == false)
			{
				int addScore = (int)(Math.random()*41)+10;
				myScore.add(addScore);
				System.out.println("Bonus: " + addScore);
				hiding = true;
				runCounter = 0;
				runMax = (int) (Math.random() * maxTime) + 1;
				//This is to avoid a weird jumping where it changes location before hiding
				setVisible(false);
				super.setLocation(((box.getWidth()-size)*Math.random()),((box.getHeight()-size)*Math.random()));
			}
		}
	}
}
