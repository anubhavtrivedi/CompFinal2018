package parallelUniverse3;

import java.util.ArrayList;

public class RunUniverse3 {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;

	public static char[] runUniverse(char[][] generation, int[] fitnessVal, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {

		System.out.println("rununiverse");
		for (int i = 0; i < 20000; i++) {
			// System.out.println("run "+i);

			generation = NextGeneration.getNextGeneration(generation, fitnessVal, populationSize, chromoLength,
					 listOfValues, problemCode);
			currentBest = generation[0];
			solutionCost = fitnessVal[0];
			if (i % 100 == 0) {
				System.out.println(print(currentBest) + "  " + solutionCost);
			}
			/*
			 * printing progress for every 50 generation
			 */

			fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);

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
