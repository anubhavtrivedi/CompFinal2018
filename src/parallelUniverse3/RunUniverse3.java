package parallelUniverse3;

import java.util.ArrayList;

import problem_TraveligSalsemen.Fitness;

public class RunUniverse3 {
	static char[] currentBest;
	static int solutionCost=99999999;
	static int[] fitnessVal;

	public static char[] runUniverse(char[][] generation, int[] fitnessVal, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {
		System.out.println(RunUniverse3.print(generation[3]));
		System.out.println("rununiverse");
		for (int i = 0; i < 20000; i++) {
			// System.out.println("run "+i);

			generation = NextGeneration.getNextGeneration(generation, fitnessVal, populationSize, chromoLength,
					 listOfValues, problemCode);
			fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);
			if(solutionCost>fitnessVal[0]) {
			currentBest = generation[0];
			solutionCost = fitnessVal[0];
			}
			if (i<50) {
				System.out.println(print(currentBest) + "  " + solutionCost+"  "+print(generation[100])+"  "+Fitness.calculateFitness(generation[100]));
			}
			/*
			 * printing progress for every 50 generation
			 */

			

		}
		return currentBest;
	}

	public static String print(char[] chromo) {
		String s = "";
		for (char c : chromo) {
			s += c;
		}
		return s;
	}

}
