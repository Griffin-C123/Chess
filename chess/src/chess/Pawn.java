package chess;

public class Pawn implements Piece{

	private int player;
	public Pawn(int player) {
		this.player=player;
	}
	
	public String getIcon() {
		if(this.player==1)
			return "1P";
		return "2P";
	}
	
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<=7 & y<=7 & (((xo == x &(yo+1 == y || yo+2 ==y)&this.player==1))||(xo == x &(yo-1 == y || yo-2 ==y)&this.player==2)))
			return true;
		return false;
	}
	
	public int getPlayer() {
		return this.player;
	}
}
