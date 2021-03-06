package parallelUniverse2;

//selecting best 50% of population and return only 50% of the population
public class Selection {
	public static char[][] selectParents(char[][] generation, int[] fitness, int populationSize, int chromoLength,
			int problemCode) {
		// System.out.println("selection universe 3");

		generation = sort(fitness, generation, chromoLength);

		//
		// for(int j=0;j<populationSize;j++) {
		//
		// System.out.println(RunUniverse3.print(generation[j])+"
		// "+ChromosomeRules.getChromoFitness(1, generation[j]));
		// }
		//

		int temp = 0, counter = 0;
		char[][] intermediateGeneration1 = new char[populationSize][chromoLength];
		while (temp < populationSize) {
			intermediateGeneration1[temp] = generation[counter];
			temp++;
			intermediateGeneration1[temp] = generation[counter];
			temp++;
			counter++;
		}
		char[][] intermediateGeneration = new char[populationSize][chromoLength];
		temp = 0;

		while (temp < populationSize) {
			counter = (int) (Math.random() * 1000) % populationSize;
			intermediateGeneration[temp] = intermediateGeneration1[counter];
			temp++;

		}

		fitness = ChromosomeRules.getPopulationFitness(problemCode, intermediateGeneration);
		// System.out.println(fitness);
		intermediateGeneration = sort(fitness, intermediateGeneration, chromoLength);

		return intermediateGeneration;
	}

	static char[][] sort(int arr[], char[][] generation, int chromoLength) {
		int temp;
		char[] gen;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
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