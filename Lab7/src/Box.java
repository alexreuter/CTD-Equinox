import acm.program.*;
import acm.graphics.*;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Box extends GraphicsProgram
{
	private Ball[] myBall;
	private int size = 2;
	
    private Paddle topPaddle;
    private Paddle bottomPaddle;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private static boolean myOver = false;
    private Score myScore = new Score(0,10);
    static int pauseTime = 50;
    
    public void init()
    {
    	myBall = new Ball [size];
        
    	double scalableWidth = this.getWidth()/4;
        double scalableHeight = this.getHeight()/20;
        
        topPaddle = new Paddle(0,0,scalableWidth,scalableHeight,Color.RED);
        bottomPaddle = new Paddle(0,this.getHeight()-scalableHeight,scalableWidth,scalableHeight,Color.RED);
        leftPaddle = new Paddle(0,0,scalableHeight,scalableWidth,Color.RED);
        rightPaddle = new Paddle(this.getWidth()-scalableHeight,0,scalableHeight,scalableWidth,Color.RED);
    	
        add(topPaddle);
        add(bottomPaddle);
        add(leftPaddle);
        add(rightPaddle);

        add(myScore);
        
        for (int k = 0 ; k < size ; k++)
        {
            myBall[k] = new InvisibleBall(this.getWidth()/2,  
            					 this.getHeight()/2,
                                 20, 
                                 new Color((int)(256 * Math.random()), (int)(256 * Math.random()), (int)(256 * Math.random())), 
                                 10 * Math.random() - 5, 
                                 10 * Math.random() - 5, 
                                 this,myScore);
        	add(myBall[k]);
        }
        
        addMouseListeners();
    }
    
    public void run()
    {
    	
        while (!myOver)
        {
            for (int k = 0 ; k < size ; k++)
            	myBall[k].move();
            
            if(Integer.parseInt(myScore.toString()) % 100 == 0 && Integer.parseInt(myScore.toString()) != 0)
            {
            	pauseTime -= 20;
            }
            pause(pauseTime);
        }
    }
    
    public Paddle getTopPaddle()
    {
    	return topPaddle;
    }
    
    public Paddle getBottomPaddle()
    {
    	return bottomPaddle;
    }
    
    public Paddle getLeftPaddle()
    {
    	return leftPaddle;
    }
    
    public Paddle getRightPaddle()
    {
    	return rightPaddle;
    }
    
    public void mouseMoved(MouseEvent e)
    {
    	double y;
    	double x;

    	y = e.getY();
    	x = e.getX();

    	if (y < 0)
    		y = 0;
    	
    	//These if statements make sure the paddles are always at their maximum length
    	if(x>=this.getWidth() - topPaddle.getWidth())
    		x = this.getWidth() - topPaddle.getWidth();
    	
    	if(y>=this.getHeight() - leftPaddle.getHeight())
    		y = this.getHeight() - leftPaddle.getHeight();
    	
    	
    	leftPaddle.setY(y);
    	rightPaddle.setY(y);
    	topPaddle.setX(x);
    	bottomPaddle.setX(x);
    }

	public static void gameOver() 
	{
		myOver = true;
	}
}