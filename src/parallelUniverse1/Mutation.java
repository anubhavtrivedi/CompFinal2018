package parallelUniverse1;

import java.util.ArrayList;

// mutation is 50%
/*
 * 1. mutateNoRepetionNoChromoRule
 * 2. 
 * 3. 
 */
public class Mutation {
	public static char[] mutate(char[] chromo, ArrayList<Character> setOfValues, int problemCode) {
		//
		int mutationType = ChromosomeRules.checkMutation(problemCode);
		if (mutationType == 1)
			return mutateNoRepetionNoChromoRule(chromo, setOfValues);

		return null;
	}

	public static char[] mutateNoRepetionNoChromoRule(char[] chromo, ArrayList<Character> setOfValues) {
		// System.out.println("mutation");
		int noOfMutation = (int) (chromo.length / 2);
		int mutationPoint, index;
		char search;
		while (noOfMutation > 0) {
			mutationPoint = (int) ((Math.random() * 10000) % chromo.length);
			if (mutationPoint == 0)
				continue;
			index = (int) ((Math.random() * 10000) % setOfValues.size());
			search = chromo[mutationPoint];
			chromo[mutationPoint] = setOfValues.get(index);
			index = 0;
			for (char c : chromo) {
				if (c == chromo[mutationPoint]) {
					chromo[mutationPoint] = search;
					break;
				}
			}
			noOfMutation--;
		}
		return chromo;
	}
}
