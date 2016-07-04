
public class LargeNumber 
{
	//Make if with isNegative for plus and minus
	//Multiply digit is working
	
	private String myNumber;
	
	public LargeNumber(String number)
	{
		myNumber = number;
	}
	
	public String toString()
	{
		return myNumber;
	}
	
	public static LargeNumber multiplyDigit(LargeNumber other, int digit)
	{
		int carry = 0;
		LargeNumber result = new LargeNumber("");
		
		for(int i=0;i<other.toString().length();i++)
		{
			int total = 0;
			int digit1 = Integer.parseInt(other.toString().substring(other.toString().length()-(i+1), other.toString().length()-i));
			total = (digit1 * digit) + carry;
			System.out.println(total);
			
			if(total>9)
			{
				carry = total/10;
				System.out.println("Carrying" + carry);
				total = total % 10;
				System.out.println("tot" + total);
			}
			
			if(i == other.toString().length()-1)
			{
				result.myNumber = carry + "" + total + result.myNumber;
			}
			else
			{
				result.myNumber = total + result.myNumber;
			}	
			
			System.out.println(result.myNumber);
		}
		return result;
	}
	
	public LargeNumber plus(LargeNumber other)
	{
		//This code makes them pad to the same length
		if(myNumber.length()<other.myNumber.length())
		{
			myNumber = leftPad(myNumber,other.myNumber.length());
		}
		else if(myNumber.length()>other.myNumber.length())
		{
			other.myNumber = leftPad(other.myNumber,myNumber.length());
		}
		else
		{
			//System.out.println("They are the same length. No padding nessecary");
		}

		int carry = 0;
		
		LargeNumber results = new LargeNumber("");
		
		//Can use myNumber.length because their lengths should be the same by now
		for(int i = 0;i<myNumber.length();i++)
		{
			int total = 0;
			
			//This goes through each digit of the number from the right one at a time
			int digit1 = Integer.parseInt(myNumber.substring(myNumber.length()-(i+1), myNumber.length()-i));
			int digit2 = Integer.parseInt(other.myNumber.substring(other.myNumber.length()-(i+1), other.myNumber.length()-i));
			
			total = digit1 + digit2 + carry;
			
			//If the total digits is greater than 9
			//Make sure you carry and get the correct digit to write down
			//If you don't need to carry, make carry 0 for the next loop
			
			if(total>9)
			{
				carry = 1;
				total = total - 10;
			}
			else
			{
				carry = 0;
			}
			
			//This adds the final digit to the end of the results string
			results.myNumber = total + results.myNumber;
		}
		
		//If you need to carry from the last calculation add it to the beginning of the number
		if(carry != 0)
		{
			results.myNumber = carry + results.myNumber;
		}
		
		return LargeNumber.cleanZeros(results);
	}
	
	public LargeNumber subtract(LargeNumber other)
	{
		//This is used at the end to determine if the answer is negative
		boolean answerNegative;
		
		String n1 = myNumber;
		String n2 = other.toString();
		
		//If the first number is not bigger
		if(!isLarger(myNumber,other.toString()))
		{
			answerNegative = true;
			
			String placeholder = myNumber;
			n1 = other.toString();
			n2 = placeholder;
		}	 
		else
		{
			answerNegative = false;
		}
			
		
		//This code makes them pad to the same length
		if(n1.length()<n2.length())
		{
			n1 = leftPad(n1,n2.length());
		}
		else if(n1.length()>n2.length())
		{
			n2 = leftPad(n2,n1.length());
		}
		else
		{
			//System.out.println("They are the same length. No padding nessecary");
		}

		int borrow = 0;
				
		LargeNumber results = new LargeNumber("");
				
		//Can use myNumber.length because their lengths should be the same by now
		for(int i = 0;i<myNumber.length();i++)
		{					
				
			int total = 0;
					
			//This goes through each digit of the number from the right one at a time
			int digit1 = Integer.parseInt(n1.substring(n1.length()-(i+1), n1.length()-i));
			int digit2 = Integer.parseInt(n2.substring(n2.length()-(i+1), n2.length()-i));
					
					
			if((digit1-borrow)-digit2<0)					
			{
				borrow = 1;
				total = (digit1+10)-digit2;
			}
			else
			{
				total = (digit1-borrow)-digit2;
				borrow = 0;
			}
			
			//This adds the final digit to the end of the results string
			results.myNumber = total + results.myNumber;
		}
		if(!answerNegative)
		{
			return LargeNumber.cleanZeros(results);
		}
		else
		{
			results.myNumber =  "-" + results.myNumber;
			return LargeNumber.cleanZeros(results);
		}
	}
	
	public static boolean isLarger(String myNumber, String otherNumber)
	{
		//need to make same size otherwise i to get furthest left values fails
		if(myNumber.length()<otherNumber.length())
		{
			myNumber = leftPad(myNumber,otherNumber.length());
		}
		else if(myNumber.length()>otherNumber.length())
		{
			otherNumber = leftPad(otherNumber,myNumber.length());
		}
		else
		{
			//System.out.println("They are the same length. No padding nessecary");
		}
		
		for(int i = 0;i<myNumber.length()-1;i++)
		{
			if(Integer.parseInt(myNumber.substring(i,i+1))>Integer.parseInt(otherNumber.substring(i,i+1)))
			{
				return true;
			}
			else if(Integer.parseInt(myNumber.substring(i,i+1))<Integer.parseInt(otherNumber.substring(i,i+1)))
			{
				return false;
			}
		}

		System.out.println("They are the same value");
		return false;
	}
	
	
	private static String leftPad(String number, int padSize)
	{
		
		int difference = padSize-number.length();
		
		if(number.length()<=padSize)
		{
			for(int i = 0;i<difference;i++)
			{
				number = "0" + number;
			}
			return number;
		}
		return "This should never happen";
	}
	
	private static LargeNumber cleanZeros(LargeNumber number)

	{
		LargeNumber result = new LargeNumber(number.toString());
		
		//This stores where the zeros end
		int startIndex = 0;
		
		//This makes sure the function doesn't delete minus sides
		if(number.toString().substring(0,1).equals("-"))
		{
			startIndex = 1;
		}
		
		//This is -2 so that is doesn't delete the last zero if the last number is a zero
		for(int i = 1;i<number.toString().length()-2;i++)
		{
			if(number.toString().substring(i, i+1).equals("0"))
			{
				startIndex++;
			}
			else
			{
				break;
			}
		}
		
		result.myNumber = result.myNumber.substring(startIndex);
		return result;
	}
	
}
