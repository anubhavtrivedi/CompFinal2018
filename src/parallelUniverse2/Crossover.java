package parallelUniverse2;

//random one point cross over
public class Crossover {
	public static char[] crossOver(char[] parent1, char[] parent2, int problemCode) {
		// System.out.println("crossover");
		int repetion = ChromosomeRules.checkRepetion(problemCode);
		/*
		 * 0 for noRepetionCrossOver 1 for repetionAllowedCrossOver 2 for
		 * noRepetionNoChromoRuleCrossOver
		 */
		if (repetion == 0) {
			return noRepetionCrossOver(parent1, parent2, problemCode);
		}
		if (repetion == 1) {
			return repetionAllowedCrossOver(parent1, parent2, problemCode);
		}
		if (repetion == 2) {
			return noRepetionNoChromoRuleCrossOver(parent1, parent2, problemCode);
		}
		return parent1;
	}

	public static char[] noRepetionCrossOver(char[] parent1, char[] parent2, int problemCode) {

		return null;
	}

	/*
	 * keeping the first half fixed, adjusting the later for no repletion.
	 */

	public static char[] noRepetionNoChromoRuleCrossOver(char[] parent1, char[] parent2, int problemCode) {

		int crossOverPoint = parent1.length / 2, temp, counter = 0;
		// System.out.println(RunUniverse3.print(parent1)+" dfg
		// "+RunUniverse3.print(parent2));
		char[] ch;
		int[] check = new int[parent1.length];

		for (int i = 0; i < parent1.length; i++) {
			if (i < crossOverPoint) {
				if (parent1[i] == 'x')
					temp = 10;
				else if (parent1[i] == 'y')
					temp = 11;
				else
					temp = Integer.parseInt("" + parent1[i]);
				check[temp] = 1;
				continue;
			}
			if (parent2[i] == 'x')
				temp = 10;
			else if (parent2[i] == 'y')
				temp = 11;
			else
				temp = Integer.parseInt("" + parent2[i]);
			if (check[temp] != 0) {
				counter = 0;
				for (int x : check) {
					if (x == 0) {
						if(counter==10) {
							parent1[i] ='x';
							check[counter] = 1;
							break;
						}
						if(counter==11) {
							parent1[i] ='y';
							check[counter] = 1;
							break;
						}
						ch = ("" + counter).toCharArray();
						parent1[i] = ch[0];
						check[counter] = 1;
						break;
					}
					counter++;
				}
			} else {
				parent1[i] = parent2[i];
				if (parent2[i] == 'x')
					temp = 10;
				else if (parent2[i] == 'y')
					temp = 11;
				else
					temp = Integer.parseInt("" + parent2[i]);
				check[temp] = 1;
			}

		}
		// problem specific
		if (problemCode == 1)
			parent1[12] = ("" + 0).charAt(0);
		// System.out.println(RunUniverse3.print(parent1));
		return parent1;

	}

	public static char[] repetionAllowedCrossOver(char[] parent1, char[] parent2, int problemCode) {

		int crossOverPoint = parent1.length / 2;
		for (int i = 0; i < parent1.length; i++) {
			if (i < crossOverPoint)
				continue;
			parent1[i] = parent2[i];
		}

		return parent1;
	}

	public static char[][] getCrossOver(char[][] generation, char[][] parents, int populationSize, int problemCode) {
		int counter = 0, parent1, parent2;
		while (counter < populationSize) {
			parent1 = (int) ((Math.random() * 100) % populationSize);
			parent2 = (int) ((Math.random() * 100) % populationSize);

			generation[counter] = crossOver(parents[parent1], parents[parent2], problemCode);
			counter++;
		}

		return generation;
	}
}
