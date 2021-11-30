package chess;

public class Queen implements Piece{
	private int player;
	public Queen(int player) {
		this.player=player;
	}
	
	//Returns what the player will see as the icon
	public String getIcon() {
		if(this.player==1)
			return "1Q";
		return "2Q";
	}
	
	//Makes sure the piece won't go out of bounds and will follow the rules that the piece must follow
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<7 & y<7 & (((xo==x & yo!=y)||(xo!=x & yo==y))||(xo-x==yo-y)))
			return true;
		return false;
	}
	
	//returns the player using this piece
	public int getPlayer() {
		return this.player;
	}
}
