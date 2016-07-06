
import acm.program.*;
import acm.graphics.*;

import java.awt.Color;

//Fix glitchy with .contains ************************************************** basically add smal sides

public class Ball extends GOval
{
    private double myXVelocity;
    private double myYVelocity;
    private Box myBox;
    private double mySize;
    private Score score;
    
    public Ball(double x, double y, double size, Color c, double xVel, double yVel, Box box,Score score)
    {
        super(x, y, size, size);
        mySize = size;
        
        setColor(c);
        setFillColor(c);
        setFilled(true);
        
        myXVelocity = xVel;
        myYVelocity = yVel;
        myBox = box;
        
        this.score = score;
    }
    
    public void move()
    {
    	
    	if (getX() <= 0)
            Box.gameOver();
        
        if (getX()+(super.getWidth()) >= myBox.getWidth())
        	Box.gameOver();
        
        if (getY() <= 0)
        	Box.gameOver();
        
        if (getY()+(super.getWidth()) >= myBox.getHeight())
        	Box.gameOver();
        
        //Paddle Conditionals
        
        if (getX() <= myBox.getLeftPaddle().getX() + myBox.getLeftPaddle().getWidth() && 
        		getY() >= myBox.getLeftPaddle().getY() && getY() <= myBox.getLeftPaddle().getY() + myBox.getLeftPaddle().getHeight())
        {
        	myXVelocity = -myXVelocity;
        	System.out.println("Hit left paddle");
        	score.add(1);
        	myBox.getLeftPaddle().setSize(myBox.getLeftPaddle().getWidth(), myBox.getLeftPaddle().getHeight()-1);
        }
        
        
        if (getX() + super.getWidth() >= myBox.getRightPaddle().getX() && getY() >= myBox.getRightPaddle().getY() && 
        		getY()<=myBox.getRightPaddle().getY() + myBox.getRightPaddle().getHeight())
        {
        	myXVelocity = -myXVelocity;
        	System.out.println("Hit RIGHT paddle");
        	score.add(1);
        	myBox.getRightPaddle().setSize(myBox.getRightPaddle().getWidth(), myBox.getRightPaddle().getHeight()-1);
        }
        
        if (getY() <= myBox.getTopPaddle().getY() + myBox.getTopPaddle().getHeight() && getX() >= myBox.getTopPaddle().getX() && 
        		getX()<=myBox.getTopPaddle().getX() + myBox.getTopPaddle().getWidth())
        {
        	myYVelocity = -myYVelocity;
        	System.out.println("Hit top paddle");
        	score.add(1);
        	myBox.getTopPaddle().setSize(myBox.getTopPaddle().getWidth()-1, myBox.getTopPaddle().getHeight());
        }
        
        if (getY() + super.getWidth() >= myBox.getBottomPaddle().getY() && getX() >= myBox.getBottomPaddle().getX() && 
        		getX()<=myBox.getBottomPaddle().getX() + myBox.getBottomPaddle().getWidth())
        {
        	myYVelocity = -myYVelocity;
        	System.out.println("Hit bottom paddle");
        	score.add(1);
        	myBox.getBottomPaddle().setSize(myBox.getBottomPaddle().getWidth()-1, myBox.getBottomPaddle().getHeight());
        }
        	
        super.move(myXVelocity, myYVelocity);
    }
    
}