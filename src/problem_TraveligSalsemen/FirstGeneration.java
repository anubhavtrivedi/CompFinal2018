package problem_TraveligSalsemen;

public class FirstGeneration {
	public static int populationSize = 150;

	public static char[][] getFirstGeneration() {
		System.out.println("firstGeneration");
		char[][] firstGeneration = new char[populationSize][11];
		int[] status = new int[10];
		int val;
		String temp;
		status[0] = 1;
		for (int i = 0; i < populationSize; i++) {
			//System.out.println(i);
			firstGeneration[i][0] = '0';
			firstGeneration[i][10] = '0';
			for (int j = 1; j < 10; j++) {
				while (true) {
					
					val = (int) ((Math.random() * 1000) % 10);
					if (status[val] == 0 ) {
						//&& PathGraph.graph[firstGeneration[i][j-1]][val] != 0
						status[val] = 1;
						temp = "" + val;
						firstGeneration[i][j] = temp.charAt(0);
						status = new int[10];
						break;
					}
				}
			}
		}
		return firstGeneration;
	}
}
