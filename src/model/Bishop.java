package model;

public class Bishop extends ChessPiece {
	private boolean hasMoved;
	private String bishop;
	private String flag;

	public Bishop(String bishop, String flag, String tileColor, String location, int grid) {
		super(tileColor,location,grid);
		this.bishop = bishop;
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
		return bishop;
	}

	public int[][] move(int from, int to, String location, String tileColor, boolean tileIsEmpty, boolean isEnemy) {
		int[][] map = new int[2][2];
		if(validMove(from, to, tileIsEmpty, isEnemy)) {
			updateBishop(location, to, tileColor);
			map[0][0] = Math.abs((from/10)-8);
			map[0][1] = from%10;
			map[1][0] = Math.abs((to/10)-8);
			map[1][1] = to%10;
			return map;
		}
		return null;
	}

	private void updateBishop(String location,int grid, String tileColor) {
		this.location = location;
		this.grid = grid;
		this.tileColor = tileColor;
	}

	private boolean validMove(int from, int to, boolean tileIsEmpty, boolean isEnemy) {

		if((Math.abs(from-to)%11==0 || Math.abs(from-to)%9==0) && (tileIsEmpty || isEnemy)) {
			setHasMoved();
			return true;
		}
		// No skipping off piece statement
		return false;
	}
}
