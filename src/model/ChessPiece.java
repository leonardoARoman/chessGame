package model;

public class ChessPiece {
	
	protected String tileColor;
	protected String location;
	protected int grid;
	
	public ChessPiece(String tileColor, String location, int grid) {
		this.tileColor = tileColor;
		this.location = location;
		this.grid = grid;
	}
	
	public int[][] move(int from, int to, String location, String tileColor, boolean tileIsEmpty, boolean isEnemy) {
		return null;
	}
	
	public void setTileColor(String tileColor) {
		this.tileColor = tileColor;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getGrid() {
		return grid;
	}
	
	public String getTileColor() {
		return tileColor;
	}
	
	public String getFlag() {
		return null;
	}
	
	public String toString() {
		return tileColor;
	}

}
