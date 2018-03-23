package fr.imie.gameoflife;

public class Virus implements Cell {
	
	protected String cellView;
	
	public Virus() {
		this.cellView = "*";
	}
	
	public Virus(String repr) {
		this.cellView = repr;
	}
	
	public String getAsString() {
		return this.cellView;
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public boolean isVirus() {
		return true;
	}

	public Cell newGeneration(int neighbourNb) {
		if (neighbourNb >= VIRUS_UNDER_POP && neighbourNb < VIRUS_OVER_POP) {
			return new Virus();
		} else {
			return new DeadCell();
		}
	}
	
	public Cell clone() {
		return new Virus();
	}
	
	public int cellType() {
		return 1;
	}
}
