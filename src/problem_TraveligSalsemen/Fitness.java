package problem_TraveligSalsemen;

public class Fitness {
	public static int calculateFitness(char[] chromo) {
		int source,destination,cost=0;
		for (int i = 0; i < PathGraph.chromoLength-1; i++) {
			source=Integer.parseInt(""+chromo[i]);
			destination=Integer.parseInt(""+chromo[i+1]);
			cost+=PathGraph.graph[source][destination];
		}
		return cost;
	}
	public static int[] getFitness(char[][] population) {
		System.out.println("fitness");
		int[] fitness=new int[FirstGeneration.populationSize];
		for (int i = 0; i < FirstGeneration.populationSize; i++) {
			fitness[i]=calculateFitness(population[i]);
		}
		return fitness;
	}
}
