package model;

public class Pawn extends ChessPiece {
	private boolean hasMoved;
	private String pawn;
	private String flag;

	public Pawn(String pawn, String flag, String tileColor, String location, int grid) {
		super(tileColor,location,grid);
		this.pawn = pawn;
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
		return pawn;
	}

	public int[][] move(int from, int to, String location, String tileColor, boolean tileIsEmpty, boolean isEnemy) {
		int[][] map = new int[2][2];
		if(validMove(from, to, tileIsEmpty, isEnemy)) {
			updatePawn(location, to, tileColor);
			map[0][0] = Math.abs((from/10)-8);
			map[0][1] = from%10;
			map[1][0] = Math.abs((to/10)-8);
			map[1][1] = to%10;
			return map;
		}
		return null;
	}

	private void updatePawn(String location,int grid, String tileColor) {
		this.location = location;
		this.grid = grid;
		this.tileColor = tileColor;
	}

	// Fix backing bug
	private boolean validMove(int from, int to, boolean tileIsEmpty, boolean isEnemy) {
		if(Math.abs(to-from)==20 && !hasBeenMoved() && tileIsEmpty) {
			setHasMoved();
			return true;
		}else if(Math.abs(to-from)==10 && tileIsEmpty) {
			setHasMoved();
			return true;
		}else if((Math.abs(to-from)==11 || Math.abs(to-from)==9) && !tileIsEmpty && isEnemy) {
			setHasMoved();
			return true;
		}
		return false;
	}
}
