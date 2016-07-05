import acm.program.*;
import acm.graphics.*;

import java.awt.Color;

public class Ball extends GOval
{
    private double myXVelocity;
    private double myYVelocity;
    private Box myBox;
    private double mySize;
    
    public Ball(double x, double y, double size, Color c, double xVel, double yVel, Box box)
    {
        super(x, y, size, size);
        mySize = size;
        
        setColor(c);
        setFillColor(c);
        setFilled(true);
        
        myXVelocity = xVel;
        myYVelocity = yVel;
        myBox = box;
    }
    
    public void move()
    {
        if (getX() <= 0)
            myXVelocity = -myXVelocity;
        
        if (getX()+(super.getWidth()) >= myBox.getWidth())
            myXVelocity = -myXVelocity;
        
        if (getY() <= 0)
            myYVelocity = -myYVelocity;
        
        if (getY()+(super.getWidth()) >= myBox.getHeight())
            myYVelocity = -myYVelocity;
        
        //Paddle Conditionals
        
        if (getX() <= myBox.getLeftPaddle().getX() + myBox.getLeftPaddle().getWidth() && getY()>=myBox.getLeftPaddle().getY() && getY()<=myBox.getLeftPaddle().getY() + myBox.getLeftPaddle().getHeight())
        	myXVelocity = -myXVelocity;
        
        if (getX() + super.getWidth() >= myBox.getRightPaddle().getX() && getY()>=myBox.getRightPaddle().getY() && getY()<=myBox.getRightPaddle().getY() + myBox.getRightPaddle().getHeight())
        	myXVelocity = -myXVelocity;
        
        if (getY() <= myBox.getTopPaddle().getY() + myBox.getTopPaddle().getHeight() && getX()>=myBox.getTopPaddle().getX() && getX()<=myBox.getTopPaddle().getX() + myBox.getTopPaddle().getWidth())
        	myYVelocity = -myYVelocity;
        
        if (getY() + super.getWidth() >= myBox.getBottomPaddle().getY() && getX()>=myBox.getBottomPaddle().getX() && getX()<=myBox.getBottomPaddle().getX() + myBox.getBottomPaddle().getWidth())
        	myYVelocity = -myYVelocity;
        	
        super.move(myXVelocity, myYVelocity);
    }
}