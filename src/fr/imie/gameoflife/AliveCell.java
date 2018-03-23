package fr.imie.gameoflife;

public class AliveCell implements Cell {
	
	protected String cellView;
	
	public AliveCell() {
		this.cellView = "0";
	}
	
	public AliveCell(String repr) {
		this.cellView = repr;
	}
	
	public String getAsString() {
		return this.cellView;
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public boolean isVirus() {
		return false;
	}
	
	public Cell newGeneration(int neighbourNb) {
		if (neighbourNb > BACT_CONTAMINATION || neighbourNb < UNDER_POP) {
			return new DeadCell();
		} else if (neighbourNb == BACT_CONTAMINATION) {
			return new Bacteria();
		} else {
			return new AliveCell();
		}
	}
	
	public Cell clone() {
		return new AliveCell();
	}
	
	public int cellType() {
		return 3;
	}
}
