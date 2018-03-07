package problem_TraveligSalsemen;

import parallelUniverse2.RunUniverse2;
import parallelUniverse3.RunUniverse3;


public class RunProblem {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	public static void main(String[] args) {
		char[][] firstGeneration=FirstGeneration.getFirstGeneration();
		/*
		 * calculating fitness of the current generation
		 */
		fitnessVal=Fitness.getFitness(firstGeneration);
		char[] solution=RunUniverse3.runUniverse(firstGeneration, fitnessVal, FirstGeneration.populationSize, PathGraph.chromoLength, Chromosome.listofAllValues(),1);
		System.out.println(print(solution)+"  "+Fitness.calculateFitness(solution)+"we have obtained solution");
	}
	static String print(char[] solution) {
		String chromosome="";
		for(char c:solution) {
			chromosome+=c;
		}
		return chromosome;
		
	}
}
