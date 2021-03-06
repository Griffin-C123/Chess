package chess;

public class Knight implements Piece{
	private int player;
	public Knight(int player) {
		this.player=player;
	}
	
	//Returns what the player will see as the icon
	public String getIcon() {
		return this.player+"H";
	}
	
	//Makes sure the piece won't go out of bounds and will follow the rules that the piece must follow
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<7 & y<7 & ((xo+1==x & yo+2==y)||(xo-1==x & yo+2==y)||(xo+2==x & yo+1==y)||(xo+2==x & yo-1==y)||(xo+1==x & yo-2==y)||(xo-1==x & yo-2==y)||(xo-2==x & yo-1==y)||(xo-2==x & yo+1==y)))
			return true;
		return false;
	}
	
	//returns the player using this piece
	public int getPlayer() {
		return this.player;
	}
}
