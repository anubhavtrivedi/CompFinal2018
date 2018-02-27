package parallelUniverse1;

import problem_TraveligSalsemen.FirstGeneration;
import problem_TraveligSalsemen.Fitness;
import problem_TraveligSalsemen.PathGraph;

public class RunUniverse {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	public static void main(String[] args) {
		char[][] generation=FirstGeneration.getFirstGeneration();
		/*
		 * calculating fitness of the current generation
		 */
		fitnessVal=Fitness.getFitness(generation);
		
		for(int i=0;i<1100000;i++) {
			generation=NextGeneration.getNextGeneration(generation, fitnessVal, FirstGeneration.populationSize, PathGraph.chromoLength);
			currentBest=NextGeneration.getGenerationBest();
			solutionCost=Fitness.calculateFitness(currentBest);
			/*
			 * printing progress for every 50 generation
			 */
			if(i%50==0) {
				for(int x:fitnessVal) {
					System.out.println(x);
				}
				System.out.println(currentBest.toString()+"  "+solutionCost);
			}
			
			
		}
	}
}
