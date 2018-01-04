package controller;

import java.util.Scanner;

import model.ChessBoard;
import model.ChessPiece;

public class ChessGameController {

	private static ChessPiece[][] board;
	public static Scanner stdin = new Scanner(System.in);
	private static String moving;

	// Private empty constructor
	private ChessGameController() {}

	// Start Game
	public static void start() {
		board = new ChessBoard().getChessBoard();
		gameState();
		makeMove();
	}

	private static void makeMove() {
		while(true) {
			System.out.print("\nWhite's move: ");
			moving = stdin.nextLine();
			playersMove();
			gameState();

			System.out.print("\nBlack's move: ");
			moving = stdin.nextLine();
			playersMove();
			gameState();
		}
	}


	private static void playersMove() {
		// Local temporary instances.
		String[] str = moving.split(" ");
		String tileColor = getChessPiece(str[0]).getTileColor();
		ChessPiece chessPiece = getChessPiece(str[0]);
		ChessPiece chessPiece2 = getChessPiece(str[1]);
		int grid = chessPiece.getGrid();
		int[][] grids = chessPiece
				.move(chessPiece
						.getGrid(),
						chessPiece2
						.getGrid(),
						str[1],chessPiece2
						.getTileColor(),
						tileIsEmpty(chessPiece2.getGrid()),
						isEnemy(chessPiece,chessPiece2));

		if(grids == null)
			return;

		swap(grids,str[0],grid,tileColor);
	}

	private static void swap(int[][] grids, String location, int grid, String tileColor) {
		board[grids[1][0]][grids[1][1]] = board[grids[0][0]][grids[0][1]];
		board[grids[0][0]][grids[0][1]] = new ChessPiece(tileColor,location,grid);
	}

	private static ChessPiece getChessPiece(String atLocation) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i][j].getLocation().equals(atLocation))
					return board[i][j];
			}
		}
		return null;
	}

	private static boolean tileIsEmpty(int index) {
		int i = Math.abs((index/10)-8);
		int j = index%10;
		if(board[i][j].toString().equals("  ") || board[i][j].toString().equals("##")) {
			return true;
		}
		return false;
	}

	private static boolean isEnemy(ChessPiece p1,ChessPiece p2) {
		if(p2.getFlag()==null)
			return true;

		else if(p1.getFlag().compareTo(p2.getFlag())==0) 
			return false;

		return true;
	}

	private static void gameState() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				//System.out.print(board[i][j].getLocation()+" ");
				//System.out.print(board[i][j].getGrid()+" ");
				System.out.print(board[i][j]+" ");
			}
			System.out.println(8-i);
		}
		System.out.println(" a  b  c  d  e  f  g  h \n");
	}
}
