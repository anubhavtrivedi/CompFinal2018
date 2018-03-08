package parallelUniverse1;

import java.util.ArrayList;

import problem_TraveligSalsemen.Fitness;

public class RunUniverse1 {
	static ArrayList<String> archive=new ArrayList<>();
	static char[] currentBest;
	static int solutionCost=99999999;
	static int[] fitnessVal;
	static int localOptimal;
	public static char[] runUniverse(char[][] generation, int[] fitnessVal, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {
		System.out.println(RunUniverse1.print(generation[3]));
		String[] split;
		int val=99999999;
		System.out.println("rununiverse");
		for (int i = 0; i < 20000; i++) {
			// System.out.println("run "+i);

			generation = NextGeneration.getNextGeneration(generation, fitnessVal, populationSize, chromoLength,
					 listOfValues, problemCode);
			fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);
			if(solutionCost>fitnessVal[0]) {
				localOptimal=0;
			currentBest = generation[0];
			solutionCost = fitnessVal[0];
			}
			else if(localOptimal>5) {
				archive.add(new String(currentBest)+" "+solutionCost);
				generation=ChromosomeRules.getNewFirstGeneration(problemCode);
				fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);
				System.out.println("stuck");
				continue;
			}
			else if(generation[0]==currentBest){
				localOptimal++;
			}
			if (i<50) {
				//System.out.println(print(currentBest) + "  " + solutionCost+"  "+print(generation[100])+"  "+Fitness.calculateFitness(generation[100]));
			}
			/*
			 * printing progress for every 50 generation
			 */

			

		}
		int g=0;
		for(String c:archive) {
			g++;
			 split=c.split(" ");
			 if(g<10)
			 System.out.println(c);
			 if(val>Integer.parseInt(split[1])) {
				 val=Integer.parseInt(split[1]);
				 currentBest=split[0].toCharArray();
			 }
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
