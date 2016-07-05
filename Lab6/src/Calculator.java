import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

//FINISH IMPLEMENTING 

public class Calculator extends Program
{
	
	private JLabel myDisplay;
	
    private SimpleStack myStack;
    private boolean myEntering = true;
    
    public void init()
    {
    	myStack = new SimpleStack();
    	myStack.push("0");
        myDisplay = new JLabel("", SwingConstants.RIGHT);
        
        setLayout(new TableLayout(6, 3));
        
        add(myDisplay, "gridwidth=4"); 
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(new JButton("0"), "gridwidth=1");
        add(new JButton("*"));
        add(new JButton("AC"));
        add(new JButton("+"));
        add(new JButton("C"));
        add(new JButton("Enter"), "gridwidth=3");
        
        addActionListeners();
        
        myDisplay.setText((String) myStack.top());
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String key;
        
        key = e.getActionCommand(); 
        
        if(key.equals("Enter"))
        {
        	if(myEntering)
        	{
        		myEntering = false;
        	}
        	else
        	{
        		myStack.push(myStack.top());
        	}
        }
        else if(key.equals("AC"))
        {
        	for(int i=0;i<myStack.toString().length();i++)
        	{
        		myStack.pop();
        	}
        }
        else if(key.equals("*"))
        {
        	System.out.println("Multiplyign");
        	
        	String popped;
        	if(myStack.top() == null)
        		popped = "0";
        	else
        		popped = myStack.pop().toString();
        	
        	LargeNumber digit1 = new LargeNumber();
            LargeNumber digit2 = new LargeNumber();
            
        	if(popped.toString().equals(null))
        	{
        		digit1 = new LargeNumber("0");
        	}
        	else
        	{
        		digit1 = new LargeNumber(popped.toString());
        	}
        	
        	if(myStack.top() == null)
        		popped = "0";
        	else
        		popped = myStack.pop().toString();
        	
        	if(popped.toString().equals(null))
        	{
        		digit2 = new LargeNumber("0");
        	}
        	else
        	{
        		digit2 = new LargeNumber(popped.toString());
        	}
        	
        	System.out.println(digit1);
        	System.out.println(digit2);
        	System.out.println("Mult: " + digit1.multiply(digit2));
        	myStack.push(digit1.multiply(digit2));
        	
        	System.out.println(myStack.top());
        	myEntering = false;
        }
        else if(key.equals("+"))
        {
        	String popped;
        	if(myStack.top() == null)
        		popped = "0";
        	else
        		popped = myStack.pop().toString();
        	
        	LargeNumber digit1 = new LargeNumber();
            LargeNumber digit2 = new LargeNumber();
            
        	if(popped.toString().equals(null))
        	{
        		digit1 = new LargeNumber("0");
        	}
        	else
        	{
        		digit1 = new LargeNumber(popped.toString());
        	}
        	
        	if(myStack.top() == null)
        		popped = "0";
        	else
        		popped = myStack.pop().toString();
        	
        	if(popped.toString().equals(null))
        	{
        		digit2 = new LargeNumber("0");
        	}
        	else
        	{
        		digit2 = new LargeNumber(popped.toString());
        	}
        	
        	myStack.push(digit1.plus(digit2));
        	myEntering = false;
        	
        	//Say is no longer in middle of entering
        }
        else if(key.equals("C"))
        {
        	myStack.pop();
        	myStack.push("0");
        	myEntering = true;
        }
        
        //This is a digit key
        else
        {
        	//Is in the middle
        	if(myEntering)
        	{
        		if(myStack.top()!= null)
        		{
        			String popped = myStack.pop().toString();
        			if(!popped.equals("0"))
        				myStack.push(popped + key);
        			else
        				myStack.push(key);
        		}
        		else
        		{
        			myStack.push(key);
        		}
        				
        	}
        	//Is not in the middle
        	else
        	{
        		myStack.push(key);
        		myEntering = true;
        	}
        }
        if(myStack.top() != null)
        {
        	myDisplay.setText(myStack.top().toString());
   		}
        else
        {
        	myDisplay.setText("0");
        }
        
        System.out.println(myStack);
    }
}