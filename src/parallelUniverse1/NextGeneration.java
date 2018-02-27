package parallelUniverse1;

public class NextGeneration {
	public static char[] generationBest;
	public static char[][] getNextGeneration(char[][] generation,int[] fitness,int populationSize,int chromoLength) {
		//System.out.println("nextGeneration");
		/*
		 * selecting the parents to produce off spring
		 */
		char[][] parents=Selection.selectParents(generation, fitness, populationSize, chromoLength);
		/*
		 * best Gene of this generation 
		 */
		generationBest=parents[0];
		
		/*
		 * having crossover between the best half and the rest
		 */
		//Sgeneration=Crossover.getCrossOver(generation, parents);
		/*
		 * mutating 10% of population
		 */
		int noOfMutation = (int) (populationSize / 10);
		int mutationPoint;
		while (noOfMutation > 0) {
			mutationPoint = (int) ((Math.random() * 10000) % populationSize);
			 generation[mutationPoint]=Mutation.mutate(generation[mutationPoint]);
			noOfMutation--;
		}
		/*
		 * returning the new generation of the population
		 */
		
		return generation;
	}
	public static char[] getGenerationBest() {
		return generationBest;
	}
	
}
