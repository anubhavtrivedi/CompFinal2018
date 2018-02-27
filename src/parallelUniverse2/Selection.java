package parallelUniverse2;

//selecting best 50% of population and return only 50% of the population
public class Selection {
	public static  char[][] selectParents(char[][] generation,int[] fitness,int populationSize,int chromoLength){
		System.out.println("selection");
		sort(fitness, 0, fitness.length-1,generation,chromoLength);
		int totalFitness=0;
		for(int fit:fitness) {
			totalFitness+=fit;
		}
		/*
		 * creating intermediate generation for probalistic selection based on each genes performance/fitness
		 */
		char[][] intermediateGeneration=generation;
		int counter=0,flag=0;
		while(counter<populationSize-4) {
			
		intermediateGeneration[counter]=generation[counter];
		intermediateGeneration[counter+1]=generation[counter];
		intermediateGeneration[counter+2]=generation[counter];
		intermediateGeneration[counter+3]=generation[counter];
		counter+=3;
		}
		

		
	return intermediateGeneration;
	}
	
	static void merge(int arr[], int l, int m, int r,char[][] generation,int chromoLength)
	    {
	       
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 	        int L[] = new int [n1];
	        int R[] = new int [n2];
	        char[][] L1 = new char [n1][chromoLength];
	        char [][] R1= new char [n2][chromoLength];
	 
	        
	        for (int i=0; i<n1; ++i) {
	            L[i] = arr[l + i];
	            L1[i]=generation[l+i];
	            
	        }
	        for (int j=0; j<n2; ++j)
	            R[j ] = arr[m + 1+ j];
	        
	          // R1[j]=generation[m+1+j];
	 
	 
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] >= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	static  void sort(int arr[], int l, int r,char[][] generation,int chromoLength)
	    {
	        if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m,generation,chromoLength);
	            sort(arr , m+1, r,generation,chromoLength);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r,generation,chromoLength);
	        }
	    }
	 
	 
	
}