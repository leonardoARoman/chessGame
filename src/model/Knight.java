package model;

public class Knight extends ChessPiece {
	private boolean hasMoved;
	private String knight;
	private String flag;
	
	public Knight(String knight, String flag, String chessPieceColor, String location, int grid) {
		super(chessPieceColor,location,grid);
		this.knight = knight;
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
		return knight;
	}
	
	public int[][] move(int from, int to, String location, String tileColor, boolean tileIsEmpty, boolean isEnemy) {
		int[][] map = new int[2][2];
		if(validMove(from, to, tileIsEmpty, isEnemy)) {
			updateKnight(location, to, tileColor);
			map[0][0] = Math.abs((from/10)-8);
			map[0][1] = from%10;
			map[1][0] = Math.abs((to/10)-8);
			map[1][1] = to%10;
			return map;
		}
		return null;
	}

	private void updateKnight(String location,int grid, String tileColor) {
		this.location = location;
		this.grid = grid;
		this.tileColor = tileColor;
	}

	private boolean validMove(int from, int to, boolean tileIsEmpty, boolean isEnemy) {
		// rewrite for Knight movement
		if((Math.abs(from-to)%10==0 || Math.abs(from-to)<8) && (tileIsEmpty || isEnemy)) {
			setHasMoved();
			return true;
		}
		// No skipping off piece statement
		return false;
	}
}
