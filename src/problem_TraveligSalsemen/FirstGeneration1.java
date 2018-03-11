package problem_TraveligSalsemen;

public class FirstGeneration1 {
	public static int populationSize = 150;
	public static int chromLength = 13;
	public static char[][] getFirstGeneration() {
		//System.out.println("firstGeneration");
		char[][] firstGeneration = new char[populationSize][chromLength];
		int[] status = new int[chromLength];
		int val;
		String temp;
		status[0] = 1;
		status[chromLength-1]=1;
		for (int i = 0; i < populationSize; i++) {
			//System.out.println(i);
			firstGeneration[i][0] = '0';
			firstGeneration[i][chromLength-1] = '0';
			status[0] = 1;
			status[chromLength-1]=1;
			for (int j = 1; j < chromLength-1; j++) {
				while (true) {
					
					val = (int) ((Math.random() * 1000) % chromLength-1);
					if (status[val] == 0 ) {
						//&& PathGraph.graph[firstGeneration[i][j-1]][val] != 0
						status[val] = 1;
						if(val==10) {
							firstGeneration[i][j] ='x';
							break;
						}
						if(val==11) {
							firstGeneration[i][j] = 'y';
							break;
						}
						temp = "" + val;
						firstGeneration[i][j] = temp.charAt(0);
						
						break;
					}
				}
			}
			status = new int[chromLength];
		}
		return firstGeneration;
	}
}
