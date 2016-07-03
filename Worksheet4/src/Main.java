
public class Main {
	
	public static void main(String[] args) 
	{
		String[] board = new String[9];
	
		board[0] = "O";
		board[1] = "X";
		board[2] = "O";
		board[3] = "X";
		board[4] = "X";
		board[5] = "O";
		board[6] = "O";
		board[7] = "O";
		board[8] = "X";
		
		printBoard(board);

		System.out.println(getBoardState(board));
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

}
