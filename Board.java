import java.util.*;

public class Board implements Iterable<TileNode>{

	//Stores a list of all of the vertices in the board
	private List<TileNode> vlist;
	
	/**
	 * Initializes an empty list of TileNode objects
	 */
	public Board(){
		vlist = new ArrayList<TileNode>();
	}
	
	
	
	/**
	 * Adds vs as a neighbor of v1 and adds v1 as a neighbor of v2.
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

	public void addTileNode(String name) {
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
		TileNode node = new TileNode(name);
			
		//Add new vertex to list of vertices in Board
		vlist.add(node);
	}
}
