import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}
	
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		boolean thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;
		int counter5 = 0;
		int counter6 = 0;
		int counter7 = 0;
		int counter8 = 0;
		
		//Checks by moving one left, then 2 up
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			if (ourBoard.getNodeFromCoords(x - 1, y + 2) != null){
				if (ourBoard.getNodeFromCoords(x - 1, y + 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 1, y + 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 1, y + 2));
					counter1++;
				}
			}
		}
		//Checks by moving 2 up, then one left
		if (ourBoard.getNodeFromCoords(x, y + 2) != null && counter1 == 0){
			if (ourBoard.getNodeFromCoords(x - 1, y + 2) != null)
				if (ourBoard.getNodeFromCoords(x - 1, y + 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 1, y + 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 1, y + 2));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 2, y) != null){
			if (ourBoard.getNodeFromCoords(x - 2, y + 1) != null){
				if (ourBoard.getNodeFromCoords(x - 2, y + 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 2, y + 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 2, y + 1));
					counter2++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y + 1) != null && counter2 == 0){
			if (ourBoard.getNodeFromCoords(x - 2, y + 1) != null)
				if (ourBoard.getNodeFromCoords(x - 2, y + 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 2, y + 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 2, y + 1));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 2, y) != null){
			if (ourBoard.getNodeFromCoords(x - 2, y - 1) != null){
				if (ourBoard.getNodeFromCoords(x - 2, y - 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 2, y - 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 2, y - 1));
					counter3++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 1) != null && counter3 == 0){
			if (ourBoard.getNodeFromCoords(x - 2, y - 1) != null)
				if (ourBoard.getNodeFromCoords(x - 2, y - 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 2, y - 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 2, y - 1));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			if (ourBoard.getNodeFromCoords(x - 1, y - 2) != null){
				if (ourBoard.getNodeFromCoords(x - 1, y - 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 1, y - 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 1, y - 2));
					counter4++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 2) != null && counter4 == 0){
			if (ourBoard.getNodeFromCoords(x - 1, y - 2) != null)
				if (ourBoard.getNodeFromCoords(x - 1, y - 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x - 1, y - 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x - 1, y - 2));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			if (ourBoard.getNodeFromCoords(x + 1, y + 2) != null){
				if (ourBoard.getNodeFromCoords(x + 1, y + 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 1, y + 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 1, y + 2));
					counter5++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y + 2) != null && counter5 == 0){
			if (ourBoard.getNodeFromCoords(x + 1, y + 2) != null)
				if (ourBoard.getNodeFromCoords(x + 1, y + 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 1, y + 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 1, y + 2));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 2, y) != null){
			if (ourBoard.getNodeFromCoords(x + 2, y + 1) != null){
				if (ourBoard.getNodeFromCoords(x + 2, y + 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 2, y + 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 2, y + 1));
					counter6++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y + 1) != null && counter6 == 0){
			if (ourBoard.getNodeFromCoords(x + 2, y + 1) != null)
				if (ourBoard.getNodeFromCoords(x + 2, y + 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 2, y + 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 2, y + 1));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 2, y) != null){
			if (ourBoard.getNodeFromCoords(x + 2, y - 1) != null){
				if (ourBoard.getNodeFromCoords(x + 2, y - 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 2, y - 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 2, y - 1));
					counter7++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 1) != null && counter7 == 0){
			if (ourBoard.getNodeFromCoords(x + 2, y - 1) != null)
				if (ourBoard.getNodeFromCoords(x + 2, y - 1).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 2, y - 1).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 2, y - 1));
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			if (ourBoard.getNodeFromCoords(x + 1, y - 2) != null){
				if (ourBoard.getNodeFromCoords(x + 1, y - 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 1, y - 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 1, y - 2));
					counter8++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 2) != null && counter8 == 0){
			if (ourBoard.getNodeFromCoords(x + 1, y - 2) != null)
				if (ourBoard.getNodeFromCoords(x + 1, y - 2).getTeamOnTile() == !thisTeam
						|| !ourBoard.getNodeFromCoords(x + 1, y - 2).isOccupied()){
					moves.add(ourBoard.getNodeFromCoords(x + 1, y - 2));
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
