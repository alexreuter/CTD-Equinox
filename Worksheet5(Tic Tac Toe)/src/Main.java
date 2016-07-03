import java.util.Scanner;


public class Main {
	public static final String[] playerSymbol = { "O", "X" };
	public static final String[] playerType = { "Computer", "Human" };
	
	public static void main(String[] args) 
	{
		String[] board = new String[9];
		int player = 0;
		
		//This gets rid of the initial board full of nulls
		for(int i=0;i<9;i++)
		{
			board[i] = " ";
		}
		
		
		while(getBoardState(board) != 3 && getBoardState(board) != 2 && getBoardState(board) != 1)
		{
			clearScreen();
			printBoard(board);
			int move = getMove(board,player);
			
			while(!isLegalMove(board,move))
			{
				System.out.println(move);
				System.out.println(playerType[player]);
				System.out.println("Your move is illegal");
				move = getMove(board,player);
			}
			board[move] = playerSymbol[player];
			player = switchPlayer(player);
		}
		
		clearScreen();
		printBoard(board);
		if(getBoardState(board) == 1)
		{
			System.out.println("Xs Won!");
		}
		else if(getBoardState(board) == 2)
		{
			System.out.println("Os Won!");
		}
		else
		{
			System.out.println("No-one won!");
		}
	}
	
	public static void printRow(String[] board,int startSquare)
	{
		System.out.print(board[startSquare]);
		System.out.print("|");
		System.out.print(board[startSquare + 1]);
		System.out.print("|");
		System.out.print(board[startSquare + 2]);
		System.out.println("");
	}
	
	public static void printBoard(String[] board)
	{
		
		printRow(board,0);
		System.out.println("-----");
		printRow(board,3);
		System.out.println("-----");
		printRow(board,6);
		System.out.println("");
	}
	
	 public static int getBoardState(String[] board)
	 {
		 //ALL HORIZONTAL WINS
		 for(int i = 0;i<7;i+=3)
		 {
				 if(board[i].equals("X") && board[i+1].equals("X") && board[i+2].equals("X"))
				 {
					 return 1;
				 }
				 
				 if(board[i].equals("O") && board[i+1].equals("O") && board[i+2].equals("O"))
				 {
					 return 2;
				 }
		 }
		 
		//ALL VERTICAL WINS
		 for(int i = 0;i<3;i++)
		 {
				 if(board[i].equals("X") && board[i+3].equals("X") && board[i+6].equals("X"))
				 {
					 return 1;
				 }
				 
				 if(board[i].equals("O") && board[i+3].equals("O") && board[i+6].equals("O"))
				 {
					 return 2;
				 }
		 }
		 
		 //DIAGONALS
		 if(board[0].equals("X") && board[4].equals("X") && board[8].equals("X"))
		 {
			 return 1;
		 }
		 
		 if(board[0].equals("O") && board[4].equals("O") && board[8].equals("O"))
		 {
			 return 2;
		 }
		 
		 if(board[2].equals("X") && board[4].equals("X") && board[6].equals("X"))
		 {
			 return 1;
		 }
		 
		 if(board[2].equals("O") && board[4].equals("O") && board[6].equals("O"))
		 {
			 return 2;
		 }
		 
		 for(int i=0;i<9;i++)
		 {
			 if(board[i].equals(" ") || board[i].equals(null))
			 {
				 return 4;
			 }
		 }
		 return 3;
	 }
	 
	 public static int getHumanMove()
	 {
		 System.out.println("Human what is your move?");
		 Scanner scan = new Scanner(System.in);
	     return scan.nextInt();
	 }
	 
	 public static int getComputerMove(String[] board,int player)
	 {
		 
		 if(canWin(board,player) != -1)
		 {
			return canWin(board,player);
		 }
		 //This runs canWin as if you are the other player. Effectively showing the computer where to block
		 else if(canWin(board,switchPlayer(player)) != -1)
		 {
			return canWin(board,switchPlayer(player)); 
		 }
		 else
		 {
			 int random = (int)(Math.random()*9);
			 
			 //This makes sure the random move is legal,avoiding printing out illegal to the screen
			 while(!isLegalMove(board,random))
			 {
				 random = (int)(Math.random()*9);
			 }
			 
			 return random;
			 
		 }
		 
	 }
	 
	 public static int getMove(String[] board, int player)
	 {
		 if(player == 0)
		 {
			 if(playerType[0].equals("Human"))
			 {
				 return getHumanMove();
			 }
			 else
			 {
				 return getComputerMove(board,player);
			 }
		 }
		 else
		 {
			 if(playerType[1].equals("Human"))
			 {
				 return getHumanMove();
			 }
			 else
			 {
				 return getComputerMove(board,player);
			 } 
		 }
	 }
	 
	 public static boolean isLegalMove(String[] board, int move)
	 {
		 if(move>8||move<0)
		 {
			 return false;
		 }
		 else if(board[move].equals(" "))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public static int switchPlayer(int player)
	 {
		 if(player == 0)
		 {
			 player = 1;
		 }
		 else
		 {
			 player = 0;
		 }
		 return player;
	 }
	 
	 public static int canWin(String [] board,int player)

	 {
		 String myValue;
		 String otherValue;
		 int Return = -1;
		
		 
		 if (playerSymbol[player].equals("X"))
		 {
			 myValue = "X"; // The computer is X
		 	 otherValue = "O"; // The other player is O
		 }
		 else
		 {
			 myValue = "O"; // The computer is O
			 otherValue = "X"; // The other player is X
		 }
		 
		 //HORIZONTAL CHECKS
		 for(int i = 0;i<7;i+=3)
		 {
			 if(board[i].equals(myValue) && board[i+1].equals(myValue))
			 {
				 if(isLegalMove(board,i+2))
				 {
					 Return = i+2;
				 } 
			 }
			 if(board[i+1].equals(myValue) && board[i+2].equals(myValue))
			 {
				 if(isLegalMove(board,i))
				 {
					 Return = i;
				 } 
			 }
			 if(board[i].equals(myValue) && board[i+2].equals(myValue))
			 {
				 if(isLegalMove(board,i+1))
				 {
					 Return = i+1;
				 } 
			 }
		 }
		 
		 //ALL VERTICAL CASES
		 for(int i = 0;i<3;i++)
		 {
			 if(board[i].equals(myValue) && board[i+3].equals(myValue))
			 {
				 if(isLegalMove(board,i+6))
				 {
					 Return = i+6;
				 } 
			 }
			 if(board[i].equals(myValue) && board[i+6].equals(myValue))
			 {
				 if(isLegalMove(board,i+3))
				 {
					 Return = i+3;
				 } 
			 }
			 if(board[i+3].equals(myValue) && board[i+6].equals(myValue))
			 {
				 if(isLegalMove(board,i))
				 {
					 Return = i;
				 } 
			 }
		 }
		 
		 //LEFT TO RIGHT DIAGONAL
		 
		 if(board[0].equals(myValue) && board[4].equals(myValue))
		 {
			 if(isLegalMove(board,8))
			 {
				 Return = 8;
			 } 
		 }
		 if(board[0].equals(myValue) && board[8].equals(myValue))
		 {
			 if(isLegalMove(board,4))
			 {
				 Return = 4;
			 } 
		 }
		 if(board[4].equals(myValue) && board[8].equals(myValue))
		 {
			 if(isLegalMove(board,0))
			 {
				 Return = 0;
			 } 
		 }
		 
		 //RIGHT TO LEFT DIAGONAL
		 
		 if(board[2].equals(myValue) && board[4].equals(myValue))
		 {
			 if(isLegalMove(board,6))
			 {
				 Return = 6;
			 } 
		 }
		 if(board[4].equals(myValue) && board[6].equals(myValue))
		 {
			 if(isLegalMove(board,2))
			 {
				 Return = 2;
			 } 
		 }
		 if(board[6].equals(myValue) && board[2].equals(myValue))
		 {
			 if(isLegalMove(board,4))
			 {
				 Return = 4;
			 } 
		 }
		 
		 
		 //This means the user cannot win
		 if(Return == -1)
		 {
			 return -1;
		 }
		 else
		 {
			return Return; 
		 }
	 }
	 
	 public static void clearScreen()
	 {
		 	//This clears the console
			for(int i = 0;i<30;i++)
			{
				System.out.print ('\n');
			}
	 }
}
