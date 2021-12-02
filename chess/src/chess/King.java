package chess;

public class King implements Piece{
	
	private int player;
	
	public King() {}
	
	public King(int player) {
		this.player=player;
	}
	
	//Returns what the player will see as the icon
	public String getIcon() {
		return this.player+"K";
	}
	
	//Makes sure the piece won't go out of bounds and will follow the rules that the piece must follow
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<7 & y<7 & ((xo == x &(yo == y+1 || yo ==y-1))||(yo == y &(xo == x+1 || xo ==x+2))))
			return true;
		return false;
	}
	
	//returns the player using this piece
	public int getPlayer() {
		return this.player;
	}
	
}
