package problem_PathFInder;

import java.util.Scanner;

public class Fitness2 {
	public static String calculateCoordinates(char[] chromo) {
		int[][] grid = Grid.getGrid();
	
		int x=1,y=1;
		for (char move : chromo) {
			if(grid[x][y]==10)
				return ""+100+""+100;
			if(grid[x][y]==1||grid[x][y]==2) {
				break;
			}
			if (move == 'R') {
				x++;
			}
			if (move == 'L') {
				x--;
			}
			if (move == 'D') {
				y--;
			}
			if (move == 'U') {
				y++;
			}
		}
		return x+" "+y;
	}
	public static int calculateFitness(char[] chromo) {
		
		int[][] grid = Grid.getGrid();
		int solutionFitness=0;
		int cost = 0,x=1,y=1;
		for (char move : chromo) {
			if(grid[x][y]==10)
				return 0;
			if(grid[x][y]==1||grid[x][y]==2) {
				break;
			}
			if (move == 'R') {
				x++;
			}
			if (move == 'L') {
				x--;
			}
			if (move == 'D') {
				y--;
			}
			if (move == 'U') {
				y++;
			}
		}
		solutionFitness=x*(x%10)+y*(y%10);
		return solutionFitness;
	}

	public static int[] getFitness(char[][] population) {
		// System.out.println("fitness");
		int[] fitness = new int[FirstGeneration2.populationSize];
		for (int i = 0; i < FirstGeneration2.populationSize; i++) {
		
			fitness[i] = calculateFitness(population[i]);
			//System.out.println(i+"  "+population[i][4]+"  "+fitness[i]);
		}
		return fitness;
	}
}
