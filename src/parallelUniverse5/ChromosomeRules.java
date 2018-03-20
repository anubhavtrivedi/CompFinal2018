package parallelUniverse5;

import problem_PathFInder.FirstGeneration2;
import problem_PathFInder.Fitness2;
import problem_PathFInder.Problem2Rules;
import problem_TraveligSalsemen.FirstGeneration1;
import problem_TraveligSalsemen.Fitness1;
import problem_TraveligSalsemen.Problem1Rules;
/*
 * PROBLEM CODE :              PROBLEM NAME
 *            1 :	TravelingSalsemenProblem
 *            2 :	PathFinderProblems
 */
public class ChromosomeRules {
	public static char[][] getNewFirstGeneration(int problemCode){
		if(problemCode==1) {
			return FirstGeneration1.getFirstGeneration();
		}
		if(problemCode==2) {
			return FirstGeneration2.getFirstGeneration();
		}
		return null;
	}
	public static int checkRepetion(int problemCode) {
		/*
		 * 0 for replication not allowed 
		 * 1 for replication allowed 
		 * 2 for noRepetionNoChromoRuleCrossOver
		 */
		if(problemCode==1)
		return Problem1Rules.checkRepetion();
		if(problemCode==2)
			return Problem2Rules.checkRepetion();
		
		return 0;	
	}
	public static int getChromoFitness(int problemCode,char[] chromo) {
		if(problemCode==1) 
			return Fitness1.calculateFitness(chromo);
		if(problemCode==2) 
			return Fitness2.calculateFitness(chromo);
		return 0;
	}
	public static int[] getPopulationFitness(int problemCode,char[][] population) {
		if(problemCode==1) 
			return Fitness1.getFitness(population);
		if(problemCode==2) 
			return Fitness2.getFitness(population);
		return null;
	}
	public static int checkMutation(int problemCode) {
		/*
		 * 1 for no repetion but no chromo constrains
		 * 
		 */
		if(problemCode==1)
		return Problem1Rules.checkMutation();
		if(problemCode==2)
			return Problem2Rules.checkMutation();
		
		return 0;	
	}
}