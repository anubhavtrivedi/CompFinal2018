package parallelUniverse1;

// mutation is 10%
public class Mutation {
	public static char[] mutate(char[] chromo) {
		//System.out.println("mutation");
		int noOfMutation = (int) (chromo.length / 10);
		int mutationPoint;
		while (noOfMutation > 0) {
			mutationPoint = (int) ((Math.random() * 10000) % chromo.length);
		//	chromo[mutationPoint] = Problem.getRandom(chromo);
			noOfMutation--;
		}
		return chromo;
	}
}
