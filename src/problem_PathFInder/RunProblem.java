package problem_PathFInder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import parallelUniverse2.RunUniverse2;

import parallelUniverse4.RunUniverse4;
import parallelUniverse3.RunUniverse3;

public class RunProblem {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	static ArrayList<String> archive = new ArrayList<>();

	public static void main(String[] args) {

		char[] solution = null;
		for (int i = 0; i < 100; i++) {

			char[][] firstGeneration = FirstGeneration2.getFirstGeneration();

			/*
			 * calculating fitness of the current generation
			 */
			fitnessVal = Fitness2.getFitness(firstGeneration);

			solution = RunUniverse4.runUniverse(firstGeneration, fitnessVal, FirstGeneration2.populationSize,
					FirstGeneration2.chromoLength, Chromosome.listofAllValues(), 2);
			System.out.println("Coordinates :" + Fitness2.calculateCoordinates(solution) + " fitness :"
					+ Fitness2.calculateFitness(solution));
			archive.add(new String(solution) + " " + Fitness2.calculateFitness(solution));

		}
		String[] split;
		int val = 0;
		for (String c : archive) {

			split = c.split(" ");

			if (val < Integer.parseInt(split[1])) {
				val = Integer.parseInt(split[1]);
				solution = split[0].toCharArray();
			}
		}
		// System.out.println(print(solution)+" "+Fitness2.calculateFitness(solution)+"
		// we have obtained solution");
		System.out.println(Fitness2.calculateCoordinates(solution));
		printGrid(solution);
	}

	static String print(char[] solution) {
		String chromosome = "";
		for (char c : solution) {
			chromosome += c;
		}
		return chromosome;

	}

	public static void printGrid(char[] solution) {
		String output = "";
		try (BufferedWriter b = Files.newBufferedWriter(Paths.get("Grid.txt"))) {
			int[][] grid = Grid.getGrid();

			int x = 10, y = 10;
			for (char move : solution) {
				if (grid[y][x] == 10)
					break;
				if (grid[y][x] == 1 || grid[y][x] == 2) 
					break;
				if (move == 'R') {
					x++;
					if (grid[y][x] == 1 || grid[y][x] == 2) 
						break;
					grid[y][x] = 3;
					
				}
				if (move == 'L') {
					x--;
					if (grid[y][x] == 1 || grid[y][x] == 2) 
						break;
					grid[y][x] = 3;
				}
				if (move == 'D') {
					y--;
					if (grid[y][x] == 1 || grid[y][x] == 2) 
						break;
					grid[y][x] = 3;
				}
				if (move == 'U') {
					y++;
					if (grid[y][x] == 1 || grid[y][x] == 2) 
						break;
					grid[y][x] = 3;
				}
			}
			for (int[] row : grid) {
				output = "";
				for (int cc : row) {
					output += cc;
				}
				b.write(output+System.lineSeparator());
			}
		} catch (IOException e) {

		}
	}
}
