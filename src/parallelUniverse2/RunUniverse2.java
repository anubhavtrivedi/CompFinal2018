package parallelUniverse2;

import java.util.ArrayList;

import problem_TraveligSalsemen.Fitness1;

public class RunUniverse2 {
	
	public static char[] runUniverse(char[][] generation, int[] fitnessVal, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {
		 ArrayList<String> archive=new ArrayList<>();
		 char[] currentBest=null;
		 int solutionCost=99999999;
		int solutionGeneration=0;
		 int localOptimal=0;
		//System.out.println(RunUniverse2.print(generation[3]));
		String[] split;
		int val=99999999;
		System.out.println("rununiverse");
		for (int i = 0; i < 1000; i++) {
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
				archive.add(new String(currentBest)+" "+solutionCost+" "+i);
				generation=ChromosomeRules.getNewFirstGeneration(problemCode);
				fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);
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
	
			 if(val>Integer.parseInt(split[1])) {
				 val=Integer.parseInt(split[1]);
				 currentBest=split[0].toCharArray();
				 solutionGeneration=Integer.parseInt(split[2]);
			 }
		}
		
		System.out.println(print(currentBest)+"  "+Fitness1.calculateFitness(currentBest)+" generation : "+solutionGeneration);
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