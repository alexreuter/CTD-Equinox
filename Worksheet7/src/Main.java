
public class Main {

	public static void main(String[] args)
	{
		
		Queue test = new simpleQueue();
		
		System.out.println(test.isEmpty());
		
		
		testCase(1,test,"*XXXXXXXXX","*");
		testCase(1,test,"**XXXXXXXX","*");
		testCase(1,test,"***XXXXXXX","*");
		testCase(1,test,"****XXXXXX","*");
		testCase(1,test,"*****XXXXX","*");
		
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
		
		System.out.println(test);
		
		for(int i=0;i<20;i++)
		{
			test.enqueue(Integer.toString(i));
			System.out.println(test);
		}
		
		test.dequeue();
		test.dequeue();
		System.out.println(test);
		System.out.println(test.isEmpty());
	}
	
	public static void testCase(int operator, Queue test, String answer,String toEncue)
	{
		
		if(operator == 1)
		{
			test.enqueue(toEncue);
		}
		if(operator == 2)
		{
			test.dequeue();
		}
		
		if(test.toString().equals(answer))
		{
			System.out.println(true);
		}
		else
		{
			System.out.println("Code produced " + test);
			System.out.println("Shoulda been " + answer);
			System.out.println(false);
		}
	}
}