import java.util.*;

public abstract class Piece {
	public int coordX, coordY;
	Board ourBoard;
	
	public Piece(int x, int y, Board ourBoard){
		coordX = x;
		coordY = y;
		this.ourBoard = ourBoard;
	}
	
	public int getX(){
		return coordX;
	}
	
	public int getY(){
		return coordY;
	}
	
	public abstract void printMoves();
}
