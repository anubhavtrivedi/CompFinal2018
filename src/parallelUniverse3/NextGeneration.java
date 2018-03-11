package parallelUniverse3;

import java.util.ArrayList;

import parallelUniverse4.Crossover;
import parallelUniverse4.Mutation;

public class NextGeneration {
	//public static char[] generationBest;

	public static char[][] getNextGeneration(char[][] generation, int[] fitness, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {
		// System.out.println("nextGeneration");

		int noOfMutation = (int) (populationSize / 10);
		int mutationPoint;
		while (noOfMutation > 0) {
			mutationPoint = (int) ((Math.random() * 10000) % populationSize);
			generation[mutationPoint] = Mutation.mutate(generation[mutationPoint], listOfValues, problemCode);
			noOfMutation--;
		}
		/*
		 * selecting the parents to produce off spring
		 */
		// System.out.println(fitness);
		char[][] intermediateGeneration = Selection.selectParents(generation, fitness, populationSize, chromoLength,
				problemCode);


		char[][] nextGeneration = Crossover.getCrossOver(generation, intermediateGeneration, populationSize,
				problemCode);

		/*
		 * returning the new generation of the population
		 */

		return nextGeneration;
	}



}
