package chess;

public class Board {

	//initializes private interface to store the chess pieces
	private Piece[][] board;
	
	//Initialize storage of king position for search function
	private int kingPosX = 0;
	private int kingPosY = 0;
	private boolean canMove = false;
	private boolean pieceCanMove = false;
	private int test =0;
	private int check=0;
	
	//Constructs the chess board placing all of the pieces
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
	
	//sets the can move variable to false to allow the returning of the correct statement when checkMoveRec is called
	public boolean checkMove(int xo, int yo, int x, int y, int player) {
		this.canMove=false;
		checkMoveRec(xo,yo,x,y,player);
		return this.canMove;
	}
	
	//Checks if a piece can move to a position changing the variable can move if possible
	void checkMoveRec(int xo, int yo, int x, int y, int player) {
		if((this.board[xo][yo].checkSpace(xo, yo, x, y))&player!=this.board[x][y].getPlayer()&(xo!=x||yo!=y)) {
			this.test++;
			checkMoveRec(xo,yo,x-(x-xo),y-(y-yo),player);
		}
		if((this.test>0&(xo==x&yo==y))||(this.board[xo][yo].getIcon().equals(player+"H")&this.board[xo][yo].checkSpace(xo, yo, x, y))&player!=this.board[x][y].getPlayer()) {
			this.canMove = true;
			this.test=0;
		}
	}
	
	//moves the piece to the given coordinates
	public void move(int xo, int yo, int x, int y) {
		this.board[x][y] = this.board[xo][yo];
		this.board[xo][yo] = new Blank();
	}
	
	//Iterates through every position on the board and checks if a piece can move/attack the king
	public void isCheck(int player) {
		this.check=0;
		searchKing(player);
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				checkMove(x, y, this.kingPosX, this.kingPosY, player);
				if(this.canMove) {
					this.check=1;
				}
			}
		}
	}
	
	//finds the king of the player given
	public void searchKing(int player) {
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				if(this.board[x][y].getIcon().equals(player+"K")) {
					this.kingPosX = x;
					this.kingPosY = y;
				}
			}
		}
	}
	
	//returns the boolean can move 
	public boolean getCanMove() {
		return this.canMove;
	}
	
	//returns the integer check
	public int getIsCheck() {
		return this.check;
	}
}
