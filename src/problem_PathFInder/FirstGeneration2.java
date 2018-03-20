package problem_PathFInder;

import java.util.ArrayList;

public class FirstGeneration2 {
	public static int populationSize = 150;
	public static int chromoLength = 10000;
	public static char[][] getFirstGeneration() {
		//System.out.println("firstGeneration");
		char[][] firstGeneration = new char[populationSize][chromoLength];
		ArrayList<Character> listOfValues=Chromosome.listofAllValues();
	
		for (int i = 0; i < populationSize; i++) {
			for (int j= 0; j< chromoLength; j++) {
			firstGeneration[i][j]=listOfValues.get((int)(Math.random()*100)%listOfValues.size());
			}
		}
		return firstGeneration;
	}
}
