import java.io.*;
import java.util.*;

public class Chess {
	private Board thisBoard;

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
				b.addTileNode(node.toLowerCase(), scan.nextInt(), scan.nextInt());
			}
			//Adding edges (i.e. connecting the nodes)
			while(!(node = scan.next()).equals("PIECES")){
				b.addEdge(node.toLowerCase(), scan.next().toLowerCase());
			}
			//Adding pieces
			while(scan.hasNext()){
				b.addPiece(scan.next().toLowerCase(), scan.next().toLowerCase(),
						scan.nextInt(), scan.nextInt());
			}
			
			scan.close();
		} catch (FileNotFoundException e){
			System.out.println("AREA FILE: " + areaFilename + " was not found.");
			System.exit(1);
		}
		
		return b;
	}
	
	public Board getBoard(String areaFilename) throws InvalidAreaFileException{
		if (thisBoard == null){
			thisBoard = Chess.createBoardFromAreaFile(areaFilename);
		}
		return thisBoard;
	}
	
	public Board getBoard(){
		return thisBoard;
	}
}