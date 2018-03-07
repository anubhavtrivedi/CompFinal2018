package parallelUniverse2;

import java.util.ArrayList;

public class RunUniverse2 {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	public static char[] runUniverse(char[][] generation,int[] fitnessVal,int populationSize ,int chromoLength,ArrayList<Character> listOfValues,int problemCode ) {
	
		System.out.println("rununiverse");
		for(int i=0;i<1;i++) {
			//System.out.println("run         "+i);
			generation=NextGeneration.getNextGeneration(generation, fitnessVal, populationSize,chromoLength,listOfValues,problemCode);
			currentBest=NextGeneration.getGenerationBest();
			solutionCost=ChromosomeRules.getFitness(problemCode, currentBest);
			/*
			 * printing progress for every 50 generation
			 */
			
			
			
		}
		return currentBest;
	}
	public static String print(char[] chromo) {
		String s="";
		for(char c:chromo) {
			s+=c;
		}
		return s;
	}
	
}
