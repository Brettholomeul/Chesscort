import java.util.*;

public class Bishop extends Piece {
	
	public Bishop(int x, int y, Board ourBoard){
		super(x, y, ourBoard);
	}

	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		boolean thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		int arbitraryCounter1 = 0;
		int arbitraryCounter2 = 0;
		int arbitraryCounter3 = 0;
		int arbitraryCounter4 = 0;
		
		for (int i = 1; i <= 8; i++){
			if (arbitraryCounter1 == 0){
				if (ourBoard.getNodeFromCoords(x + i, y + i) == null){
					arbitraryCounter1++;
				}
				else{
					if (ourBoard.getNodeFromCoords(x + i, y + i).getTeamOnTile() == !thisTeam
							|| !ourBoard.getNodeFromCoords(x + i, y + i).isOccupied())
						moves.add(ourBoard.getNodeFromCoords(x + i, y + i));
				}
			}
			if (arbitraryCounter2 == 0){
				if (ourBoard.getNodeFromCoords(x - i, y - i) == null){
					arbitraryCounter2++;
				}
				else{
					if (ourBoard.getNodeFromCoords(x - i, y - i).getTeamOnTile() == !thisTeam
							|| !ourBoard.getNodeFromCoords(x - i, y - i).isOccupied())
						moves.add(ourBoard.getNodeFromCoords(x - i, y - i));
				}
			}
			if(arbitraryCounter3 == 0){
				if (ourBoard.getNodeFromCoords(x - i, y + i) == null){
					arbitraryCounter3++;
				}
				else{
					if (ourBoard.getNodeFromCoords(x - i, y + i).getTeamOnTile() == !thisTeam
							|| !ourBoard.getNodeFromCoords(x - i, y + i).isOccupied())
						moves.add(ourBoard.getNodeFromCoords(x - i, y + i));
				}
			}
			if (arbitraryCounter4 == 0){
				if (ourBoard.getNodeFromCoords(x + i, y - i) == null){
					arbitraryCounter4++;
				}
				else{
					if (ourBoard.getNodeFromCoords(x + i, y - i).getTeamOnTile() == !thisTeam
							|| !ourBoard.getNodeFromCoords(x + i, y - i).isOccupied())
						moves.add(ourBoard.getNodeFromCoords(x + i, y - i));
				}
			}
		}
		
		return moves;
	}
	
	public void printMoves() {
		ArrayList<TileNode> moves = moveSet();
		for (TileNode n : moves){
			System.out.println(n.toString());
		}
	}
}
