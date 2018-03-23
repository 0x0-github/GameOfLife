package fr.imie.gameoflife;

public class Bacteria implements Cell{
protected String cellView;
	
	public Bacteria() {
		this.cellView = "~";
	}
	
	public Bacteria(String repr) {
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
		if (neighbourNb >= BACT_OVER_POP && neighbourNb <= VIRUS_MUTATION) {
			return new Virus();
		} else if (neighbourNb == CURE) {
			return new AliveCell();
		} else if (neighbourNb < BACT_OVER_POP) {
			return new Bacteria();
		} else {
			return new DeadCell();
		}
	}
	
	public Cell clone() {
		return new Virus();
	}
	
	public int cellType() {
		return 2;
	}

}
