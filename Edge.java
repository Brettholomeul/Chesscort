package ChessPack;

public class Edge implements Comparable<Edge> {
	private TileNode neighbor;
	
	public Edge(TileNode neighbor){
		this.neighbor = neighbor;
	}
	
	/**
	 * Returns the neighbor on the other end of the edge
	 * 
	 * @return the neighbor
	 */
	public TileNode getNeighborNode(){
		return neighbor;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Return the results of comparing this node's neighbor name to the other
	 * node's neighbor name. Allows List of Edges to be sorted.
	 * 
	 * @param otherNode Edge instance whose TileNode needs to be compared
	 * @return negative or positive value or zero
	 */
	/*
	public int compareTo(Edge otherNode){
		//Get name of the vertex at the end of the other neighbor
		String otherName = otherNode.getNeighborNode().getNodeName();
		
		//Compare
		return neighbor.getNodeName().compareToIgnoreCase(otherName);
	}
	*/
	
}
