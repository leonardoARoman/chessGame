package model;

public class ChessBoard {

	private ChessPiece[][] chessBoard;

	public ChessBoard() {
		chessBoard = new ChessPiece[8][8];
	}

	public ChessPiece[][] getChessBoard() {
		for(int i = 0; i < chessBoard.length; i++) {
			for(int j = 0; j < chessBoard.length; j++) {
				String str = Character.toString((char)(97+j));
				if((i+j)%2==0) {
					chessBoard[i][j] = new ChessPiece("##",(str+(8-i)),(((8-i)*10)+j));
				}else {
					chessBoard[i][j] = new ChessPiece("  ",(str+(8-i)),(((8-i)*10)+j));
				}
			}
		}

		chessBoard[6][0] = new Pawn("wp","w","##","a2",20);
		chessBoard[6][1] = new Pawn("wp","w","  ","b2",21);
		chessBoard[6][2] = new Pawn("wp","w","##","c2",22);
		chessBoard[6][3] = new Pawn("wp","w","  ","d2",23);
		chessBoard[6][4] = new Pawn("wp","w","##","e2",24);
		chessBoard[6][5] = new Pawn("wp","w","  ","f2",25);
		chessBoard[6][6] = new Pawn("wp","w","##","g2",26);
		chessBoard[6][7] = new Pawn("wp","w","  ","h2",27);
		
		chessBoard[7][0] = new Rock("wR","w","  ","a1",10);
		chessBoard[7][1] = new Knight("wN","w","##","b1",11);
		chessBoard[7][2] = new Bishop("wB","w","  ","c1",12);
		chessBoard[7][3] = new Queen("wQ","w","##","d1",13);
		chessBoard[7][4] = new King("wK","w","  ","e1",14);
		chessBoard[7][5] = new Bishop("wB","w","##","f1",15);
		chessBoard[7][6] = new Knight("wN","w","  ","g1",16);
		chessBoard[7][7] = new Rock("wR","w","##","h1",17);

		chessBoard[1][0] = new Pawn("bp","b","  ","a7",70);
		chessBoard[1][1] = new Pawn("bp","b","##","b7",71);
		chessBoard[1][2] = new Pawn("bp","b","  ","c7",72);
		chessBoard[1][3] = new Pawn("bp","b","##","d7",73);
		chessBoard[1][4] = new Pawn("bp","b","  ","e7",74);
		chessBoard[1][5] = new Pawn("bp","b","##","f7",75);
		chessBoard[1][6] = new Pawn("bp","b","  ","g7",76);
		chessBoard[1][7] = new Pawn("bp","b","##","h7",77);
		
		chessBoard[0][0] = new Rock("bR","b","##","a8",80);
		chessBoard[0][1] = new Knight("bN","b","  ","b8",81);
		chessBoard[0][2] = new Bishop("bB","b","##","c8",82);
		chessBoard[0][3] = new Queen("bQ","b","  ","d8",83);
		chessBoard[0][4] = new King("bK","b","##","e8",84);
		chessBoard[0][5] = new Bishop("bB","b","  ","f8",85);
		chessBoard[0][6] = new Knight("bN","b","##","g8",86);
		chessBoard[0][7] = new Rock("bR","b","  ","h8",87);

		return chessBoard;
	}
}
