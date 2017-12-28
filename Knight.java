import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}
	
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		String thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;
		int counter5 = 0;
		int counter6 = 0;
		int counter7 = 0;
		int counter8 = 0;
		
		//The knight has a maximum of 8 possible destinations, but can reach
		//each destination by two separate routes (e.g. 1 left, 2 up versus
		//2 up, 1 left). For the sake of future-proofing when that could be
		//significant, the method checks the first "half" of the move, then
		//checks the second "half," only adding it as a move if both conditions
		//are satisfied.
		//==================================================================//
		
		//Checks by moving one left, then 2 up
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			TileNode xm1yp2 = ourBoard.getNodeFromCoords(x - 1, y + 2);
			
			if (xm1yp2 != null){
				if (!xm1yp2.getTeamOnTile().equals(thisTeam)
						|| !xm1yp2.isOccupied()){
					moves.add(xm1yp2);
					counter1++;
				}
			}
		}
		//Checks by moving 2 up, then one left
		if (ourBoard.getNodeFromCoords(x, y + 2) != null && counter1 == 0){
			TileNode xm1yp2 = ourBoard.getNodeFromCoords(x - 1, y + 2);
			
			if (xm1yp2 != null)
				if (!xm1yp2.getTeamOnTile().equals(thisTeam)
						|| !xm1yp2.isOccupied()){
					moves.add(xm1yp2);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 2, y) != null){
			TileNode xm2yp1 = ourBoard.getNodeFromCoords(x - 2, y + 1);
			
			if (xm2yp1 != null){
				if (!xm2yp1.getTeamOnTile().equals(thisTeam)
						|| !xm2yp1.isOccupied()){
					moves.add(xm2yp1);
					counter2++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y + 1) != null && counter2 == 0){
			TileNode xm2yp1 = ourBoard.getNodeFromCoords(x - 2, y + 1);
			
			if (xm2yp1 != null)
				if (!xm2yp1.getTeamOnTile().equals(thisTeam)
						|| !xm2yp1.isOccupied()){
					moves.add(xm2yp1);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 2, y) != null){
			TileNode xm2ym1 = ourBoard.getNodeFromCoords(x - 2, y - 1);
			
			if (xm2ym1 != null){
				if (!xm2ym1.getTeamOnTile().equals(thisTeam)
						|| !xm2ym1.isOccupied()){
					moves.add(xm2ym1);
					counter3++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 1) != null && counter3 == 0){
			TileNode xm2ym1 = ourBoard.getNodeFromCoords(x - 2, y - 1);
			
			if (xm2ym1 != null)
				if (!xm2ym1.getTeamOnTile().equals(thisTeam)
						|| !xm2ym1.isOccupied()){
					moves.add(xm2ym1);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			TileNode xm1ym2 = ourBoard.getNodeFromCoords(x - 1, y - 2);
			
			if (xm1ym2 != null){
				if (!xm1ym2.getTeamOnTile().equals(thisTeam)
						|| !xm1ym2.isOccupied()){
					moves.add(xm1ym2);
					counter4++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 2) != null && counter4 == 0){
			TileNode xm1ym2 = ourBoard.getNodeFromCoords(x - 1, y - 2);
			
			if (xm1ym2 != null)
				if (!xm1ym2.getTeamOnTile().equals(thisTeam)
						|| !xm1ym2.isOccupied()){
					moves.add(xm1ym2);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			TileNode xp1yp2 = ourBoard.getNodeFromCoords(x + 1, y + 2);
			
			if (xp1yp2 != null){
				if (!xp1yp2.getTeamOnTile().equals(thisTeam)
						|| !xp1yp2.isOccupied()){
					moves.add(xp1yp2);
					counter5++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y + 2) != null && counter5 == 0){
			TileNode xp1yp2 = ourBoard.getNodeFromCoords(x + 1, y + 2);
			
			if (xp1yp2 != null)
				if (!xp1yp2.getTeamOnTile().equals(thisTeam)
						|| !xp1yp2.isOccupied()){
					moves.add(xp1yp2);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 2, y) != null){
			TileNode xp2yp1 = ourBoard.getNodeFromCoords(x + 2, y + 1);
			
			if (xp2yp1 != null){
				if (!xp2yp1.getTeamOnTile().equals(thisTeam)
						|| !xp2yp1.isOccupied()){
					moves.add(xp2yp1);
					counter6++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y + 1) != null && counter6 == 0){
			TileNode xp2yp1 = ourBoard.getNodeFromCoords(x + 2, y + 1);
			
			if (xp2yp1 != null)
				if (!xp2yp1.getTeamOnTile().equals(thisTeam)
						|| !xp2yp1.isOccupied()){
					moves.add(xp2yp1);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 2, y) != null){
			TileNode xp2ym1 = ourBoard.getNodeFromCoords(x + 2, y - 1);
			
			if (xp2ym1 != null){
				if (!xp2ym1.getTeamOnTile().equals(thisTeam)
						|| !xp2ym1.isOccupied()){
					moves.add(xp2ym1);
					counter7++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 1) != null && counter7 == 0){
			TileNode xp2ym1 = ourBoard.getNodeFromCoords(x + 2, y - 1);
			
			if (xp2ym1 != null)
				if (!xp2ym1.getTeamOnTile().equals(thisTeam)
						|| !xp2ym1.isOccupied()){
					moves.add(xp2ym1);
				}
		}
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			TileNode xp1ym2 = ourBoard.getNodeFromCoords(x + 1, y - 2);
			
			if (xp1ym2 != null){
				if (!xp1ym2.getTeamOnTile().equals(thisTeam)
						|| !xp1ym2.isOccupied()){
					moves.add(xp1ym2);
					counter8++;
				}
			}
		}
		if (ourBoard.getNodeFromCoords(x, y - 2) != null && counter8 == 0){
			TileNode xp1ym2 = ourBoard.getNodeFromCoords(x + 1, y - 2);
			
			if (xp1ym2 != null)
				if (!xp1ym2.getTeamOnTile().equals(thisTeam)
						|| !xp1ym2.isOccupied()){
					moves.add(xp1ym2);
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
