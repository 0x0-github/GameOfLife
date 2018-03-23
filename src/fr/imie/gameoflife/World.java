package fr.imie.gameoflife;

public class World {
	//The various parameters are the duration of the "game", the interval and the number of cell at the start
	public Cell map[][];
	protected int x;
	protected int y;
	
	public World(int x, int y) {
		this.x = x;
		this.y = y;
		this.map = new Cell[x][y];
	}
	
	public Cell[][] getMap() {
		return map;
	}

	public void setMap(Cell[][] map) {
		this.map = map;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public World clone(World wrld) {
		World world = new World(wrld.getX(), wrld.getY());
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				world.map[i][j] = wrld.map[i][j];
			}
		}
		return world;
	}
	
	public void initWorld() {
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				this.map[i][j] = new DeadCell();
			}
		}
	}
	
	public void createLife(int nb, Cell cell) {
		for (int i = 0; i < nb; i++) {
			int rdmX = (int)(Math.random()*this.x);
			int rdmY = (int)(Math.random()*this.y);
			if (!this.map[rdmX][rdmY].isAlive()) {
				this.map[rdmX][rdmY] = cell.clone();
			} else {
				i--;
			}
		}
	}
	
	public int checkNeighbours(int x, int y) {
		int neighbourNb = (this.map[x][y].isAlive()) ? -1 : 0;
		for (int i = (x > 0) ? x-1 : 0; i <= x+1 && i < this.x; i++) {
			for (int j = (y > 0) ? y-1 : 0; j <= y+1 && j < this.y; j++) {
				if (this.map[i][j].isAlive()) {
					neighbourNb++;
				}
			}
		}
		return neighbourNb;
	}
	
	void newGeneration() {
		World past = this.clone(this);
		for (int i = 0; i < past.getX(); i++) {
			for (int j = 0; j < past.getY(); j++) {
				int nb = past.checkNeighbours(i, j);
				this.map[i][j] = past.getMap()[i][j].newGeneration(nb);
			}
		}
	}
}

