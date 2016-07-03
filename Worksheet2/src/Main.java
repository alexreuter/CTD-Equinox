import java.util.Scanner;


public class Main 
{
	public static void main(String[] args) 
	{
		problemOne();
		problemTwo();
		problemThree();
		problemFour();
		problemFive();
		problemSix();
		problemSeven();
		problemEight();
	}
	
	public static void problemOne()
	{
		System.out.println("1. Write a program that prints a random number between 0.0 and 1.0. Run your program multiple times. Does the number printed change each time you run it?");
		double rand;
		rand = Math.random();
		System.out.println(rand);
	}
	
	public static void problemTwo()
	{
		System.out.println("2. Write a program that prints 100 random numbers between 0.0 and 1.0.");
		double rand;
		for(int i=0;i<100;i++)
		{
			rand = Math.random();
			System.out.println(rand);
		}
	}
	
	public static void problemThree()
	{
		System.out.println("3. Write a program that prints 100 random numbers between 0.0 and 19.0.");
		double rand;
		for(int i=0;i<100;i++)
		{
			rand = Math.random()*19;
			System.out.println(rand);
		}
	}
	
	public static void problemFour()
	{
		System.out.println("4. Write a program that prints 100 random integers between 0 and 18 inclusive.");
		double rand;
		for(int i=0;i<100;i++)
		{
			rand = (int)(Math.random()*19);
			System.out.println(rand);
		}
	}
	
	public static void problemFive()
	{
		System.out.println("5. Write a program that prints 100 random integers between 1 and 19 inclusive.");
		double rand;
		for(int i=0;i<100;i++)
		{
			rand = (int)((Math.random())*20);
			System.out.println(rand);
		}
	}
	
	public static void problemSix()
	{
		System.out.println("6. Write a program that prints 100 random integers between 1 and 2 inclusive");
		double rand;
		for(int i=0;i<100;i++)
		{
			rand = (int)(1+((Math.random())*2));
			System.out.println(rand);
		}
	}
	
	public static void problemSeven()
	{
		System.out.println("7. Write a program that prints 100 random coin tosses. For each toss, it should print either “Heads” or “Tails”.");
		double rand;
		for(int i=0;i<100;i++)
		{
			rand = (int)(1+((Math.random())*2));
			if(rand == 1.0)
			{
				System.out.println("Heads");
			}
			else
			{
				System.out.println("Tails");
			}
		}
	}
	
	public static void problemEight()
	{
		System.out.println("8. Write a program that asks the user for a number and then prints that many random coin tosses. ");
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.println("Enter a number: ");
		num = scan.nextInt();
		double rand;
		for(int i=0;i<num;i++)
		{
			rand = (int)(1+((Math.random())*2));
			if(rand == 1.0)
			{
				System.out.println("Heads");
			}
			else
			{
				System.out.println("Tails");
			}
		}
	}
	
}
