package parallelUniverse2;

import java.util.ArrayList;

public class NextGeneration {
	public static char[] generationBest;

	public static char[][] getNextGeneration(char[][] generation, int[] fitness, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {
		//System.out.println("nextGeneration");
		/*
		 * selecting the parents to produce off spring
		 */
		char[][] intermediateGeneration = Selection.selectParents(generation, fitness, populationSize, chromoLength);
		
		/*
		 * best Gene of this generation
		 */
		generationBest = intermediateGeneration[0];

		/*
		 * having crossover between the best half and the rest
		 */
		char[][] nextGeneration = Crossover.getCrossOver(generation, intermediateGeneration, populationSize,
				problemCode);
		/*
		 * mutating 10% of population
		 */


		
		
		
		
		
		
		
		int noOfMutation = (int) (populationSize / 10);
		int mutationPoint;
		while (noOfMutation > 0) {
			mutationPoint = (int) ((Math.random() * 10000) % populationSize);
			nextGeneration[mutationPoint] = Mutation.mutate(nextGeneration[mutationPoint], listOfValues, problemCode);
			noOfMutation--;
		}
		/*
		 * returning the new generation of the population
		 */

		return nextGeneration;
	}

	public static char[] getGenerationBest() {
		return generationBest;
	}

}
