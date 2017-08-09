package com.vns.MAIN;

import java.util.ArrayList;

import com.vns.LOCALSEARCH.LocalSearch;
import com.vns.METAHEURISTICA.SA;
import com.vns.STRUCTURE.Instance;
import com.vns.STRUCTURE.Solucao;
import com.vns.STRUCTURE.Solution;

public class Teste {

	public static void main(String[] args) throws CloneNotSupportedException{


		Solucao so = new Solucao();
		so.ConstroiSolution();
		so.imprimeSolucao();
		System.out.println("----------------------------");
		SA sa = new SA(so);
		sa.execute();
		
		

	}

}
