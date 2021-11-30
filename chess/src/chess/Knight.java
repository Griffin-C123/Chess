package chess;

public class Knight implements Piece{
	private int player;
	public Knight(int player) {
		this.player=player;
	}
	
	public String getIcon() {
		if(this.player==1)
			return "1H";
		return "2H";
	}
	
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<7 & y<7 & ((xo+1==x & yo+2==y)||(xo-1==x & yo+2==y)||(xo+2==x & yo+1==y)||(xo+2==x & yo-1==y)||(xo+1==x & yo-2==y)||(xo-1==x & yo-2==y)||(xo-2==x & yo-1==y)||(xo-2==x & yo+1==y)))
			return true;
		return false;
	}
	
	public int getPlayer() {
		return this.player;
	}
}
