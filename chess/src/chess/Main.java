package chess;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//instantiate methods
		Scanner scan = new Scanner(System.in);
		Board board = new Board();
		
		//instantiate variables
		String cordsog, cordnew;
		boolean safeMove;
		int winPlayer;
		
		//Print game rules
		System.out.print("Chess Game\nTwo people are required to play.\nPlayer 1 is light and always goes first.\nEvery piece is shortened to a letter with your player number preceeding it.\nThis is a key.\nKing=K, Queen=Q, Rook=R, Bishop=B, Knight=H, Pawn=P\n\n");
		
		//While loop to Play game
		while(true) {
			//Prints Chess Board
			System.out.print(board.toString());
			
			//Uses the players inputs to move the piece if possible and if not will notify player to try again for player 1
			do {
				//Players input is the coordinates
				System.out.print("Player 1 Enter the coordinates for the piece you want to move.\n");
				cordsog = scan.nextLine();
				System.out.print("Enter the coordinates of where you want to move the piece.\n");
				cordnew = scan.nextLine();
				
				//calls board methods one returns if a move is safe the other sets the board looks at the board and determines if there is a check
				safeMove=board.checkMove(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew), 1);
				board.isCheck(1);
				
				//If else making sure that the piece is able to move restarts the while loop if false and not in check
				if(safeMove&board.getIsCheck()==0) 
					board.move(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew));
				else if(board.getIsCheck()==1)
					System.out.print("Your king is in check PROTECT IT!!!\n\n");
				else 
					System.out.print("Your piece cannot move there please choose another place.\n\n");
			}while((safeMove&board.getIsCheck()==0)!=true);
			
			//prints chess board with latest changes
			System.out.print(board.toString());
			
			//Uses the players inputs to move the piece if possible and if not will notify player to try again for player 1
			do {
				//Players input is the coordinates
				System.out.print("Player 2 Enter the coordinates for the piece you want to move.\n");
				cordsog = scan.nextLine();
				System.out.print("Enter the coordinates of where you want to move the piece.\n");
				cordnew = scan.nextLine();
				
				//calls board methods one returns if a move is safe the other sets the board looks at the board and determines if there is a check
				safeMove=board.checkMove(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew), 2);
				board.isCheck(2);
				
				//If else making sure that the piece is able to move restarts the while loop if false and not in check
				if(safeMove&board.getIsCheck()==0) 
					board.move(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew));
				else if(board.getIsCheck()==1)
					System.out.print("Your king is in check PROTECT IT!!!\n\n");
				else 
					System.out.print("Your piece cannot move there please choose another place.\n\n");
			}while((safeMove&board.getIsCheck()==0)!=true);
			
		}
	}
	
	//method to convert the String the player inputs into a x coordinate for the board class
	public static int xcord(String inp) {
		switch(inp.substring(0, 1).toLowerCase()) {
		case "a": return 0; 
		case "b": return 1; 
		case "c": return 2;
		case "d": return 3;
		case "e": return 4; 
		case "f": return 5; 
		case "g": return 6; 
		case "h": return 7;
		}
		return 0;
	}
	
	//method to convert the String the player inputs into a y coordinate for the board class
	public static int ycord(String inp) {
		switch(inp.substring(1)) {
		case "8": return 0; 
		case "7": return 1; 
		case "6": return 2;
		case "5": return 3;
		case "4": return 4; 
		case "3": return 5; 
		case "2": return 6; 
		case "1": return 7;
		}
		return 0;
	}
}
