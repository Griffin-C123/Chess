package chess;

public class King implements Piece{
	
	private int player;
	public King(int player) {
		this.player=player;
	}
	
	public String getIcon() {
		if(this.player==1)
			return "1K";
		return "2K";
	}
	
	public boolean checkSpace(int xo, int yo, int x, int y) {
		if(x<7 & y<7 & ((xo == x &(yo == y+1 || yo ==y-1))||(yo == y &(xo == x+1 || xo ==x+2))))
			return true;
		return false;
	}
	
	public int getPlayer() {
		return this.player;
	}
	
}
