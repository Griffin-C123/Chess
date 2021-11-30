package chess;

public class Board {

	//initializes private interface to store the chess pieces
	private Piece[][] board;
	
	public Board() {
		
		//instantiates the board variable
		this.board = new Piece[8][8];
		
		//Places Pawns and blank spots into the array
		for(int i = 0; i<8;i++) {
			this.board[i][1]= new Pawn(1);
			this.board[i][6]= new Pawn(2);
			this.board[i][2]= new Blank();
			this.board[i][3]= new Blank();
			this.board[i][4]= new Blank();
			this.board[i][5]= new Blank();
		}
		//Places the Rook into the array
		this.board[0][0] = new Rook(1);
		this.board[7][0] = new Rook(1);
		this.board[0][7] = new Rook(2);
		this.board[7][7] = new Rook(2);
		
		//Places the Knight into the array
		this.board[1][0] = new Knight(1);
		this.board[6][0] = new Knight(1);
		this.board[1][7] = new Knight(2);
		this.board[6][7] = new Knight(2);
		
		//Places the Bishop into the array
		this.board[2][0] = new Bishop(1);
		this.board[5][0] = new Bishop(1);
		this.board[2][7] = new Bishop(2);
		this.board[5][7] = new Bishop(2);
		
		//Places the Queen into the array
		this.board[3][0] = new Queen(1);
		this.board[3][7] = new Queen(2);
		
		//Place the King into the array
		this.board[4][0] = new King(1);
		this.board[4][7] = new King(2);
	}
	
	//Converts the array into a string so it can be printed
	public String toString() {
		String board="";
		int sideCount = 8;
		for(int i=0; i<8; i++) {
			board = board + sideCount +" ";
			for(int j=0; j<8; j++) {
				board = board + this.board[j][i].getIcon() +" ";
			}
			board += "\n";
			sideCount--;
		}
		board += "  A  B  C  D  E  F  G  H\n\n\n";
		return board;
	}
	
	//Checks if a piece on the same team is in the way
	public boolean checkMove(int xo, int yo, int x, int y, int player) {
		if((this.board[xo][yo].checkSpace(xo, yo, x, y))&player!=this.board[x][y].getPlayer()) 
			return true;
		return false;
	}
	
	//moves the piece to the given coordinates
	public void move(int xo, int yo, int x, int y) {
		this.board[x][y] = this.board[xo][yo];
		this.board[xo][yo] = new Blank();
	}
}
