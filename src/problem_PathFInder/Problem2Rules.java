package problem_PathFInder;

public class Problem2Rules {
	public static int checkRepetion() {
		/*
		 * 0 for replication not allowed 1 for replication allowed 2 for
		 * noRepetionNoChromoRuleCrossOver
		 */
		return 1;
	}

	public static int checkMutation() {
		/*
		 * 1 for no repetion but no chromo constrains 2 no repetion, no chromosome rule
		 */
		return 2;
	}
}
