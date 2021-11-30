package chess;

public class Rook implements Piece{
	
	private int player;
	public Rook(int player) {
		this.player=player;
	}
	
	public String getIcon() {
		if(this.player==1)
			return "1R";
		return "2R";
	}
	
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<7 & y<7 & ((xo==x & yo!=y)||(xo!=x & yo==y)))
			return true;
		return false;
	}
	
	public int getPlayer() {
		return this.player;
	}
}
