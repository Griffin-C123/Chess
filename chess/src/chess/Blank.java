package chess;

public class Blank implements Piece{
	
	public Blank() {}

	public String getIcon() {
		return "[]";
	}
	
	public boolean checkSpace(int xo, int yo, int x, int y) {
		return true;
	}
	
	public int getPlayer() {
		return 0;
	}
}
