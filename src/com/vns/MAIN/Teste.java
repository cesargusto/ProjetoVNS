package com.vns.MAIN;

import com.vns.LOCALSEARCH.LocalSearch;
import com.vns.STRUCTURE.Solution;

public class Teste {

	public static void main(String[] args) throws CloneNotSupportedException {

		Solution so = new Solution();
		Solution so2 = new Solution();
		LocalSearch ls = new LocalSearch();
		so.RandInitSolution();
		so.imprimeMaq(0);
		so.getMac(0).swapJob(0, 1);
		so.imprimeMaq(0);
		//so2 = ls.best_improvement(so);

	}

}
