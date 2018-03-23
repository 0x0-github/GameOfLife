package fr.imie.gameoflife;

public interface Cell {
	
	//Store the number max of cells which may affect alive cells/viruses
	public static int UNDER_POP = 2;
	public static int OVER_POP = 3;
	public static int VIRUS_UNDER_POP = 1;
	public static int VIRUS_OVER_POP = 4;
	public static int CURE = 1;
	public static int BACT_OVER_POP = 4;
	//Stores the number which makes the dead cells /viruses alive
	public static int POP_NB = 3;
	public static int VIRUS_POP_NB = 2;
	public static int BACT_POP_NB = 4;
	//The number which makes the alive cells mutate into virus
	public static int VIRUS_MUTATION = 5;
	public static int BACT_CONTAMINATION = 4;
		
	//Return the next generation of cells depending on the number of cells around
	Cell newGeneration(int neighbourNb);
	//Return the representation of the cell
	String getAsString();
	//Return true if AliveCell, false if DeadCell
	boolean isAlive();
	//Return true if virus, false if not
	int cellType();
	//Return a new generic cell depending on the class. 
	Cell clone();
}
