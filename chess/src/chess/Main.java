package chess;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Board board = new Board();
		
		String cordsog, cordnew;
		//Print game rules
		System.out.print("Chess Game\nTwo people are required to play.\nPlayer 1 is light and always goes first.\nEvery piece is shortened to a letter with your player number preceeding it.\nThis is a key.\nKing=K, Queen=Q, Rook=R, Bishop=B, Knight=H, Pawn=P\n\n");
		
		//While loop to Play game
		while(true) {
			//Prints Chess Board
			System.out.print(board.toString());
			
			//Prints 
			do {
			System.out.print("Player 1 Enter the cordinates for the piece you want to move.\n");
			cordsog = scan.nextLine();
			System.out.print("Enter the cordinates of where you want to move the piece.\n");
			cordnew = scan.nextLine();
			if(board.checkMove(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew))) {
				board.move(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew));
			}
			else {
				System.out.print("Your piece cannot move there please choose another place.\n\n");
			}
			}while(board.checkMove(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew))!=true);
			
			System.out.print(board.toString());
			
			do {
				System.out.print("Player 2 Enter the cordinates for the piece you want to move.\n");
				cordsog = scan.nextLine();
				System.out.print("Enter the cordinates of where you want to move the piece.\n");
				cordnew = scan.nextLine();
				if(board.checkMove(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew))) {
					board.move(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew));
				}
				else {
					System.out.print("Your piece cannot move there please choose another place.\n\n");
				}
				}while(board.checkMove(xcord(cordsog), ycord(cordsog), xcord(cordnew), ycord(cordnew))!=true);
			
		}
	}
	
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