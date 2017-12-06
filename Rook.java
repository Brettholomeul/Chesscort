import java.util.*;

public class Rook extends Piece {
	
	public Rook(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}

	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		int arbitraryCounter1 = 0;
		int arbitraryCounter2 = 0;
		int arbitraryCounter3 = 0;
		int arbitraryCounter4 = 0;
		
		for (int i = 1; i <= 8; i++){
			if (arbitraryCounter1 == 0){
				if (ourBoard.getNodeFromCoords(x + i, y) == null){
					arbitraryCounter1++;
				}
				else{
					moves.add(ourBoard.getNodeFromCoords(x + i, y));
				}
			}
			if (arbitraryCounter2 == 0){
				if (ourBoard.getNodeFromCoords(x - i, y) == null){
					arbitraryCounter2++;
				}
				else{
					moves.add(ourBoard.getNodeFromCoords(x - i, y));
				}
			}
			if(arbitraryCounter3 == 0){
				if (ourBoard.getNodeFromCoords(x, y + i) == null){
					arbitraryCounter3++;
				}
				else{
					moves.add(ourBoard.getNodeFromCoords(x, y + i));
				}
			}
			if (arbitraryCounter4 == 0){
				if (ourBoard.getNodeFromCoords(x, y - i) == null){
					arbitraryCounter4++;
				}
				else{
					moves.add(ourBoard.getNodeFromCoords(x, y - i));
				}
			}
		}
		
		return moves;
	}
	
	public void printMoves(){
		ArrayList<TileNode> moves = moveSet();
		for (TileNode n : moves){
			System.out.println(n.toString());
		}
	}
}
