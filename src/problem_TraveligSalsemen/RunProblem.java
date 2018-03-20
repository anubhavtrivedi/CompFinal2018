package problem_TraveligSalsemen;

import java.util.ArrayList;

import parallelUniverse1.RunUniverse1;
import parallelUniverse2.RunUniverse2;
import parallelUniverse3.RunUniverse3;
import parallelUniverse4.RunUniverse4;
import parallelUniverse3.RunUniverse3;


public class RunProblem {
	static char[] currentBest;
	static int solutionCost;
	static int[] fitnessVal;
	static ArrayList<String> archive=new ArrayList<>();
	public static void main(String[] args) {
		char[] solution=null;
		for(int i=0;i<50;i++) {
			
		System.out.println(i);
		char[][] firstGeneration=FirstGeneration1.getFirstGeneration();
		/*
		 * calculating fitness of the current generation
		 */
		fitnessVal=Fitness1.getFitness(firstGeneration);
		 solution=RunUniverse3.runUniverse(firstGeneration, fitnessVal, FirstGeneration1.populationSize, PathGraph.chromoLength, Chromosome.listofAllValues(),1);
		 archive.add(new String(solution)+" "+Fitness1.calculateFitness(solution));
		
		}	
		String[] split;
		int val=0;
		for(String c:archive) {
			
			 split=c.split(" ");

			 if(val<Integer.parseInt(split[1])) {
				 val=Integer.parseInt(split[1]);
				 solution=split[0].toCharArray();
			 }
		}
		System.out.println(print(solution)+"  "+Fitness1.calculateFitness(solution)+" we have obtained solution");
	}
	static String print(char[] solution) {
		String chromosome="";
		for(char c:solution) {
			chromosome+=c;
		}
		return chromosome;
		
	}
}
