import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) 
			throws FileNotFoundException, InvalidAreaFileException {
		Chess chessGame = new Chess();
		
		//If incorrect number of arguments, exit
		if (args.length != 1){
			System.out.println("Usage: java main area.txt");
			System.exit(1);
		}
		
		//Board file is the text document in the 0th index command line argument
		String areaFilename = args[0];
		
		//Creates the board based on the file
		Board board = chessGame.getBoard(areaFilename);
		
//		System.out.println(board.getNodeFromName("e7").getNeighbors().toString());
//		System.out.println(board.getNodeFromName("e7").getX());
//		System.out.println(board.getNodeFromName("e7").getY());
		
		board.getBlackPieceFromCoords(1, 8).printMoves();
	}
}