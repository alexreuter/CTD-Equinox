
public class Quack implements Stack,Queue
{	
	
	private Object[] myArray = new Object[10];
	public int frontIndex = 0;
	public int endIndex = 0;
	
	public Quack(Object[] elements)
	{
		myArray = elements;
	}
	
	public Quack()
	{
		//Do nothing
	}
	
	public boolean enqueue(Object element) {
		if(!isFull())
		{
			//If the enqueue space is open
			if(myArray[getRidofNullPointers(endIndex-1)] == null)
			{
				endIndex = getRidofNullPointers(endIndex-1);
				myArray[endIndex] = element;
				return true;
			}
			else
			{
				//This should never happen it should just make debugging easier.
				System.out.println("Tried to enqueue to full index, isFull failed");
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public Object pop() {
		if(!isFull())
		{
			//If the dequeue space is full
			if(myArray[getRidofNullPointers(endIndex)] != null)
			{
				Object placeholder = myArray[getRidofNullPointers(endIndex)];
				myArray[getRidofNullPointers(endIndex)] = null;
				endIndex = getRidofNullPointers(endIndex+1);
				return placeholder;
			}
			else
			{
				//This should never happen it should just make debugging easier.
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	//This is for a queue
	public Object front() 
	{
		return myArray[getRidofNullPointers(frontIndex-1)];
	}

	public boolean isEmpty() 
	{
		boolean foundFull = true;
		for(int i = 0;i<myArray.length;i++)
		{
			if(myArray[i] != null)
			{
				foundFull = false;
			}
		}
		return foundFull;
	}

	public boolean push(Object element) 
	{
		//Push does the exact same thing as enqueue
		return this.enqueue(element);
	}

	public Object dequeue() {
		//If the pop space is full
		if(myArray[getRidofNullPointers(frontIndex-1)] != null)
		{
			Object placeholder = myArray[getRidofNullPointers(frontIndex-1)];
			myArray[getRidofNullPointers(frontIndex-1)] = null;
			frontIndex = getRidofNullPointers(frontIndex-1);
			return placeholder;
		}
		else
		{
			//This should never happen it should just make debugging easier.
			return null;
		}
	}

	//This is for a stack
	public Object top() 
	{
		return myArray[frontIndex];
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
	
	private int getRidofNullPointers(int x)
	{
		if(x>myArray.length-1)
		{
			x %= 10;
		}
		else if(x<0)
		{
			x += myArray.length;
		}
		
		return x;
	}
	
	private boolean isFull()
	{
		for(int i = 0;i<myArray.length;i++)
		{
			if(myArray[i] == null)
			{
				return false;
			}
		}
		return true;
	}
	
}
