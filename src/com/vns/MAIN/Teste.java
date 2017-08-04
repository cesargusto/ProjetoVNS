package com.vns.MAIN;

import com.vns.LOCALSEARCH.LocalSearch;
import com.vns.STRUCTURE.Solution;

public class Teste {

	public static void main(String[] args) throws CloneNotSupportedException {

		Solution so = new Solution();
		Solution so2 = new Solution();
		LocalSearch ls = new LocalSearch();
		so.RandInitSolution();
		so.imprimeSolution();
		System.out.println("\nMakespan solucao inicial: \t\t"+so.getMakespan());
		System.out.println("------------------------------");
		
		so2 = ls.best_improvement(so);
		
		System.out.println("------------------------------");
		so2.imprimeSolution();
		System.out.println("\nMakespan solucao inicial: \t\t"+so2.getMakespan());

	}

}
