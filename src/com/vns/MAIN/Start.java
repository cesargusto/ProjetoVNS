package com.vns.MAIN;

import com.vns.LOCALSEARCH.LocalSearch;
import com.vns.STRUCTURE.Instance;
import com.vns.STRUCTURE.Solution;

/* 
 * Name: Main Class Start.java
 * Function: To execute the application
 * @author: Cesar Oliveira
 * Data: 21/04/2017
 * 
 * */

public class Start {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Solution so = new Solution();
		Solution so2 = new Solution();
		LocalSearch ls = new LocalSearch();
		so.RandInitSolution();
		so.imprimeSolution();
		System.out.println("\nMakespan solucao inicial: \t\t"+so.getMakespan());
		so2 = ls.best_improvement(so);
		so2.imprimeSolution();
		System.out.println("\nMakespan melhor vizinho : \t\t"+so2.getMakespan());
	}
}
