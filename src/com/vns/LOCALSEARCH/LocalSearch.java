package com.vns.LOCALSEARCH;
/* 
 * Name: Main Class Start.java
 * Function: To execute the local search process
 * @author: Cesar Oliveira
 * Data: 21/04/2017
 * 
 * */

import com.vns.STRUCTURE.Instance;
import com.vns.STRUCTURE.Solution;

public class LocalSearch {

	public Solution best_improvement(Solution solution) throws CloneNotSupportedException{
		int melhor_mspan = Integer.MAX_VALUE;
		Solution melhor_solution = new Solution();
		
		if(solution.getMakespan() < melhor_mspan){
			System.out.println("mspan anterior: "+melhor_mspan);
			melhor_mspan = solution.getMakespan();
			melhor_solution = solution.clone();
			System.out.println("mspan atual: "+melhor_mspan);
		}
		for(int i = 0;i < Instance.numMachines;i++){
			int x = 0;
			int contador = solution.getMac(i).getMachine().size();
			while(x < contador){
				for(int j = 1;j < solution.getMac(i).getMachine().size();j++){
					solution.imprimeSolution();
					solution.getMac(i).swapJob(x, j);
					solution.imprimeSolution();
					if(solution.getMakespan() < melhor_mspan){
						melhor_mspan = solution.getMakespan();
						melhor_solution = solution.clone();
					}
					solution.getMac(i).swapJob(x, j);
				}
				x ++;
			}
		}
		return melhor_solution;
	}

	public Solution first_improvement(Solution solution){

		
		return solution;
	}
}
