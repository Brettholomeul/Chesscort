import java.util.*;

public class King extends Piece{

	public King(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}
	
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		boolean thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			if (ourBoard.getNodeFromCoords(x + 1, y).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x + 1, y).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x + 1, y));
		}
		
		if (ourBoard.getNodeFromCoords(x, y + 1) != null){
			if (ourBoard.getNodeFromCoords(x, y + 1).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x, y + 1).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x, y + 1));
		}
		
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			if (ourBoard.getNodeFromCoords(x - 1, y).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x - 1, y).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x - 1, y));
		}
		
		if (ourBoard.getNodeFromCoords(x, y - 1) != null){
			if (ourBoard.getNodeFromCoords(x, y - 1).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x, y - 1).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x, y - 1));
		}
		
		if (ourBoard.getNodeFromCoords(x + 1, y + 1) != null){
			if (ourBoard.getNodeFromCoords(x + 1, y + 1).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x + 1, y + 1).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x + 1, y + 1));
		}
	
		if (ourBoard.getNodeFromCoords(x - 1, y + 1) != null){
			if (ourBoard.getNodeFromCoords(x - 1, y + 1).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x - 1, y + 1).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x - 1, y + 1));
		}
		
		if (ourBoard.getNodeFromCoords(x + 1, y - 1) != null){
			if (ourBoard.getNodeFromCoords(x + 1, y - 1).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x + 1, y - 1).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x + 1, y - 1));
		}
		
		if (ourBoard.getNodeFromCoords(x - 1, y - 1) != null){
			if (ourBoard.getNodeFromCoords(x - 1, y - 1).getTeamOnTile() == !thisTeam
					|| !ourBoard.getNodeFromCoords(x - 1, y - 1).isOccupied())
				moves.add(ourBoard.getNodeFromCoords(x - 1, y - 1));
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
