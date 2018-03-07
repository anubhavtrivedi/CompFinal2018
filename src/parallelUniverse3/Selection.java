package parallelUniverse3;

import parallelUniverse1.RunUniverse;

//selecting best 50% of population and return only 50% of the population
public class Selection {
	public static  char[][] selectParents(char[][] generation,int[] fitness,int populationSize,int chromoLength){
	//	System.out.println("selection universe 3");
		generation=sort(fitness,generation,chromoLength);
		
//		
//	for(int j=0;j<populationSize;j++) {
//			
//			System.out.println(RunUniverse3.print(generation[j])+"  "+ChromosomeRules.getChromoFitness(1, generation[j]));
//		}
//		
		
		
		
		int temp=0,counter=0;
		char[][] intermediateGeneration=new char[populationSize][chromoLength];
		while(temp<populationSize) {
			intermediateGeneration[temp]=generation[counter];
			temp++;
			intermediateGeneration[temp]=generation[counter];
			temp++;counter++;
		}

		

	return intermediateGeneration;
	}
	
	
	static  char[][] sort(int arr[],char[][] generation,int chromoLength)
	    {int temp;
	    	char[] gen;
	       for(int i=0;i<arr.length;i++) {
	    	   for(int j=0;j<arr.length-1-i;j++) {
	    		   if(arr[j+1]<arr[j]) {
	    			   temp=arr[j];
	    			   arr[j]=arr[j+1];
	    			   arr[j+1]=temp;
	    			   gen=generation[j];
	    			   generation[j]=generation[j+1];
	    			   generation[j+1]=gen;
	    		   }
	    	   }
	       }
	       return generation;
	    }
	 
	 
	
}