package model;

public class King extends ChessPiece {

	private boolean hasMoved;
	private String king;
	private String flag;

	public King(String king, String flag, String chessPieceColor, String location, int grid) {
		super(chessPieceColor,location, grid);
		this.king = king;
		this.location = location;
		this.grid = grid;
		this.flag = flag;
		hasMoved = false;
	}

	public void setHasMoved() {
		hasMoved = true;
	}

	public String getLocation() {
		return this.location;
	}

	public int getGrid() {
		return this.grid;
	}

	public String getTileColor() {
		return this.tileColor;
	}

	public boolean hasBeenMoved() {
		return hasMoved;
	}

	public String getFlag() {
		return flag;
	}

	public String toString() {
		return king;
	}

	public int[][] move(int from, int to, String location, String tileColor, boolean tileIsEmpty, boolean isEnemy) {
		int[][] map = new int[2][2];
		if(validMove(from, to, tileIsEmpty, isEnemy)) {
			updateKing(location, to, tileColor);
			map[0][0] = Math.abs((from/10)-8);
			map[0][1] = from%10;
			map[1][0] = Math.abs((to/10)-8);
			map[1][1] = to%10;
			return map;
		}
		return null;
	}

	private void updateKing(String location,int grid, String tileColor) {
		this.location = location;
		this.grid = grid;
		this.tileColor = tileColor;
	}

	private boolean validMove(int from, int to, boolean tileIsEmpty, boolean isEnemy) {
		if((Math.abs(to-from)==11 
				|| Math.abs(to-from)==9 
				|| Math.abs(to-from)==10 
				|| Math.abs(to-from)==1) && (tileIsEmpty || isEnemy)) {
			setHasMoved();
			return true;
		}
		// Castle logic{...}
		return false;
	}
}
