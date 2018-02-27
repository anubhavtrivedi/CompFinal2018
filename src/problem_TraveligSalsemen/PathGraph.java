package problem_TraveligSalsemen;

public class PathGraph {
	public static int n = 10;
	public static int chromoLength = n+1;
	public static int[][] graph = new int[n][n];
//	public static int[][] graph={
			 0 1 2 3 4 5 6 7 8 9 
//			{99999,3,99999,6,9,99999,99999,99999,99999,99999},
//			{3,99999,2,4,9,9,99999,99999,99999,99999},
//			{99999,2,5,2,99999,8,9,99999,99999,99999},
//			{5,5,5,5,5,5,5,5,5,5},
//			{5,5,5,5,5,5,5,5,5,5},
//			{5,5,5,5,5,5,5,5,5,5},
//			{5,5,5,5,5,5,5,5,5,5},
//			{5,5,5,5,5,5,5,5,5,5},
//			{5,5,5,5,5,5,5,5,5,5},
//			{5,5,5,5,5,5,5,5,5,5}
//	};
	/*
	 * initialization block
	 */
	static {
	// graph 1 with not complete edges
				 graph[2][3] = 2;
					graph[2][5] = 8;
					graph[2][1] = 2;
					graph[2][6] = 9;
					
		graph[0][1] = 3;
		graph[0][4] = 9;
		graph[0][3] = 6;
		
		graph[1][0] = 3;
		graph[1][2] = 2;
		graph[1][3] = 4;
		graph[1][4] = 9;
		graph[1][5] = 9;
		
		
		
		graph[3][1] = 4;
		graph[3][0] = 6;
		graph[3][2] = 2;
		graph[3][6] = 9;
		graph[4][0] = 9;
		graph[4][1] = 9;
		graph[4][5] = 8;
		graph[4][9] = 18;
		graph[5][1] = 9;
		graph[5][4] = 8;
		graph[5][2] = 8;
		graph[5][6] = 7;
		graph[5][8] = 9;
		graph[5][9] = 10;
		graph[6][2] = 9;
		graph[6][5] = 7;
		graph[6][3] = 9;
		graph[6][7] = 4;
		graph[6][8] = 5;
		graph[7][6] = 4;
		graph[7][8] = 1;
		graph[7][9] = 4;
		graph[8][7] = 1;
		graph[8][6] = 5;
		graph[8][5] = 9;
		graph[8][9] = 3;
		graph[9][5] = 10;
		graph[9][4] = 18;
		graph[9][8] = 3;
		graph[9][7] = 4;

	}
}
