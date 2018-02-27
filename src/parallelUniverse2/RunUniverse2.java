package parallelUniverse2;

import java.util.ArrayList;

public class RunUniverse2 {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	public static char[] runUniverse(char[][] generation,int[] fitnessVal,int populationSize ,int chromoLength,ArrayList listOfValues,int problemCode ) {
	
		System.out.println("rununiverse");
		for(int i=0;i<11;i++) {
			generation=NextGeneration.getNextGeneration(generation, fitnessVal, populationSize,chromoLength,listOfValues,problemCode);
			currentBest=NextGeneration.getGenerationBest();
			solutionCost=ChromosomeRules.getFitness(problemCode, currentBest);
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
		return currentBest;
	}
	
}
