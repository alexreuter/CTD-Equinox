
public class Main 
{
	public static void main(String args[])
	{
		Quack bob = new Quack();
		((Quack) bob).enqueue("1");
		((Quack) bob).enqueue("2");
		((Quack) bob).enqueue("3");
		((Quack) bob).enqueue("4");
		((Quack) bob).enqueue("5");
		System.out.println(bob);
		System.out.println(bob.frontIndex);
		System.out.println(bob.endIndex);
		System.out.println(bob.front());
		System.out.println(((Quack) bob).dequeue());
		System.out.println(bob);
		System.out.println(bob.pop());
		System.out.println(bob);
	}
}
