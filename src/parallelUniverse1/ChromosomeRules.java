package parallelUniverse1;

import problem_TraveligSalsemen.FirstGeneration1;
import problem_TraveligSalsemen.Fitness1;
import problem_TraveligSalsemen.Problem1Rules;
/*
 * PROBLEM CODE :              PROBLEM NAME
 *            1 :	TravelingSalsemenProblem
 */
public class ChromosomeRules {
	public static char[][] getNewFirstGeneration(int problemCode){
		if(problemCode==1) {
			return FirstGeneration1.getFirstGeneration();
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
		
		return 0;	
	}
	public static int getChromoFitness(int problemCode,char[] chromo) {
		if(problemCode==1) 
			return Fitness1.calculateFitness(chromo);
		return 0;
	}
	public static int[] getPopulationFitness(int problemCode,char[][] population) {
		if(problemCode==1) 
			return Fitness1.getFitness(population);
		return null;
	}
	public static int checkMutation(int problemCode) {
		/*
		 * 1 for no repetion but no chromo constrains
		 * 
		 */
		if(problemCode==1)
		return Problem1Rules.checkMutation();
		
		return 0;	
	}
}