package com.vns.MAIN;

import com.vns.LOCALSEARCH.LocalSearch;
import com.vns.STRUCTURE.Instance;
import com.vns.STRUCTURE.Solucao;
import com.vns.STRUCTURE.Solution;

/* 
 * Name: Main Class Start.java
 * Function: To execute the application
 * @author: Cesar Oliveira
 * Data: 21/04/2017
 * 
 * */

public class Start {

	public static void main(String[] args){
		
		Solucao so = new Solucao();
		so.ConstroiSolution();
		so.imprimeSolucao();
		so.two_realloc();
		so.imprimeSolucao();
		/*so.task_move();
		so.imprimeSolucao();
		so.shift();
		so.imprimeSolucao();
		so.Switch();
		so.imprimeSolucao();*/

	}
}
