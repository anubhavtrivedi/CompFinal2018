package parallelUniverse1;

//selecting best 50% of population and return only 50% of the population
public class Selection {
	public static  char[][] selectParents(char[][] generation,int[] fitness,int populationSize,int chromoLength){
		//System.out.println("selection");
		generation=sort(generation,fitness);
		char[][] parents=new char[(populationSize/2)+1][chromoLength];
		for(int i=0;i<=populationSize/2;i++){
			
				parents[i]=generation[i];
			
		}
	return parents;
	}
	public static char[][] sort(char[][] generation,int[] fitness){
		return generation;
	}
}