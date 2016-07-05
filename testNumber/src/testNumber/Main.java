package testNumber;

public class Main {

	public static void main(String[] args) 
	{
		LargeNumber test = new LargeNumber("228941");
		LargeNumber test1 = new LargeNumber("908919412");

		System.out.println(test.multiply(test1).toString());
	}
}
