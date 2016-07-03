
public class simpleQueue implements Queue
{
	private Object[] myArray = new Object[10];
	private int toEnqueue = 0;
	public int toDequeue = 0;
	
	public simpleQueue(Object [] arr)
	{
		myArray = arr;
	}
	
	public simpleQueue()
	{
		//Do nothing
	}
	
	public String toString()
	{
		String results = "";
		
		for(int i = 0;i<myArray.length;i++)
		{
			if(myArray[i] == null)
			{
				results = results + "X";
			}
			else
			{
				results = results + myArray[i].toString();
			}
			
		}
		return results;
		
	}

	public boolean isEmpty() {
		if(myArray[toDequeue] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean enqueue(Object element) {
		//If there is an empty spot
		toEnqueue = fixValue(toEnqueue);
		
		if(myArray[toEnqueue] == null)
		{
			myArray[toEnqueue] = element;
			toEnqueue = fixValue(toEnqueue);
			toEnqueue = toEnqueue + 1;
			return true;
		}
		else
		{
			return false;
		}
	}

	public Object dequeue() 
	{
		if(myArray[toDequeue] == null)
		{
			System.out.println("Queue is empty");
			return null;
		}
		else
		{
			toDequeue = fixValue(toDequeue);
			Object valuetoreturn = myArray[toDequeue];
			myArray[toDequeue] = null;
			toDequeue = toDequeue + 1;
			return valuetoreturn;
		}
	}

	public Object front() {
		return myArray[toDequeue];
	}
	
	private int fixValue(int x)
	{
		if(x > myArray.length-1)
		{
			return (x%myArray.length);
		}
		else if(x<0)
		{
			return x+10;
		}
		return x;
	}
}
