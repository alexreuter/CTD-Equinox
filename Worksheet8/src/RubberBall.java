import java.awt.Color;

import acm.graphics.GOval;
import java.awt.Color;

public class RubberBall extends GOval
{
	private double myXVelocity;
    private double myYVelocity;
    private Box myBox;
    private double mySize;
    private int myWidth;
    
	public RubberBall(double x, double y, double size, Color c, double xVel, double yVel, Box box) 
	{
		super(x, y, size, size);
		myBox = box;
		mySize = size;
		myXVelocity = xVel;
		myYVelocity = yVel;
		
		 setColor(c);
	      setFillColor(c);
	      setFilled(true);
	}
	
	public void move()
	{
		
		if (getX() <= 0)
		{
			//Moving left
			if(myXVelocity<0)
			{
				setBounds(getX(),getY(),myWidth-myXVelocity,mySize);
				super.move(myXVelocity, myYVelocity);
			}
			//Moving right
			else if(myXVelocity>0)
			{
				setBounds(getX(),getY(),myWidth+myXVelocity,mySize);
			}
			//Ball is completely "compressed" against wall
			else
			{
				myXVelocity = -myXVelocity;
			}
		}
		else if (getX()+(super.getWidth()) >= myBox.getWidth())
		{
			myXVelocity = -myXVelocity;
		}
		else if (getY() <= 0)
		{
			myYVelocity = -myYVelocity;
		}
		else if (getY()+(super.getWidth()) >= myBox.getHeight())
		{
			myYVelocity = -myYVelocity;
		}
		
		
	}
}
