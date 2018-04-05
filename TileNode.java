package ChessPack;
import java.util.*;

public class TileNode implements Comparable<TileNode> {
	private List<Edge> neighbors;
	private boolean occupied;
	private String teamOnTile;
	
	private int xCoord;
	private int yCoord;
	
	
	/**
	 * Constructs a new tile node and an empty list of its neighbors
	 * @param name - a unique name for a tile
	 */
	public TileNode(int x, int y){
		neighbors = new ArrayList<Edge>();
		xCoord = x;
		yCoord = y;
	}
	
	
	
	/**
	 * Gives a list of the neighbors of the node
	 * 
	 * @return the neighbors of this TileNode
	 */
	public List<Edge> getNeighbors(){
		return neighbors;
	}
	
	
	/**
	 * Sets the tile to its occupation state and team
	 * 
	 */
	public void setOccupied(boolean occupy, String team){
		occupied = occupy;
		teamOnTile = team;
	}
	
	/**
	 * Gives the occupation state of this tile
	 * 
	 * @return boolean value
	 */
	public boolean isOccupied(){
		return occupied;
	}
	
	public void setTeamOnTile(String team){
		teamOnTile = team;
	}
	/*
	 * Returns what team is occupying the tile
	 */
	public String getTeamOnTile(){
		return teamOnTile;
	}
	
	public void setX(int x){
		this.xCoord = x;
	}
	
	public int getX(){
		return xCoord;
	}
	
	public void setY(int y){
		this.yCoord = y;
	}
	
	public int getY(){
		return yCoord;
	}
	
	/**
	 * Adds a new neighbor
	 * 
	 * @param neighbor neighbor an adjacent node
	 */
	public void addEdge(TileNode neighbor){
		//Creates a new edge from this vertex to another vertex
		Edge thisEdge = new Edge(neighbor);
		
		//Adds edge to vertex's list of neighbors
		neighbors.add(thisEdge);
	}


	@Override
	public int compareTo(TileNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/**
	 * Returns the TileNode associated with name that is a neighbor of the 
	 * current node
	 * 
	 * @param neighborName name of the neighbor
	 * @return the TileNode associated with name that is neighbor of this node
	 * @throws NotNeighborException if neighborName is not a neighbor
	 */
	/*
	public TileNode getNeighbor(String neighborName) throws NotNeighborException{
		Edge neighborEdge = getNeighborEdge(neighborName);
		
		if (getNeighborEdge(neighborName) == null){
			throw new NotNeighborException();
		}
		
		return neighborEdge.getNeighborNode();
	}
	*/
	
	
	/**
	 *Returns an iterator that can be used to find neighbor names of this TileNode
	 *
	 * @return iterator of String node labels
	 */
	/*
	public Iterator<String> getNeighborNames(){
		//Create a list to store neighbor names
		List<String> neighborNames = new ArrayList<String>();
		
		//Add all of this vertex's neighbors to this list
		for (int i = 0; i < neighbors.size(); i++){
			String name = neighbors.get(i).getNeighborNode().getNodeName();
			neighborNames.add(name);
		}
		
		//Return an iterator that goes through this vertex's list of neighbors
		return neighborNames.iterator();
	}
	*/
	
	
	/**
	 * Returns true if this node name is a neighbor of current node
	 * 
	 * @param neighborName name of neighbor
	 * @return true if the node is an adjacent neighbor
	 */
	/*
	public boolean isNeighbor(String neighborName){
		if (getNeighborEdge(neighborName) == null){
			return false;
		}
		
		return true;
	}
	*/
	
	/*
	private Edge getNeighborEdge(String neighborName){
		//Go through this vertex's list of neighbor vertices
		for (int i = 0; i < neighbors.size(); i++){
			//If the current neighbor in the list of neighbors points to the 
			//desired neighbor vertex, return this neighbor edge
			Edge neighbor = neighbors.get(i);
			String otherNeighborName = neighbor.getNeighborNode().getNodeName();
			if (otherNeighborName.equals(neighborName)){
				return neighbor;
			}
		}
		
		//If no matching neighbor is found, return null
		return null;
	}
	*/
}
