package problem_PathFInder;

import java.util.ArrayList;

import parallelUniverse2.RunUniverse2;
import parallelUniverse3.RunUniverse3;
import parallelUniverse4.RunUniverse4;


public class RunProblem {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	static ArrayList<String> archive=new ArrayList<>();
	public static void main(String[] args) {
		
		char[] solution=null;
		for(int i=0;i<50;i++) {
			
		System.out.println(i);
		char[][] firstGeneration=FirstGeneration2.getFirstGeneration();
		
		/*
		 * calculating fitness of the current generation
		 */
		fitnessVal=Fitness2.getFitness(firstGeneration);
	
		 solution=RunUniverse4.runUniverse(firstGeneration, fitnessVal, FirstGeneration2.populationSize, FirstGeneration2.chromoLength, Chromosome.listofAllValues(),2);
		
		 archive.add(new String(solution)+" "+Fitness2.calculateFitness(solution));
		
		}	
		String[] split;
		int val=999999;
		for(String c:archive) {
			
			 split=c.split(" ");

			 if(val>Integer.parseInt(split[1])) {
				 val=Integer.parseInt(split[1]);
				 solution=split[0].toCharArray();
			 }
		}
		//System.out.println(print(solution)+"  "+Fitness2.calculateFitness(solution)+" we have obtained solution");
		System.out.println(Fitness2.calculateCoordinates(solution));
	}
	static String print(char[] solution) {
		String chromosome="";
		for(char c:solution) {
			chromosome+=c;
		}
		return chromosome;
		
	}
}
