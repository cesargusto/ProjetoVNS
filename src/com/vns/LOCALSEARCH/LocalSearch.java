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
	
	private int melhor_mspan;
	private Solution melhor_solution;
	
	public Solution best_improvement(Solution solution) throws CloneNotSupportedException{
		
		melhor_mspan = Integer.MAX_VALUE;
		melhor_solution = new Solution();
		
		int mkspan1 = solution.getMakespan(); 
		if(mkspan1 < melhor_mspan){
			melhor_mspan = mkspan1;
			melhor_solution = solution.clone();
			solution.limpaMakespan();
		}
		for(int i = 0;i < Instance.numMachines;i++){
			int tam_maq = solution.getMac(i).getMachine().size();
			for(int k = 0;k < tam_maq;k++){
				for(int j = k+1;j < tam_maq;j++){
					solution.getMac(i).swapJob(i, k, j);
					int mkspan2 = solution.getMakespan(); 
					solution.imprimeSolution();
					if(mkspan2 < melhor_mspan){
						melhor_mspan = mkspan2;
						melhor_solution = solution.clone();
						solution.limpaMakespan();
					}
					solution.getMac(i).swapJob(i, k, j);
				}
			}
		}
		return melhor_solution;
	}

	public Solution first_improvement(Solution solution){
		return solution;
	}

	public int getMelhor_mspan() {
		return melhor_mspan;
	}

	public Solution getMelhor_solution() {
		return melhor_solution;
	}
	
	
}
