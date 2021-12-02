package chess;

public class Pawn implements Piece{

	private int player;
	public Pawn(int player) {
		this.player=player;
	}
	
	//Returns what the player will see as the icon
	public String getIcon() {
		return this.player+"P";
	}
	
	//Makes sure the piece won't go out of bounds and will follow the rules that the piece must follow
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<=7 & y<=7 & (((xo == x &(yo+1 == y || yo+2 ==y)&this.player==1))||(xo == x &(yo-1 == y || yo-2 ==y)&this.player==2)))
			return true;
		return false;
	}
	
	//returns the player using this piece
	public int getPlayer() {
		return this.player;
	}
}
