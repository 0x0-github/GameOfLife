package fr.imie.gameoflife;

import java.util.Scanner;

public class Launcher {
	public static void affWorld(World world)
	{
		for (int i = 0; i < world.getX(); i++) {
			for (int j = 0; j < world.getY(); j++) {
				System.out.print(world.map[i][j].getAsString());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void launchGame() {
		int x;
		int y;
		int cellNb = 250;
		int gen = 1000;
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.println("How many rows ?");
			x = sc.nextInt();
			sc.nextLine();
			System.out.println("How many columns ?");
			y = sc.nextInt();
			if ((x < 10 || x > 300) || (y < 10 || y > 300)) {
				throw new Exception("Invalid number: The number should be between 10 to 300.");
			}
			World world = new World(x, y);
			world.initWorld();
			world.createLife(cellNb, new AliveCell());
			for (int k = 0; k < gen; k++) {
				affWorld(world);
				world.newGeneration();
				Thread.sleep(500);
				System.out.print(String.format("\033[H\033[2J"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Launcher.launchGame();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Launcher.launchGame();
	}

}
