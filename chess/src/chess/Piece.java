package chess;

public interface Piece {

	//methods that all chess pieces must have
	
	//Outputs the piece icon like 1P
	public String getIcon();
	
	//makes sure the piece is moving how it is supposed to
	public boolean checkSpace(int xo, int yo, int x, int y);
	
	//Returns which team a piece is on
	public int getPlayer();
	
}
