
public class SimpleStack implements Stack 
{
	private Object[] myElements = new Object[10];
	private int nextEmpty = 0;
	
	public SimpleStack(Object [] objs)
	{
		myElements = objs;
	}
	
	public SimpleStack()
	{
	}
	
	public boolean isEmpty()
	{
		if(myElements[0] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean push(Object obj)
	{
		//myElements[nextEmpty] == null && 
		if(nextEmpty !=10)
		{
			System.out.println("SimpleStack push");
			myElements[nextEmpty] = obj;
			nextEmpty++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Object pop()
	{
		Object placeholder;
		
		if(nextEmpty != 0)
		{
			placeholder = myElements[nextEmpty-1];
			myElements[nextEmpty-1] = null;
			nextEmpty--;
			return placeholder;
		}
		else
			if(myElements[0] != null)
				return myElements[0];
			else
				return null;
	}
	
	public Object top()
	{
		if(nextEmpty-1!=-1)
			return myElements[nextEmpty-1];
		else if(myElements[nextEmpty] != null)
			return myElements[nextEmpty];
		else
			return null;
	}
	
	public String toString()
	{
		String results = "";
		
		for(int i = 0;i<myElements.length;i++)
		{
			if(myElements[i] == null)
			{
				results = results + "X";
			}
			else
			{
				results = results + myElements[i].toString();
			}
			
		}
		return results;
		
	}
}