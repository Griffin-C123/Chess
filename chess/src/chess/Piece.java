package chess;

public interface Piece {

	public String getIcon();
	public boolean checkSpace(int xo, int yo, int x, int y);
	public int getPlayer();
	
}
