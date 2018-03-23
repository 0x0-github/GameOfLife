package fr.imie.gameoflife;

public class DeadCell implements Cell {

	protected String cellView;
	
	public DeadCell() {
		this.cellView  = " ";
	}
	
	public DeadCell(String repr) {
		this.cellView = repr;
	}
	
	public String getAsString() {
		return this.cellView;
	}
	
	public boolean isAlive() {
		return false;
	}
	
	public boolean isVirus() {
		return false;
	}
	
	public Cell newGeneration(int neighbourNb) {
		if (neighbourNb == POP_NB) {
			return new AliveCell();
		} else {
			return new DeadCell();
		}
	}
	
	public Cell clone() {
		return new DeadCell();
	}
	
	public int cellType() {
		return 0;
	}
}
