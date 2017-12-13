import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static void main(String[] args) 
			throws FileNotFoundException, InvalidAreaFileException {
		Chess chessGame = new Chess();
		
		Scanner scan = new Scanner(System.in);
		
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
		
//		board.getWhitePieceFromCoords(4, 4).printMoves();
		
		System.out.println("Starting team is WHITE");
		
		boolean team = true;
		
		int xStart;
		int yStart;
		int xEnd;
		int yEnd;
		
		do {
			/*
			 * Choose a piece to move based on coordinates
			 */
			System.out.println("Choose a piece to move (coordinates)");
			
			System.out.print("X-Coordinate: ");
			xStart = scan.nextInt();
			System.out.println();
			
			System.out.print("Y-Coordinate: ");
			yStart = scan.nextInt();
			System.out.println();
			
			/*
			 * Lists the viable moves
			 */
			if (team){
				System.out.println("Viable moves:");
				board.getWhitePieceFromCoords(xStart, yStart).printMoves();;
			}
			else{
				System.out.println("Viable moves:");
				board.getBlackPieceFromCoords(xStart, yStart).printMoves();;
			}
			
			/*
			 * Choose a tile to move to based on coordinates
			 */
			System.out.println("\nChoose a place to move to (coordinates)");
			System.out.print("X-Coordinate: ");
			xEnd = scan.nextInt();
			System.out.println();
			
			System.out.print("Y-Coordinate: ");
			yEnd = scan.nextInt();
			System.out.println();
			
			/*
			 * Shows that the move is being made and consequently makes the move
			 */
			System.out.println("Moving Piece.");
			board.movePieceAtCoords(xStart, yStart, xEnd, yEnd, team);
			
			/*
			 * Lists the white and black pieces still on the board
			 */
			System.out.print("Current White Pieces: ");
			for (Piece p : board.getWhitePieces())
				System.out.print(p.toString().split("@", 2)[0] + " ");
			
			System.out.println();
			
			System.out.print("Current Black Pieces: ");
			for (Piece p : board.getBlackPieces())
				System.out.print(p.toString().split("@", 2)[0] + " ");
			
			System.out.println();
			
			/*
			 * Lists the removed white and black pieces in reverse order
			 * that they were removed
			 */
			System.out.println("Removed White Pieces in reverse order: ");
			if (!(board.getRemovedWhite() == null)){
				for (int i = 0; i < board.getRemovedWhite().size(); i++)
					System.out.print(board.getRemovedWhite().pop().toString().split("@", 2)[0] + " ");
			}
			
			System.out.println();
			
			System.out.println("Removed Black Pieces in reverse order: ");
			if (!(board.getRemovedBlack() == null)){
				for (int i = 0; i < board.getRemovedBlack().size(); i++)
					System.out.print(board.getRemovedBlack().pop().toString().split("@", 2)[0] + " ");
			}
			
			System.out.println("\n");
			
			System.out.println("Changing teams.");
			
			team = !team;
			
			System.out.println("Type 'Y' to Continue");
		} while (!scan.next().equals("end"));
	}
}