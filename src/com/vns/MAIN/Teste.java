package com.vns.MAIN;

import com.vns.METAHEURISTICA.SA;
import com.vns.STRUCTURE.Solucao;

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
