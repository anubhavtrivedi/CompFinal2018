package parallelUniverse1;


//random one point cross over
public class Crossover {
	public static char[] crossOver(char[] parent1, char[] parent2) {
		//System.out.println("crossover");
		int crossOverPoint = (int) ((Math.random() * 100) % parent1.length);
		for (int i = 0; i < parent1.length; i++) {
			if (i < crossOverPoint)
				continue;
			parent1[i] = parent2[i];
		}
		return parent1;
	}
	public static char[][] getCrossOver(char[][] generation,char[][] parents,int populationSize) {
		int crossingPoint=(populationSize/2);
		for(int i=0;i<((populationSize/2))&&(crossingPoint<populationSize);i++) {
			generation[crossingPoint]=Crossover.crossOver(parents[i],generation[crossingPoint]);
			crossingPoint++;
		}
		return generation;
	}
}
