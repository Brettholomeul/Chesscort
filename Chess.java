import java.io.*;
import java.util.*;

public class Chess {

	public static void main(String[] args) 
			throws FileNotFoundException, InvalidAreaFileException {
		//If incorrect number of arguments, exit
		if (args.length != 1){
			System.out.println("Usage: java main area.txt");
			System.exit(1);
		}
		
		//Board file is the text document in the 0th index command line argument
		String areaFilename = args[0];
		
		//Creates the board based on the file
		Board board = Chess.createBoardFromAreaFile(areaFilename);
		
		System.out.println(board.getNodeFromName("a8").getNeighbors().toString());
	}

	/**
	 * Builds the Board from the area data file.
	 * 
	 * @param areaFilename The name of a file that contains info for creating
	 * an undirected graph. Vertex names and edge pairs.
	 * @return A Board constructed according to the file input
	 * @throws InvalidAreaFileException if the file does not correspond to a board
	 */
	public static Board createBoardFromAreaFile(String areaFilename) 
			throws InvalidAreaFileException{
		Board b = new Board();
		
		try{
			String node = null;
			Scanner scan = new Scanner(new File(areaFilename));
			scan.nextLine();
			
			//Adding nodes
			while(!(node = scan.next()).equals("EDGES")){
				b.addTileNode(node.toLowerCase());
				
			}
			//Adding edges (i.e. connecting the nodes)
			while(scan.hasNext()){
				b.addEdge(scan.next().toLowerCase(), scan.next().toLowerCase());
			}
		} catch (FileNotFoundException e){
			System.out.println("AREA FILE: " + areaFilename + " was not found.");
			System.exit(1);
		}
		
		return b;
	}
}
