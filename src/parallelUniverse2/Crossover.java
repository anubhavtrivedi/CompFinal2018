package parallelUniverse2;


//random one point cross over
public class Crossover {
	public static char[] crossOver(char[] parent1, char[] parent2,int problemCode) {
	//	System.out.println("crossover");
		int repetion=ChromosomeRules.checkRepetion(problemCode);
		/*
		 * 0 for noRepetionCrossOver 
		 * 1 for repetionAllowedCrossOver
		 * 2 for noRepetionNoChromoRuleCrossOver
		 */
		if(repetion==0) {
			return noRepetionCrossOver(parent1,parent2,problemCode);
		}
		if(repetion==1) {
			return repetionAllowedCrossOver(parent1,parent2,problemCode);
		}
		if(repetion==2) {
			return noRepetionNoChromoRuleCrossOver(parent1,parent2,problemCode);
		}
		return parent1;
	}
	
	
	public static char[] noRepetionCrossOver(char[] parent1, char[] parent2,int problemCode) {
		
		return null;
	}
	
	public static char[] noRepetionNoChromoRuleCrossOver(char[] parent1, char[] parent2,int problemCode) {
		
		return null;
	}
	
	public static char[] repetionAllowedCrossOver(char[] parent1, char[] parent2,int problemCode) {
		
		int crossOverPoint = (int) ((Math.random() * 100) % parent1.length);
		for (int i = 0; i < parent1.length; i++) {
			if (i < crossOverPoint)
				continue;
			parent1[i] = parent2[i];
		}
		
		return parent1;
	}
	
	public static char[][] getCrossOver(char[][] generation,char[][] parents,int populationSize,int problemCode)
	{
		int counter=0,parent1,parent2;
		while(counter<populationSize) {
			parent1 = (int) ((Math.random() * 100) % populationSize);
			parent2 = (int) ((Math.random() * 100) % populationSize);
			generation[counter]=crossOver(parents[parent1],parents[parent2],problemCode);
			counter++;
		}
		
		return generation;
	}
}
