package problem_PathFInder;

public class Grid {
	private static int size=101;
	public static int[][] grid=new int[size][size];
	static{
		for(int i=1;i<size-1;i++) {
			for(int j=1;j<size-1;j++) {
				if(i==30&&j<60) {
					grid[i][j]=1;
					continue;
				}
				if(i==60&&j>50) {
					grid[i][j]=1;
					continue;
				}
				grid[i][j]=0;
			}
		}
		int i,j=0;
		i=0;
		while(j<size) {
			grid[i][j]=2;
			j++;
		}
		i=size-1;
		j=0;
		while(j<size) {
			grid[i][j]=2;
			j++;
		}
		j=size-1;
		i=0;
		while(i<size) {
			grid[i][j]=2;
			i++;
		}
		j=0;
		i=0;
		while(i<size) {
			grid[i][j]=2;
			i++;
		}
			
		
		grid[1][1]=9;
		grid[99][99]=5;
	}
	static public int[][] getGrid(){
		return grid;
	}
}
