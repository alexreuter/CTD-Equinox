import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class Paddle extends GRect
{
	public Paddle(double x, double y, double width, double height, Color c)
	{
		super(x,y,width,height);
		
		setColor(c);
        setFillColor(c);
        setFilled(true);
	}
	
	public void setX(double x)
	{
		super.setLocation(x,super.getY());
	}
	
	public void setY(double y)
	{
		super.setLocation(super.getX(),y);
	}
	
	public void setSize(double x,double y)
	{
		if(!(x<5 || y<5))
		{
			super.setSize(x,y);
		}
	}
	
}
