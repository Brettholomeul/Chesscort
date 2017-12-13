import java.util.*;

public class Board implements Iterable<TileNode>{

	//Stores a list of all of the vertices in the board
	private List<TileNode> vlist;
	
	//Stores lists of the pieces for each side
	private ArrayList<Piece> blackPieces;
	private ArrayList<Piece> whitePieces;
	
	private Stack<Piece> removedBlack;
	private Stack<Piece> removedWhite;
	
	/**
	 * Initializes an empty list of TileNode objects
	 */
	public Board(){
		vlist = new ArrayList<TileNode>();
		
		removedBlack = new Stack<Piece>();
		removedWhite = new Stack<Piece>();
	}
	
	/**
	 * Adds v2 as a neighbor of v1 and adds v1 as a neighbor of v2.
	 * 
	 * @param v1name The name of the first vertex of this edge
	 * @param v2name The name of the second vertex of this edge
	 * @throws IllegalArgumentException if the names are the same
	 */
	public void addEdge(String v1name, String v2name) throws IllegalArgumentException{
		//Vertices cannot be direct neighbors of themselves. If the two vertices
		//listed are the same, throw IllegalArgumentException
		if (v1name.equals(v2name)) throw new IllegalArgumentException();
		
		//Get the TileNode objects/vertices from the given names
		TileNode node1 = getNodeFromName(v1name);
		TileNode node2 = getNodeFromName(v2name);
		
		//Add vertices as neighbors of each other. Dual setting required to
		//make is an undirected graph.
		node1.addEdge(node2);
		node2.addEdge(node1);
	}
	
	/**
	 * REturn an iterator through all nodes in the Board
	 * 
	 * @return iterator through all nodes in alphabetical order
	 */
	public Iterator<TileNode> iterator() {
		return vlist.iterator();
	}
	
	/**
	 * @param name Name corresponding to node to be returned
	 * @return TileNode associated with name, null if no such node exists
	 */
	public TileNode getNodeFromName(String name){
		for (TileNode n : vlist){
			if (n.getNodeName().equalsIgnoreCase(name))
				return n;
		}
		return null;
	}

	
	/*
	 * Adds a tile node to board list
	 */
	public void addTileNode(String name, int x, int y) {
		//Create an iterator for the list of all vertices in the board
		Iterator<TileNode> itr = iterator();
				
		//For every vertex in the board, check to see if the vertex we are
		//adding is a duplicate. If so, exit method without adding vertex.
		while(itr.hasNext()){
			if (itr.next().getNodeName().equals(name)){
				return;
			}
		}
				
		//If no duplicates, create new TileNode from given name
		TileNode node = new TileNode(name, x, y);
			
		//Add new vertex to list of vertices in Board
		vlist.add(node);
	}
	
	
	/*
	 * Gets a tile node given the coordinates
	 */
	public TileNode getNodeFromCoords(int x, int y){
		for (TileNode n : vlist){
			if ((n.getX() == x) && (n.getY() == y)){
				return n;
			}
		}
		return null;
	}
	
	
	/*
	 * Gets a piece from the white team list based on coordinates
	 */
	public Piece getWhitePieceFromCoords(int x, int y){
		for (Piece p : whitePieces){
			if ((p.getX() == x) && (p.getY() == y)){
				return p;
			}
		}
		return null;
	}
	
	
	/*
	 * Gets a piece from the black team list based on coordinates
	 */
	public Piece getBlackPieceFromCoords(int x, int y){
		for (Piece p : blackPieces){
			if ((p.getX() == x) && (p.getY() == y)){
				return p;
			}
		}
		return null;
	}
	
	/*
	 * Adds the pieces to the board and to their respective team lists
	 * and sets their tiles to occupied
	 */
	public void addPiece(String team, String pieceName, int x, int y){
		if (whitePieces == null)
			whitePieces = new ArrayList<Piece>();
		if (blackPieces == null)
			blackPieces = new ArrayList<Piece>();
		
		if (team.equals("white")){
			if (pieceName.equals("rook")){
				Rook rook = new Rook(x, y, this);
				
				whitePieces.add(rook);
				
				getNodeFromCoords(x, y).setOccupied(true, true);
			}
			else if (pieceName.equals("pawn")){
				
			}
			else if (pieceName.equals("king")){
				King king = new King(x, y, this);
				
				whitePieces.add(king);
				
				getNodeFromCoords(x, y).setOccupied(true, true);
			}
			else if (pieceName.equals("queen")){
				Queen queen = new Queen(x, y, this);
				
				whitePieces.add(queen);
				
				getNodeFromCoords(x, y).setOccupied(true, true);
			}
			else if (pieceName.equals("bishop")){
				Bishop bishop = new Bishop(x, y, this);
				
				whitePieces.add(bishop);
				
				getNodeFromCoords(x, y).setOccupied(true, true);
			}
			else if (pieceName.equals("knight")){
				Knight knight = new Knight(x, y, this);
				
				whitePieces.add(knight);
				
				getNodeFromCoords(x, y).setOccupied(true, true);
			}
		}
		else if (team.equals("black")){
			if (pieceName.equals("rook")){
				Rook rook = new Rook(x, y, this);
				
				blackPieces.add(rook);
				
				getNodeFromCoords(x, y).setOccupied(true, false);
			}
			else if (pieceName.equals("pawn")){
				
			}
			else if (pieceName.equals("king")){
				King king = new King(x, y, this);
				
				blackPieces.add(king);
				
				getNodeFromCoords(x, y).setOccupied(true, false);
			}
			else if (pieceName.equals("queen")){
				Queen queen = new Queen(x, y, this);
				
				blackPieces.add(queen);
				
				getNodeFromCoords(x, y).setOccupied(true, false);
			}
			else if (pieceName.equals("bishop")){
				Bishop bishop = new Bishop(x, y, this);
				
				blackPieces.add(bishop);
				
				getNodeFromCoords(x, y).setOccupied(true, false);
			}
			else if (pieceName.equals("knight")){
				Knight knight = new Knight(x, y, this);
				
				blackPieces.add(knight);
				
				getNodeFromCoords(x, y).setOccupied(true, false);
			}
		}
	}
	
	
	/*
	 * Moves a piece from its starting coordinates to its ending coordinates
	 */
	public void movePieceAtCoords(int xStart, int yStart, int xEnd, int yEnd, boolean team){

//		if (removedBlack == null)
//			removedBlack = new Stack<Piece>();
//		if (removedWhite == null)
//			removedWhite = new Stack<Piece>();
		
		if (team == true){
			Piece p = getWhitePieceFromCoords(xStart, yStart);
			
			ArrayList<TileNode> moveSet = p.moveSet();
			
			if (moveSet.contains(getNodeFromCoords(xEnd, yEnd))){
				p.setX(xEnd);
				p.setY(yEnd);
				
				if (getNodeFromCoords(xEnd, yEnd).getTeamOnTile() == !team){
					Piece removed = getBlackPieceFromCoords(xEnd, yEnd);
					removedBlack.push(removed);
					
					blackPieces.remove(removed);
				}
			}
		}
		else if (team == false){
			Piece p = getBlackPieceFromCoords(xStart, yStart);
			
			ArrayList<TileNode> moveSet = p.moveSet();
			if (moveSet.contains(getNodeFromCoords(xEnd, yEnd))){
				p.setX(xEnd);
				p.setY(yEnd);
				
				if (getNodeFromCoords(xEnd, yEnd).getTeamOnTile() == !team){
					Piece removed = getWhitePieceFromCoords(xEnd, yEnd);
					removedWhite.push(removed);
					
					whitePieces.remove(removed);
				}
			}
		}
	}
	
	
	public ArrayList<Piece> getBlackPieces(){
		return blackPieces;
	}
	
	public ArrayList<Piece> getWhitePieces(){
		return whitePieces;
	}
	
	public Stack<Piece> getRemovedBlack(){
		return removedBlack;
	}
	
	public Stack<Piece> getRemovedWhite(){
		return removedWhite;
	}
}
