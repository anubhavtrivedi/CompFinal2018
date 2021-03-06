package parallelUniverse4;

import java.util.Scanner;

//selecting best 50% of population and return only 50% of the population
public class Selection {
	public static char[][] selectParents(char[][] generation, int[] fitness, int populationSize, int chromoLength,
			int problemCode) {
		

		generation = sort(fitness, generation, chromoLength);

		int temp = 0, counter = 0;
		//first half duplicated 2times each
		char[][] intermediateGeneration = new char[populationSize][chromoLength];
		while (temp < populationSize-4) {
			intermediateGeneration[temp] = generation[counter];
			temp++;
			intermediateGeneration[temp] = generation[counter];
			temp++;
			intermediateGeneration[temp] = generation[counter];
			temp++;
			intermediateGeneration[temp] = generation[counter];
			temp++;
			counter++;
		}

//		fitness = ChromosomeRules.getPopulationFitness(problemCode, intermediateGeneration);
//		// System.out.println(fitness+"SDf");
//		// System.out.println(fitness+""+intermediateGeneration+chromoLength);
//		intermediateGeneration = sort(fitness, intermediateGeneration, chromoLength);
	
		return intermediateGeneration;
	}

	static char[][] sort(int arr[], char[][] generation, int chromoLength) {
		int temp;
		char[] gen;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					gen = generation[j];
					generation[j] = generation[j + 1];
					generation[j + 1] = gen;
				}
			}
		}
		return generation;
	}

}