import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("1. Write a program that gets a number from the user and prints it.");
		problemOne();
		System.out.println("2. Write a program that gets two numbers from the user and prints them.");
		problemTwo();
		System.out.println("3. Write a program that gets two numbers from the user and outputs their sum.");
		problemThree();
		System.out.println("4. Write a program that gets two numbers from the user and outputs their average.");
		problemFour();
		System.out.println("5. Write a program that gets three numbers from the user and outputs their sum.");
		problemFive();		
		System.out.println("6. Write a program that gets three numbers from the user and outputs their average.");
		problemSix();
		System.out.println("7. Write a program that gets two numbers from the user and outputs the smaller number.");
		problemSeven();
		System.out.println("8. Write a program that gets two numbers from the user and outputs both of them in order (in other words, the smaller number followed by the larger number).");
		problemEight();
		System.out.println("9. Write a program that gets three numbers from the user and outputs the smaller number.");
		problemNine();
		System.out.println("10. Write a program that gets three numbers from the user and outputs them in order from smallest to largest.");
		problemTen();
	
	}
	



	public static void problemOne()
	{
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("Enter a number: ");
		num = scan.nextInt();
		System.out.println("Here is your number: " + num);
	}
	
	public static void problemTwo()
	{
		Scanner scan = new Scanner(System.in);
		int n1,n2;
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		System.out.println("Here is your first number: " +n1);
		System.out.println("Here is your second number: " + n2);
	}
	
	public static void problemThree()
	{
		Scanner scan = new Scanner(System.in);
		int n1,n2;
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		System.out.println("Here is the sum of those numbers: " + Integer.toString(n1+n2));
	}
	
	public static void problemFour()
	{
		int n1,n2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		double average = (n1+n2)/2.0;
		System.out.println("Here is the average of those numbers: " + average);
	}
	
	public static void problemFive()
	{
		int n1,n2,z;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		System.out.print("Enter another number again: ");
		z = scan.nextInt();
		
		System.out.println("Here is the sum of those numbers: " + Integer.toString(n1+n2+z));
	}
	
	public static void problemSix()
	{
		int n1,n2,z;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		System.out.print("Enter another number again: ");
		z = scan.nextInt();
		double average = (n1+n2+z)/3.0;
		System.out.println("Here is the average of those numbers: " + average);
	}
	
	public static void problemSeven()
	{
		int n1,n2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		
		if(n1>n2)
		{
			System.out.println(n2 + " is smaller!");
		}
		else if (n1<n2)
		{
			System.out.println(n1 + " is smaller!");
		}
		else if (n1==n2)
		{
			System.out.println("They are equal!");
		}
		else
		{
			System.out.println("That isn't a number!");
		}
	}
	
	public static void problemEight()
	{
		int n1,n2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2 = scan.nextInt();
		
		if(n1>n2)
		{
			System.out.println(n2 + "," +n1);
		}
		else if (n1<n2)
		{
			System.out.println(n1 + "," + n2);
		}
		else if (n1==n2)
		{
			System.out.println("They are equal!");
		}
		else
		{
			System.out.println("That isn't a number!");
		}
	}
	
	public static void problemNine()
	{
		int n1,n2,n3;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		System.out.print("Enter another number again: ");
		n3 = scan.nextInt();

		
		if(n1 == n2 && n2== n3)
		{
			System.out.println("They are all equal");
		}
		else if(n1>=n2)
		{
			if(n2>n3)
			{
				System.out.println(n3);
			}
			else
			{
				System.out.println(n2);
			}
		}
		else if(n2>n1)
		{
			if(n1>n3)
			{
				System.out.println(n3);
			}
			else
			{
				System.out.println(n1);
			}
		}
		else if(n2>n3)
		{
			if(n3>n2)
			{
				System.out.println(n2);
			}
			else
			{
				System.out.println(n3);
			}
		}
		else if(n3>n2)
		{
			if(n2>n1)
			{
				System.out.println(n1);
			}
			else
			{
				System.out.println(n2);
			}
		}
		else
		{
			System.out.println("You inputted a non number");
		}
		
	}
	
	public static void problemTen()
	{
		int n1,n2,n3;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		n1 = scan.nextInt();
		System.out.print("Enter another number: ");
		n2  =scan.nextInt();
		System.out.print("Enter another number again: ");
		n3 = scan.nextInt();
		
		if(n1 == n2 && n2 == n3)
		{
			System.out.println("They are all equal");
		}
		else if(n1>=n2&&n2>=n3)
		{
			System.out.println("Biggest to smallest: "+ n1+","+n2+","+n3);
		}
		else if(n2>=n1&&n1>=n3)
		{
			System.out.println("Biggest to smallest: "+ n2+","+n1+","+n3);
		}
		else if(n2>=n3&&n3>=n1)
		{
			System.out.println("Biggest to smallest: "+ n2+","+n3+","+n1);
		}
		else if(n3>=n1&&n1>=n2)
		{
			System.out.println("Biggest to smallest: "+ n3+","+n1+","+n2);
		}
		else if(n3>=n2&&n2>=n1)
		{
			System.out.println("Biggest to smallest: "+ n3+","+n2+","+n1);
		}
		else if(n1>=n3&&n3>=n2)
		{
			System.out.println("Biggest to smallest: "+ n1+","+n3+","+n2);
		}
	}
	

}