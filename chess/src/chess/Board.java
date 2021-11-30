package chess;

public class Board {

	private Piece[][] board;
	private int score1, score2=0;
	public Board() {
		this.board = new Piece[8][8];
		//Places Pawns and blank spots
		for(int i = 0; i<8;i++) {
			this.board[i][1]= new Pawn(1);
			this.board[i][6]= new Pawn(2);
			this.board[i][2]= new Blank();
			this.board[i][3]= new Blank();
			this.board[i][4]= new Blank();
			this.board[i][5]= new Blank();
		}
		//Places the Rook
		this.board[0][0] = new Rook(1);
		this.board[7][0] = new Rook(1);
		this.board[0][7] = new Rook(2);
		this.board[7][7] = new Rook(2);
		
		//Places the Knight
		this.board[1][0] = new Knight(1);
		this.board[6][0] = new Knight(1);
		this.board[1][7] = new Knight(2);
		this.board[6][7] = new Knight(2);
		
		//Places the Bishop
		this.board[2][0] = new Bishop(1);
		this.board[5][0] = new Bishop(1);
		this.board[2][7] = new Bishop(2);
		this.board[5][7] = new Bishop(2);
		
		//Places the Queen
		this.board[3][0] = new Queen(1);
		this.board[3][7] = new Queen(2);
		
		//Place the King
		this.board[4][0] = new King(1);
		this.board[4][7] = new King(2);
	}
	
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
	
	public boolean checkMove(int xo, int yo, int x, int y) {
		if((this.board[xo][yo].checkSpace(xo, yo, x, y))&this.board[xo][yo].getPlayer()!=this.board[x][y].getPlayer()) 
			return true;
		return false;
	}
	
	public void move(int xo, int yo, int x, int y) {
		this.board[x][y] = this.board[xo][yo];
		this.board[xo][yo] = new Blank();
	}
}
