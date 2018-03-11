package problem_TraveligSalsemen;

public class Fitness1 {
	public static int calculateFitness(char[] chromo) {
		int source, destination, cost = 0;
		for (int i = 0; i < PathGraph.chromoLength - 1; i++) {
			if (chromo[i] == 'x')
				source = 10;
			else if (chromo[i] == 'y')
				source = 11;
			else
				source = Integer.parseInt("" + chromo[i]);
			if (chromo[i + 1] == 'y')
				destination = 11;
			else if (chromo[i + 1] == 'x')
				destination = 10;
			else
				destination = Integer.parseInt("" + chromo[i + 1]);
			cost += PathGraph.graph[source][destination];
		}
		return cost;
	}

	public static int[] getFitness(char[][] population) {
		//System.out.println("fitness");
		int[] fitness = new int[FirstGeneration1.populationSize];
		for (int i = 0; i < FirstGeneration1.populationSize; i++) {
			fitness[i] = calculateFitness(population[i]);
		}
		return fitness;
	}
}
