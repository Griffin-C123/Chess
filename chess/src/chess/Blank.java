package chess;

public class Blank implements Piece{
	
	public Blank() {}

	//Returns what the player will see as the icon
	public String getIcon() {
		return "[]";
	}
	
	//always shows that pieces can move here
	public boolean checkSpace(int xo, int yo, int x, int y) {
		return true;
	}
	
	//returns a player of zero allowing all pieces to move onto the blank
	public int getPlayer() {
		return 0;
	}
}
