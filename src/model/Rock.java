package model;

public class Rock extends ChessPiece {
	private boolean hasMoved;
	private String rock;
	private String flag;

	public Rock(String rock, String flag, String tileColor, String location, int grid) {
		super(tileColor, location, grid);
		this.rock = rock;
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
		return rock;
	}

	public int[][] move(int from, int to, String location, String tileColor, boolean tileIsEmpty, boolean isEnemy) {
		int[][] map = new int[2][2];
		if(validMove(from, to, tileIsEmpty, isEnemy)) {
			updateRock(location, to, tileColor);
			map[0][0] = Math.abs((from/10)-8);
			map[0][1] = from%10;
			map[1][0] = Math.abs((to/10)-8);
			map[1][1] = to%10;
			return map;
		}
		return null;
	}

	private void updateRock(String location,int grid, String tileColor) {
		this.location = location;
		this.grid = grid;
		this.tileColor = tileColor;
	}

	private boolean validMove(int from, int to, boolean tileIsEmpty, boolean isEnemy) {
		
		if((Math.abs(from-to)%10==0 || Math.abs(from-to)<8) && (tileIsEmpty || isEnemy)) {
			setHasMoved();
			return true;
		}
		// No skipping off piece statement
		return false;
	}
}
