package parallelUniverse4;

import java.util.ArrayList;
import java.util.Scanner;

import parallelUniverse4.ChromosomeRules;
import problem_PathFInder.Fitness2;
import problem_TraveligSalsemen.Fitness1;

public class RunUniverse4 {
	//public static int averageFitness;
	public static int leastFit=0;
	public static char[] runUniverse(char[][] generation, int[] fitnessVal, int populationSize, int chromoLength,
			ArrayList<Character> listOfValues, int problemCode) {
		 ArrayList<String> archive=new ArrayList<>();
		 char[] currentBest=null;
		 int solutionfitness=0;
		
		int solutionGeneration=0;
		 int localOptimal=0;
		//System.out.println(RunUniverse3.print(generation[3]));
		String[] split;
		int val=0;
//		int totalFitness=0;
//		for(int score:fitnessVal) {
//			totalFitness+=score;
//		}
//		averageFitness=totalFitness/(populationSize*2);
		
		System.out.println("rununiverse");
		for (int i = 0; i < 2; i++) {
			
			// System.out.println("1");
			//System.out.println(Fitness2.calculateCoordinates(generation[0]));
			generation = NextGeneration.getNextGeneration(generation, fitnessVal, populationSize, chromoLength,
					 listOfValues, problemCode);
			
			// System.out.println("2");
			fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);
		
//			for(int score:fitnessVal) {
//				totalFitness+=score;
//			}
//			averageFitness=totalFitness/(populationSize*2);
			Selection.sort(fitnessVal, generation, chromoLength);
			leastFit=fitnessVal[populationSize-1];
			// System.out.println("3");
			if(solutionfitness<fitnessVal[0]) {
				localOptimal=0;
			currentBest = generation[0];
			solutionfitness = fitnessVal[0];
			}
			else if(localOptimal>50) {
				archive.add(new String(currentBest)+" "+solutionfitness+" "+i);
				generation=ChromosomeRules.getNewFirstGeneration(problemCode);
				fitnessVal = ChromosomeRules.getPopulationFitness(problemCode, generation);
				Selection.sort(fitnessVal, generation, chromoLength);
				leastFit=fitnessVal[populationSize-1];
//				for(int score:fitnessVal) {
//					totalFitness+=score;
//				}
//				averageFitness=totalFitness/(populationSize*2);
				continue;
			}
			else if(generation[0]==currentBest){
				localOptimal++;
			}
			
			

		}
		
		for(String c:archive) {
			
			 split=c.split(" ");
	
			 if(val<Integer.parseInt(split[1])) {
				 val=Integer.parseInt(split[1]);
				 currentBest=split[0].toCharArray();
				 solutionGeneration=Integer.parseInt(split[2]);
			 }
		}
		
		System.out.println(print(currentBest)+"  "+ChromosomeRules.getChromoFitness(problemCode,currentBest)+" generation : "+solutionGeneration);
		return currentBest;
	}

	public static String print(char[] chromo) {
		String s = "";
		int count=0;
		for (char c : chromo) {
			count++;
			s += c;
			if(count>20)
				return s;
		}
		return s;
	}

}